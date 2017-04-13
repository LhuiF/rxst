package com.unionx.core.file;


import lombok.Data;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 文件存储
 * @author songjunjie
 */
@Data
public class FileStorageManager  {
    private static final Logger logger = LoggerFactory.getLogger(FileStorageManager.class);
    private String configFile = "fdfs_client.conf";
    private String trackerServerAddr;
    private String trackerUrl;
    private TrackerServer trackerServer = null;
    private int trackerHttpPort;
    private static FileStorageManager fileStorageManager = null;

    public FileStorageManager() throws Exception {
        init();
    }

    public static FileStorageManager getInstance() throws Exception {
        if (fileStorageManager == null) {
            fileStorageManager = new FileStorageManager();
        }
        return fileStorageManager;
    }

    /**
     * 初始化
     * @throws Exception
     */
    private void init() throws Exception {

        Properties prop = new Properties();
        try {
            InputStream in = FileStorageManager.class.getResourceAsStream("/" + configFile);
            prop.load(in);
        } catch (Exception e) {
            logger.error("在classpath下面没有找到配置文件:{}", configFile);
            throw e;
        }
        trackerUrl = prop.getProperty("tracker_url");
        if (StringUtils.isBlank(trackerUrl)) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的tracker_url错误", configFile);
            throw new Exception("配置错误");
        }
        trackerUrl = trackerUrl.trim();
        trackerServerAddr = prop.getProperty("tracker_server");
        if (StringUtils.isBlank(trackerServerAddr)) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的tracker_server错误", configFile);
            throw new Exception("配置错误");
        }
        trackerServerAddr = trackerServerAddr.trim();
        String trackerPortStr = prop.getProperty("tracker_port");
        if (StringUtils.isBlank(trackerPortStr)) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的tracker_port错误", configFile);
            throw new Exception("配置错误");
        }
        trackerPortStr = trackerPortStr.trim();
        int trackerPort;
        try {
            trackerPort = Integer.valueOf(trackerPortStr);
        } catch (NumberFormatException e) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的tracker_port错误", configFile, e);
            throw e;
        }

        String conTimeout = prop.getProperty("connect_timeout");
        if (StringUtils.isBlank(conTimeout)) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的connect_timeout错误", configFile);
            throw new Exception("配置错误");
        }
        conTimeout = conTimeout.trim();
        int connectTimeout;
        try {
            connectTimeout = Integer.valueOf(conTimeout);
        } catch (NumberFormatException e) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的connect_timeout错误", configFile, e);
            throw e;
        }
        String networkTimeoutStr = prop.getProperty("network_timeout").trim();
        if (StringUtils.isBlank(networkTimeoutStr)) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的network_timeout错误", configFile);
            throw new Exception("配置错误");
        }
        networkTimeoutStr = networkTimeoutStr.trim();
        int networkTimeout;
        try {
            networkTimeout = Integer.valueOf(networkTimeoutStr);
        } catch (NumberFormatException e) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的network_timeout错误", configFile, e);
            throw e;
        }
        String charset = prop.getProperty("charset").trim();
        if (StringUtils.isNotBlank(charset)) {
            charset = charset.trim();
        }
        String trackerHttpPortStr = prop.getProperty("http.tracker_http_port");
        if (StringUtils.isBlank(trackerHttpPortStr)) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的http.tracker_http_port错误", configFile);
            throw new Exception("配置错误");
        }
        trackerHttpPortStr = trackerHttpPortStr.trim();
        try {
            trackerHttpPort = Integer.valueOf(trackerHttpPortStr);
        } catch (NumberFormatException e) {
            logger.error("初始化FastDFS Client失败！配置文件{}中的http.tracker_http_port错误", configFile, e);
            throw e;
        }
        String antiStealTokenStr = prop.getProperty("http.anti_steal_token").trim();
        if (StringUtils.isNotBlank(antiStealTokenStr)) {
            antiStealTokenStr = antiStealTokenStr.trim();
        }
        boolean antiStealToken;
        if (antiStealTokenStr.equalsIgnoreCase("yes") || antiStealTokenStr.equalsIgnoreCase("true")) {
            antiStealToken = true;
        } else if (antiStealTokenStr.equalsIgnoreCase("no") || antiStealTokenStr.equalsIgnoreCase("false")) {
            antiStealToken = false;
        } else {
            logger.error("初始化FastDFS Client失败！配置文件{}中的http.anti_steal_token错误", configFile);
            throw new Exception("配置错误");
        }
        String secretKey = prop.getProperty("http.secret_key").trim();

        InetSocketAddress[] trackerServers = new InetSocketAddress[1];
        trackerServers[0] = new InetSocketAddress(trackerServerAddr, trackerPort);
        ClientGlobal.setG_tracker_group(new TrackerGroup(trackerServers));
        // 连接超时的时限，单位为毫秒 
        ClientGlobal.setG_connect_timeout(connectTimeout);// 网络超时的时限，单位为毫秒 
        ClientGlobal.setG_network_timeout(networkTimeout);
        ClientGlobal.setG_anti_steal_token(antiStealToken);// 字符集 
        ClientGlobal.setG_charset(charset);
        ClientGlobal.setG_secret_key(secretKey);
        ClientGlobal.setG_tracker_http_port(trackerHttpPort);
        TrackerClient trackerClient = new TrackerClient();
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            logger.error("链接服务器时出现错误!", e);
            throw e;
        }
    }

    private StorageClient1 getStorageClient() {
        TrackerClient trackerClient = new TrackerClient();
        StorageServer storageServer = null;
        StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
        return storageClient;
    }

    /**
     * 上传文件
     * @param fileData 文件数据
     * @param originalFilename  文件原始名称
     * @return 文件id
     * @throws Exception
     */
    public String upload(byte[] fileData, String originalFilename) throws Exception {
        String extName = FilenameUtils.getExtension(originalFilename);
        NameValuePair[] metaList = new NameValuePair[3];
        metaList[0] = new NameValuePair("fileName", originalFilename);
        metaList[1] = new NameValuePair("fileExtName", extName);
        metaList[2] = new NameValuePair("fileLength", String.valueOf(fileData.length));
        // 上传文件
        try {
            String fileId = FileStorageManager.getInstance().getTrackerUrl() + getStorageClient().upload_file1(fileData, extName, metaList);
            return fileId;
        } catch (Exception e) {
            logger.error("上传文件失败！", e);
            throw e;
        }
    }

    /**
     * 上传文件比例压缩
     *
     * @param fileData         文件数据
     * @param originalFilename 文件原始名称
     * @param percent 图片的压缩比。整数。例如：30，标识压缩到30%.
     * @return 文件id
     * @throws Exception
     */
    public Map uploadImage(byte[] fileData, String percent, String originalFilename) throws Exception {
        Map map = new HashMap();
        try {
            String extName = FilenameUtils.getExtension(originalFilename);
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", originalFilename);
            metaList[1] = new NameValuePair("fileExtName", extName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(fileData.length));
            String fileId = getStorageClient().upload_file1(fileData, extName, metaList);
            if (StringUtils.isNotBlank(percent)) {
                int i = Integer.parseInt(percent);
                float percentF = (float) i / 100;
                InputStream in = new ByteArrayInputStream(fileData);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                Thumbnails.of(in).scale(percentF).outputFormat("JPEG").toOutputStream(outputStream);
                byte[] data1 = outputStream.toByteArray();
                String minExtName = FilenameUtils.getExtension(originalFilename);
                NameValuePair[] minMetaList = new NameValuePair[3];
                minMetaList[0] = new NameValuePair("fileName", originalFilename);
                minMetaList[1] = new NameValuePair("fileExtName", minExtName);
                minMetaList[2] = new NameValuePair("fileLength", String.valueOf(data1.length));
                String fileId1 = getStorageClient().upload_file1(data1, minExtName, minMetaList);
                map.put("minFileId",FileStorageManager.getInstance().getTrackerUrl() +fileId1);
//                map.put("minFileId","/" +fileId1);
            }else{
                map.put("minFileId",FileStorageManager.getInstance().getTrackerUrl() + fileId);
//                map.put("minFileId","/" + fileId);
            }
            map.put("success", true);
            map.put("fileId",FileStorageManager.getInstance().getTrackerUrl()+fileId);
//            map.put("fileId","/"+fileId);
            map.put("serverAddr", FileStorageManager.getInstance().getTrackerServerAddr());
            map.put("port", FileStorageManager.getInstance().getTrackerHttpPort());
            map.put("fileName", originalFilename);
            return map;
        }catch (Exception e){
            logger.error("", e);
            map.put("success", false);
            return map;
        }
    }


    /**
     * 上传文件 容量压缩
     *
     * @param fileData         文件数据
     * @param originalFilename 文件原始名称
     * @param allowSize 最大容量
     * @return 文件id
     * @throws Exception
     */
    public Map uploadImageAllowSize(byte[] fileData, Integer allowSize, String originalFilename) throws Exception {
        Map map = new HashMap();
        try {
            String extName = FilenameUtils.getExtension(originalFilename);
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", originalFilename);
            metaList[1] = new NameValuePair("fileExtName", extName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(fileData.length));
            String fileId = getStorageClient().upload_file1(fileData, extName, metaList);
            if (allowSize != null) {
                float percentF = (float) allowSize / (float) fileData.length;
                InputStream in = new ByteArrayInputStream(fileData);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                Thumbnails.of(in).scale(percentF).outputFormat("JPEG").toOutputStream(outputStream);
                byte[] data1 = outputStream.toByteArray();
                String minExtName = FilenameUtils.getExtension(originalFilename);
                NameValuePair[] minMetaList = new NameValuePair[3];
                minMetaList[0] = new NameValuePair("fileName", originalFilename);
                minMetaList[1] = new NameValuePair("fileExtName", minExtName);
                minMetaList[2] = new NameValuePair("fileLength", String.valueOf(data1.length));
                String fileId1 = getStorageClient().upload_file1(data1, minExtName, minMetaList);
                map.put("minFileId",FileStorageManager.getInstance().getTrackerUrl() + fileId1);
//                map.put("minFileId","/" + fileId1);
            }else{
                map.put("minFileId",FileStorageManager.getInstance().getTrackerUrl() + fileId);
//                map.put("minFileId","/" + fileId);
            }
            map.put("success", true);
            map.put("fileId",FileStorageManager.getInstance().getTrackerUrl() + fileId);
//            map.put("fileId","/" + fileId);
            map.put("serverAddr", FileStorageManager.getInstance().getTrackerServerAddr());
            map.put("port", FileStorageManager.getInstance().getTrackerHttpPort());
            map.put("fileName", originalFilename);
            return map;
        } catch (Exception e) {
            logger.error("", e);
            map.put("success", false);
            return map;
        }
    }


    /**
     * 上传文件 宽高压缩
     *
     * @param fileData         文件数据
     * @param originalFilename 文件原始名称
     * @param width          图片最大宽度
     * @param height         图片最大高度
     * @return 文件id
     * @throws Exception
     */
    public Map uploadImage(byte[] fileData, Integer width, Integer height, String originalFilename) throws Exception {
        Map map = new HashMap();
        try {
            String extName = FilenameUtils.getExtension(originalFilename);
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", originalFilename);
            metaList[1] = new NameValuePair("fileExtName", extName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(fileData.length));
            String fileId = getStorageClient().upload_file1(fileData, extName, metaList);
            if (width != null && height != null) {
                InputStream in = new ByteArrayInputStream(fileData);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                Thumbnails.of(in).size(width,height).outputFormat("JPEG").toOutputStream(outputStream);
                byte[] data1 = outputStream.toByteArray();
                String minExtName = FilenameUtils.getExtension(originalFilename);
                NameValuePair[] minMetaList = new NameValuePair[3];
                minMetaList[0] = new NameValuePair("fileName", originalFilename);
                minMetaList[1] = new NameValuePair("fileExtName", minExtName);
                minMetaList[2] = new NameValuePair("fileLength", String.valueOf(data1.length));
                String fileId1 = getStorageClient().upload_file1(data1, minExtName, minMetaList);
                map.put("minFileId",FileStorageManager.getInstance().getTrackerUrl() + fileId1);
//                map.put("minFileId","/" + fileId1);
            }else{
                map.put("minFileId",FileStorageManager.getInstance().getTrackerUrl() + fileId);
//                map.put("minFileId","/" + fileId);
            }
            map.put("success", true);
            map.put("fileId",FileStorageManager.getInstance().getTrackerUrl() + fileId);
//            map.put("fileId","/" + fileId);
            map.put("serverAddr", FileStorageManager.getInstance().getTrackerServerAddr());
            map.put("port", FileStorageManager.getInstance().getTrackerHttpPort());
            map.put("fileName", originalFilename);
            return map;
        } catch (Exception e) {
            logger.error("", e);
            map.put("success", false);
            return map;
        }
    }

    /**
     * 删除文件
     * @param fileId 文件id
     * @return
     * @throws Exception
     */
    public boolean delete(String fileId) throws Exception{
        fileId = fileId.replace(FileStorageManager.getInstance().getTrackerUrl(),"");
        int count = this.getStorageClient().delete_file1(fileId);
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 返回文件信息
     * @param fileId
     * @throws Exception
     */
    public FileInfo getFielInfo(String fileId) throws Exception {

        FileInfo fileInfo = this.getStorageClient().get_file_info1(fileId);
        return fileInfo;
    }

    /**
     * 返回Meta数据
     * @param fileId
     * @return
     * @throws Exception
     */
    public Map<String,String> getMetaData(String fileId) throws Exception {
        Map<String,String> map = new HashMap();
        NameValuePair[] metadata = this.getStorageClient().get_metadata1(fileId);
        for (NameValuePair vp : metadata) {
            map.put(vp.getName(),vp.getValue());
        }
        return map;
    }

    /**
     * 下载文件
     * @param fileId
     * @return
     * @throws Exception
     */
    public byte[] download(String fileId) throws Exception {
        byte[] bytes = this.getStorageClient().download_file1(fileId);
        return bytes;
    }


    /**
     * 返回服务器地址
     * @return
     */
    public String getTrackerServerAddr() {
        return trackerServerAddr;
    }

    /**
     * 返回服务器地址
     *
     * @return
     */
    public String getTrackerUrl() {
        return trackerUrl;
    }
    /**
     * 返回http端口
     * @return
     */
    public int getTrackerHttpPort() {
        return trackerHttpPort;
    }

}

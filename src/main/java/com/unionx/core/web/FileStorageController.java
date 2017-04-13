package com.unionx.core.web;

import com.unionx.core.file.FileStorageManager;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author songjunjie
 */
@Controller
@RequestMapping(value = "/fileStorage")
public class FileStorageController {
    private static final Logger logger = LoggerFactory.getLogger(FileStorageController.class);

    /**
     * 上传文件
     *
     * @param multipartFile
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        try {
            byte[] data = multipartFile.getBytes();
            String filename = multipartFile.getOriginalFilename();
            String fileId = FileStorageManager.getInstance().upload(data, filename);
            Map map = new HashMap();
            map.put("success", true);
            map.put("fileId", fileId);
            map.put("serverAddr", FileStorageManager.getInstance().getTrackerServerAddr());
            map.put("port", FileStorageManager.getInstance().getTrackerHttpPort());
            map.put("fileName", filename);
            return map;
        } catch (Exception e) {
            logger.error("", e);
            Map map = new HashMap();
            map.put("success", false);
            return map;
        }
    }

    /**
     * 上传文件
     *
     * @param multipartFile
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadEditor", method = RequestMethod.POST)
    public Map uploadEditor(@RequestParam("upfile") MultipartFile multipartFile, HttpServletRequest request) {
        try {
            byte[] data = multipartFile.getBytes();
            String filename = multipartFile.getOriginalFilename();
            String fileId = FileStorageManager.getInstance().upload(data, filename);
            Map map = new HashMap();
            map.put("state", "SUCCESS");
            map.put("title", filename);
            map.put("original", "uploadEditor.jpg");
            map.put("type", ".jpg");
            map.put("url", fileId);
            map.put("size", data.length);
            return map;
        } catch (Exception e) {
            logger.error("", e);
            Map map = new HashMap();
            map.put("success", false);
            return map;
        }
    }
    /**
     * 图片文件上传。此方法可以将图片压缩
     *
     * @param multipartFile
     * @param percent 图片的压缩比。整数。例如：30，标识压缩到30%。默认是50\
     * @param allowSize 最大容量
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public Map uploadImage(@RequestParam("file") MultipartFile multipartFile, String percent,Integer allowSize) {
        Map map = new HashMap();
        Pattern pattern = Pattern.compile("BMP|JPG|JEPG|PNG");
        if (!pattern.matcher(multipartFile.getOriginalFilename().toUpperCase()).find()) {
            map.put("success", false);
            map.put("message", "文件格式不正确");
            return map;
        }
        float percentF = 0.5f;
        if (StringUtils.isNotBlank(percent)) {
            try {
                int i = Integer.parseInt(percent);
                percentF = (float) i / 100;
            } catch (NumberFormatException e) {
                logger.error("", e);
                map.put("success", false);
                map.put("message", "参数percent不正确");
                return map;
            }
        } else if (multipartFile.getSize()>0&&allowSize != null) {
            if(multipartFile.getSize()>Long.valueOf(allowSize)){
                percentF = (float)allowSize/(float)multipartFile.getSize();
            }else{
                percentF = 1;
            }
        }
        try {
            byte[] data = multipartFile.getBytes();
            String filename = multipartFile.getOriginalFilename();
            String fileId = FileStorageManager.getInstance().upload(data, filename);

            InputStream in = new ByteArrayInputStream(data);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Thumbnails.of(in).scale(percentF).toOutputStream(outputStream);
            byte[] data1 = outputStream.toByteArray();
            String fileId1 = FileStorageManager.getInstance().upload(data1, filename);

            map.put("success", true);
            map.put("fileId", fileId);
            map.put("serverAddr", FileStorageManager.getInstance().getTrackerServerAddr());
            map.put("port", FileStorageManager.getInstance().getTrackerHttpPort());
            map.put("minFileId", fileId1);
            map.put("fileName", filename);
            return map;
        } catch (Exception e) {
            logger.error("", e);
            map.put("success", false);
            return map;
        }
    }

    /**
     * 删除文件
     * @param fileId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Map delete(String fileId) {
        Map map = new HashMap();
        try {
            String host = FileStorageManager.getInstance().getTrackerServerAddr();
            if (fileId.contains(host)) {
                fileId = fileId.substring(host.length() + 8);
            }
            boolean r = FileStorageManager.getInstance().delete(fileId);
            if (r) {
                map.put("success", true);
                map.put("message", "删除成功");
            } else {
                map.put("success", false);
                map.put("message", "删除失败");
            }
        } catch (Exception e) {
            logger.error("", e);
            map.put("success", false);
            map.put("message", "删除失败");
        }
        return map;
    }
}


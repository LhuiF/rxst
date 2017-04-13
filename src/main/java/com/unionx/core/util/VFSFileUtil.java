package com.unionx.core.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.FileType;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.provider.ftp.FtpFileSystemConfigBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 文件操作
 * commons-vfs-2.0
 * 
 * 支持：本地File、FTP、FTPS、SFTP、WebDAV
 * 
 * File-----------------------------
 * file:///home/someuser/somedir 
 * file:///C:/Documents and Settings 
 * file://///somehost/someshare/afile.txt 
 * /home/someuser/somedir 
 * c:\program files\some dir 
 * c:/program files/some dir 
 * 
 * zip
 * jar:../lib/classes.jar!/META-INF/manifest.mf 
 * zip:http://somehost/downloads/somefile.zip 
 * jar:zip:outer.zip!/nested.jar!/somedir 
 * jar:zip:outer.zip!/nested.jar!/some%21dir 
 * tar:gz:http://anyhost/dir/mytar.tar.gz!/mytar.tar!/path/in/tar/README.txt 
 * tgz:file://anyhost/dir/mytar.tgz!/somepath/somefile 
 * gz:/my/gz/file.gz 
 * 
 * HTTP
 * http://somehost:8080/downloads/somefile.jar 
 * http://myusername@somehost/index.html 
 * 
 * WebDAV
 * webdav://[ username[: password]@] hostname[: port][ absolute-path]
 * webdav://somehost:8080/dist 
 * 
 * 
 * FTP
 * ftp://[ username[: password]@] hostname[: port][ absolute-path]
 * ftp://myusername:mypassword@somehost/pub/downloads/somefile.tgz
 * 
 * ftps
 * ftps://myusername:mypassword@somehost/pub/downloads/somefile.tgz 
 * 
 * sftp
 * sftp://myusername:mypassword@somehost/pub/downloads/somefile.tgz
 * 
 * 
 * @author qiaoxl
 *
 */
public class VFSFileUtil {

	/** 日志输出 */
	private static final Logger logger = LoggerFactory.getLogger(VFSFileUtil.class);
	
	private static FileSystemManager fsm = null;   

    private static FileSystemOptions opts = null;
	  
    static {   
        try {   
            fsm = VFS.getManager();
            opts = new FileSystemOptions();
        	String flag = "ftp://rsxtuser:rsxtuser@192.168.1.15:21";
        	if(StringUtils.isNotEmpty(flag)){
                FtpFileSystemConfigBuilder.getInstance().setPassiveMode(opts, Boolean.parseBoolean(flag));  //true 被动模式;false 主动模式
        	}else{
                FtpFileSystemConfigBuilder.getInstance().setPassiveMode(opts, true);  //true 被动模式;false 主动模式
        	}
        } catch (FileSystemException e) {   
			logger.error("出现异常", e);
        }
    }   
  
    /**
     * 获取
     * @param path
     * @return
     */
    public static FileObject getFile(String path){   
        try {   
            return fsm.resolveFile(path,opts);   
        } catch (FileSystemException e) {   
			logger.error("出现异常", e);
        }   
        return null;   
    }
    
    /**
     * 删除
     * @param path
     * @throws Exception 
     */
    public static void delete(String path) throws Exception {  
    	FileObject fo = null;
        try {   
            fo = getFile(path);  
            if(fo.exists()){
                fo.delete(); 
            }  
        } catch (FileSystemException e) {   
			logger.error("出现异常", e);
        }finally{
        	if(fo != null){
                fo.close();
        	}
        }
    }   
    
    public static Long getSize(String path)throws Exception{
    	 FileObject fo = null;
    	 Long fileSize = new Long(0);
    	 try {   
    		 fo = getFile(path); 
             if(fo.exists()){
            	 fileSize = fo.getContent().getSize();
             } 
         } catch (FileSystemException e) {   
 			logger.error("出现异常", e); 
         } finally{
        	if(fo != null){
                fo.close();
        	}
         }  
         return fileSize;
    }
    
    /**
     * 判断是否为文件夹
     * @param path
     * @return
     */
    public static boolean isDirectory(String path) throws Exception {   
   	 	FileObject fo = null;
        try {   
            fo = getFile(path);
            if(fo.exists()){
                return fo.getType().equals(FileType.FOLDER);  
            } 
        } catch (FileSystemException e) {   
			logger.error("出现异常", e); 
        } finally{
        	if(fo != null){
                fo.close();
        	}
        } 
        return false;   
    }   
    
    /**
     * 输入流
     * 读取文件内容使用：FileContent.getInputStream()
     * @param path
     * @return
     */
    public static void getInputStream(String path,OutputStream output) throws Exception {  
   	 	FileObject fo = null; 
		InputStream input = null;
        try {   
            fo = getFile(path); 
            if(fo.exists()){
            	input = fo.getContent().getInputStream(); 
                if(input != null){
    				int bytesRead = 0;
    				byte[] buffer = new byte[8192];
    				while((bytesRead = input.read(buffer,0,8192)) != -1){
    					output.write(buffer, 0, bytesRead);
    				}
    				output.flush();
    			} 
            } 
        } catch (FileSystemException e) {   
			logger.error("出现异常", e);
        } finally{
			if(input != null){
				input.close();
				input = null;
			}
        	if(fo != null){
        		fo.getContent().close();
                fo.close();
        	}
        } 
    }   
    
    /**
     * 输出流
     * 写内容使用：FileContent.getOutputStream()
     * @param path
     * @return
     */
    public static boolean writeObject(String path,InputStream inputStream) throws Exception {  
   	 	FileObject fo = null;  
   	 	OutputStream os = null;
        try {   
            fo = getFile(path);   
            os = fo.getContent().getOutputStream();
            int i = 0;
			//缓冲大小为1024字节
			byte[] buffer = new byte[1024];
			while(true) {
				if(inputStream.available() < 1024) {
					while(i != -1) {
						i = inputStream.read();
						os.write(i);
					}
					break;//注意此处不能忘记哦
				} else {
					//当文件的大小大于1024字节时
					inputStream.read(buffer);
					os.write(buffer);
				}
			}
			return true;
        } catch (FileSystemException e) {   
			logger.error("出现异常", e);
        } finally{
		    if(inputStream != null){
			   inputStream.close();
			   inputStream = null;  
		    }
		    if(os != null){
		    	os.close();
		    	os = null;  
		    }
        	if(fo != null){
        		fo.getContent().close();
                fo.close();
        	}
		    
		    System.gc();
        } 
        return false;
    }   
    
    /**
     * 输出流
     * 写内容使用：FileContent.getOutputStream()
     * @param path
     * @return
     */
    public static boolean writeObject(String path, BufferedImage srcImage) throws Exception {  
   	 	FileObject fo = null;  
        try {
            fo = getFile(path);   
            
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();  
            boolean flag = ImageIO.write(srcImage, "jpg", out);  
            byte[] b = out.toByteArray();  
            
            fo.getContent().getOutputStream().write(b);
			return true;
        } catch (FileSystemException e) {   
        	e.printStackTrace();
			logger.error("出现异常", e);
        } finally{
        	if(fo != null){
        		fo.getContent().close();
                fo.close();
        	}
		    System.gc();
        } 
        return false;
    }   
    
    /**
     * 输出流
     * 写内容使用：FileContent.getOutputStream()
     * @param path
     * @return
     */
    public static boolean writeObject(String path,byte[] fileByte) throws Exception {  
   	 	FileObject fo = null;  
        try {
            fo = getFile(path);   
            fo.getContent().getOutputStream().write(fileByte);
			return true;
        } catch (FileSystemException e) {   
        	e.printStackTrace();
			logger.error("出现异常", e);
        } finally{
        	if(fo != null){
        		fo.getContent().close();
                fo.close();
        	}
		    System.gc();
        } 
        return false;
    } 
    
    /**
     * 是否为文件
     * @param path
     * @return
     */
    public static boolean isFile(String path) throws Exception {   
   	 	FileObject fo = null;  
        try {   
            fo = getFile(path);   
            if(fo.exists()){
                return fo.getType().equals(FileType.FILE);  
            } 
        } catch (FileSystemException e) {   
			logger.error("出现异常", e); 
        } finally{
        	if(fo != null){
                fo.close();
        	}
        }  
        return false;   
    }   
    
    /**  
     * 函数描述：根据传入的文件路径创建文件夹(包括各级父文件夹)。如果路径中有文件，会自动去掉文件名。 （文件的判断是  
     * 以最后一个"/"之后是否有"."为标识的，）  
     *   
     * @param path  
     * @return 如果创建成功，返回true；否则，返回false;  
     */  
    public static boolean mkdirs(String path)  throws Exception{   
        String realPath = "";   
        path = path.replaceAll("\\\\", "/");   
        // 如果该路径已"/"结尾，则整个字符串都是路径   
        if (path.endsWith("/")) {   
            realPath = path;   
        } else {   
            int fileNamePoint = path.lastIndexOf("/");   
            // 获取真正的路径   
            if (fileNamePoint >= 0) {   
                realPath = path.substring(0, fileNamePoint);   
            }  
            
            // 读取文件名   
            String fileName = path.substring(fileNamePoint + 1);   
            // 如果读取的文件名中没有"."，说明整个字符串都是路径   
            if (fileName.indexOf(".") < 0) {   
                realPath = path;   
            }   
        }   
        
   	 	FileObject fo = null;  
        try {   
            fo = getFile(realPath);
            fo.createFolder();   
            return true;   
        } catch (Exception e) {   
			logger.error("出现异常", e); 
        } finally{
        	if(fo != null){
                fo.close();
        	}
        }
        return false;   
    } 
  
    /**  
     * 函数描述：对文件进行copy  
     *   
     * @param sourceFilePath  
     *            源文件的全部路径+文件名  
     * @param targetFilePath  
     *            目标文件的全部路径+文件名  
     * @param overWrite  
     *            如果目标文件存在，是否覆盖。true:覆盖；false:不覆盖(当源文件和目标文件都存在并且不覆盖时,返回true)。  
     * @return true:成功；false:失败; (当源文件和目标文件都存在并且不覆盖时,返回true)。  
     */  
    public static boolean copyFile(String sourceFilePath, String targetFilePath, boolean overWrite) throws IOException { 

   	 	FileObject from = null;  
   	 	FileObject to = null;  
    	try {
    		if (StringUtils.isBlank(sourceFilePath) || StringUtils.isBlank(targetFilePath)) {   
                throw new IOException("源文件或者目标文件为空");   
            }   
            from = getFile(sourceFilePath);   
            to = getFile(targetFilePath);   
            if (to.exists()) {   
                if (to.getType() == FileType.FILE) {   
                    if (overWrite && !to.delete()) {   
                        throw new IOException("目标文件[" + targetFilePath + "]被保护，不能被覆盖！");   
                    } else if (!overWrite) {   
                        throw new IOException("目标文件[" + targetFilePath + "]已经存在！");   
                    }   
                }   
            }   
            to.copyFrom(from, Selectors.SELECT_ALL);   
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("出现异常", e);
		} finally{
        	if(from != null){
        		from.close();
        	}
        	if(to != null){
        		to.close();
        	}
        }
        
        return true;   
    } 
    
    /**  
     * Moving a File to Another File ,没有进行磁盘空间大小的判断  
     *   
     * @param srcFile  
     *            源文件 eg: c:\windows\abc.txt  
     * @param targetFile  
     *            目标文件 eg: c:\temp\abc.txt  
     * @param overwrite  
     *            如果目标文件存在，是否覆盖  
     * @return success  
     */  
    public static boolean moveFile(String srcFile, String targetFile, boolean overWrite) throws IOException {   
        if (srcFile.equals(targetFile)) {   
            return true;   
        }   
        FileObject src = null;
        FileObject to = null;
        try{

            src = getFile(srcFile); 
            // Destination directory   
            to = getFile(targetFile); 
            
            // File (or directory) to be moved   
            if (StringUtils.isNotBlank(srcFile) && !src.exists()) {   
                throw new IOException("源文件[" + srcFile + "]不存在");   
            }   
            if (to.exists()) {   
                if (to.getType() == FileType.FILE) {   
                    if (overWrite && !to.delete()) {   
                        throw new IOException("目标文件[" + targetFile + "]被保护，不能被覆盖！");   
                    } else if (!overWrite) {   
                        throw new IOException("目标文件[" + targetFile + "]已经存在！");   
                    }   
                }   
            }
            to.createFile();
            src.moveTo(to);   
            return true;  
        }catch(Exception e){
        	throw new IOException(e);   
        } finally{
        	if(src != null){
        		src.close();
        	}
        	if(to != null){
        		to.close();
        	}
        }
    } 
  
    /**  
     * 文件重命名
     *   
     * @param srcFile  
     *            源文件名eg: c:\windows\abc.txt  
     * @param targetFile  
     *            目标文件名eg: c:\windows\ddd.txt    
     */  
    public static boolean reFileNameTo(String srcPath,String targetPath) throws IOException {
    	FileObject src = null;
    	try {
    		src = getFile(srcPath); 
    		src.moveTo(getFile(targetPath)); 
        	return true;
		} catch (Exception e) {
			logger.error("出现异常", e);
		} finally{
        	if(src != null){
        		src.close();
        	}
        }
		return false;
    }
    
	 /**
     * 输入流
     * 读取文件内容使用：FileContent.getInputStream()
     * @param path
     * @return
	 * @throws FileSystemException 
     */
    public static InputStream getInputStream(String path) throws FileSystemException{  
   	 		FileObject fo = getFile(path); 
            if(fo.exists()){
            	return fo.getContent().getInputStream(); 
            }
			return null; 
    }   
}

package com.unionx.web.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.protobuf.ServiceException;
import com.unionx.core.file.FileManager;
import com.unionx.core.file.FileMeta;
import com.unionx.core.util.VFSFileUtil;
import com.unionx.core.vo.CommonResponse;


@Controller
@RequestMapping("/fileController")
@Slf4j
public class FileController {

    
	@Autowired
	private FileManager fileManager;
	
	
    @ResponseBody
    @RequestMapping("/pictureUpload")
    public CommonResponse uploadbyFtp(HttpServletRequest request,HttpServletResponse response,String topDirectory,String twoDirectory){
		CommonResponse commonResponse = new CommonResponse();
    	String realpaht="";
		try {
    		if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
                
               String path="ftp://rsxtuser:rsxtuser@192.168.1.15:21/"+topDirectory+"/"+twoDirectory+"/";
                VFSFileUtil.mkdirs(path);
                Iterator iter = mr.getFileMap().values().iterator();
                if (iter.hasNext()) {
                	byte[] inputData = null;
                    MultipartFile file = (MultipartFile) iter.next();
                    String filename = file.getOriginalFilename();
                    String before = filename.substring(0, filename.indexOf("."));
                    String after = filename.substring(filename.indexOf(".")+1, filename.length());
                    if(!".jpg.jpeg.gif.ai.pdg".contains(after)){
                    	throw new ServiceException("上传文件格式不正确");
                    }
                    realpaht="http://192.168.1.15:9090/rsxtfj/"+topDirectory+"/"+twoDirectory+"/"+before+System.currentTimeMillis()+"."+after;
            		VFSFileUtil.writeObject(path+before+System.currentTimeMillis()+"."+after,file.getInputStream());
                }
            }
    		commonResponse.setSuccess(true);
			commonResponse.setMessage("上传成功");
			commonResponse.setData(realpaht);
		}catch (ServiceException e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage(e.getMessage());
		}catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("上传失败");
			log.error("", e);
			e.printStackTrace();
		}
    	return commonResponse;
    }
    /**
     * mongodb 上传文件
     * @param request
     * @param response
     * @param topDirectory
     * @param twoDirectory
     * @return
     */
    @ResponseBody
    @RequestMapping("/pictureUploadBydb")
    public CommonResponse uploadbyMongodb(HttpServletRequest request,HttpServletResponse response,String topDirectory,String twoDirectory){
		CommonResponse commonResponse = new CommonResponse();
    	String realpaht="";
		try {
			FileMeta fileMeta = new FileMeta();
    		if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
                Iterator iter = mr.getFileMap().values().iterator();
                if (iter.hasNext()) {
                	byte[] inputData = null;
                    MultipartFile file = (MultipartFile) iter.next();
                    String filename = file.getOriginalFilename();
                    String before = filename.substring(0, filename.indexOf("."));
                    String after = filename.substring(filename.indexOf(".")+1, filename.length());
                    if(!".jpg.jpeg.gif.ai.pdg".contains(after)){
                    	throw new ServiceException("上传文件格式不正确");
                    }
                    fileMeta.setCatetory(topDirectory+"/"+twoDirectory);
                    fileMeta.setFilename(filename);
                    fileMeta.setContentType(file.getContentType());
                    fileMeta.setData(file.getBytes());
                    fileMeta.setSizeCode(file.getSize()+"");
                    fileMeta = fileManager.save(fileMeta);
                }
            }
    		commonResponse.setSuccess(true);
			commonResponse.setMessage("上传成功");
			commonResponse.setData(fileMeta.getAliases());
		}catch (ServiceException e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage(e.getMessage());
		}catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("上传失败");
			log.error("", e);
			e.printStackTrace();
		}
    	return commonResponse;
    }
    
    /**
     * mongodb 返回文件
     * @param request
     * @param response
     * @param topDirectory
     * @param twoDirectory
     * @return
     */
    @RequestMapping("/returnFile/{aliases:.+}")
    public void returnfile(@PathVariable("aliases") String aliases,HttpServletRequest request,HttpServletResponse response){
		CommonResponse commonResponse = new CommonResponse();
		try {
			FileMeta file = fileManager.getFileByAliases(aliases);
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(file.getData());
		}catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
    }
}

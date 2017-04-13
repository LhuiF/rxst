package com.unionx.core.util;

//import org.apache.poi.ss.usermodel.Workbook;

import com.unionx.core.web.HttpContentTypes;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * HttpServletResponse 相关的工具类
 * @author songjunjie
 */
public class ResponseUtils {

    /*
     * 将excel数据写到HttpServletResponse中，浏览器将提示下载文件。默认的编码格式为UTF-8
     * @param response
     * @param workbook POI wekbook对象
     * @param filename 浏览器下载文件时，显示的文件名字
     * @throws IOException
*/
    public static void writeExcel(HttpServletResponse response, Workbook workbook, String filename) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        // 清空response
        response.reset();
        // 设置response的Header
        response.setContentType(HttpContentTypes.XLS+";charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String (filename.getBytes("utf-8"),"iso8859-1"));
        response.addHeader("Content-Length", "" + bytes.length);
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();

    }
}

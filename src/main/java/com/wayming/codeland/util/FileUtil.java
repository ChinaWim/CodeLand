package com.wayming.codeland.util;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Ming
 * Created on 2018/2/10.
 */

public class FileUtil {


    public static String upload(MultipartFile multipartFile, String uploadDir, String fileName, String fileType) {
        String originalFilename = multipartFile.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String type = "";
        if(index != -1){
            type = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        if (fileType != null) {
            type = fileType;
        }
        String newFilename = UUIDUtil.createByTime() + type;
        if (fileName != null) {
            newFilename = fileName + type;
        }
        String realPath = uploadDir + "/" + newFilename;
        try {
            FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(realPath));
            return newFilename;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 下载文件
     *
     * @param fileRealPath 文件完全路径
     * @param response
     * @throws Exception
     */
    public static void downloadFile(String fileRealPath, HttpServletResponse response) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileRealPath);
        File file = new File(fileRealPath);
        response.setHeader("content-disposition", "attachment;filename=" + file.getName());
        OutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024];
        int length = 0;
        while ((length = fileInputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, length);
            outputStream.flush();
        }
        fileInputStream.close();
        outputStream.close();
    }

}

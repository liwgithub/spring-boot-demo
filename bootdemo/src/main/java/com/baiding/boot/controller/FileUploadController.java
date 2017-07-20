package com.baiding.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by BaiDing on 2017/7/19.
 */
@Controller
public class FileUploadController {

    private final static String upload_path="D:/data/www/wifiin/upload/";

    @RequestMapping("/file")
    public String toFile(){
        return "file";
    }

    @RequestMapping("/batchFile")
    public String toBatchFIle(){
        return "/upload/batchFile";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            try{
                String filePath = upload_path+ file.getOriginalFilename();
                System.out.println(filePath);
                file.transferTo(new File(filePath));
            }catch (Exception e){
                e.printStackTrace();
                return "上传失败,"+e.getMessage();
            }
            return"上传成功";
        }else{
            return"上传失败，因为文件是空的.";
        }
    }

    @RequestMapping("/batch/upload")
    @ResponseBody
    public String handleBatchFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try{
                    String filePath = upload_path+ file.getOriginalFilename();
                    System.out.println(filePath);
                    file.transferTo(new File(filePath));
                }catch(Exception e){
                    return"You failed to upload " + i + " => " + e.getMessage();
                }

            }else {
                return"You failed to upload " + i + " because the file was empty.";
            }
        }
        return"upload successful";
    }
}

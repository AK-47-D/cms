package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.dto.FileDto;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("manage")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("file/upload")
    @ResponseBody
    public Result<MultipartFile> upload(MultipartFile file, HttpServletRequest request){
        return fileService.upload(file,request);
    }
    @PostMapping("file/listFile")
    @ResponseBody
    public PageResult<FileDto> listFile(PageResult<FileDto> pageResult){
        return fileService.findList(pageResult).getResult();
    }
}

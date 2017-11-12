package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.dto.FileDto;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    @Override
    public Result<MultipartFile> upload(MultipartFile file, HttpServletRequest request) {
        if(file == null){
            return ResultUtils.instanceResult("未获取到file",null,false,"文件上传");
        }
        String fileName = file.getOriginalFilename();
        String path = CommonContent.UPLOAD_PATH + File.separator;
        if(fileName != null && fileName.indexOf(".") > -1){
            path += fileName.split("\\.")[1];
        }else{
            path += "xxx";
        }
//        String fileName = new Date().getTime()+".jpg";
        logger.info("路径 =========> {}",path);
        File pathFile = new File(path);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        File targetFile = new File(pathFile, fileName);
        if(!targetFile.exists()){
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtils.instanceResult("保存成功",null,true,"文件上传");
    }

    @Override
    public Result<PageResult<FileDto>> findList(PageResult<FileDto> pageResult) {
        File fileDirs = new File(CommonContent.UPLOAD_PATH);
        if(!fileDirs.exists()){
            return ResultUtils.instanceResult("未找到file",pageResult,false,"文件管理");
        }
        int indexFlg = (pageResult.getPageNumber()-1) * pageResult.getPageSize();
        List<FileDto> fileDtos = new ArrayList<>();
        Arrays.stream(fileDirs.listFiles()).forEach(rows -> Arrays.stream(rows.listFiles()).forEach(row -> fileDtos.add(new FileDto(row))));
        pageResult.setTotal(fileDtos.size());
        pageResult.setRows(fileDtos.stream().sorted((f1,f2)->(int)(f2.getModifiedFileDate()-f1.getModifiedFileDate())).skip(indexFlg).limit(pageResult.getPageSize()).collect(Collectors.toList()));

        return ResultUtils.instanceResult("获取成功",pageResult,true,"文件管理");
    }
}

package com.ak47.cms.cms.service;

import com.ak47.cms.cms.dto.FileDto;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public interface FileService  {
    Result<MultipartFile> upload(MultipartFile file,HttpServletRequest request);
    Result<PageResult<FileDto>> findList(PageResult<FileDto> pageResult);
}

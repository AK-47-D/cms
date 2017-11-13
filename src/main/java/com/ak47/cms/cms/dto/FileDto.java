package com.ak47.cms.cms.dto;

import java.io.File;

public class FileDto {
    private String url;
    private String name;
    private String type;
    private Long modifiedFileDate;
    private File file;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getModifiedFileDate() {
        return modifiedFileDate;
    }

    public void setModifiedFileDate(Long modifiedFileDate) {
        this.modifiedFileDate = modifiedFileDate;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileDto(File file) {
        this.file = file;
        this.name = file.getName();
        if(this.name.indexOf(".") > -1){
            String[] name = this.name.split("\\.");
            this.type = name[name.length-1];
        }else{
            this.type = "xxx";
        }
        this.url = "upload/" + this.type + "/"+this.name;
        this.modifiedFileDate = file.lastModified();
    }
}

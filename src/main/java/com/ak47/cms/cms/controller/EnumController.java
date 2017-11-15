package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.enums.ManageCountryEnum;
import com.ak47.cms.cms.enums.ManageFromEnum;
import com.ak47.cms.cms.enums.ManageStatusEnum;
import com.ak47.cms.cms.util.EnumUtil;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class EnumController {

    @GetMapping("findCountryList")
    @ResponseBody
    public List<Map<String,Object>> findCountryList(){
        return EnumUtil.getList(ManageCountryEnum.values());
    }
    @GetMapping("findFromList")
    @ResponseBody
    public List<Map<String,Object>> findFromList(){
        return EnumUtil.getList(ManageFromEnum.values());
    }
    @GetMapping("findStatusList")
    @ResponseBody
    public List<Map<String,Object>> findStatusList(){
        return EnumUtil.getList(ManageStatusEnum.values());
    }
}

package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.api.PBCCrawler;
import com.ak47.cms.cms.entity.PBCArtical;
import com.ak47.cms.cms.enums.PBCType;
import com.ak47.cms.cms.service.PBCArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Controller
@RequestMapping("/news")
public class NewsArticalController {
    @Autowired
    private PBCArticalService PBCArticalService;
    @GetMapping("syncNews")
    public boolean syncNews(){
        List<PBCArtical> pbcArticals = PBCCrawler.instanceCrawler().getAllPBCArtical(PBCType.NEWS.getUrl(),PBCType.NEWS.getTypeCode());
        for(PBCArtical pbcArtical:pbcArticals){
            PBCArticalService.save(pbcArtical);
        }
        return true;
    }
    @PostMapping("findList")
    @ResponseBody
    public List<PBCArtical> findAll(){
        return PBCArticalService.findAll();
    }
}

package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.entity.FocusEvents;
import com.ak47.cms.cms.enums.ManageStatusEnum;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.FocusEventsService;
import com.ak47.cms.cms.validator.FocusEventsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FocusEventsController {

    @Autowired
    private FocusEventsService focusEventsService;
    @Autowired
    private FocusEventsValidator focusEventsValidator;

    @ModelAttribute
    public void setModel(Long id, ModelMap modelMap){
        if(id != null) {
            modelMap.put("focusEvents", focusEventsService.findOne(id));
        }
    }

    @InitBinder("focusEvents")
    public void initBinder(WebDataBinder binder) {
        binder.replaceValidators(focusEventsValidator);
    }

    @PostMapping("manage/focus/saveFocus")
    @ResponseBody
    public Result<FocusEvents> saveFocus(@ModelAttribute @Validated FocusEvents focusEvents, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResultUtils.instanceResult(focusEvents,bindingResult);
        }
        return focusEventsService.saveFocus(focusEvents);
    }
    @PostMapping("manage/focus/findFocusList")
    @ResponseBody
    public PageResult<FocusEvents> findFocusList(PageResult<FocusEvents> pageResult){
        return focusEventsService.findPage(pageResult,null).getResult();
    }
    @GetMapping("/findFocusList")
    @ResponseBody
    public List<FocusEvents> findFocusPage(FocusEvents focusEvents) {
        return focusEventsService.findCmsPage(focusEvents).getResult();
    }
    @GetMapping("/focus/{focusId}")
    public String findFocusOne(@PathVariable Long focusId, ModelMap modelMap) {
        modelMap.addAttribute("focus", focusEventsService.findOne(focusId));
        return "cms_layout/focus/focus_detail";
    }
}

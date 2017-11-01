package com.ak47.cms.cms.advice

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.ModelAndView

@ControllerAdvice
class GlobalExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception::class) //表示捕捉到所有的异常，你也可以捕捉一个你自定义的异常
    fun exception(exception: Exception, request: WebRequest): ModelAndView {
        val modelAndView = ModelAndView("/error") //error页面
        modelAndView.addObject("errorMessage", exception.message)
        modelAndView.addObject("stackTrace", exception.stackTrace)
        return modelAndView
    }
}
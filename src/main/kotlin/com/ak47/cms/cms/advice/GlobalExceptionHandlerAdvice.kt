//package com.ak47.cms.cms.advice
//
//import org.springframework.web.bind.annotation.ControllerAdvice
//import org.springframework.web.bind.annotation.ExceptionHandler
//import org.springframework.web.servlet.ModelAndView
//import javax.servlet.http.HttpServletRequest
//
//@ControllerAdvice
//class GlobalExceptionHandlerAdvice {
//
//    @ExceptionHandler(value = Exception::class) //表示捕捉到所有的异常，你也可以捕捉一个你自定义的异常
//    fun exception(exception: Exception, request: HttpServletRequest): ModelAndView {
//        val modelAndView = ModelAndView("/error") //error页面
//        modelAndView.addObject("errorMessage", exception.message)
//        modelAndView.addObject("stackTrace", exception.stackTrace)
//        modelAndView.addObject("requestURI", request.requestURI)
//        return modelAndView
//    }
//}
package com.exception.controller;

import com.exception.domain.AjaxObject;
import com.exception.domain.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理器
 * @author zhou
 */
@RestControllerAdvice
public class BusinessExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    /**
     * 请求有参数才进来
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "zhou");
    }

    /**
     * 异常处理
     * @param e
     * @param req
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req) {
        AjaxObject r = new AjaxObject();
        //业务异常
        if (e instanceof BusinessException) {
            r.put("code", ((BusinessException) e).getCode());
            r.put("msg", ((BusinessException) e).getMsg());
        } else {
            //系统异常
            r = AjaxObject.error();
        }
        String contentTypeHeader = req.getHeader("Content-Type");
        String acceptHeader = req.getHeader("Accept");
        String xRequestedWith = req.getHeader("X-Requested-With");
        boolean isAjaxRequest = (contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith);
        if (isAjaxRequest) {
            return r;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.addObject("url", req.getRequestURL());
            modelAndView.addObject("stackTrace", e.getStackTrace());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
}

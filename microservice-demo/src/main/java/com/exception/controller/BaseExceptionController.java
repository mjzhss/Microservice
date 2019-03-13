package com.exception.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 统一异常处理
 * @ControllerAdvice是Controller层的全局异常处理
 * @author zhou 2019-02-26 20:31:45
 */
@ControllerAdvice
public class BaseExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(BaseExceptionController.class);

}

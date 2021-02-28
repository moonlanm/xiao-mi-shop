package edu.hubu.xiaomishop.controller;

import edu.hubu.xiaomishop.exception.LoginException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author moonlan
 * date 2021/1/12 下午4:40
 */
@SuppressWarnings(value = "unused")
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(LoginException.class)
    public String loginError(Model model) {
        model.addAttribute("loginErrMsg", "用户名或密码错误");
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String err(Exception e) {
        System.out.println(e);
        return "common/err";
    }

}

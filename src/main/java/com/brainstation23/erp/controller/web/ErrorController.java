package com.brainstation23.erp.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        log.info("Redirect to error page");
        return "404";
    }
}

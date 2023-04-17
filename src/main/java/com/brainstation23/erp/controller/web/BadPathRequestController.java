package com.brainstation23.erp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BadPathRequestController {
	@GetMapping("/{path:[^\\.]*}")
	public RedirectView redirect() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:8080/error");
		return redirectView;
	}
}

package com.whenling.mattress.web.wap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whenling.module.web.controller.BaseController;

@Controller
@RequestMapping("/wap")
public class HomeController extends BaseController {

	@RequestMapping(value = { "", "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		return template("/wap/index");
	}
}

package com.igi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"","/"})
public class DefaultController {
	
	
	public String getIndex()
	{
		return "index";
	}

}

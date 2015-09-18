package com.appt.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspPassThroughController {
	
	@RequestMapping(value = {"/{jspName}.jhtml", "/templates/{jspName}.jhtml"})
	public String jspPassThrough(@PathVariable("jspName") String jspName)
	{		
		return jspName;
	}
}

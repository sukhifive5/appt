package com.appt.web.mvc.controller;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appt.common.ApptConstants;
import com.appt.common.bo.JsonExceptionBo;

@Controller
public class ApptRestController {

	@RequestMapping(value = "/rest/getCurrentDateTime.html")
	public String restGetLatestDayAheadForecastDate(Model model)
	{
		DateTime current = new DateTime();
		JsonExceptionBo jsonException = new JsonExceptionBo();
		
		// add to model for json template
		model.addAttribute("currentDateTime", current);
		model.addAttribute("exception", jsonException);
		return ApptConstants.JSON_TEMPLATE;
	}
}

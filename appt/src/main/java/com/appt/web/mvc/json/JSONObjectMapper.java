package com.appt.web.mvc.json;

import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JSONObjectMapper extends ObjectMapper {
	
	public JSONObjectMapper()
	{
	       SimpleModule module = new SimpleModule("JSONModule", new Version(2, 0, 0, null, null, null));
	       module.addSerializer(Date.class, new DateSerializer());
	       module.addSerializer(DateTime.class, new DateTimeSerializer());
	       module.addSerializer(BigDecimal.class, new BigDecimalSerializer());
	       registerModule(module);
	}

}

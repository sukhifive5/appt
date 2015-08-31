package com.appt.web.mvc.json;

import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTime;

import com.appt.common.utils.DateTimeUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateTimeSerializer extends StdSerializer<DateTime> {

    public DateTimeSerializer() {
        super(DateTime.class);
    }

    @Override
    public void serialize(DateTime value, JsonGenerator json,
            SerializerProvider provider) throws IOException,
            JsonGenerationException {

    	json.writeStartObject();
    	json.writeStringField("date", DateTimeUtils.toString(value));
    	json.writeNumberField("hour", value.getHourOfDay());
    	json.writeNumberField("minute", value.getMinuteOfHour());
    	json.writeEndObject();
    }
}

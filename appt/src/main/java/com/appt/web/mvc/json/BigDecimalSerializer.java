package com.appt.web.mvc.json;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BigDecimalSerializer extends StdSerializer<BigDecimal> {

    public BigDecimalSerializer() {
        super(BigDecimal.class);
    }

    @Override
    public void serialize(BigDecimal bigDecimal, JsonGenerator json,
            SerializerProvider provider) throws IOException,
            JsonGenerationException {

    	DecimalFormat df = new DecimalFormat("#.00");
        String out = df.format(bigDecimal);
        json.writeString(out);
    }
}

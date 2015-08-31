package com.appt.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class HTMLUtils {

	/**
	 * Forces HTML wrapping at a certain character limit
	 */
	public static String forceWrappingInHTML(String str, Integer length) {
		if (str==null)
           return str;
		str = str.trim();
		if ((str.length() > length) && (length > 0)) {
    	   String returnStr = "";
    	   int numCharWithoutSpace = 0;
    	   for (int i=0; i < str.length(); i++) {
    		   char c = str.charAt(i);
    		   if (Character.isWhitespace(c)) 
    			   numCharWithoutSpace = 0;
    		   else
    			   numCharWithoutSpace++;
	   
    		   returnStr = returnStr + Character.toString(c);
    		   if (numCharWithoutSpace == length) {
    			   returnStr = returnStr + "<BR>";
    			   numCharWithoutSpace = 0;
    		   }
    	   }
    	   return returnStr;
       }
       return str;
	}
	
	
	/**
	 * Returns an exception stack trace as a string.
	 * @param aThrowable
	 * @return
	 */
	public static String getStackTrace(Throwable aThrowable) {
	    final Writer result = new StringWriter();
	    final PrintWriter printWriter = new PrintWriter(result);
	    aThrowable.printStackTrace(printWriter);
	    return result.toString();
	}
}

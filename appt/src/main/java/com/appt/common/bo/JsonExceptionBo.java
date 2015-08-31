package com.appt.common.bo;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonExceptionBo {
	private String exceptionCode;
	private String exceptionMessage;
	@JsonIgnore private DateTime execptionTime;
	
	public String getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public DateTime getExecptionTime() {
		return execptionTime;
	}
	public void setExecptionTime(DateTime execptionTime) {
		this.execptionTime = execptionTime;
	}	
}

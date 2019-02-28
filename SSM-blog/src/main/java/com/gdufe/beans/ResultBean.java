package com.gdufe.beans;

public class ResultBean {
	boolean success;
	String message;
	Object value;

	public ResultBean(boolean success, String message, Object value) {
		this.success = success;
		this.message = message;
		this.value=value;
	}

	public ResultBean(boolean success, String message) {
		this.success = success;
		this.message = message;
		this.value=null;
	}
	
	public ResultBean(boolean success) {
		this.success = success;
		this.message = "";
		this.value=null;
	}

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}

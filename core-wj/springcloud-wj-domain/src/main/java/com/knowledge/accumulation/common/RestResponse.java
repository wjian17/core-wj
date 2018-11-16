package com.knowledge.accumulation.common;

public class RestResponse {

	/**
	 * 业务流水号
	 */
	private String serialNo;

	/**
	 * 返回头信息，包括返回码（ErrorCode类中定义的类型）和返回信息
	 */
	private ResponseHeader responseHeader = new ResponseHeader();
	
	/**
	 * 返回体，也就是真正的业务数据，可以是List、Map、Object等类型
	 */
	private Object responseBody;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

}

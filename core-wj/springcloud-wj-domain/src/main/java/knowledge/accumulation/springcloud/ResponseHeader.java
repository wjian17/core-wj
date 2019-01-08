package knowledge.accumulation.springcloud;

public class ResponseHeader {

	/**
	 * 返回码，在ErrorCode类中定义
	 */
	private String errorCode;
	
	/**
	 * 返回信息，包括成功和失败的信息
	 */
	private String message;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

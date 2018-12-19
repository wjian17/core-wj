package com.knowledge.accumulation.utils.exception;

/**
 * @author wj
 */
public class AppException extends Exception {

	private static final long serialVersionUID = 863914125581806736L;

	public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

}

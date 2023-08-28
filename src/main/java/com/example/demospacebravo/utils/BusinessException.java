package com.example.demospacebravo.utils;

/**
 * 基本业务异常。
 *
 * @author wangruiv
 * @date 2017-07-04 09:03:19
 */
public class BusinessException extends RuntimeException {
	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	protected BusinessException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

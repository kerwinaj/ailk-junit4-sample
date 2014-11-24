package com.ailk.util;

public class IncorrectIp4FormatException extends RuntimeException {
	private static final long serialVersionUID = -7212331388019812480L;

	public IncorrectIp4FormatException(String msg, Exception e) {
		super(msg, e);
	}

	public IncorrectIp4FormatException(String msg) {
		super(msg);
	}
}

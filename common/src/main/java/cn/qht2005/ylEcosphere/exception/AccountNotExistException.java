package cn.qht2005.ylEcosphere.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountNotExistException extends BaseException{

	public AccountNotExistException(String message) {
		super(message);
	}
	public AccountNotExistException() {
		super("用户不存在！");
	}
}

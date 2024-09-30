package cn.qht2005.ylEcosphere.exception;

public class LoginFailedException extends BaseException{
	public LoginFailedException(String message) {
		super(message);
	}
	public LoginFailedException() {
		super("登录失败！请重试！");
	}
}

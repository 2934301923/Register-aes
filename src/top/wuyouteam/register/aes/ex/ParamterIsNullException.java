package top.wuyouteam.register.aes.ex;
/**
 * 若调用方法时传入的参数为空串或为null将会抛出该异常
 * @author ASUS
 *
 */
public class ParamterIsNullException extends RuntimeException {

	private static final long serialVersionUID = -9109094541917127890L;

	public ParamterIsNullException() {
		//  Auto-generated constructor stub
	}

	public ParamterIsNullException(String message) {
		super(message);
		//  Auto-generated constructor stub
	}

	public ParamterIsNullException(Throwable cause) {
		super(cause);
		//  Auto-generated constructor stub
	}

	public ParamterIsNullException(String message, Throwable cause) {
		super(message, cause);
		//  Auto-generated constructor stub
	}

	public ParamterIsNullException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		//  Auto-generated constructor stub
	}

}

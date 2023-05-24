import java.util.Scanner;

public class InvalidOCCCDateException extends IllegalArgumentException{
	public String msg;
	public static final String DEFAULT_INVALDIOCCCDATEEXCEPTION_MESSAGE = "Invalid Date";
	
	public InvalidOCCCDateException(){
		super();
		msg = DEFAULT_INVALDIOCCCDATEEXCEPTION_MESSAGE;
	}
	
	public InvalidOCCCDateException(String msg){
		super();
		this.msg = new String(msg);
	}
	
	@Override
	public String getMessage(){
		return new String(msg);
	}
	
	@Override
	public String toString(){
		return getClass().getName() + ": " + msg;
	}
}
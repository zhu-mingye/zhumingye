/**
 * 
 */
package com.DemoAll.Utils;

 
/**
 * 说明:
 * 
 * @version 1.0
 *
 */
public class AssertUtil {

	/**
	 * 功能说明：断言为真<br>
	 * @param exp
	 * @param defaultMessage
	 * void
	 * @throws Exception 
	 */
	public static void isTrue(Boolean exp, String defaultMessage) throws Exception{
		if(!Boolean.TRUE.equals(exp)){
			throw new Exception(defaultMessage);
		}
	}
	
	/**
	 * 功能说明：断言为假<br>
	 * @param exp
	 * @param defaultMessage
	 * void
	 * @throws Exception 
	 */
	public static void isFalse(Boolean exp, String defaultMessage) throws Exception{
		if(exp != null && exp){
			throw new Exception(defaultMessage);
		}
	}
	
	/**
	 * 功能说明：断言字符串必须有值<br>
	 * @param exp
	 * @param defaultMessage
	 * void
	 * @throws Exception 
	 */
	public static void hasLength(String exp, String defaultMessage) throws Exception{
		if(exp == null || exp.length() == 0){
			throw new Exception(defaultMessage);
		}
	}
	
	public static void notNull(Object object, String defaultMessage) throws Exception{
		if(object == null){
			throw new Exception(defaultMessage);
		}
	}
	
}

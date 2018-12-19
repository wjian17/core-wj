package com.knowledge.accumulation;

public class ErrorCode {

	//-------------------------业务异常类-------------------------
	public static final String SUCCESS = "0"; //成功

	public static final String EXCEPTION = "500"; //系统未知异常

	public static final String INIT_FAIL = "505"; // 初始化识别

	public static final String SYSTEM_BUSY = "600"; // 系统繁忙

	public static final String NOT_VALID_CLIENT = "403"; //未在平台注册的客户端

	public static final String CALL_ALGORITHM_FAIL = "605"; // 算法调用失败

	public static final String SERIAL_FILE_NOT_EXISTS = "606"; // 流水文件不存在
	public static final String MULTI_SERIAL_FILES = "607"; // 找到多个流水文件

	public static final String ALG_NOT_SUPPORT = "1001"; // 平台不支持

	public static final String WRONG_PARAM = "10000"; // 参数错误

}

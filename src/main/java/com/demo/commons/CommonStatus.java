package com.demo.commons;

public class CommonStatus {
	/**
	 * 参数
	 */
	public final static String PARAM_SING="sign";
	public final static String PARAM_USER_ID="userId";
	public final static String PARAM_TIMESTAMP="timestamp";
	public final static String PARAM_IMEI="imei";
	public final static String CURRENT_USER="current_user";
	public final static String REQUEST_IP="ip";
	
	/**
	 * 支付参数
	 */
	public final static String ENCRYPT_TYPE_RSA="RSA";//加密类型
	public final static String ENCRYPT_TYPE_3DES="3DES";//加密类型
	public final static String ENCRYPT_TYPE_DES="3DES";//加密类型
	public final static String SING_TYPE="SHA-256";//签名类型
	public final static String CHARSET="UTF-8";
	
	/**
	 * 支付返回参数
	 */
	public final static String RETURN_PARAM_NULL="RETURN_PARAM_NULL";//返回数据为null
	public final static String SYSTEM_ERROR="SYSTEM_ERROR";
	public final static String OUT_TRADE_NO_EXIST="OUT_TRADE_NO_EXIST";
	public final static String TRADE_NOT_EXIST="TRADE_NOT_EXIST";
	public final static String ILLEGAL_SIGN="ILLEGAL_SIGN";
	public final static String SUCCESS="0000";
	
	public final static String TRADE_FINI="FINI";//交易成功
	public final static String TRADE_CLOS="CLOS";//交易关闭，失败
	public final static String TRADE_WPAR="WPAR";//等待支付结果
	public final static String TRADE_BUID="BUID";//交易建立
	public final static String TRADE_REFU="REFU";//交易退款
	public final static String TRADE_ACSU="ACSU";//已受理
	
	public final static String PAY_TOOL="TRAN";
	
	public final static String PAY_RETURN="PAY_RETURN";
	public final static String PAY_NOTIFY="PAY_NOTIFY";
	
	/**
	 * 短信类
	 */
	public final static String SMS_CODE_SUCCSEE="0";//发送成功
	public final static String SMS_CODE_FAIL="1";//发送失败
	public final static int SMS_TYPE_MANUAL=0;//手动发送
	public final static int SMS_CODE_AUTO=1;//自动发送
	public final static String SMS_STATE_WAIT="WAIT";//消息发送的默认状态
	
	/**
	 * spring定时任务的cron表达式的
	 */
	public static final String EVERY_HALF_MINUTE = "30 * * * * ?"; //每半分钟触发任务
	public static final String EVERY_ONE_MINUTE = "0 0/1 * * * ?"; //每一分钟触发任务
	public static final String EVERY_TOW_MINUTE = "0 0/2 * * * ?"; //每两分钟触发任务
	public static final String EVERY_FIVE_MINUTE = "0 0/5 * * * ?"; //每五分钟触发任务
	public static final String COMMIT_PRODUCTVIEW_TIME = "0 0/30 9-17 * * ?"; //朝九晚五工作时间内每半小时 
	public static final String PRODUCTVIEW_TIME = "0/30 * 8-23 * * ?";
	public static final String EVERY_MIDNIGHT = "0 0 1 * * ?";//每天凌晨

	/**
	 * 短信验证码有效时间：分钟
	 */
	public final static Integer SYS_TIME = 30;
	public final static Integer SYS_COUNT = 10;//一个IP一天内发短信的次数
	
	
	/**
	 * 用户来源(字典表：type=source)
	 */
	public final static int SOURCE_ANDROID=1;//安卓
	public final static int SOURCE_IOS=2;//ios
	public final static int SOURCE_PC=3;//pc端
	public final static int SOURCE_OTHER=4;//其他
	
	public final static String SHRIO_SESSION = ":ShrioSession";//session共享

	/**
	 * 用户认证状态
	 */
	public final static int PRE_APPROVAL = 1;//未认证
	public final static int APPROVALING = 2;//审核中
	public final static int APPROVAL = 3;//认证通过
	public final static int NO_APPROVAL = 4;//认证不通过
}



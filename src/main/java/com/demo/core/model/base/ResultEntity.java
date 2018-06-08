package com.demo.core.model.base;


public class ResultEntity {
	private int responseCode;//响应码 0-失败  1-成功
	private String responseMsg;//响应信息
	private Object responseData;//返回其他自定义信息
	
	public ResultEntity(int responseCode){
		this.responseCode = responseCode;
	}
	public ResultEntity(int responseCode,String responseMsg,Object responseData){
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.responseData = responseData;
		
	}
	
	public ResultEntity(int responseCode,Object responseData){
		this.responseCode = responseCode;
		this.responseData = responseData;
	}
	
	public ResultEntity(int responseCode,String responseMsg){
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

}

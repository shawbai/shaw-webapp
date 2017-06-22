package com.shaw.blog.enums;

public enum AuditType {
	Person_Audit(0,"个人申请"),
	Company_Audit(1,"公司申请");
	
	private Integer code;
	private String msg;
	
	private AuditType(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static String getMsg(Integer code){
		for(AuditType auditType:AuditType.values())
		{	
			if(auditType.getCode()==code)
				return auditType.getMsg();
		}
		return null;
	}
	
	
}

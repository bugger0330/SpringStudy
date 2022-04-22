package com.instagram.app.web.util.auth;

public class AuthResponseScript {

	public String signupScript(boolean result) {
		StringBuilder script = new StringBuilder();
		
		if(result) {
			script.append("<script>");
			script.append("alert(\"회원가입 완료.\");");
			script.append("location.replace(\"/app/auth/signin\");"); // replace 히스토리가 삭제되서 뒤로가기가 안된다
			script.append("</script>");
		}else {
			script.append("<script>");
			script.append("alert(\"회원가입 실패.\");");
			script.append("history.back();"); // == location.href 히스토리가 살이있어서 뒤로가기가 가능하다
			script.append("</script>");
		}
		return script.toString();
	}
	
	public String signinValidScript(String msg) {
		StringBuilder script = new StringBuilder();
		
		script.append("<script>");
		script.append("alert(\"" + msg + "\");");
		script.append("location.replace(\"/app/auth/signin\");"); // replace 히스토리가 삭제되서 뒤로가기가 안된다
		script.append("</script>");
		
		return script.toString();
	}
	
}

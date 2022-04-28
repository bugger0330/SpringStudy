const profileUsername = document.querySelector(".profile-username");
const passwordInputs = document.querySelectorAll(".password-input");
const submitBtn = document.querySelector(".submit-btn");

//내가 만든거(미완)

let usercode = 0;

let principal = getPrincipal();

load();

function load(){
	profileUsername.textContent = principal.username;
}

function isEmpty(str){
	return typeof str == "undefined" || str == "" || str == null;
}




submitBtn.onclick = () => {
	
	let originPassword = passwordInputs[0].value;
	let newPassword = passwordInputs[1].value;
	let newRePassword = passwordInputs[2].value;
	let originPassword2 = principal.getPassword;//dddddd
	
	if(isEmpty(originPassword)){
		alert("이전 비밀번호를 입력해 주세요.");
	} else if(isEmpty(newPassword)){
		alert("새 비밀번호를 입력해 주세요.");
	} else if(newPassword != newRePassword){
		alert("새 비밀번호가 일치하지 않습니다.");
	} else if(originPassword != originPassword2){
		alert("이전 비밀번호를 확인해 주세요.");
	} else {
		document.querySelector("form").submit();
	}
	
	$.ajax({
		type : "put",
		url : "/app/profile/account/password/update",
		data : JSON.stringify(user),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(data){
			if(data == "true"){
				alert("회원정보 수정 완료");
				location.replace("/app/profile/account");
			}else{
				alert("이미 존재하는 비밀번호 입니다");
			}
		},
		error : function(){
			alert("비동기 처리 오류");
		}
	});
}











passwordUpdateBtn.onclick = () => {
	let originPasswordInput = itemInputs[0].value;
	let newPasswordInput = itemInputs[1].value;
	let newRePasswordInput = itemInputs[2].value;
	
	
	
}





























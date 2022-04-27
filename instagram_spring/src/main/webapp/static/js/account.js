const profileUsername = document.querySelector(".profile-username");
const textInputs = document.querySelectorAll(".text-input");
const inctroduceText = document.querySelector(".text-textarea");

const submitBtn = document.querySelector(".submit-btn");
let usercode = 0;

let principal = getPrincipal();

load();

function load(){
	$.ajax({
		type:"get",
		url:"/app/profile/account/user",
		data: {
			usercode:principal.usercode
		},
		dataType:"text",
		success: function(data){
			let account = JSON.parse(data);
			pageLoad(account);
			alert("usercode : " + usercode);
		},
		error: function(){
			alert("비동기 처리 오류");
		}
	});
}



function pageLoad(account){
	usercode = account.usercode;
	profileUsername.textContent = account.username;
	textInputs[0].value = account.name;
	textInputs[1].value = account.username;
	textInputs[2].value = account.website;
	inctroduceText.value = account.introduce;
	textInputs[3].value = account.email;
	textInputs[4].value = account.phone;
	textInputs[5].value = account.gender;
	
}

submitBtn.onclick = () => {
	account = createAccount();
	$.ajax({
		type : "put",
		url : "/app/profile/account/update",
		data : JSON.stringify(account),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(data){
			if(data == "true"){
				alert("회원정보 수정 완료");
				location.replace("/app/profile/account");
			}else{
				alert("이미 존재하는 사용자 이름 입니다");
			}
		},
		error : function(){
			alert("비동기 처리 오류");
		}
	});
}

function createAccount(){
	let account = {
		"usercode" : usercode,
		"name" : textInputs[0].value,
		"username" : textInputs[1].value,
		"website" : textInputs[2].value,
		"introduce" : inctroduceText.value,
		"email" : textInputs[3].value,
		"phone" : textInputs[4].value,
		"gender" : textInputs[5].value
	}
	return account;
}

























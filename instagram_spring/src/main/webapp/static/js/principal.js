function getPrincipal(){
	let principal = null;
	
	$.ajax({
		type : "get",
		url : "/app/api/principal",
		async : false,
		dataType : "text",
		success : function(data){
			principal = JSON.parse(data);
		},
		error : function(){
			alert("비동기 처리 오류");
		}
	});
	return principal;
}

//async : false ==  동기 처리
//async : 기본값(true) ==  비동기 처리(생략)
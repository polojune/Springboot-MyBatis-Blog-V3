let index = {
	    
		init:function(){
		//1.리스너
		$("#btn-save").on("click",()=>{
			//콜백 스텍
			this.save();
		});
		//2.리스너
		$("#btn-login").on("click",()=>{
			//콜백 스텍
			this.login();
		});
		$("#btn-update").on("click",()=>{
			//콜백 스텍
			this.update();
		});
		},
   
	 save:function(){
		 let data = {
			username:$("#username").val(),	 
			password:$("#password").val(),	 
			email:$("#email").val()	 
		 };
		 
		$.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp){
		  
			   alert("회원가입 성공"); 
			   location.href="/";
		   
			console.log(resp);
		//console.log(JSON.parse(resp));
		}).fail(function(error){
			
			alert("회원가입 실패")
			console.log(error);
		}) 
	 },
	 
	 login:function(){
		 let data = {
			username:$("#username").val(),	 
			password:$("#password").val()	 
			 
		 };
		 
		$.ajax({
			type:"POST",
			url:"/auth/loginProc",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp){
		   if(resp.statusCode == 1){
		    alert("로그인 성공"); 
		    location.href="/";	
			console.log(resp);
		   }else{
			   alert("아이디와 패스워드를 다시 입력하세요"); 
			   console.log(resp);
		   }
		//console.log(JSON.parse(resp));
		}).fail(function(error){
			
			alert("로그인 실패")
			console.log(error);
		}) 
	 },
	 
	 update: function(){
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			};

			$.ajax({
				type: "POST",
				url: "/user/updateProc",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			})
			.done(function(resp){
				console.log("회원정보 수정 후 resp: ",resp);
				if (resp.statusCode == 1) {
					alert("회원정보 수정에 성공했습니다");
					location.href="/";
				} else {
					alert("회원정보 수정 실패네요");
				}
			})
			.fail(function(error){
				alert("회원정보 수정 실패입니다", error);
			});
	 }
}

index.init();
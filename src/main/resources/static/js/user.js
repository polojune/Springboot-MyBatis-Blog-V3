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
		   
		    alert("로그인 성공"); 
		    location.href="/";	
			console.log(resp);
		//console.log(JSON.parse(resp));
		}).fail(function(error){
			
			alert("로그인 실패")
			console.log(error);
		}) 
	 },
}

index.init();
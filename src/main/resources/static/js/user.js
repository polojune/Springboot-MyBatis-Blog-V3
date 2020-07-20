let index = {
	
		init:function(){
		
		$("#btn-save").on("click",()=>{
			this.save();
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
		   if(resp.statusCode == 1){
			   alert("회원가입 성공"); 
			   location.href="/";
		   }
			console.log(resp);
		//console.log(JSON.parse(resp));
		}).fail(function(error){
			console.log(error);
		}) 
	 },
}

index.init();
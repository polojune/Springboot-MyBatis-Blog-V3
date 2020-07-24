let index = {
	    
		init:function(){
		//1.리스너
		$("#btn-save").on("click",()=>{
			//콜백 스텍
			this.save();
		});
		},
	
	 save:function(){
		 let data = {
			title:$("#title").val(),	 
			password:$("#content").val(),	 
			userId:$("#userId").val()	 
		 };
		 
		$.ajax({
			type:"POST",
			url:"/post",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp){
		       console.log(resp);
			   alert("글쓰기 성공"); 
			   location.href="/";
		   
			console.log(resp);
		//console.log(JSON.parse(resp));
		}).fail(function(error){
			
			alert("글쓰기 실패")
			console.log(error);
		}) 
	 },
	 

	 
}

index.init();
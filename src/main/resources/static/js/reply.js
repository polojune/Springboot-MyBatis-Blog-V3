let index = {
	    
		init:function(){
			//1.리스너
			$("#btn-reply").on("click",()=>{
				//콜백 스텍
				this.save();
			});
			
					
		//1.리스너
		$("#btn-delete").on("click",()=>{
			//콜백 스텍
			this.deleteOne();
//		});
//		
//		$("#btn-update-mode").on("click",()=>{
//			//콜백 스텍
//			this.updateMode();
//		});
//		$("#btn-update").on("click",()=>{
//			//콜백 스텍
//			this.update();
//		});
//		 $("#btn-update").hide();
		
		},
		
//		update:function(){
//		    
//			let data = {
//				id:$("#id").val(),
//				title:$("#title").val(),	 
//				content:$("#content").val(),	 
//				 
//			 };
//			 
//			$.ajax({
//				type:"PUT",
//				url:"/post/"+data.id,
//				data:JSON.stringify(data),
//				contentType:"application/json; charset=utf-8", 
//				dataType:"json"
//			}).done(function(resp){
//			       console.log(resp);
//				   alert("수정 성공"); 
//				   location.href="/post/"+data.id;
//			   
//				console.log(resp);
//			//console.log(JSON.parse(resp));
//			}).fail(function(error){
//				
//				alert("수정 실패")
//				console.log(error);
//			}) 
//		 },
		
		 save:function(){
			 let data = {
				reply:$("#reply").val(),	 
				userId:$("#userId").val()	 
			 };
			 
			$.ajax({
				type:"POST",
				url:"/reply",
				data:JSON.stringify(data),
				contentType:"application/json; charset=utf-8", 
				dataType:"json"
			}).done(function(resp){
			       console.log(resp);
				   alert("댓글쓰기 성공"); 
				   location.href="/post/{id}";
			   
				//console.log(resp);
			//console.log(JSON.parse(resp));
			}).fail(function(error){
				
				alert("댓글쓰기 실패")
				console.log(error);
			}) 
		 },
		 
		
	 deleteOne:function(){
		 let data = {
			 id:$("#id").val()
		 };
		 
		$.ajax({
			type:"DELETE",
			url:"/post/"+data.id,						
			dataType:"json"
		}).done(function(resp){
		       console.log(resp);
			   alert("글삭제 성공"); 
			   location.href="/";
		   
			console.log(resp);
		//console.log(JSON.parse(resp));
		}).fail(function(error){
			
			alert("글삭제 실패")
			console.log(error);
		}) 
	 },
	 
//	 updateMode:function(){
//		 $("#btn-update-mode").hide();
//		 $("#btn-update").show();
//		 
////		 let element = $("#btn-update-mode"); 
////		 element.attr("class","btn btn-primary"); 
////		 element.attr("id","btn-update"); 
////		 element.text("수정하기");
//		 
//		 $("#title").attr("readonly", false);
//		 $("#content").attr("readonly", false);
//	 }
//	 	 
}

index.init();
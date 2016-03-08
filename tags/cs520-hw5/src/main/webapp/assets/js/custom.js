$(document).ready(function(){

	$(".deleteProgram").click(function(){
		var programId = $(this).prop("id");
		var departmentId = $(this).attr("departmentId");
		var answer = confirm("Are you sure want to delete ? ");
		var url = $(this).attr("url");
		if(answer){
			$.ajax({
				type:"GET",
				url:url,
				data:{id:programId,departmentId:departmentId},
				dataType:"json",
				beforeSend:function(){},
				success:function(data){

				},
				error:function(){

				}
			});
		}
	});

	//Edit Department Name



});
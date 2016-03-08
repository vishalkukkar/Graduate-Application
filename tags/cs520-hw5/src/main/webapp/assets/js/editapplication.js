var counter = 0;
$(document).ready(function(){
	"use strict";
	counter = parseInt($("#existingEBCount").val());
	$("#addNewButton").on('click',function(){
		getNew();
	});
	
	$(".removeEB").on('click',function(){
		var rel = $(this).attr("rel");
		var id = $(this).prop("id");
		if(id == 0){
			$(rel).remove();
			counter--;
		}else{
			$.ajax({
				type : 'POST',
				url : '/springmvc/RemoveEdu.html',
				data : {backId : id},
				cache : false,
				dataType : 'json',
				beforeSend : function(){},
				success : function(data) {
					$(rel).fadeOut('slow');
				},
				error : function(
				data) {
				alert("error");}
			});
		}
	});
});

function removeEB(rel){
	$(rel).remove();
	
}

function getNew(){
	counter =counter + 1;
	var eb ="<div class='well' id='eb_"+counter+"'> &nbsp <strong>Educational Background #<strong><input type='button' class='btn btn-danger pull-right control-group removeEB' name='background' rel='#eb_"+counter+"' id='0' value='Remove' />";
	eb +="<br/><br/>";
	eb +="<b>University</b>:<input type='text' class='form-control' name='university[]' placeholder='Univerisity...'>";
	eb +="<b>Degree </b>:<input type='text' class='form-control' name='degree[]' placeholder='Degree...'> ";
	eb +="<b>Major</b>:<input type='text' class='form-control' name='major[]'  placeholder='Major...' > ";
	eb +="<b>Start Date</b>: <input type='text' class='form-control' name='startDate[]' placeholder='m/d/yy...' id='datepicker1'> ";
	eb +="<b>End	Date</b>: <input type='text' class='form-control' name='endDate[]' id='datepicker2' placeholder='m/d/yy...'></div>";
	eb +="</div>";
	
	$("#addnew").append(eb);
	$("#addNewCount").val(counter);
}


/*function getNew(){
	counter =counter + 1;
	var eb ="<div class='well' id='eb_"+counter+"'> &nbsp <strong>Educational Background #<strong><input type='button' class='btn btn-danger pull-right control-group removeEB' name='background' rel='#eb_"+counter+"' id='0' value='Remove' />";
	eb +="<br/><br/>";
	eb +="<b>University</b>:<input type='text' class='form-control' name='university[]' placeholder='Univerisity...'>";
	eb +="<b>Degree </b>:<input type='text' class='form-control' name='degree[]' placeholder='Degree...'> ";
	eb +="<b>Major</b>:<input type='text' class='form-control' name='major[]'  placeholder='Major...' > ";
	eb +="<b>Start Date</b>: <input type='text' class='form-control' name='startDate[]' placeholder='m/d/yy...' id='datepicker1'> ";
	eb +="<b>End	Date</b>: <input type='text' class='form-control' name='endDate[]' id='datepicker2' placeholder='m/d/yy...'></div>";
	eb +="</div>";
	
	$("#addnew").append(eb);
	$("#addNewCount").val(counter);
}*/

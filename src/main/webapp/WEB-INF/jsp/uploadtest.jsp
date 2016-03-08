<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    
</head>
<body>
    <form id="fileUploadForm" action="uploadtest1"  enctype="multipart/form-data">
      <input type="text" name="filename" />
      <input type="file" id="postedFile" name="postedFile" />
      <input type="submit" value="Submit" />
    </form>
    
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="http://malsup.github.io/jquery.form.js"></script>
    
    
		
    <script type="text/javascript">
        $(function() {  
        	"use strict"
          $('#fileUploadForm').ajaxForm({  
        	type : 'GET',
      		url : '/springmvc/getProgram.html',
      		cache : false,
    		dataType : 'json',
            beforeSubmit: ShowRequest,
            success: SubmitSuccesful,
            error: AjaxError                               
          });                                    
        });            

        function ShowRequest(formData, jqForm, options) {
          var queryString = $.param(formData);
          alert('BeforeSend method: \n\nAbout to submit: \n\n' + queryString);
          return true;
        }

        function AjaxError() {
          alert("An AJAX error occured.");
        }

        function SubmitSuccesful(responseText, statusText) {        
          alert("SuccesMethod:\n\n" + responseText);
        }    
    </script>
    </body>
</html>
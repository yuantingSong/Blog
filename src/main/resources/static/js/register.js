var namCheck = false
var pswCheck = false

$(document).ready(function(){
    $("#btn").addClass('disable')
    $('input').change(function(){ 
        if(window.pswCheck && window.nameCheck){
        	if ($("#btn").hasClass('disable')) {
        		$("#btn").removeClass('disable')
        	}
        } else {        
        	if (!$("#btn").hasClass('disable')) {
	    		$("#btn").addClass('disable')
	    	}
        }
    });
});

function register() {  
	var user = {}
	user["username"] = $("#username").val();
	user["password"] = $("#password").val();  
	user["email"] = $("#email").val();  
	$.ajax({
        method: "post",
        url: "/register",  
        async:false,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user),
        success: function(data) {
        		alert(data.message)
        		if (data.msg == "success") {
        			 window.location.href = "/login";
        		}
		},
		error: function(data) {
			alert(data)
		}
	}) 
} 

function checkPassword() {
	  if ($('#password').val() == $('#confirmPassword').val()) {
	    $('#passwordMsg').html('Matching').css('color', 'green');
	    window.pswCheck = true;
	  } else {
		$('#passwordMsg').html('Not Matching').css('color', 'red');  
		window.pswCheck = false;
	  }
	};
	
function checkUsername() {
	var user = {}
	user["username"] = $("#username").val();
	$.ajax({
        method: "post",
        url: "/checkUsername",  
        async:false,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user),
        success: function(data) { 
        		if (data.message == "existing") {
        			 $('#usernameMsg').html('Existing').css('color', 'red');
        			 window.nameCheck = false;
        		} else { 
            		$('#usernameMsg').html('Available').css('color', 'green');
            		window.nameCheck = true;
        		}
		},
		error: function(data) {
			 $('#usernameMsg').html('Available').css('color', 'green');
		}
	})
}

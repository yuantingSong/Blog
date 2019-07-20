
function register() {  
	var user = {}
	user["username"] = $("#username").val();
	user["password"] = $("#password").val();  
	user["email"] = $("#email").val();  
	$.ajax({
        method: "post",
        url: "/user/register",  
        async:false,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user),
        success: function(data) {
        		alert(data.msg)
        		if (data.msg == "success") {
        			 window.location.href = "/login";
        		}
		},
		error: function(data) {
			alert("data")
		}
	}) 
 
} 

function checkPassword() {
	  if ($('#password').val() == $('#confirmPassword').val()) {
	    $('#passwordMsg').html('Matching').css('color', 'green');
	  } else 
	    $('#passwordMsg').html('Not Matching').css('color', 'red');
	};
	
function checkUsername() {
	var user = {}
	user["username"] = $("#username").val();
	$.ajax({
        method: "post",
        url: "/user/checkUsername",  
        async:false,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user),
        success: function(data) { 
        		if (data.msg == "existing") {
        			 $('#usernameMsg').html('Existing').css('color', 'red');
        		} else { 
            		$('#usernameMsg').html('Available').css('color', 'green');
        		}
		},
		error: function(data) {
			 $('#usernameMsg').html('Available').css('color', 'green');
		}
	})
}
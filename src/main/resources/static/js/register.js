
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
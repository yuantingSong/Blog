 
$(document).ready(function(){
	$('#search-form').submit(function(event){
		//stop submit the form, we will post it manually.
        event.preventDefault();
        register();
	});
}); 
function register() { 

	//alert("??");
	debugger;
	var user = {}
	user["username"] = $("#username").val();
	user["password"] = $("#password").val(); 
	
	alert("!!");
	$.ajax({
        method: "post",
        url: "/register",  
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user),
        success: function(data) {
			alert("success")
		},
		error: function(data) {
			alert("fail")
		}
	})

} 
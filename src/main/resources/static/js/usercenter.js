function profile(userId) {
	$.ajax({
		url:"/profile/"+userId,
		dataType:"json",
		type:'get',
		cache:false,
		success:function(data) {
			
		}
		})
}
function myarticles() {
    $.ajax({
        url: "/myarticles",
        dataType: 'json',
        type: 'get',
        cache:false,
        success: function(data){  
        	$("#myarticles").find("tbody").empty();
            var event_data = '';
            $.each(data, function(index, article){
                /*console.log(value);*/
                event_data += '<tr>';
                event_data += '<td>'+article.articleId+'</td>';
                event_data += '<td>'+article.articleTitle+'</td>'; 
                event_data += '<td>'+article.authorName+'</td>';
                event_data += '<td>'+article.Date+'</td>'; 
                event_data += '<td>'+'<a href="/articles/' + article.articleId + '">view</a>'+'</td>'; 
                event_data += '</tr>';
            });
            $("#myarticles").append(event_data);
        },
        error: function(d){ 
            alert("404. Please wait until the File is Loaded.");
        }
    });
}
function articles() {
    $.ajax({
        url: "/articles",
        dataType: 'json',
        type: 'get',
        cache:false,
        success: function(data){  
        	$("#articles").find("tbody").empty();
            var event_data = '';
            $.each(data, function(index, article){
                /*console.log(value);*/
                event_data += '<tr>';
                event_data += '<td>'+article.articleId+'</td>';
                event_data += '<td>'+article.articleTitle+'</td>'; 
                event_data += '<td>'+article.authorName+'</td>';
                event_data += '<td>'+article.Date+'</td>'; 
                event_data += '<td>'+'<a href="/articles/' + article.articleId + '">view</a>'+'</td>'; 
                event_data += '</tr>';
            });
            $("#articles").append(event_data);
        },
        error: function(d){ 
            alert("404. Please wait until the File is Loaded.");
        }
    });
}
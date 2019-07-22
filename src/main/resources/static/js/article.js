$(document).ready(function(){
	alert("?>>>")
    $.ajax({
        url: "/article/list",
        dataType: 'json',
        type: 'get',
        cache:false,
        success: function(data){ 
            var event_data = '';
            $.each(data, function(index, article){
                /*console.log(value);*/
                event_data += '<tr>';
                event_data += '<td>'+article.articleId+'</td>';
                event_data += '<td>'+article.articleTitle+'</td>'; 
                event_data += '<td>'+article.authorName+'</td>';
                event_data += '<td>'+article.Date+'</td>'; 
                event_data += '<td>'+'<a href="/article/view/' + article.articleId + '">view</a>'+'</td>'; 
                event_data += '</tr>';
            });
            $("#listArticles").append(event_data);
        },
        error: function(d){
            /*console.log("error");*/
            alert("404. Please wait until the File is Loaded.");
        }
    });
})
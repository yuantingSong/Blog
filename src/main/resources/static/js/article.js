$(document).ready(function(){
    $.ajax({
        url: "/articles",
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
                event_data += '<td>'+'<a href="/articles/' + article.articleId + '">view</a>'+'</td>'; 
                event_data += '</tr>';
            });
            $("#listArticles").append(event_data);
        },
        error: function(d){ 
            alert("404. Please wait until the File is Loaded.");
        }
    });
})
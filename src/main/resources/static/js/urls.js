/**
 * Created by yi on 2018/10/18.
 */
function getShortUrl() {
    var str = $("#url").val();
    console.log(str);
    $.ajax({
        cache : true,
        type : "POST",
        url : "/getShortUrl",
        data : {"url":str},
        async : false,
        error : function() {
            alert("系统异常");
        },
        success : function(data) {
            $('#sUrlDiv').removeClass("hidden");
            if (data.code == 0) {
                $('#sUrl').html(getHost() + data.data);
            }
        }
    });

}

function getSinaShortUrl() {
    var str = $("#sinaurl").val();
    console.log(str);
    $.ajax({
        cache : true,
        type : "POST",
        url : "/getSinaShortUrl",
        data : {"url":str},
        async : false,
        error : function() {
            alert("系统异常");
        },
        success : function(data) {
            $('#sUrlDiv').removeClass("hidden");
            if (data.code == 0) {
                $('#sUrl').html(data.data);
            }
        }
    });

}


function getHost() {
    var protocol = window.location.protocol;
    var host = window.location.host;
    return protocol+'//'+host+'/';
}
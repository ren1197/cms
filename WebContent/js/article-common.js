//写cookies（设置作用域）
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    let hostname = location.hostname.substring(location.hostname.indexOf(".") + 1); //设置为一级域名
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";domain=" + hostname + ";path=/";
}


//读取cookies
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

    if (arr = document.cookie.match(reg))

        return (arr[2]);
    else
        return null;
}

//删除cookies
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

//删除cookies（有作用域的）
function delCookie(name) {
    var exp = new Date();
    var name = "access_token";
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) {
        let hostname = location.hostname.substring(location.hostname.indexOf(".") + 1)
        document.cookie = name + "='';expires=" + exp.toGMTString() + ";domain=" + hostname + ";path=/";
    }
}

function goPage(pageNo, action) {
    formSubmit('page.action?pageNo=' + pageNo, action)
}


function isChecked() {
    var hasChecked = false;
    $.each($("input[type=checkbox]"), function (index,element) {
        if ($(element).attr('checked') == true)
            hasChecked = true;
    });
    return hasChecked;
}

function validity2Submit(url,action) {
    if (isChecked())
        formSubmit(url,action)
    else alert('请选中一条记录')
}
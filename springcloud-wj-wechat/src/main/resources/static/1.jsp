<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script>
    function GetQueryString()
    {
        alert(window.location.search.substr(1));
        var r = window.location.search.substr(1).split("=")[1];//search,查询？后面的参数，并匹配正则
        if(r!=null)return  unescape(r); return null;
    }

    // 调用方法
    alert(GetQueryString());
    alert(GetQueryString());
    alert(GetQueryString());
</script>
<body>

</body>
</html>
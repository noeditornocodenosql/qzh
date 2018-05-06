<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/admin.css">
    <style type="text/css">
*{ margin:0px; padding:0px;}
.error-container{ background:#fff; border:1px solid #0ae;  text-align:center; width:450px; margin:auto auto; font-family:Microsoft Yahei; padding-bottom:30px; border-top-left-radius:5px; border-top-right-radius:5px;  }
.error-container h1{ font-size:16px; padding:12px 0; background:#0ae; color:#fff;} 
.errorcon{ padding:35px 0; text-align:center; color:#0ae; font-size:18px;}
.errorcon i{ display:block; margin:12px auto; font-size:30px; }
.errorcon span{color:red;}
h4{ font-size:14px; color:#666;}
a{color:#0ae;}
</style>
    <script src="${pageContext.request.contextPath}/backstage/js/jquery.js"></script>   
</head>
<body class="no-skin">
 <jsp:include  page="header.jsp"/>
 <jsp:include  page="leftnav.jsp"/>
<div class="admin">
<div class="error-container"> 
    <h1> 后台管理系统-信息提示 </h1>   
    <div class="errorcon">     
        <i class="icon-smile-o"></i>操作成功        
        <span style="display:none;"><i class="icon-frown-o"></i>操作失败!</span>
   </div>
    <h4 class="smaller"> 
     <button class="button bg-main icon-check-square-o" type="button" onclick="window.history.go(-1);"> 返回</button>   
    </h4> 
</div>
</div>
</body>
</html>

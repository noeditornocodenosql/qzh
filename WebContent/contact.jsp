<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>翡娅官网</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>

<body>
<div class="top1">
<div class="top">
<div class="logo">
<h1><a href="#">翡娅官网</a></h1>
</div>

<%@include file="common/menu.jsp" %>

<script type="text/javascript">
$('#nav-menu .menu > li').hover(function(){
	$(this).find('.children').animate({ opacity:'show', height:'show' },200);
	$(this).find('.xialaguang').addClass('navhover');
}, function() {
	$('.children').stop(true,true).hide();
	$('.xialaguang').removeClass('navhover');
});
</script>


</div>
</div>

<div class="nybanner">
</div>

<div class="nymian">
<h2><span>您当前位置：<a href="#">首页</a> > <a href="#">联系我们</a></span><strong>QIANZHIHE联系我们</strong></h2>
<div class="nymian_con">

</div>
</div>



<div class="nydi">
</div>
<div class="nydi_con">
<a href="#"><img src="images/imgdf_51.jpg" height="90" width="227"></a>
</div>
</body>
</html>

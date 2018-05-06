<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>翡娅官网</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/lrtk.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
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

<div class="neiyecp">
<div class="neiyecpl fl">
<h2><p>品牌实力</p></h2>

<ul>
<li><a href="#">QIANZHIHE简介    </a></li>
<li><a href="#">品牌历程    </a></li>
<li><a href="#">合作媒体    </a></li>
<li><a href="#">卓越团队</a></li>



</ul>

</div>

<div class="neiyecpr fr">
<h2><span class="fr">您当前位置：<a href="#">首页</a> > <a href="#">新闻</a></span><p>QIANZHIHE新闻</p>
</h2>
<div class="news">
	<ul>
		<c:forEach items="${newsList }" var="news">
			<li><span><fmt:formatDate type="time" value="${news.time }" pattern="yyyy-MM-dd HH:mm:ss" /></span><a href="${pageContext.request.contextPath}/news/detail?id=${news.id}">${news.title }</a></li>
		</c:forEach>
	</ul>
	
	<c:if test="${page.totalCount != 0}">
  <div style="float: right;padding-top: 15px;">
    	<a   href="${pageContext.request.contextPath}/news/1" >首页</a>
    <c:if test="${page.pageNow != 1}">
 		<a href="${pageContext.request.contextPath}/news/${page.pageNow-1}">上一页</a>
		<a   href="${pageContext.request.contextPath}/news/1" >1</a>
	  <c:if test="${page.pageNow-1 != 1}">
		<a href="${pageContext.request.contextPath}/news/${page.pageNow-1}">${page.pageNow-1}</a>
	  </c:if>
	</c:if>
		<a>${page.pageNow}</a>
	<c:if test="${page.pageNow != page.totalPageCount}">
	  <c:if test="${page.pageNow+1 != page.totalPageCount}">
		<a href="${pageContext.request.contextPath}/news/${page.pageNow+1}">${page.pageNow+1}</a>
	  </c:if>
		<a href="${pageContext.request.contextPath}/news/${page.totalPageCount}">${page.totalPageCount}</a>
		<a href="${pageContext.request.contextPath}/news/${page.pageNow+1}" >下一页</a>
    </c:if>
		<a href="${pageContext.request.contextPath}/news/${page.totalPageCount}">末页</a>
 </div> 
 </c:if>
</div>

</div>
</div>
<div  style="height:50px; overflow:hidden; clear:both;"></div>

<div class="huoban cl wid">
<div class="huobanm w">
<a href="#"><img src="${pageContext.request.contextPath}/images/ny5_03.jpg" width="113" height="116"></a><a href="#"><img src="${pageContext.request.contextPath}/images/ny5_05.jpg" width="113" height="116"></a><a href="#"><img src="${pageContext.request.contextPath}/images/ny5_07.jpg" width="113" height="116"></a><a href="#"><img src="${pageContext.request.contextPath}/images/ny5_09.jpg" width="113" height="116"></a><a href="#"><img src="${pageContext.request.contextPath}/images/ny5_11.jpg" width="113" height="116"></a><a href="#"><img src="${pageContext.request.contextPath}/images/ny5_13.jpg" width="113" height="116"></a>
</div>
</div>
<div class="main3 wid">
<p class="w">Copyright©2014 Vbteor 版权所有  京ICP备8888888号</p>
</div>


<div class="nydi_con">
<a href="#"><img src="${pageContext.request.contextPath}/images/imgdf_51.jpg" height="90" width="227"></a>
</div>
</body>
</html>

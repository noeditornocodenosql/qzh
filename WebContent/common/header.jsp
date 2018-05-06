<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!--头部-->
<div class="head">
	<div class="block yh f13">
    	<p class="tright"></p>
   <div class="box position_a clearfix">     
   
   <!--导航-->
   <div class="nav fleft ofHidden">
       <ul>
       <c:forEach items="${sessionScope.menulist }" var="menu">
	    <c:choose>
	       	 <c:when test="${menu.ftype eq '0' }">
	       	   <li><a href="${pageContext.request.contextPath}/index">${menu.fname }</a></li>
	       	 </c:when>
	       	  <c:when test="${menu.ftype eq '1' }">
	       	   <li><a href="${pageContext.request.contextPath}/about">${menu.fname }</a></li>
	       	 </c:when>
	       	  <c:when test="${menu.ftype eq '2' }">
	       	   <li><a href="${pageContext.request.contextPath}/newsinfo/1">${menu.fname }</a></li>
	       	 </c:when>
	       	  <c:when test="${menu.ftype eq '3' }">
	       	   <li><a href="${pageContext.request.contextPath}/exampleIinfo/1">${menu.fname }</a></li>
	       	 </c:when>
	       	  <c:when test="${menu.ftype eq '4' }">
	       	    <li><a href="${pageContext.request.contextPath}/teaminfo/1">${menu.fname }</a></li>
	       	 </c:when>
	       	  <c:when test="${menu.ftype eq '5' }">
	       	    <li><a href="${pageContext.request.contextPath}/healthinfo/1">${menu.fname }</a></li>
	       	 </c:when>
	       	  <c:when test="${menu.ftype eq '6' }">
	       	  <li><a href="${pageContext.request.contextPath}/join">${menu.fname }</a></li>
	       	 </c:when>
	       	  <c:when test="${menu.ftype eq '7' }">
	       	  <li><a href="${pageContext.request.contextPath}/contact">${menu.fname }</a></li>
	       	 </c:when>
	       </c:choose> 
           </c:forEach>
       </ul>
   </div>	
    </div>
    </div>
</div>

<!--幻灯片-->
<div class="fullSlide">
		<div class="bd">
			<ul>
			<li style="background:url('${pageContext.request.contextPath}/images/banner.png') #FFF center 0 no-repeat;"><a  href="javascript:;"></a></li>
			<li style="background:url('${pageContext.request.contextPath}/images/banner2.png') #FFF center 0 no-repeat;"><a  href="javascript:;"></a></li>
			<li style="background:url('${pageContext.request.contextPath}/images/banner3.png') #FFF center 0 no-repeat;"><a  href="javascript:;"></a></li>
			<li style="background:url('${pageContext.request.contextPath}/images/banner4.png') #FFF center 0 no-repeat;"><a  href="javascript:;"></a></li>
			</ul>
		</div>

		<div class="hd"><ul></ul></div>
	</div>  
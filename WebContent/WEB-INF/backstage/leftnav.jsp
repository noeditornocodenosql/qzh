<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="${pageContext.request.contextPath}/jcmx/i/1" target="right"><span class="icon-caret-right"></span>消息提醒(<font color="red">${counts}</font>)</a></li>
    <li><a href="${pageContext.request.contextPath}/jcmx/keyword" target="right"><span class="icon-caret-right"></span>网站设置</a></li>
    <li><a href="${pageContext.request.contextPath}/jcmx/pcp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    <li><a href="${pageContext.request.contextPath}/jcmx/menu" target="right"><span class="icon-caret-right"></span>导航管理</a></li>
    <li><a href="javascript:;" target="right"><span class="icon-caret-right"></span>单页管理</a></li>  
    <li><a href="javascript:;" target="right"><span class="icon-caret-right"></span>首页轮播</a></li>   
    <li><a href="${pageContext.request.contextPath}/jcmx/n/1" target="right"><span class="icon-caret-right"></span>公司资讯</a></li>     
    <li><a href="${pageContext.request.contextPath}/jcmx/e/1" target="right"><span class="icon-caret-right"></span>加盟案例</a></li>
    <li><a href="${pageContext.request.contextPath}/jcmx/h/1" target="right"><span class="icon-caret-right"></span>健康生活</a></li>
    <li><a href="${pageContext.request.contextPath}/jcmx/t/1" target="right"><span class="icon-caret-right"></span>企业团队</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
  <ul>
    <li><a href="javascript:;" target="right"><span class="icon-caret-right"></span>内容管理</a></li>
    <li><a href="javascript:;" target="right"><span class="icon-caret-right"></span>添加内容</a></li>
    <li><a href="javascript:;" target="right"><span class="icon-caret-right"></span>分类管理</a></li>        
  </ul>  
</div>

<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
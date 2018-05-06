<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/css/style.css"/>
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="${pageContext.request.contextPath}/backstage/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/login/js/verificationNumbers.js"></script>
<script src="${pageContext.request.contextPath}/login/js/Particleground.js"></script>
<script src="${pageContext.request.contextPath}/login/js/jquery.validate-1.13.1.js"></script>
<script>
$(document).ready(function() {
	
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
 // createCode();
  //测试提交，对接程序删除即可
  /*  $(".submit_btn").click(function(){
	  location.href="javascrpt:;";
	  });  */
  
  $("#loginForm").validate({
	    rules: {
	    	userName: {
	        required: true,
	        minlength: 2
	      },
	      passWord: {
	        required: true,
	        minlength: 5
	      }
	    },
	    messages: {
	    	userName: {
	        required: "请输入用户名",
	        minlength: "用户名必需由两个字母组成"
	      },
	      passWord: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母"
	      }
	    }
    });
});
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/ks_2017/main" method="post" id="loginForm">
<dl class="admin_login">
 <dt>
  <strong>尚赫公司全国总代理</strong>
  <em>The national general agent ShangHe company</em>
 </dt>
 <dd class="user_icon">
  <input type="text" placeholder="账号" class="login_txtbx" name="userName"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" name="passWord"/>
 </dd>
 <!--  <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx" name="">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
  <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
 </dd> -->
 <dd>
  <input type="submit" value="立即登陆" class="submit_btn"/>
 </dd>
 <span style="color: #FFFFFF;">${message }</span>
 <dd>
  <p>©2007-2017 尚赫公司全国总代理  版权所有</p>
  <p>皖ICP备17001592号</p>
 </dd>
</dl>
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>公司资讯-修改</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/admin.css">
<script src="${pageContext.request.contextPath}/backstage/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/backstage/js/pintuer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/js/uploadPreview.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/js/uploadPreview.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	//上传图片预览
	$("#up").uploadPreview({ Img: "ImgPr"});
});
</script>
</head>
<body>
 <jsp:include  page="header.jsp"/>
 <jsp:include  page="leftnav.jsp"/>
 <div class="admin">
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>内容修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/jcmx/nes" enctype="multipart/form-data">  
    <input type="hidden" name="id" value="${news.id}"/>
    <input type="hidden" name="imagePath" value="${news.imagePath}"/>
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="title" maxlength="100" data-validate="required:请输入标题" value="${news.title}"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>内容：</label>
        </div>
        <div class="field">
          <textarea name="content" class="input" style="height:450px; border:1px solid #ddd;" data-validate="required:请输入内容">${news.content}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          原图：<img src="${pageContext.request.contextPath}/${news.imagePath }" style="width: 360px;height: 240px;">
          <input type="file" id="up" name="myfile" class="input tips" style="width:25%; float:left;"  value=""  data-toggle="hover" data-place="right" data-image=""/>
           现图：<img id="ImgPr" src="">
          <div class="tipss">温馨提示：图片尺寸应小于2M</div>
        </div>
      </div>     
      
        <div class="form-group">
          <div class="label">
            <label>分类标题：</label>
          </div>
          <div class="field">
            <select name="type" class="input w50" data-validate="required:请选择分类" >
              <option value="">请选择分类</option>
              <option value="2001"<c:if  test="${news.type  eq  '2001' }"> selected="selected"</c:if>>最新动态</option>
              <option value="2002"<c:if  test="${news.type  eq  '2002' }"> selected="selected"</c:if>>行业新闻</option>
              <option value="2003"<c:if  test="${news.type  eq  '2003' }"> selected="selected"</c:if>>专业知识</option>
            </select>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>其他属性：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
		            首页 <input id="ishome"  type="checkbox" />
		            推荐 <input id="isvouch"  type="checkbox" />
		            置顶 <input id="istop"  type="checkbox" /> 
          </div>
        </div>
      
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
          <a class="button bg-main icon-check-square-o" onclick="javascript:history.go(-1)" style="cursor:pointer;"> 返回</a>
        </div>
      </div>
    </form>
  </div>
</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/admin.css">
<script src="${pageContext.request.contextPath}/backstage/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/backstage/js/pintuer.js"></script>  
 <jsp:include  page="header.jsp"/>
 <jsp:include  page="leftnav.jsp"/>
 <div class="admin">
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>网站基本信息维护</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/jcmx/upKeyword">
    <input type="hidden" name="id" value="${contact.id }"/>
     <div class="form-group">
        <div class="label">
          <label>地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w100"  name="address" maxlength="100" data-validate="required:请输入地址" value="${contact.address}"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>固话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w100"  name="telephone" maxlength="100" value="${contact.telephone}"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>手机：</label>
        </div>
        <div class="field">
          <input type="text" class="input w100"  name="mobile" maxlength="100" data-validate="required:请输入手机" value="${contact.mobile}"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>QQ：</label>
        </div>
        <div class="field">
          <input type="text" class="input w100"  name="qq" maxlength="100" value="${contact.qq}"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w100"  name="email" maxlength="100" data-validate="required:请输入邮箱" value="${contact.email}"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">关键词：</label>
        </div>
        <div class="field">
        <textarea name="keyword" class="input" style="height:250px; border:1px solid #ddd;" data-validate="required:请输入关键词">${contact.keyword}</textarea>
        </div>
      </div>      
      
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
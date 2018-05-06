<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/admin.css">
    <script src="${pageContext.request.contextPath}/backstage/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/js/pintuer.js"></script>  
    <script src="${pageContext.request.contextPath}/backstage/layer/layer.js"></script>
</head>
<body>
 <jsp:include  page="header.jsp"/>
 <jsp:include  page="leftnav.jsp"/>
  <div class="admin">
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 导航列表</strong></div>
  <div class="padding border-bottom">  
  <a class="button border-yellow" href="${pageContext.request.contextPath}/jcmx/menu/ts"><span class="icon-plus-square-o"></span> 添加导航</a>
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">序号</th>     
      <th>导航名称</th>  
      <th>排序</th>     
      <th width="250">操作</th>
    </tr>
   
   <c:forEach items="${menuList }" var="m" varStatus="xh">
    <tr>
      <td>${xh.count }</td>      
      <td>${m.fname }</td>  
      <td>${m.ftype }</td>      
      <td>
      <div class="button-group">
      <a class="button border-main"  href="${pageContext.request.contextPath}/jcmx/menu/tu?fid=${m.fid}"><span class="icon-edit"></span>修改</a>
       <a class="button border-red"  style="cursor: pointer;" onclick="return del('${m.fid}')"><span class="icon-trash-o"></span> 删除</a>
      </div>
      </td>
    </tr> 
  <%--   <c:forEach items="${m.menuTwoList }" var="mt">
      <tr>
      <td>${xh.count }</td>      
      <td>${mt.tname }</td>  
      <td>${mt.ttype }</td>      
      <td>
      <div class="button-group">
      <a class="button border-main"  href="${pageContext.request.contextPath}/jcmx/menu/tu?fid=${m.fid}"><span class="icon-edit"></span>修改</a>
       <a class="button border-red"  style="cursor: pointer;" onclick="return del('${m.fid}')"><span class="icon-trash-o"></span> 删除</a>
      </div>
      </td>
    </tr> 
    </c:forEach> --%>
    </c:forEach>
  </table>
</div>

</div>

<script>
	function del(fid){
		layer.confirm('确认删除吗?', {icon: 3, title:'删除提示'}, function(index){
			window.location.href = "${pageContext.request.contextPath}/jcmx/menu/d?fid="+fid;
			  layer.close(index);
			});  
	}
</script>
</body></html>
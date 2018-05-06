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
<title>投资自助</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/admin.css">
<script src="${pageContext.request.contextPath}/backstage/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/backstage/js/pintuer.js"></script>
<script src="${pageContext.request.contextPath}/backstage/layer/layer.js"></script>
<script type="text/javascript">
	var  ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>
 <jsp:include  page="header.jsp"/>
 <jsp:include  page="leftnav.jsp"/>
 <div class="admin">
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">消息列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="javascript:;"> 添加内容</a> </li>
        <li>搜索：</li>
        <li>首页
          <select name="s_ishome" class="input" onchange="changesearch()" style="width:60px; line-height:17px; display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          &nbsp;&nbsp;
         	 推荐
          <select name="s_isvouch" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          &nbsp;&nbsp;
       		   置顶
          <select name="s_istop" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
        </li>
        <if condition="$iscid eq 1">
          <li>
            <select name="cid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
              <option value="">请选择分类</option>
              <option value="3001">合作案例</option>
              <option value="3002">项目实例</option>
            </select>
          </li>
        </if>
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="2%" style="text-align:left; padding-left:20px;">序号</th>
        <th width="4%" >投资预算</th>
        <th width="2%" >姓名</th>
        <th width="2%" >联系方式</th>
        <th width="8%" >留言</th>
        <th width="6%" >留言时间</th>
        <th width="4%">是否阅读</th>
        <th width="4%">操作</th>
      </tr>
      <c:forEach items="${investmentList }" var="investment" varStatus="status">
        <tr>
          <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]"/><input type="hidden" value="${investment.id}"/>
         ${ status.index + 1}</td>
          <td width="10%">
          <c:choose>
             <c:when test="${investment.budget  eq '1'}">打算投资费用1至4万元</c:when>
             <c:when test="${investment.budget eq '2'}">打算投资费用4至7万元</c:when>
             <c:when test="${investment.budget eq '3'}">打算投资费用7至9万元</c:when>
             <c:when test="${investment.budget eq '4'}">打算投资费用9至13万元</c:when>
          </c:choose>
          </td>
          <td>${investment.name }</td>
          <td>${investment.mobile}</td>
          <td title="${investment.message }">
           <c:choose>
				<c:when test="${fn:length(investment.message) > 30}">
				  ${fn:substring(investment.message, 0, 30)}...
				</c:when>
				<c:otherwise>
				  ${investment.message}
				</c:otherwise>
		 </c:choose>
          </td>
          <td><fmt:formatDate type="time" value="${investment.addTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
           <td>
           <c:if test="${investment.readFlag eq '0'}">
             <div class="button-group"> <a class="button border-red" href="${pageContext.request.contextPath}/b/ee?id=${investment.id}">未读</a> </div>
           </c:if>
            <c:if test="${investment.readFlag eq '1'}">
             <div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath}/b/ee?id=${investment.id}"> 已读</a> </div>
            </c:if>
           </td>
          <td>
            <c:if test="${investment.readFlag eq '0'}">
           <a class="button border-main" href="javascript:;" onclick="see(${investment.id})"><span class="icon-edit"></span> 查看</a>
           </c:if>
            <c:if test="${investment.readFlag eq '1'}">
             <a class="button border-red" href="javascript:void(0)" onclick="return del('${investment.id}')"><span class="icon-trash-o"></span> 删除</a>
            </c:if>
          </td>
        </tr>
        </c:forEach>
      <tr>
        <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>
       	   全选 </td>
        <td colspan="7" style="text-align:left;padding-left:20px;"><a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()"> 删除</a> <a href="javascript:void(0)" style="padding:5px 15px; margin:0 10px;" class="button border-blue icon-edit" onclick="sorts()"> 排序</a> 操作：
          <select name="ishome" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeishome(this)">
            <option value="">首页</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          <select name="isvouch" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeisvouch(this)">
            <option value="">推荐</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          <select name="istop" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeistop(this)">
            <option value="">置顶</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          &nbsp;&nbsp;&nbsp;
        	  移动到：
          <select name="movecid" style="padding:5px 15px; border:1px solexample #ddd;" onchange="changecate(this)">
            <option value="">请选择分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
          </select>
          <select name="copynum" style="padding:5px 15px; border:1px solid #ddd;" onchange="changecopy(this)">
            <option value="">请选择复制</option>
            <option value="5">复制5条</option>
            <option value="10">复制10条</option>
            <option value="15">复制15条</option>
            <option value="20">复制20条</option>
          </select></td>
      </tr>
      <tr>
        <td colspan="8">
         <c:if test="${page.totalCount != 0}">
        <div class="pagelist">
			   <a   href="${pageContext.request.contextPath}/jcmx/i/1" >首页</a>
			    <c:if test="${page.pageNow != 1}">
			 		<a href="${pageContext.request.contextPath}/jcmx/i/${page.pageNow-1}">上一页</a>
					<a href="${pageContext.request.contextPath}/jcmx/i/1" >1</a>
				  <c:if test="${page.pageNow-1 != 1}">
					<a href="${pageContext.request.contextPath}/jcmx/i/${page.pageNow-1}">${page.pageNow-1}</a>
				  </c:if>
				</c:if>
					<a  class="current">${page.pageNow}</a>
				<c:if test="${page.pageNow != page.totalPageCount}">
				  <c:if test="${page.pageNow+1 != page.totalPageCount}">
					<a href="${pageContext.request.contextPath}/jcmx/i/${page.pageNow+1}">${page.pageNow+1}</a>
				  </c:if>
					<a href="${pageContext.request.contextPath}/jcmx/i/${page.totalPageCount}">${page.totalPageCount}</a>
					<a href="${pageContext.request.contextPath}/jcmx/i/${page.pageNow+1}" >下一页</a>
			    </c:if>
					<a href="${pageContext.request.contextPath}/jcmx/i/${page.totalPageCount}">末页</a>
         </div>
          </c:if>
         </td>
      </tr>
    </table>
  </div>
</form>
</div>
<script type="text/javascript">

function see(id){
	   $.ajax({  
	       url : '${pageContext.request.contextPath}/jcmx/i/see?id='+id,  
	       type : "GET",  
	       success : function(data, stats) { 
	           if (stats == "success") {  
	          	  layer.msg('已查看!', {time:3000});
	           }  
	       },  
	       error : function(data) {  
	           alert("请求失败");  
	       }  
	   }); 
}

//搜索
function changesearch(){	
		
}

//单个删除
function del(id){
	layer.confirm('确认删除吗?', {icon: 3, title:'删除提示'}, function(index){
		window.location.href = "${pageContext.request.contextPath}/jcmx/i/del?id="+id;
		  layer.close(index);
		});  
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	var ids = "";
	 $("input[name='id[]']").each(function(i){
	  if (this.checked==true) {		
		Checkbox=true;	
		  if (0 == i) {
				ids = $(this).next().val();
			} else {
				ids += ("," + $(this).next().val());
			}
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
	    $.ajax({
	        type:"post",
	        url:ctx + "/jcmx/i/batchDel.ajax",
	        data:{"ids":ids},
	        async:false,
	        traditional: true,
	        success:function(data){
	        	console.log(data);
	            if(data > 0){
	            	 layer.msg("删除成功！",{icon: 6,time: 2000},function(){
	              	   history.go(0);
	                  });
	            } else {
	            	layer.msg("删除失败！", {icon: 2, shade: [0.4], time: 1500});
	            }
	        }
	    });		
	}
	else{
		layer.msg("请选择您要删除的内容!", {icon: 5, shade: [0.4], time: 1500});
		return false;
	}
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");	
		
		return false;
	}
}

//批量置顶
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}


//批量移动
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		
		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}		
	    });
		if(i>1){ 
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{
		
			$("#listform").submit();		
		}	
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}
</script>
</body>
</html>
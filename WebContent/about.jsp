<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>翡娅官网</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
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
<h2><span class="fr">您当前位置：<a href="#">首页</a> > <a href="#">简介</a></span><p>QIANZHIHE简介</p>
</h2>
<p>　　尚赫集团致力于从事健康、美容产品的研发和健康、美丽事业的推广，打造人类品质生活，形成了成熟、完善的产品研发理念，恪守“撒播美丽·奉献健康”的品牌使命，践行“诚信、稳健、踏实”的经营理念，将企业丰硕成果回馈至全社会，履行社会职责，肩负慈善公益。尚赫集团创造了一个又一个品牌业绩佳话，投资达10亿元人民币，搭建了广阔、坚实的创业平台，与越来越多的人一同追梦、圆梦。
　　   <p> </p>
	    	 1993年，尚赫作为早期进入中国投资的外商直销公司之一，投资1000万美元成立天津尚赫保健用品有限公司，并投资亿元人民币自建规模宏伟、设施齐全的尚赫智能科贸大厦，奠定尚赫集团在中国的根基；
	    	<p> </p>
		    2005年，斥资500万美金投建总面积达9000平方米、集生产研发、GMP生产基地、营运管理、市场行销、教育培训、物流中心等于一身的研发生产中心，成为尚赫集团在中国的战略决策中心。
      　<p> </p>
   　	   2014年，尚赫公司乔迁新址，尚赫新厦正式启用，作为品牌经营人研修业务水平、拓展市场空间的交流中心；2015年，毗邻原有生产研发中心，尚赫再度置地50亩，建设集生产厂房、综合科研及配套设施于一身的健康、美容研发阵营，总建筑面积达38800平方米，总投资达2.5亿，成为尚赫集团发展史上的又一个崭新里程碑。
　      <p> </p>
　       20余年来，尚赫由最初的梦想初衷，到今天的永续愿景，已经伴随广大心怀梦想的有识之士，以广阔的创业平台、优质的产品结构和多元的教育培训，走出一条灿烂辉煌的创业之路，共襄盛世伟业荣耀之举。
                	<p> </p>

</div>
</div>
<div  style="height:50px; overflow:hidden; clear:both;"></div>

<div class="huoban cl wid">
<div class="huobanm w">
<a href="#"><img src="images/ny5_03.jpg" width="113" height="116"></a><a href="#"><img src="images/ny5_05.jpg" width="113" height="116"></a><a href="#"><img src="images/ny5_07.jpg" width="113" height="116"></a><a href="#"><img src="images/ny5_09.jpg" width="113" height="116"></a><a href="#"><img src="images/ny5_11.jpg" width="113" height="116"></a><a href="#"><img src="images/ny5_13.jpg" width="113" height="116"></a>
</div>
</div>
<div class="main3 wid">
<p class="w">Copyright©2014 Vbteor 版权所有  京ICP备8888888号</p>
</div>

<div class="nydi_con">
<a href="#"><img src="images/imgdf_51.jpg" height="90" width="227"></a>
</div>
</body>
</html>

var num=6;
function redirect(){
	num--;
	document.getElementById("num").innerHTML=num;
	if(num<0){
		document.getElementById("num").innerHTML=0;
		location.href="http://www.sunhopelife.com";
		}
	}
setInterval("redirect()", 1000);

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
<style type="text/css">
.border-style {
	border-radius:75px/90px;
}
#padding{
	padding: 0px 0px 0px 15px;
}
.note{
	position:absolute;
	width:50px;
	height:50px;
	animation-timing-function: ease-in-out;
	animation-direction: alternate;
	animation-name:note;
	animation-duration:5s;
	animation-iteration-count:infinite;
	
}
.box{
  position:relative;
}
.box:before{
  content:'';
  position:absolute;
  z-index:2;
  top:60px;
  left:50px;
  width:50px;
  height:50px;
  
  border-radius:2px;
  transform: rotate(45deg);
  -webkit-animation:box 1.25s infinite ; 
}
@-webkit-keyframes box{
  0%{
    top:50px;
  }
  20%{
    border-radius:2px;  
  }
  50%{
    top:80px; 
    border-bottom-right-radius:25px;
  }
  80%{
    border-radius:2px; 
  }
  100%{
    top:50px;
  }
}
.box:after{
  content:'';
  position:absolute;
  z-index:1;
  top:128px;
  left:52px;
  width:44px;
  height:3px;
  background:#eaeaea;
  border-radius:100%;
  -webkit-animation:shadow 1.25s infinite ; 
}
@-webkit-keyframes shadow{
  0%,100%{
    left:54px;
    width:40px;
    background:#eaeaea;
  }
  50%{
    top:126px;
    left:50px;   
    width:50px;
    height:7px;
    background:#eee;
  }
}
</style>
</head>
<body style='background-color:#FDFCDC'>
<form action='${requestUri}' method='get'>

<div class = 'box'style = 'position:absolute;margin-top:530px;margin-left:635px;'></div> 
<div>
<input type='text' class="border-style" id="padding"  
style='font-size:120%;position:absolute;left:50%;top:48%;
margin-top:50px;margin-left:-400px;width:800px;height:45px' name='keyword' placeholder='請輸入關鍵字'
onfocus="placeholder= '' " onblur="placeholder='請輸入關鍵字'" />
</div>
<div>
</div>
<div>
<input type='image' id="padding" src="images/loupe-2.png" 
style='position:absolute;width:37px;height:37px;left:50%;top:50%;margin-top:44px;margin-left:355px '/><!-- margin-top:-55px;margin-left:368px -->
</div>
<div>
<a href ='http://localhost:8080/FinalProjectWeb/TestProject'><img src="images/icon.png" style='position:absolute;width:517.6px;height:236.8px;left:50%;top:50%;margin-top:-200px;margin-left:-240px'></a> <!-- margin-top:-265px;margin-left:-175px -->
</div>
</form>
</body>
</html>

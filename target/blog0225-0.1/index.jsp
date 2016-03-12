<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body style="background-color:#f5f8fa;">
	<nav class="navbar navbar-default navbar-fixed-top"> 
		<div class="container">
			<jsp:include page="/component/head/head.jsp"></jsp:include>
			<div style="margin-top:40px; width:25%; position:relative; float:left;padding-right:10px;">
				<jsp:include page="/component/intro/intro.jsp"></jsp:include>
			</div>
			
			<div style="margin-top:40px; width:50%; position:relative; float:left;">
				<div class="panel-body">
				center
				</div>
			
			</div>
			
			<div style="margin-top:40px; width:25%; position:relative; float:left;">
				<div class="panel-body">
				right
				</div>
			
			</div>
		</div>
	</nav>
</body>
</html>
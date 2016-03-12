<#ftl encoding="UTF-8">
<link href="${PATH }/component/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="${PATH }/component/login/login.css" rel="stylesheet">
<script type="text/javascript" src="${PATH }/component/jquery/jquery1.11.3.js"></script>
<script type="text/javascript" src="${PATH }/component/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${PATH }/component/utils/common.js"></script>
<script type="text/javascript" src="${PATH }/component/login/login.js"></script>
<div class="panel out" style="padding:10px; width:100%; height:100%; background-color:#828282">
	
	<div class="outer">
		<div class="login-user">当前操作员：游客</div>
		<div class="login-operate">
			<div>输入你的名字</div>
			<div class="login-input-focus"><span class="glyphicon glyphicon-user" aria-hidden="true"></span><input type="text" id="username" class="login-input"></div>
		</div>
	</div>
	<a href="${PATH}/home/index.htm"><span id="loginA"></span></a>
</div>
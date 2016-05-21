<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="js/jquery-1.10.2.min.js"></script>
<script>
	$(document).ready(function() {

		$("#but1").click(function() {
			$.ajax({
				url : 'http://localhost:8080/corstest-0.0.1-SNAPSHOT/get',
				type : "get",
				async : false,
				dataType : "jsonp",
				jsonp : "callbackparam", //服务端用于接收callback调用的function名的参数 
				jsonpCallback : "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来 
				success : function(json) {
					alert(json);
				},
				error : function() {
					alert('Error');
				}
			});
		});

		$("#but2").click(function() {
			$.ajax({
				url : 'http://localhost:8080/corstest-0.0.1-SNAPSHOT/getJsonp',
				type : "get",
				async : false,
				dataType : "jsonp",
				jsonp : "callbackparam", //服务端用于接收callback调用的function名的参数 
				jsonpCallback : "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来 
				success : function(json) {
					alert(json);
				},
				error : function() {
					alert('Error');
				}
			});
		});

	});
</script>
</head>
<body>

	<div id="div1">
		<h2>使用 jQuery AJAX 来改变文本</h2>
	</div>
	<button id="but1">按钮1</button>
	<br />
	<button id="but2">按钮2</button>

</body>
</html>

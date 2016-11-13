<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cooking Managerment</title>
<jsp:include page="../_bootstrap.jsp" />

<script type="text/javascript">
	$(document).ready(function(){
		$(".navbar").css("background-color","#2020df");
		$(".navbar").css('border-radius', '0px');
		$(".navbar a").css("color","#ff9900");
		$(".navbar li").hover(function(){
        $(this).css("background-color", "#6666cc");
        }, function(){
        $(this).css("background-color", "#2020df");
    	});
	});
</script>
</head>
<body>
	<!------------------------------------------- Menu -------------------------------->
	<% 

	User user = (User)session.getAttribute("user");
	if(user != null){
    %>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li><a href="#"><span class="glyphicon glyphicon-home"></span>Home</a></li>
			<li><a href="ManageAccount">Quản lí Tài khoản</a></li>
			<li><a href="ManageTask">Quản lí Công việc</a></li>
			<li><a href="Scheduler">Xếp lịch</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span><%=user.getFullname() %></a></li>
			<li><a href="Logout"><span
					class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>
	</div>
	</nav>

	<!------------------------------------------- Content -------------------------------->
	<div class="container" style="min-height: 430px">
  	
  	<h1>Phần mềm quản lí phân chia công việc(Nấu ăn)theo tuần:</h1>
  	<h2>Chức năng chính:</h2>
  	<h3>Admin:</h3> 
  	<h4>+ Quản lí tài khoản</h4>
    <h4>+ Xếp lịch công việc</h4>
    <h3>User:</h3>
    <h4>+ Đăng kí công việc</h4>
    <h4>+ Xem lịch làm việc</h4>
    <hr>
    <h1>Thành viên nhóm:</h1>
    <h4>PM: Thủy Việt Quốc</h4>
    <h4>PE: Nguyễn Khắc Tam</h4>
    <h4>PE: Phạm Văn Huy</h4>
    <h4>TE: Nguyễn Ngọc Thịnh</h4>
    <h4>CL: Nguyễn Văn Quang</h4>
</div>
<%} %>
<footer class="alert alert-info" >
  <center>Copyright@2016-5S team</center>
</footer>
</body>
</html>

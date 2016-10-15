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
	
</script>
</head>
<body>
	<!------------------------------------------- Menu -------------------------------->
	<% 

	User user = (User)session.getAttribute("user");
	if(user != null){
    %>
	<nav class="navbar navbar-inverse" style="background-color: #2020df">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li><a href="#"><span class="glyphicon glyphicon-home"></span>Home</a></li>
			<li><a href="Ad_account">Quản lí Tài khoản</a></li>
			<li><a href="Ad_task">Quản lí Công việc</a></li>
			<li><a href="Ad_scheduler">Xếp lịch</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span><%=user.getFullname() %></a></li>
			<li><a href="Logout"><span
					class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>
	</div>
	</nav>

	<!------------------------------------------- Content -------------------------------->
	<div class="container-fluid" style="min-height: 430px">
  <div class="row content">
  <!------------------------------------------- Left-Menu --------------------------------> 
    <div class="col-sm-3 sidenav">
    <p>OPTION</p>
    <ul class="nav nav-tabs nav-stacked nav-pills">
	    <li class="active"><a data-toggle="tab" href="#menu1">Tạo tài khoản</a></li>
	    <li><a data-toggle="tab" href="#menu2">Danh sách Tài khoản</a></li>
  	</ul>
     <br>
      
    </div>
<!------------------------------------------- Main-content --------------------------------> 
    <div class="col-sm-9">
      <div class="tab-content">
	    <div id="menu1" class="tab-pane fade in active">
	      <h3>Tạo tài khoản</h3>
	      <form>
		     	<div class="row">
			     	<div class="col-md-2"></div>
			     	<div class="col-md-6">
			     	<center><img src="images/avatar.png" class="img-circle" alt="Avartar" width="150" height="100"></center>
			     	</div>
		     	</div>
		     	<div class="row btn-lg">
			     	<div class="col-md-2">Username</div>
			     	<input class="col-md-6" type="password" value=""/>
		     	</div>
		     	<div class="row btn-lg">
			     	<div class="col-md-2">Fullname</div>
			     	<input class="col-md-6" type="password" value=""/>
		     	</div>
		     	<div class="row btn-lg">
			     	<div class="col-md-2">Mật khẩu</div>
			     	<input class="col-md-6" type="password" value=""/>
		     	</div>
		     	<div class="row btn-lg">
			     	<div class="col-md-2">Xác nhận mật khẩu</div>
			     	<input class="col-md-6" type="password" value=""/>
		     	</div>
		     	<div class="row btn-lg">
			     	<div class="col-md-2">Is administrator</div>
			     	<input class="col-md-1" type="checkbox" value=""/>
		     	</div>
		     	<div class="row btn-lg">
			     	<div class="col-md-2"></div>
			     	<input class="col-md-2" type="submit" value="Submit"/>
			     	<div class="col-md-1"></div>
			     	<input class="col-md-2" type="reset" value="Reset"/>
		     	</div>
		     	<br><br>
	     	</form>	
	    </div>
	    <div id="menu2" class="tab-pane fade">
	      <h3>Thông tin tài khoản</h3>
	      <hr>
	      <%
	      ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
	      if(users != null){
	      %>
	      <table class="table table-striped">
	      	<tr class="btn-lg">
	      		<td>ID</td>
	      		<td>Username</td>
	      		<td>Fullname</td>
	      		<td>Actions</td>
	      	</tr>
	      	<%
	      	for(int i=0; i<users.size(); i++){
	      	%>
	      	<tr class="btn-lg">
	      		<td><%= i+1 %></td>
	      		<td><%= users.get(i).getUsername()%></td>
	      		<td><%= users.get(i).getFullname()%></td>
	      		<td>
	      			<button type="button" class="btn btn-primary btn-sm">Edit</button>
	      			<button type="button" class="btn btn-primary btn-sm">Delete</button>
	      		</td>
	      	</tr>
	      	<%} %>
	      </table>
	      <%} %>
	    </div>
	   
	  </div>
     
    </div>
  </div>
</div>
<%} %>
<footer class="alert alert-info" >
  <center>Copyright@2016-5S team</center>
</footer>
</body>
</html>

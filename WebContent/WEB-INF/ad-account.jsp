<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cooking Managerment</title>
<jsp:include page="_bootstrap.jsp" />
<style>
div{
padding-top: 1px;
}
 /* Set black background color, white text and some padding */
    footer {
      background-color: #2020df;
      color: white;
      padding: 15px;
      text-align: center;
    }
    /*                   */
.nav.navbar-nav li a {
    color: #ffbf00;
}
.nav.navbar-nav li:active,
.nav.navbar-nav li:focus ,
.nav.navbar-nav li:hover {
    background-color: #bf00ff;
}
.table-bordered.table-striped tr {
	height: 50px;
}
.table-striped {
	width: 100%;
	height: 50px;
}
.table-bordered.table-striped table, tr, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding-left: 5px;
}

</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<!------------------------------------------- Menu --------------------------------> 
	<nav class="navbar navbar-inverse" style="background-color: #2020df">
	  <div class="container-fluid" > 
	    <ul class="nav navbar-nav" >
	      <li><a href="#"><span class="glyphicon glyphicon-home"></span>Home</a></li>
	      <li><a href="Ad_account">Quản lí Tài khoản</a></li> 
	      <li><a href="Ad_task">Quản lí Công việc</a></li>
	      <li><a href="Xeplich">Xếp lịch</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span>Nguyen Khac Tam</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>

<!------------------------------------------- Content --------------------------------> 
<div class="container-fluid" style="min-height: 430px">
  <div class="row content">
  <!------------------------------------------- Left-Menu --------------------------------> 
    <div class="col-sm-3 sidenav">
    <p>OPTION</p>
    <ul class="nav nav-tabs nav-stacked">
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
		     	<br>
		     	<div class="row">
			     	<div class="col-md-2">Username</div>
			     	<input class="col-md-6" type="password" value=""/>
		     	</div>
		     	<br>
		     	<div class="row">
			     	<div class="col-md-2">Fullname</div>
			     	<input class="col-md-6" type="password" value=""/>
		     	</div>
		     	<br>
		     	<div class="row">
			     	<div class="col-md-2">Mật khẩu</div>
			     	<input class="col-md-6" type="password" value=""/>
		     	</div>
		     	<br>
		     	<div class="row">
			     	<div class="col-md-2">Xác nhận mật khẩu</div>
			     	<input class="col-md-6" type="password" value=""/>
		     	</div>
		     	<br>
		     	<div class="row">
			     	<div class="col-md-2">Is administrator</div>
			     	<input class="col-md-1" type="checkbox" value=""/>
		     	</div>
		     	<br>
		     	<div class="row">
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
	      <table class="table-striped">
	      	<tr>
	      		<td>ID</td>
	      		<td>Username</td>
	      		<td>Fullname</td>
	      		<td>Actions</td>
	      	</tr>
	      	<%
	      	for(int i=0; i<users.size(); i++){
	      	%>
	      	<tr>
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

<footer class="container-fluid">
  <p>Copyright@2016-5S team</p>
</footer>
</body>
</html>

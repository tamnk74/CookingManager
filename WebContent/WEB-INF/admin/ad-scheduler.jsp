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
	height: 25px;
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
   
    </div>
<!------------------------------------------- Main-content --------------------------------> 
    <div class="col-sm-9">
     <h2>
     Tạo lịch
     </h2>
     
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Copyright@2016-5S team</p>
</footer>
</body>
</html>

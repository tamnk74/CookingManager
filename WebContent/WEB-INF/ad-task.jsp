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
.table-bordered.table-striped{
	width: 100%;
}
.table-bordered.table-striped table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding-left: 5px;
}
.navbar.navbar-inverse{
	background-color: #2020df;
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
	    <li class="active"><a data-toggle="tab" href="#menu1">Danh sách công việc</a></li>
	    <li><a data-toggle="tab" href="#menu2">Thông tin Đăng kí</a></li>
	    <li><a data-toggle="tab" href="#menu2">Thống kê</a></li>
  	</ul>
     <br>
      
    </div>
<!------------------------------------------- Main-content --------------------------------> 
    <div class="col-sm-9">
      <div class="tab-content">
	    <div id="menu1" class="tab-pane fade in active">
	      <h3>Danh sách công việc</h3>
	      <hr>
	      <table class="table-striped table-bordered">
	      	<tr>
	      		<td>ID</td>
	      		<td>Công việc</td>
	      		<td>Trọng số</td>
	      		<td>Actions</td>
	      	</tr>
	      	<tr>
	      		<td>1</td>
	      		<td>Đi chợ</td>
	      		<td> 2 </td>
	      		<td>
	      			<button type="button" class="btn btn-primary btn-sm">Edit</button>
	      			<button type="button" class="btn btn-primary btn-sm">Delete</button>
	      		</td>
	      	</tr>
	      	<tr>
	      		<td>1</td>
	      		<td>Rửa chén</td>
	      		<td> 2 </td>
	      		<td>
	      			<button type="button" class="btn btn-primary btn-sm">Edit</button>
	      			<button type="button" class="btn btn-primary btn-sm">Delete</button>
	      		</td>
	      	</tr>
	      	<tr>
	      		<td>1</td>
	      		<td>Rửa chén</td>
	      		<td> 2 </td>
	      		<td>
	      			<button type="button" class="btn btn-primary btn-sm">Edit</button>
	      			<button type="button" class="btn btn-primary btn-sm">Delete</button>
	      		</td>
	      	</tr>
	      </table>
	    </div>
	    <div id="menu2" class="tab-pane fade">
	      <h3>Thông tin đăng kí</h3>
	      <hr>
	      <table class="table-striped  table-bordered">
	      	<tr>
	      		<td>ID</td>
	      		<td>Username</td>
	      		<td>Tình trạng đăng kí</td>
	      		<td>Thông báo</td>
	      	</tr>
	      	<tr>
	      		<td>1</td>
	      		<td>khactam</td>
	      		<td><input type="checkbox"/></td>
	      		<td>
	      			<button type="button" class="btn btn-primary btn-sm">Thông báo đăng kí</button>
	      		</td>
	      	</tr>
	      		<td>1</td>
	      		<td>khactam</td>
	      		<td><input type="checkbox" checked/></td>
	      		<td>
	      			
	      		</td>
	      	</tr>
	      	<tr>
	      		<td>1</td>
	      		<td>khactam</td>
	      		<td><input type="checkbox" checked/></td>
	      		<td>
	      			
	      		</td>
	      	</tr>
	      </table>
	    </div>
	   
	  </div>
     
    </div>  </div>
</div>

<footer class="container-fluid">
  <p>Copyright@2016-5S team</p>
</footer>
</body>
</html>

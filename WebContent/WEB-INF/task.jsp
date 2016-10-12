<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cooking Managerment</title>
<jsp:include page="_bootstrap.jsp" />
<style>
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
	      <li><a href="Task">Công việc</a></li> 
	      <li><a href="Account">Tài khoản</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Nguyen Khac Tam</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
	    </ul>
	  </div>
	</nav>

<!------------------------------------------- Content --------------------------------> 
<div class="container-fluid" style="min-height: 420px">
  <div class="row content">
  <!------------------------------------------- Left-Menu --------------------------------> 
    <div class="col-sm-3 sidenav">
    <p>OPTION</p>
    <ul class="nav nav-tabs nav-stacked">
	    <li class="active"><a data-toggle="tab" href="#menu1">Công việc trong tuần</a></li>
	    <li><a data-toggle="tab" href="#menu2">Đăng kí công việc</a></li>
	    <li><a data-toggle="tab" href="#menu3">Đăng kí thời gian rảnh</a></li>
	    <li><a data-toggle="tab" href="#menu4">Xem thống kê</a></li>
  	</ul>
     <br>
      
    </div>
<!------------------------------------------- Main-content --------------------------------> 
    <div class="col-sm-9">
      <div class="tab-content">
	    <div id="menu1" class="tab-pane fade in active">
	      <h3>Công việc trong tuần</h3>
	      <div class="container">
	      <table class="table-bordered table-striped" style="width:50%">
	      	<tr>
		      	<td>Thứ 2</td>
		      	<td>Thứ 3</td>
		      	<td>Thứ 4</td>
		      	<td>Thứ 5</td>
		      	<td>Thứ 6</td>
		      	<td>Thứ 7</td>
		      	<td>Chủ nhật</td>
	      	</tr>
	      	<tr>
	      		<td></td>
		      	<td>Nấu ăn</td>
		      	<td></td>
		      	<td>Rửa chén</td>
		      	<td></td>
		      	<td>Đi chợ</td>
		      	<td>Đi chợ</td>
	      	</tr>
	      	<tr>
	      		<td>Nấu ăn</td>
	      		<td></td>
		      	<td></td>
		      	<td>Rửa chén</td>
		      	<td></td>
		      	<td>Đi chợ</td>
		      	<td>Đi chợ</td>
	      	</tr>
	      </table>
	      </div>
	    </div>
	    <div id="menu2" class="tab-pane fade">
	      <h3>Đăng kí công việc</h3>
	      <div class="container">
	      <table class="table-bordered table-striped" style="width:50%">
	      	<tr>
	      	<td>Công việc</td>
	      	<td>Lựa chọn</td>
	      	</tr>
	      	<tr>
	      		<td>Đi chợ</td>
	      		<td><center><input type="checkbox" value=""></center></td>
	      	</tr>
	      	<tr>
	      		<td>Nấu ăn</td>
	      		<td><center><input type="checkbox" value=""></center></td>
	      	</tr>
	      	
	      </table>
	      <br>
	      <input type="submit" value="submit">
	      </div>
	    </div>
	    <div id="menu3" class="tab-pane fade">
	      <h3>Đăng kí thời gian rảnh</h3>
	      <div class="row">
	      <div class="col-md-1">
	      	<br>
	      	<p>Sáng </p>
	 		<p>Chiều </p>
	      </div>
	      <div class="col-md-11">
	      <table class="table-bordered table-striped" style="width:80%">
	      	<tr>
		      	<td>Thứ 2</td>
		      	<td>Thứ 3</td>
		      	<td>Thứ 4</td>
		      	<td>Thứ 5</td>
		      	<td>Thứ 6</td>
		      	<td>Thứ 7</td>
		      	<td>Chủ nhật</td>
	      	</tr>
	      	<tr>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      	</tr>
	      	<tr>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="0"></center></td>
	      		<td><center><input type="checkbox" value="1"></center></td>
	      	</tr>
	      </table>
	      <br>
	      <input type="submit" value="submit">
	      </div>
	     </div>
	    </div>
	    <div id="menu4" class="tab-pane fade">
	      <h3>Thống kê</h3>
	      
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

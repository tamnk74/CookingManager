<%@page import="Config.Const"%>
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
<% 
ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");%>
<script type="text/javascript">
	$(document).ready(function(){
	    $(".edit-user").click(function(){
	    	$("#editusername").val($(this).closest('tr').children()[1].textContent);
	    	$("#editfullname").val($(this).closest('tr').children()[2].textContent);
	    });
	    
	    $("#adduser input[name='username']").change(function(){
	    	var username = $(this).val();
	    	if(username != null){
		    	if(username.length><%= Const.MAX_LENGTH_USERNAME%>){
		    		$('#adduser .userMsg').text("username is too long!");
		    	}
		    	else{
		    		$.ajax({
						url : 'CheckUser',
						data : {
							username : username
						},
						success : function(responseText) {
							if(responseText == "valid"){
								$("#adduser .username").removeClass("has-error has-feedback");
								$("#adduser .username").addClass("has-success has-feedback");
								$("#adduser .username .col-md-6 span").remove();
								$("#adduser .username .col-md-6").append("<span class='glyphicon glyphicon-ok form-control-feedback'></span>");
							}
							else{
								$("#adduser .username").removeClass("has-success has-feedback");
								$("#adduser .username").addClass("has-error has-feedback");
								$("#adduser .username .col-md-6 span").remove();
								$("#adduser .username .col-md-6").append("<span class='glyphicon glyphicon-remove form-control-feedback'></span>");
							}
						}
					});
		    	}
	    	}
	    });
	    
	    $("#adduser input[name='fullname']").change(function(){
	    	var fullname = $(this).val();
	    	if(fullname != null){
		    	if(fullname.length><%= Const.MAX_LENGTH_FULLNAME%>){
		    		$("#adduser .fullname").removeClass("has-success has-feedback");
					$("#adduser .fullname").addClass("has-error has-feedback");
					$("#adduser .fullname .col-md-6 span").remove();
					$("#adduser .fullname .col-md-6").append("<span class='glyphicon glyphicon-remove form-control-feedback'></span>");
		    	}
		    	else{
		    		$("#adduser .fullname").removeClass("has-error has-feedback");
					$("#adduser .fullname").addClass("has-success has-feedback");
					$("#adduser .fullname .col-md-6 span").remove();
					$("#adduser .fullname .col-md-6").append("<span class='glyphicon glyphicon-ok form-control-feedback'></span>");
		    	}
	    	}
	    });
	    
	    $("#adduser input[name='password']").change(function(){
	    	var password = $(this).val();
	    	if(password != null){
		    	if(password.length > <%= Const.MAX_LENGTH_PASSWORD%> || password.length<3){
		    		$("#adduser .password").removeClass("has-success has-feedback");
					$("#adduser .password").addClass("has-error has-feedback");
					$("#adduser .password .col-md-6 span").remove();
					$("#adduser .password .col-md-6").append("<span class='glyphicon glyphicon-remove form-control-feedback'></span>");
		    	}
		    	else{
		    		$("#adduser .password").removeClass("has-error has-feedback");
					$("#adduser .password").addClass("has-success has-feedback");
					$("#adduser .password .col-md-6 span").remove();
					$("#adduser .password .col-md-6").append("<span class='glyphicon glyphicon-ok form-control-feedback'></span>");
		    	}
	    	}
	    });
	    
	    $("#adduser input[name='cf_password']").change(function(){
	    	var cf_password = $(this).val();
	    	if(cf_password != null){
		    	if(cf_password != $("#adduser input[name='password']").val()){
		    		$("#adduser .cf_password").removeClass("has-success has-feedback");
					$("#adduser .cf_password").addClass("has-error has-feedback");
					$("#adduser .cf_password .col-md-6 span").remove();
					$("#adduser .cf_password .col-md-6").append("<span class='glyphicon glyphicon-remove form-control-feedback'></span>");
		    	}
		    	else{
		    		$("#adduser .cf_password").removeClass("has-error has-feedback");
					$("#adduser .cf_password").addClass("has-success has-feedback");
					$("#adduser .cf_password .col-md-6 span").remove();
					$("#adduser .cf_password .col-md-6").append("<span class='glyphicon glyphicon-ok form-control-feedback'></span>");
		    	}
	    	}
	    });
	    
	});
	function validateForm(){
		
	}
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
	<div class="container-fluid" style="min-height: 430px">
  <div class="row content">
  <!------------------------------------------- Left-Menu --------------------------------> 
    <div class="col-sm-3 sidenav">
    <p>OPTION</p>
    <ul class="nav nav-tabs nav-stacked nav-pills">
	    <li class="active"><a data-toggle="tab" href="#menu1">Tạo tài khoản</a></li>
	    <li><a data-toggle="tab" href="#menu2">Danh sách Tài khoản</a></li>
  	</ul>
  	<hr>
  	<%
  	String message = (String)request.getAttribute("message");
  	String error = (String)request.getAttribute("error");
  	if(message != null ){
  	%>
  	<div class="alert alert-info">
	  <%= message %>
	</div>
  	<%}
  	message = null;
  	if(error != null ){
  	  	%>
  	  	<div class="alert alert-danger">
  		  <%= error %>
  		</div>
  	  	<%}
  	error = null;
  	%>
    </div>
<!------------------------------------------- Main-content --------------------------------> 
    <div class="col-sm-9">
      <div class="tab-content">
	    <div id="menu1" class="tab-pane fade in active">
	      <h3>Tạo tài khoản</h3>
	      <form class="form-horizontal" id="adduser" action="AddAccount" method="post">
		     	<div class="form-group">
			     	<div class="col-md-offset-2 col-md-6">
			     	<center><img src="images/avatar.png" class="img-circle" alt="Avartar" width="150" height="100"></center>
			     	</div>
		     	</div>
		     	<div class="form-group username">
    				<label class="control-label col-md-2" for="username">Tài khoản:</label>
    				<div class="col-md-6">
			     	<input class="form-control" type="text" name="username" required/>
			     	</div>
		     	</div>
		     	<div class="row"><div class="col-md-offset-3 col-md-9 userMsg"></div></div>
		     	<div class="form-group fullname">
    				<label class="control-label col-md-2" for="fullname">Họ tên:</label>
    				<div class="col-md-6">
			     	<input class="form-control" type="text" name="fullname" required/>
			     	</div>
		     	</div>
		     	<div class="form-group password">
    				<label class="control-label col-md-2" for="password">Mật khẩu:</label>
    				<div class="col-md-6">
			     	<input class="form-control" type="password" name="password" required/>
			     	</div>
		     	</div>
		     	<div class="form-group cf_password">
    				<label class="control-label col-md-2" for="cf_password">Xác nhận mật khẩu:</label>
    				<div class="col-md-6">
			     	<input class="form-control" type="password" name="cf_password" required/>
			     	</div>
		     	</div>
		     	<div class="form-group">
    				<label class="control-label col-md-2" for="cf_password">Is Administrator:</label>
    				<div class="col-md-6">
			     	<input class="btn" type="checkbox" name="isadmin"/>
			     	</div>
		     	</div>
		     	<div class="form-group">
			     	<div class="col-md-offset-2 col-md-2">
			     		<input class="btn btn-primary btn-block" type="submit" value="Submit" onclick="validateForm()"/>
			     	</div>
			     </div>
	     	</form>	
	    </div>
	    <div id="menu2" class="tab-pane fade">
	      <h3>Thông tin tài khoản</h3>
	      <hr>
	      <%
	      if(users != null){
	      %>
	      <table class="table table-striped table-bordered">
	      	<tr class="info btn-lg">
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
	      			<button class="btn btn-primary edit-user" data-toggle="modal" data-target="#myModal">Edit</button>
	      			<a href="DeleteAccount?username=<%=users.get(i).getUsername()%>" type="button" class="btn btn-primary" onclick="confirm('Bạn có muốn xóa tài khoản này?')">Delete</button>
	      		</td>
	      	</tr>
	      	<%} %>
	      </table>
	      
	      <div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Chỉnh sửa tài khoản</h4>
			      </div>
			      <div class="modal-body">
			        <form name="edituserform" class="form-horizontal" action="UpdateAccount" method="post">
					  <div class="form-group">
					    <label class="control-label col-sm-3" for="username">username:</label>
					    <div class="col-sm-9">
					      <input class="form-control" type="text" name="username" id="editusername" readonly/>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="control-label col-sm-3" for="fullname">Họ tên:</label>
					    <div class="col-sm-9">
					      <input class="form-control" type="text" name="fullname" id="editfullname" required/>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-3 col-sm-3">
					      <button class="btn btn-primary btn-block" type="submit" id="submit">Submit</button>
					    </div>
					  </div>
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			
			  </div>
			</div>
	      
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

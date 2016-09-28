<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cooking Managerment</title>
<jsp:include page="WEB-INF/_bootstrap.jsp" />
<script type="text/javascript">
	
</script>
</head>
<body>
<div class="container" style="width: 40%; height: 40%; margin-top: 50px">
	<form action="CheckLogin" method="post">
		<div class="row">
			<center><img src="images/avatar.png" class="img-circle" alt="Avartar" width="200" height="150"></center>
		</div>
		<br>
		<div class="form-group">
		  <p id="err_login" style="color: red"></p>

		</div>
		<div class="form-group">
		  <label for="usr"><b>Username</b></label>
		  <input type="text" class="form-control" placeholder="Enter Username" name="username" id="username" required>
		</div>
		<div class="form-group">
		  <label for="pwd">Password:</label>
		  <input type="password" class="form-control" placeholder="Enter Password" name="password" id="password" required>
		</div>
		
		<div class="form-group">
			<button type="submit" class="form-control btn btn-primary">Login</button>
		</div>
		<div class="form-group">
			<input type="checkbox" checked="checked"> Remember me
		</div>
	</form>
</div>
</body>
</html>

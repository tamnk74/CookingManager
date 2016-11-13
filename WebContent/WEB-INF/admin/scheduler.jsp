<%@page import="model.bean.UserTask"%>
<%@page import="model.bean.Worker"%>
<%@page import="model.bean.User"%>
<%@page import="model.bean.Task"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="libraries/RGraph.common.core.js"></script>
<script src="libraries/RGraph.common.dynamic.js"></script>
<script src="libraries/RGraph.common.annotate.js"></script>
<script src="libraries/RGraph.common.context.js"></script>
<script src="libraries/RGraph.bar.js"></script>
<jsp:include page="../_bootstrap.jsp" />

<title>Cooking Managerment</title>

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
<div class="container-fluid" style="min-height: 430px">
 
  <div class="row content">
  <!------------------------------------------- Left-Menu --------------------------------> 
    <div class="col-sm-4">
    <%
    String cweek = (String)request.getAttribute("cweek");
    if(cweek != null){
    %>
    <h2>Tuần <%=cweek %></h2><hr>
    <%} %>
    <form class="form-group" action="CreateScheduler" method="post">
	   <%
	   String isCreateScheduler = (String)request.getAttribute("isCreateChecduler");
	   if(isCreateScheduler.equals("1")){
		  %> 
		  <input class="btn btn-primary active" type="submit" value="Tạo lịch tự động"/>
	   <%}
	   else{
	   %>
	   	<input class="btn btn-primary" type="submit" value="Tạo lịch tự động" disabled="disabled"/>
	   	<div class="alert alert-warning">
		  Chưa đủ dữ lệu đăng kí cho tuần sau
		</div>
	   <%} %>
	</form>
	<h2> Công việc trong tuần</h2><hr>
	<%
	ArrayList<UserTask> userTasks = (ArrayList<UserTask>)request.getAttribute("userTasks");
	if(userTasks!=null){
		String daystr[] = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"};
		int index=0;
		for(int i=0; i<7; i++){
		%>
		<div class="panel panel-default">
		  <div class="panel-heading" ><button class = "btn btn-default" data-toggle="collapse" data-target=<%= "#demo" + i%>><%= daystr[i]%></button></div>
		  <div class="panel-body collapse" id=<%="demo" + i %>>
		  <table class="table">
			  <tbody>
		  
		  <%
		  while(index <userTasks.size() && userTasks.get(index).getDay() == i){
			  %>
			  <tr>
			  	<td><%=userTasks.get(index).getFullname()%>
			  	<%
			  	if(userTasks.get(index).getTaskName() != null ){
			  	%>
			  	<td><%=userTasks.get(index).getTaskName()%></td>
			  	<%}
			  	else{%>
			  	<td>Chưa xếp lịch</td>
			  	<%} 
			  	index++;
			  	%>
			  </tr>
			  <%
		  }
		  %>
		  </tbody>
		   </table>
		  </div>
		</div>
		<%
	}}
	%>
    </div>
    
<!------------------------------------------- Main-content --------------------------------> 
   	<div class="col-sm-8">
    	<h2> Thống kê công việc</h2><hr>
    	<canvas id="cvs1" width="600" height="250">[No canvas support]</canvas>
    	<hr>
    	<canvas id="cvs2" width="600" height="250">[No canvas support]</canvas>
   	<%
    	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
   		ArrayList<UserTask> userTasks2 = (ArrayList<UserTask>) request.getAttribute("userTasks2");
   		
   		if(user != null && userTasks2 != null){
   		String amounts[] = new String[users.size()];
   		String usernames[] = new String[users.size()];
   		String amounts2[] = new String[userTasks2.size()];
   		String usernames2[] = new String[userTasks2.size()];
   		for(int i=0; i<users.size(); i++){
   			amounts[i] = String.valueOf(users.get(i).getAmount());
   			usernames[i] = "'" + users.get(i).getUsername() + "'";
   		}
   		
   		for(int i=0; i<userTasks2.size(); i++){
   			amounts2[i] = String.valueOf(userTasks2.get(i).getTaskAmount());
   			usernames2[i] = "'" + userTasks2.get(i).getUsername() + "'";
   		}
    %>
   <script>
        window.onload = function ()
        {
            var bar = new RGraph.Bar({
                id:'cvs1',
                data: [<%=String.join(",", amounts)%>],
                options: {
                    backgroundGridDashed: true,
                    labels: [<%=String.join(",", usernames)%>],
                    title: 'Khối lượng công việc đã làm',
                    strokestyle: 'rgba(0,0,0,0)',
                    textAccessible: true
                }
            }).draw();
            var bar2 = new RGraph.Bar({
                id:'cvs2',
                data: [<%=String.join(",", amounts2)%>],
                options: {
                    backgroundGridDashed: true,
                    labels: [<%=String.join(",", usernames2)%>],
                    title: 'Khối lượng công việc trong tuần',
                    strokestyle: 'rgba(0,0,0,0)',
                    textAccessible: true
                }
            }).draw();
        };
    </script>
	<%} %>
	</div>
			
</div>
</div>
<%} %>
<footer class="alert alert-info" >
  <center>Copyright@2016-5S team</center>
</footer>
</body>
</html>

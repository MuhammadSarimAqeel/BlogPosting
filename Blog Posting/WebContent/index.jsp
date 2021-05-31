<%@page import="com.entities.users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body >
<div class="fullpage">
<%@include file="normal_navbar.jsp"  %>
<div class="container-fluid p-0 m-0">
<div class="jumbotron text-white" >
<div class="container">
<h3 class="display">Welcome to Blogging World </h3>
<p>Welcome to the world of Blogging for programming and modern technologies. Computer programming is the process of designing and building an executable computer program to accomplish a specific computing result or to perform a specific task. Programming involves tasks such as: analysis, generating algorithms, profiling algorithms' accuracy and resource consumption, and the implementation of algorithms in a chosen programming language (commonly referred to as coding)</p>
 
<a href="login.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle-o"></span> Login 
</a> 
<a href="register.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-plus"></span> signup
</a> 

</div>


</div>


</div>
<%
postdao Dao = new postdao(ConnectionProvider.getConnection());
ArrayList<category> List= Dao.getAllCategories();
%>
<div class="container">

<div class="row">
<% 
for(category cc: List){

%>

<div class="col-md-6 ">
<div class="card my-2 " style="max-width:34.375rem ; max-height: 10.625rem" >
  
  <div class="card-body">
  
    <h5 class="card-title"><%= cc.getName() %></h5>
    <p class="card-text"><%= cc.getDescription() %></p>
    <%

users user =(users)session.getAttribute("currentuser");
if(user==null){
	
    %>
        <a href="login.jsp" class="btn btn-primary">Learn more..</a>
 <%
}else{  
	 %>
	<a href="profile.jsp" class="btn btn-primary">Learn more..</a>
	<%
}
	%>

 
 
 
 
  </div>

  </div>

  </div>

       <%
}
%>
</div>
</div>

<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="javascript/myjs.js" type= "text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/10.5.0/sweetalert2.all.js"></script>
<!-- 
<script>
$(document).ready(function(e){
	$("#search-bar").on("submit" , function(event){
		
		event.preventDefault();
		console.log("submitted")
		let form = new FormData(this);
		
		$.ajax({
		
			url:"SearchServlet",
			type: "post",
			data: form,
			success: function(data, textStatus, jqXHR){
				console.log(data);
				if(data.trim()==='error'){
					Swal.fire('This post doesn`t exist.')
				}
				else{
					Swal.fire('An error occured')
				}
			},
			error: function(jqXHR, textStatus, errorThrown){
				Swal.fire('error occured')
			},
			processData: false,
			contentType: false
			
		})
		
		
	})
})
-->







</body>
</html>
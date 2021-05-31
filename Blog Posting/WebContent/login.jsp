<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.entities.messege" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
body{
background-color: #ab47bc;
}

</style>
<body>
<div id="loginpage">
<%@include file="normal_navbar.jsp"  %>
<main class="d-flex align-items-center" id="pagebg" >
<div class="container mt-4">
<div class="row">
<div class="col-md-4 offset-md-4 mt-3">
<div class="card">
<div class="cardheader text-center">
    <span class="fa fa-user-circle-o"></span><h4>Login Here</h4>
</div>
<br>
<%
messege m = (messege)session.getAttribute("msg");
if(m!=null){
%>	
<div class="alert alert-primary <%= m.getCssclass() %>" role="alert">
 <%= m.getContent() %>
</div>	


	
<% 
session.removeAttribute("msg");
}

%>
<div class="cardbody">
<form class="myform" action="LoginServlet" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" name="email" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your Email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" required class="form-control" id="exampleInputPassword1" placeholder="Enter Your Password">
  </div>
 <br>
 <div class="container text-center">
  <button type="submit" class="btn btn-primary">Submit</button>
  </div><br>
  <div class="container text-center">
<h5><a href="register.jsp">create an account</a></h5>
</div>
</form>

</div> 


</div>




</div>




</div>



</div>


</main>


</div>

<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="javascript/myjs.js" type= "text/javascript"></script>
<script>
$(document).ready(function () {
    function disableBack() {
        window.history.forward()
    }

    window.onload = disableBack();
    window.onpageshow = function (evt) {
        if (evt.persisted)
            disableBack()
    }
});



</script>

</body>
</html>
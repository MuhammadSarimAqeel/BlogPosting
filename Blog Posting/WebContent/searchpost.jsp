<%@page import="com.dao.usersdao"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.likedao"%>
<%@page import="com.entities.post"%>
<%@page import="com.dao.searchdao"%>
<%@page import="com.entities.users" %>
<%@page errorPage="error.jsp" %>
<%@page import="com.entities.messege" %>
<%@page import="com.dao.postdao" %>
<%@page import="com.helper.ConnectionProvider" %>
<%@page import="com.entities.category" %>
<%@page import="java.util.ArrayList" %>



<%

response.setHeader("Cache-Control", "no-cache, no-store, must-validate");





%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Posts Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body{
background-color: #ab47bc;
}

</style>


</head>
<body>

<!-- navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp"><span class="	fa fa-bank"></span>Programming World</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp" id="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contact.jsp">Contact us</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="	fa fa-crosshairs"></span>  Categories
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="background-color:#424242">
        <div class="list-group">
          <a href="login.jsp" onclick="return getPosts(0, this)"  class=" c-link list-group-item  btn btn-light btn-lg list-group-item-action active" style="background-color: #424242; color:white">All Posts</a>
  <%
  postdao dao2 = new postdao(ConnectionProvider.getConnection());
 ArrayList<category> list2= dao2.getAllCategories();
 for(category cc: list2){

  %>
  
  <a href="login.jsp" onclick="return getPosts(<%= cc.getCid()  %>, this)" class=" c-link list-group-item  btn btn-light list-group-item-action" style="background-color: #424242; color:white"><%= cc.getName() %></a>
 <%
 }
 %>
        </div>
        </div>
      </li>
     </ul>
         <ul class="navbar nav mr-right">
      <li>
      
      
       <a href="register.jsp"  class="btn btn-outline-light btn-lg"> Create an Account 
</a> 
   </li>   
    </ul>
    
   
  
  </div>
</nav>


<!-- End Of Navbar -->

<!-- Main Body of the Page -->
<main>

  
   <%
   String name= request.getParameter("search");
  searchdao dao = new searchdao(ConnectionProvider.getConnection());
  List<post> list=dao.getPostByName(name);
 
 System.out.println(list);

  if(list.size()== 0){
	
		out.println("<h3 class='display-3 text-center' >This Post Doesn`t Exist</h3>");
	}
  
  
	for(post p:list){
	%>

	<div class= "container">
	<div class="row my-3">
	<div class="col-md-9 offset-md-2 mt-2">
	<div class="card">
	<div class="card-body">
		<div class="row my-3">
		 <div class="col-md-8">
	<h3><%= p.getpTitle() %></h3>
	<p><%= p.getpContent() %></p>

      </div>
       <div class="col-md-4">
          <%
        usersdao udao = new usersdao(ConnectionProvider.getConnection());
       
          %>
        <h6 class="post user info"><a href="#" data-toggle="modal" data-target="#NewModal"  ><%= udao.getUserByUserId(p.getUserid()).getName() %></a> Posted it on : <%= p.getpDate().toLocaleString() %></h6>
         </div>
        
	</div>
	</div>
	<div class="card-footer">


	<%
	likedao Ldao = new likedao(ConnectionProvider.getConnection());

	%>

	<a onclick="dolike(<%= p.getPid() %>, <%= p.getUserid() %>)" class="btn btn-outline-light "><i class="fa fa-thumbs-o-up" ></i><span class="like-counter"><%= Ldao.countLikeonPost(p.getPid()) %></span></a>
	<a href="#" class="btn btn-outline-light " data-toggle="modal" data-target="#ReadModal"  >Read more...</a>

	</div>



	</div>
	</div>
		</div>
			</div>
<%
	}
	%>






	







</main>



<!-- End of Main Body of the Page -->
<!-- Modal -->
<div class="modal" tabindex="-1" id ="NewModal">
  <div class="modal-dialog">
    <div class="modal-content">
    
      <div class="modal-body">
        <p>You Must be login to see user`s profile.</p>
      </div>
      <div class="modal-footer">
        <a href="login.jsp" class="btn btn-secondary"  >Close</a>
      </div>
    </div>
  </div>
</div>
     
     
     <!-- Modal -->
<div class="modal" tabindex="-1" id ="ReadModal">
  <div class="modal-dialog">
    <div class="modal-content">
    
      <div class="modal-body">
        <p>You Must be login to see full post.</p>
      </div>
      <div class="modal-footer">
        <a href="login.jsp" class="btn btn-secondary"  >Close</a>
      </div>
    </div>
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









<script>
function dolike(pid , uid){
	console.log(pid+ "," + uid);
	
	const d = {
		uid : uid,
		pid:pid,
		operation: 'like'
	}
	$.ajax({
		url: "LikeServlet",
		data: d,
		success: function(data, textStatus, jqXHR){
			console.log(data)
			if(data.trim()=== 'true'){
				
				let c = $(".like-counter").html();
				c++;
				$(".like-counter").html(c);
				
			}
			
		},
		error: function(jqXHR, textStatus, errorThrown){
			console.log(data)
			
		}
		
	})
	
}

</script>

</body>
</html>
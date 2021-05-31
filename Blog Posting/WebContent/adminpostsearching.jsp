<%@page import="com.entities.post"%>
<%@page import="com.dao.searchdao"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.usersdao"%>
<%@page import="com.dao.likedao"%>
<%@page import="com.entities.users" %>
<%@page errorPage="error.jsp" %>
<%@page import="com.entities.messege" %>
<%@page import="com.dao.postdao" %>
<%@page import="com.helper.ConnectionProvider" %>
<%@page import="com.entities.category" %>
<%@page import="java.util.ArrayList" %>



<%



users user=(users)session.getAttribute("currentuser");
if(user==null){
	response.sendRedirect("login.jsp");
	
	
}


%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
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
        <a class="nav-link" href="profile.jsp" id="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contact.jsp">Contact us</a>
      </li>
      
     
       <li class="nav-item">
        <a class="nav-link " href="#" tabindex="-1" aria-disabled="true" data-toggle="modal" data-target="#AddPostModal"><span class="fa fa-plus-square"></span> Add Post</a>
      </li>
      
      
    </ul>
 
    
   <ul class="navbar nav mr-right">
 
 <li>
  <a href="#" class="btn btn-lg" data-toggle="modal" data-target="#exampleModal" style="color:white"><span class="fa fa-user-circle-o"></span><%= user.getName() %> 
</a> 
 </li>
 <li>
  <a onclick="dologout()"  class="btn btn-outline-light btn-lg"> Logout 
</a> 
   
   </ul>
  </div>
</nav>


<!-- End Of Navbar -->
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
<!-- Main Body of the Page -->



  
  
  
  

  
  
 


<!-- posts -->






  
   <%
   String name= request.getParameter("search");
  searchdao dao = new searchdao(ConnectionProvider.getConnection());
  List<post> list=dao.getPostByName(name);
 


  if(list.size()== 0){
	
		out.println("<h3 class='display-3 text-center' >This Post Doesn`t Exist</h3>");
	}
  
  
	for(post p:list){		
	%>
	<div class="container">
<div class="row mt-3">
<div class="col-md-4 mt-4">
<!-- Catogories -->
<a href="#"  class=" c-link list-group-item  btn btn-light list-group-item-action" style="background-color: #424242; color:white"> All Posts</a>
	 
  <%
  postdao pdao = new postdao(ConnectionProvider.getConnection());
 ArrayList<category> list1= pdao.getAllCategories();
 for(category cc: list1){

  %>
  <% if(p.getCid()== cc.getCid()){ %>
  
  <a href="#"  class="c-link list-group-item  btn btn-light  list-group-item-action active " style="background-color: #424242; color:white"><%= cc.getName() %></a>
   
 
  <%}else{ %>
  <a href="#" class=" c-link list-group-item  btn btn-light list-group-item-action" style="background-color: #424242; color:white"><%= cc.getName() %></a>
  
 
  <%} %>
 <%
 }
 %>
	
	</div>
	
	<div class="col-md-8 mt-2" >

	<div class= "container mt-4">

	<div class="card mt-4">
	<div class="card-body">
		<div class="row my-3">
		 <div class="col-md-10">
	<h3><%= p.getpTitle() %></h3>
	<p><%= p.getpContent() %></p>

      </div>
       <div class="col-md-2">
         
         </div>
        
	</div>
	</div>
	<div class="card-footer">

	<%
	likedao Ldao = new likedao(ConnectionProvider.getConnection());

	%>

	
<a href="adminshowpost.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light ">Read more...</a>
<a href="editpost.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light "><span class="fa fa-pencil"></span></a>

<a  onclick="dodelete(<%= p.getPid() %>)" class="btn btn-outline-light " id="delete"><span class="fa fa-trash"></span></a>




</div>

		</div>
		</div>
			</div>

<%
}

%>




	









</div>
</div>








  
  
  
  
  
  
  
  
  






<!-- End of Main Body of the Page -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: #1976d2; color:white;">
        <h5 class="modal-title" id="exampleModalLabel">Coding World</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container text-center">
        <img src="pics/<%= user.getProfile() %>" class="img-fluid" style="border-radius: 30%; max-width: 150px;">
        <br>
        <h4 class="modal-title" id="exampleModalLabel"><%= user.getName() %></h4>
      <br>
        <!-- details -->
        <div id="profile-details">
        <table class="table">
 
  <tbody>
    <tr>
      <th scope="row">Role :</th>
      <td><%= user.getRole() %></td>
      
    </tr>
  
  
    <tr>
      <th scope="row">ID :</th>
      <td><%= user.getId() %></td>
      
    </tr>
    <tr>
      <th scope="row">Email :</th>
      <td><%= user.getEmail() %></td>
     
    </tr>
    <tr>
      <th scope="row">Gender :</th>
      <td><%= user.getGender() %></td>
      
    </tr>
      <tr>
      <th scope="row">Mobile :</th>
      <td><%= user.getMobile() %></td>
      
    </tr>
      <tr>
      <th scope="row">About :</th>
      <td><%= user.getAbout() %></td>
      
    </tr>
    
     <tr>
      <th scope="row">Posts:</th>
      <td><a href="myposts.jsp">Go To Profile Page</a></td>
      
    </tr>
    
    
    
    
  </tbody>
</table>
        </div>
        <!-- profile edit -->
        <div id="profile-edit" style="display:none">
        
       <form action="EditServlet" method="post" method="get" id="Edit-form"  enctype="multipart/form-data" >
     
       <table class="table">
       
        <tr>
      <td>New Profile :</td>
      <td><input type= "file"  name="image" ></td>
      
    </tr> 
        <tr>
      <th scope="row">Role :</th>
      <td><%= user.getRole() %></td>
      
    </tr>
    
        <tr>
      <th scope="row">ID :</th>
      <td><%= user.getId() %></td>
      
    </tr>
         <tr>
      <td scope="row">Email :</td>
      <td><input type"email" class=""form-control name="user_email" value="<%= user.getEmail()%>" style="width: 300px"></td>
      
    </tr> 
         <tr>
      <td scope="row">NAME :</td>
      <td><input type"text" class=""form-control name="user_name" value="<%= user.getName()%>" style="width: 300px"></td>
      
    </tr> 
         <tr>
      <td scope="row">Password :</td>
      <td><input type"password" class=""form-control name="user_password" value="<%= user.getPass()%>" style="width: 300px"></td>
      
    </tr> 
    <tr>
      <td scope="row">Mobile :</td>
      <td><input type"number" class=""form-control name="user_mobile" value="<%= user.getMobile()%>" style="width: 300px"></td>
      
    </tr> 
    
    
         <tr>
      <td scope="row">Gender :</td>
      <td><%= user.getGender() %></td>
      
    </tr> 
    <tr>
      <td scope="row">About :</td>
      <td><textarea rows="3" cols="8" class="form-control" name="user_about" ><%= user.getAbout()%></textarea></td>
      
    </tr> 
    
    
  
    
    
       </table>
       <div class="container">
       <button  type="submit" class="btn btn-primary">Save</button>
       </div>
       
       </form>
        
        </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button id="edit-profile" type="button" class="btn btn-primary">EDIT</button>
      </div>
    </div>
  </div>
</div>


<!-- Add post modal starts from here -->

<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="AddPostModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"> Post Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
        <form action="AddPostServlet" method="post" id="addpostform">
        <div class="form-group" >
        <select class="form-control" style="width:400px" name="cid">
        <option selected disabled>---Select Category---</option>
        <%
        postdao Dao =new postdao(ConnectionProvider.getConnection());
        ArrayList<category> L=Dao.getAllCategories();
        for(category c:L){
        %>
        
        <option value="<%= c.getCid()  %>"><%= c.getName() %></option>
   
        <%
        }
        %>
        
        </select>
        
        
        </div>
        

        <div class="form-group" >
        <select class="form-control" style="width:400px" name="posttype">
        <option selected disabled>---Select Post Type---</option>
        
        
        <option value="Public">Public</option>
    <option value="Private">Private</option>
      
        
        </select>
        
        
        </div>
        <div class="form-group">
        <input type="text" name="posttitle" onfocus="this.value=''" placeholder="Enter Post Title" class="form-control" style="width: 400px"/>
 
        </div>
        
         <div class="form-group">
        <textarea  placeholder="Post Your Content Here" onfocus="this.value=''" name="postcontent" class="form-control" style="width: 400px; height: 200px"></textarea>
 
        </div>
          <div class="form-group">
        <textarea  placeholder="Post Your Code here" onfocus="this.value=''" name="postcode" class="form-control" style="width: 400px; height: 200px"></textarea>
 
        </div>
        <div class="form-group">
        <label>Select Your Pic :</label><br>
       <input type="file" name="postpic"> 
 
        </div>
        <div class="container text-center">
        <button type="submit" class="btn btn-primary">Post</button>
        </div>
        
        
        </form>
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
$(document).ready(function(){
	let editStatus= false;
	
	$('#edit-profile').click(function(){
		if(editStatus==false){
			$('#profile-details').hide()
				$('#profile-edit').show()
				editStatus= true;
			$(this).text("Back")
		}
		else{
			
			$('#profile-details').show()
			$('#profile-edit').hide()
			editStatus= false;
			$(this).text("EDIT")
		}
	})
})






</script>

<script>
$(document).ready(function(e){
	$("#Edit-form").on("submit" , function(event){
		
		event.preventDefault();
		console.log("submitted")
		let form = new FormData(this);
		
		$.ajax({
		
			url:"EditServlet",
			type: "post",
			data: form,
			success: function(data, textStatus, jqXHR){
				console.log(data);
				if(data.trim()==='done'){
					Swal.fire('Edited Successfully')
				}
				else{
					Swal.fire('An error occured...')
				}
			},
			error: function(jqXHR, textStatus, errorThrown){
				Swal.fire('An error occured')
			},
			processData: false,
			contentType: false
			
		})
		
		
	})
})






</script>

 
<script>
$(document).ready(function(e){
	$("#addpostform").on("submit" , function(event){
		
		event.preventDefault();
		console.log("submitted")
		let form = new FormData(this);
		
		$.ajax({
		
			url:"AddPostServlet",
			type: "post",
			data: form,
			success: function(data, textStatus, jqXHR){
				console.log(data)
				if(data.trim()=== 'done'){
					Swal.fire('posted Successfully');
				}else{
					Swal.fire('An error occured');
				}
			},
			error: function(jqXHR, textStatus, errorThrown){
				Swal.fire('An error occured');
			},
			processData: false,
			contentType: false
			
		})
		
		
	})
})






</script>

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

<script>
function dologout(){
	
	
	
	

	Swal.fire({
	  title: 'Are you sure?',
	  text: "You won't be able to revert this!",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Yes Logout'
	}).then((result) => {
	  if (result.isConfirmed) {
		$.ajax({
			url: "LogoutServlet",
			success: function(data){
				window.location.href = "login.jsp"
             
				    Swal.fire(
	      'Logged out!',
	      'Your have been logout.',
	      'success'
	    )
					
			
		
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log(data);
				Swal.fire('Error Occured');
				
			}
			
		})


	  }
	})
	
}


</script>

<script>
function dodelete(pid){
	console.log(pid);
	
	
	const k = {
		
		pid:pid,
		operation: 'delete'
		
	}

	Swal.fire({
	  title: 'Are you sure?',
	  text: "You won't be able to revert this!",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Yes, delete it!'
	}).then((result) => {
	  if (result.isConfirmed) {
		$.ajax({
			url: "DeleteServlet",
			data: k,
			success: function(data, textStatus, jqXHR){
				console.log(data)
				if(data.trim()=== 'done'){

				    Swal.fire(
	      'Deleted!',
	      'Your file has been deleted.',
	      'success'
	    )
					
				}else{
					Swal.fire(data);
				}	
		
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log(data);
				Swal.fire('Error Occured');
				
			}
			
		})


	  }
	})
	
}


</script>




</body>
</html>
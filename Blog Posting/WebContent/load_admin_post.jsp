<%@page import="com.dao.likedao"%>
<%@page import="com.entities.users"%>
<%@page import="com.entities.post"%>
<%@page import="java.util.List"%>
<%@page import="com.helper.ConnectionProvider"%>
<%@page import="com.dao.postdao"%>


<%
response.setHeader("Cache-Control", "no-cache, no-store, must-validate");


users user=(users)session.getAttribute("currentuser");
if(user==null){
	response.sendRedirect("login.jsp");
	
	
}else if ( user.getRole().equals("User")){
	
	response.sendRedirect("profile.jsp");
	
}




%>




<div class="rows">
<%

postdao d = new postdao(ConnectionProvider.getConnection());

int cid= Integer.parseInt(request.getParameter("cid"));
List <post> posts = null;
if(cid==0){
 posts=d.getAllPosts();
}


else if (cid==100000000){
	
	posts = d.getPostsByUserID(user.getId());
	
}


else{
	posts=d.getPostByCId(cid);
}
if(posts.size()== 0){
	
	out.println("<h3 class='display-3 text-center' >No post in this category yet</h3>");
}
for(post p:posts){
%>

<div class="col-md-12 mt-2">
<div class="card">
<div class="card-body">
<div class="row  row-user">
<div class="col-md-8">

<h3 ><a href="adminshowpost.jsp?post_id=<%= p.getPid() %>" style= "color: white; text-decoration: none;" ><%= p.getpTitle() %></a></h3>
<p><%= p.getpContent() %></p>
</div>
<div class="col-md-4">
<p style="align-text: right;"><b>Post Type: </b><%= p.getpType() %></p>

</div>
</div>

<%
likedao Ldao = new likedao(ConnectionProvider.getConnection());

%>


</div>
<div class="card-footer">


<a href="adminshowpost.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light ">Read more...</a>
<a href="editpost.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light "><span class="fa fa-pencil"></span></a>

<a  onclick="dodelete(<%= p.getPid() %>)" class="btn btn-outline-light " id="delete"><span class="fa fa-trash"></span></a>

</div>



</div>



</div>




<%
}
%>
</div>




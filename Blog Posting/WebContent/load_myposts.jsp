<%@page import="com.entities.users"%>
<%@page import="com.dao.likedao"%>
<%@page import="com.entities.post"%>
<%@page import="java.util.List"%>
<%@page import="com.helper.ConnectionProvider"%>
<%@page import="com.dao.postdao"%>


<%
response.setHeader("Cache-Control", "no-cache, no-store, must-validate");


users user=(users)session.getAttribute("currentuser");
if(user==null){
	response.sendRedirect("login.jsp");
	
	
}else if ( user.getRole().equals("Admin")){
	
	response.sendRedirect("adminuser.jsp");
	
}




%>



<div class="rows">
<%

postdao d = new postdao(ConnectionProvider.getConnection());

int cid= Integer.parseInt(request.getParameter("cid"));
List <post> posts = null;

if (cid==0){
	
	posts = d.getPostsByUserID(user.getId());
	if(posts.size()== 0){
		
		out.println("<h3 class='display-3 text-center' >You don`t have any post.</h3>");
	}
}
else{
	posts=d.getPostByCIdAndUserId(cid, user.getId());
	if(posts.size()== 0){
		
		out.println("<h3 class='display-3 text-center' >You don`t have any post in this category</h3>");
	
}

}
for(post p:posts){
%>

<div class="col-md-12 mt-2">
<div class="card">




<div class="card-body">
<div class="row ml-1 row-user">
<div class="col-md-10 mt-2">

<h3><a href="adminshowpost.jsp?post_id=<%= p.getPid() %>"   style= "color: white; text-decoration: none;"><%= p.getpTitle() %></a></h3>

<p><%= p.getpContent() %></p><br>


</div>
<div class="col-md-2 mt-2">
<p style="align-text: right;"><%= p.getpType() %></p>

</div>
</div>
</div>
<div class="card-footer ml-1">


<%
likedao Ldao = new likedao(ConnectionProvider.getConnection());

%>



<%
if(p.getUserid()==user.getId()){
%>	
	
<a href="adminshowpost.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light ">Read more...</a>
<a href="editpost.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light "><span class="fa fa-pencil"></span></a>

<a  onclick="dodelete(<%= p.getPid() %>)" class="btn btn-outline-light " id="delete"><span class="fa fa-trash"></span></a>

<% 	
}else{
	%>
	
	<a href="show_postpage.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light ">Read more...</a>
	
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
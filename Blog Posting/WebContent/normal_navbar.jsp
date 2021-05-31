<%@page import="com.entities.users"%>
<%@page import="com.entities.category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.helper.ConnectionProvider"%>
<%@page import="com.dao.postdao"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp"><span class="	fa fa-bank"></span>TechBlog</a>
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
        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="background-color:#424242;">
                 <div class="list-group">
          <a href="login.jsp" onclick="return getPosts(0, this)"  class=" c-link list-group-item  btn btn-light btn-lg list-group-item-action active" style="background-color: #424242; color:white">All Posts</a>
  <%
  postdao dao2 = new postdao(ConnectionProvider.getConnection());
 ArrayList<category> list2= dao2.getAllCategories();
 for(category cc: list2){

  %>
  
  <% 
  users user =(users)session.getAttribute("currentuser");
if(user==null){
	
    %>
         <a href="login.jsp" onclick="return getPosts(<%= cc.getCid()  %>, this)" class=" c-link list-group-item  btn btn-light list-group-item-action" style="background-color: #424242; color:white"><%= cc.getName() %></a>
 <%
}else{  
	 %>
	 <a href="profile.jsp" onclick="return getPosts(<%= cc.getCid()  %>, this)" class=" c-link list-group-item  btn btn-light list-group-item-action" style="background-color: #424242; color:white"><%= cc.getName() %></a>
	<%
}
	%>
  
  
  
 
 <%
 }
 %>
 
 
        </div>
        
        </div>
        
      </li>
     
    </ul>
   
    
    
    <form class="form-inline my-2 my-lg-0" action="SearchServlet" method="post" id="search-bar" name="myform">
      <input class="form-control mr-sm-2" type="text" placeholder="Search Posts Here" required aria-label="Search" name="search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>


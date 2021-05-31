<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verification page</title>

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
<main class="d-flex align-items-center" id="pagebg" style="height:80vh">
<div class="container">
<div class="row">
<div class="col-md-4 offset-md-4 my-3">
<div class="card">
<div class="cardheader text-center">
    <span class="fa fa-user-plus"></span><h4>Verify Here</h4>
</div>
<br>

<div class="cardbody">

<form id="my-form" style="margin: 1.2rem;">
<p>We already send you the verification code on your gmail account.</p>
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Code Here</label>
    <input type="text" name="code" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Verification Code">
  </div>
 <br>
 <div class="container text-center">
  <button type="submit" id="submitbtn" class="btn btn-primary">Send</button>
  </div><br>

</form>

</div> 
 <div class="container text-center" id="loader" style="display:none;">
  <span  class="fa fa-spinner fa-spin fa-4x" ></span>
  <h4>Please Wait....</h4>
  </div>

</div>




</div>




</div>



</div>


</main>


<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="javascript/myjs.js" type= "text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/10.3.5/sweetalert2.all.js"></script>


<script>

$(document).ready(function(event){
	$("#my-form").on("submit" , function(event){
		
		event.preventDefault();
		console.log("submitted")
		let form = new FormData(this);
		console.log(form)
	
		$.ajax({
		
			url:"VerifyCodeServlet",
			type: "post",
			data: form,
			success: function(data,textStatus,jqXHR){
				console.log(data);
				if(data.trim() =='done'){
					Swal.fire('Registered Successfully')
			window.location.href="login.jsp"
					
					
				}
				else{
					Swal.fire(data)
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
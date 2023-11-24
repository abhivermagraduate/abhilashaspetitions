<!-- Student Name : Abhilasha Verma
    Email ID : A.Verma7@nuigalway.ie
    Student ID : 22102028
-->
<!-- Purpose of this jsp is to create petition -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Petition Website</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
}

header {
	background-color: #333;
	color: #fff;
	padding: 10px;
	text-align: center;
}

h1 {
	margin: 0;
}

.container {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
}

.petitionForm {
	display: flex;
	flex-direction: column;
}

.petitionForm label {
	font-weight: bold;
	margin-bottom: 5px;
}

.petitionForm input[type="text"], .petitionForm textarea {
	margin-bottom: 15px;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.petitionForm button {
	background-color: #333;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.petitionForm button:hover {
	background-color: #555;
}

label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

input[type=text], select {
	width: 200px;
}




button {
	padding: 10px;
	margin: 10px;
}
</style>

<script type = "text/javascript">
      // Form validation code will come here.
      function validate() {
      
         if( document.petitionForm.name.value == "" ) {
            alert( "Please enter your name" );
            document.petitionForm.name.focus() ;
            return false;
         }
         if( document.petitionForm.email.value == "" ) {
             alert( "Please enter your email Id" );
             document.petitionForm.email.focus() ;
             return false;
          }
         if( document.petitionForm.petitionTitle.value == "" ) {
             alert( "Please enter petition title" );
             document.petitionForm.petitionTitle.focus() ;
             return false;
          }
         if( document.petitionForm.petitionText.value == "" ) {
             alert( "Please enter petition text" );
             document.petitionForm.petitionText.focus() ;
             return false;
          }
         if( document.petitionForm.signatureGoalCount.value == "" ) {
             alert( "Please enter signature goal count" );
             document.petitionForm.signatureGoalCount.focus() ;
             return false;
          }
         if( document.petitionForm.geographicArea.value == "" ) {
             alert( "Please enter City, Country or Region " );
             document.petitionForm.geographicArea.focus() ;
             return false;
          }
       
         return( true );
      }
</script>



</head>
<%@ include file="header.jsp"%>
<body>
	<div class="container">
		<%
		String displayMessage = (String) request.getAttribute("displayMessage");
		if (displayMessage != null) {
		%>
		<br>
		<p style="color: red"><%=displayMessage%></p>

		<%
		}
		%>
		<header>
			<h1>Support Our Cause</h1>
		</header>





		<div class="container">
			<h2>Create a Petition</h2>


			<form:form action="createPetition.htm" enctype="multipart/form-data"
				method="post" modelAttribute="petition" name= "petitionForm" onsubmit="return validate()">

				<form:label path="name">Your Name:</form:label>
				<form:input path="name" />
				<br />

				<form:label path="email">E-mail:</form:label>
				<form:input path="email" />
				<br />

				<form:label path="petitionTitle">Petition Title :</form:label>
				<form:input path="petitionTitle" />
				<br />


				<form:label path="petitionText">Petition Text:</form:label>
				<form:textarea path="petitionText" cols="25" rows="5" />
				<br />

				<form:label path="signatureGoalCount">Signature Goal Count :</form:label>
				<form:input path="signatureGoalCount" />
				<br />
				
				<form:label path="geographicArea">City, Country or Region :</form:label>
				<form:input path="geographicArea" />
				<br />
				
				<form:label path="imageFile">Select a image to upload :</form:label>
				<form:input type="file" path="imageFile" />
				<br />


				<form:button class="btn btn-primary">Create Petition</form:button>
			</form:form>
		</div>
</body>

</body>
</html>
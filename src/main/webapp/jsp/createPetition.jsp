<!-- Student Name : Abhilasha Verma
    Email ID : A.Verma7@nuigalway.ie
    Student ID : 22102028
-->
<!-- Purpose of this jsp is to give option to user to upload xml file -->
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

.petition-form {
	display: flex;
	flex-direction: column;
}

.petition-form label {
	font-weight: bold;
	margin-bottom: 5px;
}

.petition-form input[type="text"], .petition-form textarea {
	margin-bottom: 15px;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.petition-form button {
	background-color: #333;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.petition-form button:hover {
	background-color: #555;
}

label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

input[type=text], input[type=password], select {
	width: 200px;
}

input[type=radio] {
	display: inline-block;
	margin-left: 45px;
}

input[type=checkbox] {
	display: inline-block;
	margin-right: 190px;
}

button {
	padding: 10px;
	margin: 10px;
}
</style>
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
				method="post" modelAttribute="petition">

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

				<form:label path="imageFile">Select a image to upload :</form:label>
				<form:input type="file" path="imageFile" />
				<br />


				<form:button>Create Petition</form:button>
			</form:form>
		</div>
</body>

</body>
</html>
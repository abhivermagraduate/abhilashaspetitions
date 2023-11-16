<!-- Student Name : Abhilasha Verma
    Email ID : A.Verma7@nuigalway.ie
    Student ID : 22102028
-->
<!-- Purpose of this jsp is to display header link with welcome message and it is included by other jsp-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>University of Galway Petition Portal </title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

 <link rel="stylesheet" href="stylesheet/style.css">

    <script type="application/javascript" src="script/functions.js"></script>


</head>
<body>
	<div class="container">
		<div class="header">
			<h1>University of Galway Petition Portal </h1>
		</div>
		<div align="center">


			<ul>
				<li id="liTag"><a href="showPetitions.htm">Home</a></li>
				<li id="liTag"><a href="createPetition.htm">Create Petition</a></li>
				<li id="liTag"><a href="showSearchPetition.htm">Search Petition</a></li>
			</ul>

		</div>
	</div>
</body>
</html>
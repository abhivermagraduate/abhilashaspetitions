<!-- Student Name : Abhilasha Verma
    Email ID : A.Verma7@nuigalway.ie
    Student ID : 22102028
-->
<!-- Purpose of this jsp is to search petition -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.nui.model.Petition"%>



<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<body>
	<div class="container">
		<%
		List<Petition> petitionList = (List) request.getAttribute("petitions");
		%>
		<%
		String displayMessage = (String) request.getAttribute("displayMessage");
		if (displayMessage != null) {
		%>
		<br>
		<p style="color: red"><%=displayMessage%></p>

		<%
		}
		%>
		<div class="row">
			<div class="col-md-12">
				<div class="card">
				
					<div class="card-body">
						Search Petition : <input id="petitionTitle" name="petitionTitle" type="text" size="25" />
					 <button class="btn btn-primary" id="post" type="button" onclick="submitSearch()">Search</button>
					
					</div>
				</div>
			</div>
		</div>
		<div class="row" id="searchResultDIV">
		</div>
	</div>
</body>
</html>
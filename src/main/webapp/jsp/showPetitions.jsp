<!-- Student Name : Abhilasha Verma
    Email ID : A.Verma7@nuigalway.ie
    Student ID : 22102028
-->
<!-- Purpose of this jsp is to give option to user to upload xml file -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Iterator"%>
		<%@page import="com.nui.model.Petition"%>
	
	
	
<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<body>
${petitions}
	<div class="container">
		<%
		List<Petition> petitionList = (List) request.getAttribute("petitions");
		%>
	
	<div class="container">
		<div align="center">
			<h2>Customer List</h2>

		</div>
		


		<table id="assignmentTables" border="1" class="table table-striped">
			<thead class="table-primary">
				<tr>
					<th>Customer Number</th>
					<th>Customer Name</th>
					<th>Phone</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<%
				Iterator iterator = petitionList.iterator();
				while (iterator.hasNext()) {
					Petition petition = (Petition) iterator.next();
				%>
				<tr>
					<td><%=petition.getPetitionText()%></td>
							Details</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	
		
		
	</div>
</body>
</html>
<!-- Student Name : Abhilasha Verma
    Email ID : A.Verma7@nuigalway.ie
    Student ID : 22102028
-->
<!-- Purpose of this jsp is to give option to user to upload xml file -->
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
					<div class="card-header bg-info bg-gradient" align="center">
						<h5 class="card-title fw-bolder">Discover petitions to sign</h5>
					</div>
					<div class="card-body">
						<table class="table">


							<%
							Iterator iterator = petitionList.iterator();
							while (iterator.hasNext()) {
								Petition petition = (Petition) iterator.next();
							%>
							<tr>
								<td>
									<div class="bg-image">
										<a
											href="getPetitionDetails.htm?petitionId=<%=petition.getId()%>">
											<img src="upload/<%=petition.getImageId()%>"
											class="img-fluid" alt="Sample" />
										</a>

									</div>

								</td>
								<td><b><%=petition.getPetitionTitle()%></b> <br> <%=petition.getPetitionText()%></td>
								<td><a
									href="getPetitionDetails.htm?petitionId=<%=petition.getId()%>">Read
										more</a></td>
							</tr>
							<%
							}
							%>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
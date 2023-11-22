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
					<div class="card-header" align="center">
						<h5 class="card-title fw-bolder">Discover petitions to sign</h5>
					</div>
					<div class="card-body text-primary">
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
											  class="img-fluid"  />
										</a>

									</div>

								</td>
								<td><b><a href="getPetitionDetails.htm?petitionId=<%=petition.getId()%>"><%=petition.getPetitionTitle()%></a></b> <br> <p class="show-read-more"> <%=petition.getPetitionText()%></p>
								<br>
								<%=petition.getSignatureGoalCount()%>
								
								<br>
								<div class="progress">
  <div class="progress-bar progress-bar-striped bg-success" role="progressbar" style='width: <%=petition.getSignatureCount()%>%' aria-valuenow="<%=petition.getSignatureCount()%>" aria-valuemin="0" aria-valuemax="<%=petition.getSignatureGoalCount()%>">
  </div>
</div>
		 
									
								</td>
								<td></td>
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
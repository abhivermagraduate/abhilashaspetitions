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
		Petition petition = (Petition) request.getAttribute("petition");
		%>

		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header bg-info bg-gradient" align="center">
						<h5 class="card-title fw-bolder">Discover petitions to sign</h5>
					</div>
					<div class="card-body">
						<table class="table">


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
								<td><%=petition.getPetitionTitle()%> <br> <%=petition.getPetitionText()%></td>
								<td><a
									href="getPetitionDetails.htm?petitionId=<%=petition.getId()%>">Read
										more</a></td>


							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header bg-info bg-gradient" align="center">
						<h5 class="card-title fw-bolder">Sign this petition</h5>
					</div>
					<div class="card-body">

						<form:form action="signPetition.htm" method="post"
							modelAttribute="petitionSignature">

							<form:label path="name">Your Name:</form:label>
							<form:input path="name" />
							<br/><br/>

							<form:label path="email">E-mail:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </form:label>
							<form:input path="email" />
							<br/><br/>


							<form:radiobutton path="petitionWinNotificationStatus" />
							<form:label path="petitionWinNotificationStatus">Yes! Tell me if this petition wins, and how I can help other relevant petitions</form:label>
<br/><br/>
							<form:radiobutton path="petitionProgressNotificationStatus" checked="false"/>
							<form:label path="petitionProgressNotificationStatus">No. I don't want to hear about this petition’s progress or other relevant petitions.</form:label>

<br/><br/>


							<form:button>Sign this petition</form:button>
						</form:form>


					</div>
				</div>
			</div>
		</div>
</body>
</html>
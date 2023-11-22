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

<script type = "text/javascript">
      // Form validation code will come here.
      function validate() {
      
         if( document.petitionSignature.name.value == "" ) {
            alert( "Please enter your name" );
            document.petitionSignature.name.focus() ;
            return false;
         }
         if( document.petitionSignature.email.value == "" ) {
             alert( "Please enter your email Id" );
             document.petitionSignature.email.focus() ;
             return false;
          }
       
         return( true );
      }
</script>

<body>
	<div class="container">
		<%
		Petition petition = (Petition) request.getAttribute("petition");
		%>

		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header  " align="center">
						<h5 class="card-title fw-bolder"><%=petition.getPetitionTitle()%> </h5>
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
								<td>
								<br>
								<b>Created on</b> : <%=petition.getCreateDateTime()%> 
								<br>
								<b>Started by</b> : <%=petition.getName()%> 
								<br>
								<b>City, Country or Region</b> : <%=petition.getGeographicArea()%> 
								<br>
								<br> <%=petition.getPetitionText()%>
										
										
										<br><br>
								<div class="progress">
  <div class="progress-bar progress-bar-striped bg-success" role="progressbar" style='width: <%=petition.getSignatureCount()%>%' aria-valuenow="<%=petition.getSignatureCount()%>" aria-valuemin="0" aria-valuemax="<%=petition.getSignatureGoalCount()%>">
  </div>
</div>
		  	
										
										
										
										
										</td>


							</tr>
							
							
							
							
							
							
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header bg-primary bg-gradient py-3" align="center">
						<h5 class="card-title fw-bolder">Sign this petition</h5>
					</div>
					<div class="card-body">

						<form:form name="petitionSignature" action="signPetition.htm" method="post"
							modelAttribute="petitionSignature" onsubmit="return validate()">

							<form:label path="name">Your Name:</form:label>
							<form:input path="name" />
							<br />
							<br />

							<form:label path="email">E-mail:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </form:label>
							<form:input path="email" />
							<br />
							<br />


							<form:radiobutton path="petitionWinNotificationStatus"
								value="true" />
							<form:label path="petitionWinNotificationStatus">Yes! Tell me if this petition wins, and how I can help other relevant petitions</form:label>
							<br />
							<br />
							<form:radiobutton path="petitionProgressNotificationStatus"
								value="true" />
							<form:label path="petitionProgressNotificationStatus">No. I don't want to hear about this petition's progress or other relevant petitions.</form:label>

							<br />
							<br />
							<input id="petitionId" name="petitionId" type="hidden" value="<%=petition.getId()%>"/>
							
							<form:button  class="btn btn-primary">Sign this petition</form:button>
						</form:form>


					</div>
				</div>
			</div>
		</div>
</body>
</html>
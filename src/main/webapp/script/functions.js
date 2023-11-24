/** Student Name : Abhilasha Verma
   Email ID : A.Verma7@nuigalway.ie
   Student ID : 22102028
**/


/**
* Purpose of this function is to search petition by sending ajax request to controller.
*
*/
function searchPetition() {
	let httpRequest = new XMLHttpRequest();
	httpRequest.open('POST', 'searchPetition.htm');
	// Track the state changes of the request.
	httpRequest.onreadystatechange = function() {
		let DONE = 4; // readyState 4 means the request is done.
		let OK = 200; // status 200 is a successful return.
		if (httpRequest.readyState === DONE) {
			if (httpRequest.status === OK) {
				let searchResultDIV = document.getElementById("searchResultDIV");
				searchResultDIV.innerHTML = httpRequest.responseText;

			} else {
				// If there is no data in DB then don't parse JSON response
				console.log('Error: ' + httpRequest.status);
			}
		}
	};
	httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httpRequest.send("petitionTitle=" + document.getElementById("petitionTitle").value);
}


/**
* Purpose of this function is to validate search petition form data data then call searchPetition to send ajax request to controller.
*
*/
function submitSearch() {

	let petitionTitle = document.getElementById("petitionTitle");
	// If condition to check comment text data is not blank.
	if (petitionTitle.value == "") {
		alert("Please enter Petition Text");
		return true;
	}
	searchPetition();
}


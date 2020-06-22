$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/create_booking.feature");
formatter.feature({
  "name": "End to end flow - create a booking, update it, get the updated values and delete it",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create a new booking successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Create default request payload",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CreateBookingSteps.createDefaultRequestPayload()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send POST request",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CreateBookingSteps.sendPostRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.ValidationSteps.statusCodeIs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The data in the response body is the same as data in the request body",
  "keyword": "And "
});
formatter.match({
  "location": "steps.ValidationSteps.responseHasSameDataAsRequestBody()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The booking id was saved successfully",
  "keyword": "And "
});
formatter.match({
  "location": "steps.ValidationSteps.bookingIdWasSavedSuccessfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Generate token for authentication",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.AuthenticationSteps.generateTokenForAuthentication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create update request payload",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.UpdateBookingSteps.createUpdateRequestPayload()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send PUT request",
  "keyword": "When "
});
formatter.match({
  "location": "steps.UpdateBookingSteps.sendPUTRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.ValidationSteps.statusCodeIs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The data in the response body after update is the same as data in the request body",
  "keyword": "And "
});
formatter.match({
  "location": "steps.ValidationSteps.theDataInTheResponseBodyAfterUpdateIsTheSameAsDataInTheRequestBody()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send GET request",
  "keyword": "When "
});
formatter.match({
  "location": "steps.RetrieveBookingSteps.sendGETRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.ValidationSteps.statusCodeIs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The retrieved data in payload is the updated one",
  "keyword": "And "
});
formatter.match({
  "location": "steps.RetrieveBookingSteps.theRetrievedDataInPayloadIsTheUpdatedOne()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send DELETE request",
  "keyword": "When "
});
formatter.match({
  "location": "steps.DeleteBookingSteps.sendDELETERequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.ValidationSteps.statusCodeIs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send GET request",
  "keyword": "When "
});
formatter.match({
  "location": "steps.RetrieveBookingSteps.sendGETRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code is 404",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.ValidationSteps.statusCodeIs(int)"
});
formatter.result({
  "status": "passed"
});
});
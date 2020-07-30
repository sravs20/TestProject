$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature1.feature");
formatter.feature({
  "name": "Test AUT login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Check login behaviour with valid and invalid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "I am on AUT login page",
  "keyword": "Given "
});
formatter.step({
  "name": "I enter \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I hit Login button",
  "keyword": "And "
});
formatter.step({
  "name": "I see successfully login to the application",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ]
    },
    {
      "cells": [
        "test@qa-experience.com",
        "Password1"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Check login behaviour with valid and invalid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "I am on AUT login page",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.MyStepdefs.iAmOnAUTLoginPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter \"test@qa-experience.com\" and \"Password1\"",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdefs.MyStepdefs.iEnterAnd(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I hit Login button",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdefs.MyStepdefs.iHitLoginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see successfully login to the application",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefs.MyStepdefs.iSeeSuccessfullyLoginToTheApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
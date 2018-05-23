<!--
Copyright 2016 Google Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->
<!-- [START base] -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
  <head>
    <title>Hello - Java on Google Cloud Platform</title>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="css/css.css">
  </head>
  <body>
  	<img src="google.png" alt="Google icon" width="100" height="100">
    <h1>Welcome!</h1>	 
    <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Sign in:</td>
      </tr>
      <tr>
      	<td>
	      	<c:choose>
	          <c:when test="${not empty userEmail}">
	          	<!-- using pageContext requires jsp-api artifact in pom.xml -->
	          	<a href="/hello">${fn:escapeXml(userEmail)}</a>
	          </c:when>
	          <c:otherwise>
	          	<a href="/login">Come on in!</a>
	          </c:otherwise>
	        </c:choose>
        </td>
      </tr>
    </table>
  </body>
</html>
<!-- [END base]-->
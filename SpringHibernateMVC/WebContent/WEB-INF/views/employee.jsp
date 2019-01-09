<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Employee Page</title>
	<link href="${pageContext.request.contextPath}/WEB-INF/styles/mystyle.css" rel="stylesheet" />
	<style>
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>

<body>
<h1>
	Add Employee
</h1>

<c:url var="addAction" value="/employees/add" ></c:url>
<form:form action="${addAction}" 
	modelAttribute="employee">
<table border="1">
	<c:if test="${!empty employee.firstName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="Employee ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" 
			size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message text="Employee First Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstName" />
			<form:errors path="firstName" cssClass="errors"></form:errors>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastName">
				<spring:message text="Employee Last Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastName" />
			<form:errors path="lastName" cssClass="errors"></form:errors>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Employee Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
			<form:errors path="email" cssClass="errors"></form:errors>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="salary">
				<spring:message text="Salary"/>
			</form:label>
		</td>
		<td>
			<form:input path="salary" />
			<form:errors path="salary" cssClass="errors"></form:errors>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="mobNo">
				<spring:message text="Mob No"/>
			</form:label>
		</td>
		<td>
			<form:input path="mobNo" />
			<form:errors path="mobNo" cssClass="errors"></form:errors>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		</td>
		<td>
			<form:input path="password" />
			<form:errors path="password" cssClass="errors"></form:errors>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="hiredate">
				<spring:message text="Hire Date"/>
			</form:label>
		</td>
		<td>			
			<form:input path="hiredate"/>		
			<form:errors path="hiredate" cssClass="errors"></form:errors>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.firstName}">
				<input type="submit"
					value="<spring:message 
					text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employee.firstName}">
				<input type="submit"
					value="<spring:message 
					text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Employee List</h3>
<c:if test="${!empty listEmployee}">
	<table class="tg" border="1">
	<tr>
		<th width="80">Person ID</th>
		<th width="120">Person First Name</th>
		<th width="120">Person last Name</th>
		<th width="60">Email</th>
		<th width="60">Salary</th>
		<th width="60">Mobile No:</th>
		<th width="60">Hire Date:</th>
	</tr>
	<c:forEach items="${listEmployee}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.email}</td>
			<td>${employee.salary}</td>
			<td>${employee.mobNo}</td>
			<td>${employee.hiredate}</td>
			<td><a href="
			<c:url value='/edit/${employee.id}' />" >Edit</a></td>
			<td><a href="
			<c:url value='/remove/${employee.id}' />" >Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${empty listEmployee}">
Employee List is empty
</c:if>
</body>
</html>
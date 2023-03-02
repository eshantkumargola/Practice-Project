<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet"/> 
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.css"/>
<title>Add Todo Page</title>
</head>
<body>
	<div class="container">
		<h2>Enter Todo details !</h2>
		<form:form method="POST" modelAttribute="todo">
			
			<fieldset class="mb-3" >
				<form:label  path="description">Description'</form:label>
				<form:input  type="text" path="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/> 			
			</fieldset>
			
			<fieldset class="mb-3" >
			<form:label  path="targetDate">TargetDate</form:label>
        	<form:input  type="date" path="targetDate" required="required"/>
        	<form:errors path="targetDate" cssClass="text-warning"/>			
			</fieldset>
			
			<form:input  type="hidden" path="id" /> <br/>
			<form:input  type="hidden" path="done" /> <br/>
			
			<input type="submit" class="btn btn-success" /><br/>
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.2.1/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
</body>
</html>
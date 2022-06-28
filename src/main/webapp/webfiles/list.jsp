<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Movie JSP</title>
	</head>
	<body>
		<a href="/logout"> Logout </a>
		<h1> Adding New Movie </h1>
		<form action="addmovie" method="get">
			<label>Id</label>
			<br>
			<input type="number" name="id" required />
			<br><br>
			<label>Movie Name</label>
			<br>
			<input type="text" name="name" required />
			<br><br>
			<label>Director Name</label>
			<br>
			<input type="text" name="director" required />
			<br><br>
			<label>Movie Length</label>
			<br>
			<input type="number" name="length" required />
			<br><br>
			<label>Producer Name</label>
			<br>
			<input type="text" name="producer" required />
			<br><br>
			<button type="submit">Add Movie</button>			
		
		
		</form>
		
		<h1> Movie content </h1>
		
		<c:forEach items="${message}" var="temp" >
			<p>
				${temp.getId()}
				<br>
				${temp.getName()}
				<br>
				${temp.getDirector()}
				<br>
				${temp.getLength()}
				<br>
				${temp.getProducer()}
				<hr>
			</p>
		</c:forEach>
		
		<table border="1">
			<thead>
				<tr>
					<th> Id </th>
					<th> Name </th>
					<th> Director </th>
					<th> Duration in hrs </th>
					<th> Producer </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${message}" var="temp" >
					<tr>
						<td>${temp.getId()}</td>
						
						<td>${temp.getName()}</td>
						
						<td>${temp.getDirector()}</td>
						
						<td>${temp.getLength()}</td>
						
						<td>${temp.getProducer()}</td>
						
						<td>
							<a href="delete?id=${temp.getId()}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		
	</body>
</html>
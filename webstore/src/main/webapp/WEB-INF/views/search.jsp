<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Search</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Search for a book</h1>
			</div>
		</div>
	</section>
	<section class="container">
		 <form action="/webstore/books/searchForBooks" method="get">
  <div class="form-group">
    <label for="title">Title:</label>
    <input type="text" class="form-control" id="title" name="title">
  </div>
    <div class="form-group">
    <label for="authors">Authors:</label>
    <input type="text" class="form-control" id="authors" name="authors">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form> 
	</section>
</body>
</html>

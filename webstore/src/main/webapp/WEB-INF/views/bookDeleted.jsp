<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Error 403</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Book deleted</h1>
				<p>The book has been deleted.</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>All books</h3>
						<p>Go back to all books</p>
						<p>
							<a href="/webstore/books/all" class="btn btn-default"> <span
								class="glyphicon glyphicon-arrow-left" /></span> Go Back
							</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>

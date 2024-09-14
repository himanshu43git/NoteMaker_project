<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>

<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>

		<br>

		<h1>PLease fill your note details</h1>
		<br>

		<!--This is add Form  -->

		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> <input type="text"
					class="form-control" id="title" aria-describedby="titleHelp"
					placeholder="Enter here" required name="title">
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>

				<textarea id="content" placeholder="Enter your content here"
					class="form-control" style="height: 300px" required name="content"></textarea>
			</div>

			<div class="text-center container">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>

		</form>
	</div>
</body>
</html>
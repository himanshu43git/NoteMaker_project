<%@page import="com.entities.Note"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note Maker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>

		<h1>Edit Your Note </h1>
		<br>

		<%
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			Session s = FactoryProvider.getFactory().openSession();
			
			Note note = (Note) s.get(Note.class, noteId);
		%>
		
		<form action="UpdateServlet" method="post">
		
		<input value="<%= note.getId()%>" name="noteId" type="hidden"/>
			<div class="form-group">
				<label for="title">Note Title</label> <input type="text"
					class="form-control" id="title" aria-describedby="titleHelp"
					placeholder="Enter here" name="title" value="<%= note.getTitle() %>" required> 
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>

				<textarea id="content" placeholder="Enter your content here"
					class="form-control" style="height: 300px" required name="content" ><%= note.getContent()%></textarea>
			</div>

			<div class="text-center container">
				<button type="submit" class="btn btn-success">Save Your Note</button>
			</div>

		</form>
	</div>
</body>
</html>
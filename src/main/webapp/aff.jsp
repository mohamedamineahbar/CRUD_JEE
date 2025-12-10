<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Livre" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Livre l = (Livre) request.getAttribute("livre");
	%>
	<%
		if(l==null){
			response.sendRedirect("/index.jsp");
		}
	%>
	<h1>le titre est : <%=l.getTitle() %></h1>
	<h1>le prix est : <%=l.getPrix() %></h1>
	<h1>le qte est : <%=l.getQte() %></h1>
</body>
</html>
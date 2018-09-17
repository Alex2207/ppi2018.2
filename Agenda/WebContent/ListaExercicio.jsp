<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<table border="1">
	
	<h1>Lista de contatos:</h1>
	
	<thead>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereco</th>
			<th>Data de nascimento</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="contato" items="${Contatos}">
		<tr>
			<td>${contato.nome }</td>
			<td>
				<c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if>
				
				<c:if test="${empty contato.email}">
					Email não informado. Tente novamente:
				</c:if>
			</td>
			<td>${contato.endereco }</td>
			<td>${contato.dataNascimento.time }</td>
		</tr>
		</c:forEach>
	</tbody>
	
	<c:choose>
		<c:when test="${not empty contato.email}">
			<a href="mailto:${contato.email}">${contato.email}</a>
		</c:when>
		<c:otherwise>
			Email não informado. Tente novamente:
		</c:otherwise>
	</c:choose>
	
	</table>
</body>
</html>
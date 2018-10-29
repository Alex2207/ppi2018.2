<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<table border="1">
	
	<thead>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereco</th>
			<th>Data de nascimento</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach var ="contato" items="${contatos }">
		<tr>
			<td>${contato.nome }</td>
			<td>${contato.email }</td>
			<td>${contato.endereco }</td>
			<td><fmt:formatDate value="${contato.dataNascimento.time }" pattern="dd/MM/yyyy" /></td>
			<td><a href="/agendaspring/contatos/remover?id=${contao.id }">Remover</a></td>
		</tr>
	</c:forEach>
	</tbody>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<td><a href="/agendaspring/contatos/remover?id=${contato.id }">Remover</a></td>
		</tr>
	</c:forEach>
	</tbody>
</body>
</html>
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
	
	<h1>Alterar contato</h1>
	<form action="/agendaspring/contatos/alterar" method=post>
	
		<div>
			<input  type="hidden" name="id" value="${contato.id }">
		</div>
		
		<div>
			<label>Nome:</label>>
			<input type="text" name="nome" value="${contato.nome }">
		</div>
		
		<div>
			<label>Email:</label>>
			<input type="text" name="email" value="${contato.email }">
		</div>
		
		<div>
			<label>Endereco:</label>>
			<input type="text" name="endereco" value="${contato.endereco }">
		</div>
		
		<div>
			<label>Data de nascimento:</label>>
			<input type="text" name="dataNascimento" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${contato.dataNascimento.time }"/>'>
		</div>
		
		<div>
			<button type="submit">Alterar</button>
		</div>
	</form>

</body>
</html>
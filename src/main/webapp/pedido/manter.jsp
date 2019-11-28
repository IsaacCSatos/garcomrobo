<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
	<head>
		<title>Gerenciador de Pedido</Title>
		<meta charset="UTF-8">
		<meta name= "viewport" content="width=device-width,initial-scale=1.0">
	</head>
	<body>
		<table>
			<c:if test="${pedido.idPedido != 0 }">
			
					<form action="altera" method="post">
					<h1>Alterar Pedido</h1>
						<tr>
							<td>Id:</td> 
							<td>${pedido.idPedido}</td>
						</tr>
					
					<input type="hidden" name="id" value="<c:out value='${pedido.idPedido}' />" >
				
			</c:if>
	
			<c:if test="${pedido.idPedido == 0}">
				<h1>Cadastro</h1>
				<form action="adiciona" method="post">
			</c:if>		
			
			<tr>
				<td>Valor Total:</th>
				<td><input type="text" name="valorTotal" /></td>
			</tr>
			
			<tr>
				<td>Status:</td>
				<td><input type="text" name="status" /></td>
			</tr>
			
			<tr>
				<td>Mesa:</td>
				<td><input type="text" name="idMesa" /></td>
			</tr>
		
			<td><button type="submit">Gravar</button></td>
		</from>
	</body>
</html>
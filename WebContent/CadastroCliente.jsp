<%@page import="br.com.projetofinal.model.Cliente" %>
<%@page import="br.com.projetofinal.db.ClienteDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Clientes</title>
<link href="bootstrap/css/bootstrap.css" rel="styleSheet">
</head>
<body>
<h1>Cadastro de Clientes</h1>

<form action="ControllerCliente" method="post">
<div class="col-sm-3">
	<div class="form-group">
	<% if(request.getAttribute("msg") != null){%>
	<div class="alert alert-primary" role="alert">
 		<%= request.getAttribute("msg") %>
	</div>
<%} %>
			<label>Nome:</label>
			<input type="text" id="nome" class="form-control" name="nome"/><br>
	</div>
	<div class="form-group">
		<label>Telefone:</label>
		<input type="text" id="telefone" class="form-control" name="telefone"/><br>
	</div>
	<div class="col-sm-6">
	<div class="form-group">
	    <label>CPF:</label>
    	<input type="text" id="cpf" class="form-control" name=cpf/><br>
    	<input type="submit" class="btn btn-primary" value="Cadastrar"/><br>
    	<br>

	<div class="col-sm-3">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nome</th>
      <th scope="col">Telefone</th>
      <th scope="col">CPF</th>


    </tr>
  </thead>
  <tbody>
    <% for(Cliente cliente : new ClienteDB().all() ){%>
	  
	   <tr>
	   	<td><%= cliente.getId() %></td>
	   	<td><%= cliente.getNome() %></td>
	   	<td><%= cliente.getTelefone() %></td>
	   	<td><%= cliente.getCpf() %></td>	   	
	  </tr>
	  
 <% }%> 
  </tbody>
</table>
</div>
	</div>
	<a href="Home.jsp">Voltar</a>
	
</div>
</form>
</body>
</html>
<%@page import="br.com.projetofinal.model.Locacao" %>
<%@page import="br.com.projetofinal.db.LocacaoDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Locação</title>
<link href="bootstrap/css/bootstrap.css" rel="styleSheet">
</head>
<body>
<h1>Cadastro de Locação</h1>

<form action="ControllerLocacao" method="post">
<div class="col-sm-3">
	<div class="form-group">
	<% if(request.getAttribute("msg") != null){%>
	<div class="alert alert-primary" role="alert">
 		<%= request.getAttribute("msg") %>
	</div>
<%} %>
			<label>Valor:</label>
			<input type="text" id="nome" class="form-control" name="valor"/><br>
	</div>
	<div class="form-group">
		<label>Data de Locação:</label>
		<input type="text" id="datalocacao" class="form-control" name="datalocacao"/><br>
	</div>
	<div class="col-sm-6">
	<div class="form-group">
	    <label>Data de Devolução:</label>
    	<input type="text" id="cpf" class="form-control" name=datadevolucao/><br>

	<div class="col-sm-3">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Valor</th>
      <th scope="col">Data de Locação</th>
      <th scope="col">Data de Devolução</th>
    </tr>
  </thead>
  <tbody>
    <% for(Locacao locacao : new LocacaoDB().all() ){%>
	  
	   <tr>
	   	<td><%= locacao.getIdlocacao() %></td>
	   	<td><%= locacao.getValor() %></td>
	   	<td><%= locacao.getDatalocacao() %></td>
	   	<td><%= locacao.getDatadevolucao() %></td>	   	
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
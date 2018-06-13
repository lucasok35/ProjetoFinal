<%@ page import="br.com.projetofinal.model.Sessao" %>
<%@ page import="br.com.projetofinal.db.SessaoDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Sessao</title>
<link href="bootstrap/css/bootstrap.css" rel="styleSheet">
</head>
<body>
<h1>Cadastro de Sessao</h1>
<form action="ControllerAcervo" method="post">
<div class="col-sm-3">
	<div class="form-group">
	<% if(request.getAttribute("msg") != null){%>
	<div class="alert alert-primary" role="alert">
 		<%= request.getAttribute("msg") %>
	</div>
<%} %>
			<label>Descricao::</label>
			<input type="text" id="descricao" class="form-control" name="descricao"/><br>
	</div>
	<div class="form-group">
		<label>Localizacao::</label>
		<input type="text" id="genero" class="form-control" name="localizacao"/><br>
	</div>
	<div class="col-sm-6">
	<div class="form-group">


	<div class="col-sm-3">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Descricao</th>
      <th scope="col">Localizacao</th>
    </tr>
  </thead>
  <tbody>
    <% for(Sessao  sessao : new SessaoDB().all() ){%>
	  
	   <tr>
	   	<td><%= sessao.getDescricao() %></td>
	   	<td><%= sessao.getLocalizacao() %></td>
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
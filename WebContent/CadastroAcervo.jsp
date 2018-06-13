<%@ page import="br.com.projetofinal.model.Acervo" %>
<%@ page import="br.com.projetofinal.db.AcervoDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Acervo</title>
<link href="bootstrap/css/bootstrap.css" rel="styleSheet">
</head>
<body>
<h1>Cadastro de Acervo</h1>
<form action="ControllerAcervo" method="post">
<div class="col-sm-3">
	<div class="form-group">
	<% if(request.getAttribute("msg") != null){%>
	<div class="alert alert-primary" role="alert">
 		<%= request.getAttribute("msg") %>
	</div>
<%} %>
			<label>Titulo:</label>
			<input type="text" id="titulo" class="form-control" name="titulo"/><br>
	</div>
	<div class="form-group">
		<label>Genero::</label>
		<input type="text" id="genero" class="form-control" name="genero"/><br>
	</div>
	<div class="col-sm-6">
	<div class="form-group">
	    <label>Quantidade em Estoque::</label>
    	<input type="text" id="qtdestoque" class="form-control" name=qtdestoque/><br>

	<div class="col-sm-3">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Titulo</th>
      <th scope="col">Genero</th>
      <th scope="col">Quantidade em Estoque</th>
    </tr>
  </thead>
  <tbody>
    <% for(Acervo  acervo : new AcervoDB().all() ){%>
	  
	   <tr>
	   	<td><%= acervo.getTitulo() %></td>
	   	<td><%= acervo.getGenero() %></td>
	   	<td><%= acervo.getQtdestoque() %></td>
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
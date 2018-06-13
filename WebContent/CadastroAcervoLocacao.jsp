<%@page import="br.com.projetofinal.model.AcervoLocacao" %>
<%@page import="br.com.projetofinal.db.AcervoLocacaoDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Baixa de Devolucao</title>
<link href="bootstrap/css/bootstrap.css" rel="styleSheet">
</head>
<body>
<h1>Baixa de Devolucao</h1>
<form action="ControllerAcervo" method="post">
<div class="col-sm-3">
	<div class="form-group">
	<% if(request.getAttribute("msg") != null){%>
	<div class="alert alert-primary" role="alert">
 		<%= request.getAttribute("msg") %>
	</div>
<%} %>
			<label>ID Acervo</label>
			<input type="text" id="idac" class="form-control" name="idac"/><br>
	</div>
	<div class="col-sm-6">
	<div class="form-group">
	
				<label>ID Acervo</label>
				<input type="text" id="idac" class="form-control" name="idac"/><br>
	</div>
	<div class="col-sm-6">
	<div class="form-group">


	<div class="col-sm-3">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID Locacao</th>
      <th scope="col">ID Acervo</th>
    </tr>
  </thead>
  <tbody>
    <% for(AcervoLocacao  acloc : new AcervoLocacaoDB().all() ){%>
	  
	   <tr>
	   	<td><%= acloc.getIdloc() %></td>
	   	<td><%= acloc.getIdac() %></td>
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
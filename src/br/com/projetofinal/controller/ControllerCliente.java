package br.com.projetofinal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetofinal.db.ClienteDB;
import br.com.projetofinal.model.Cliente;


@WebServlet("/ControllerCliente")
public class ControllerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerCliente() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String cpf =request.getParameter("cpf");
		
		
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setTelefone(telefone);
		c.setCpf(cpf);
		
		
		if(new ClienteDB().insert(c)) {
			request.setAttribute("msg", "Registro inserido com sucesso!");
			request.getRequestDispatcher("CadastroCliente.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "Erro ao inserir registro!");
			request.getRequestDispatcher("CadastroCliente.jsp").forward(request, response);
		}
		
	}

}

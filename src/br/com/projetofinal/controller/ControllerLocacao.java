package br.com.projetofinal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetofinal.db.ClienteDB;
import br.com.projetofinal.db.LocacaoDB;
import br.com.projetofinal.model.Cliente;
import br.com.projetofinal.model.Locacao;


@WebServlet("/ControllerLocacao")
public class ControllerLocacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerLocacao() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Double valor = Double.parseDouble(request.getParameter("nome"));
		String datalocacao =request.getParameter("datalocacao");
		String datadevolucao = request.getParameter("datadevolucao");
		
		Locacao l = new Locacao();
		l.setValor(valor);
		l.setDatalocacao(datalocacao);
		l.setDatadevolucao(datadevolucao);
		
		if(new LocacaoDB().insert(l)) {
			request.setAttribute("msg", "Registro inserido com sucesso!");
			request.getRequestDispatcher("Locacao.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "Erro ao inserir registro!");
			request.getRequestDispatcher("Locacao.jsp").forward(request, response);
		}
	}

}

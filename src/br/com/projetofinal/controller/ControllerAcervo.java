package br.com.projetofinal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetofinal.model.Acervo;
import br.com.projetofinal.db.AcervoDB;




@WebServlet("/ControllerAcervo")
public class ControllerAcervo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControllerAcervo() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		int qtdestoque = Integer.parseInt("qtdestoque");
		
		Acervo a = new Acervo();
		a.setTitulo(titulo);
		a.setGenero(genero);
		a.setQtdestoque(qtdestoque);
		
		if(new AcervoDB().insert(a)) {
			request.setAttribute("msg", "Registro inserido com sucesso!");
			request.getRequestDispatcher("CadastroAluno.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "Erro ao inserir registro!");
			request.getRequestDispatcher("CadastroAluno.jsp").forward(request, response);
		}
	}

}

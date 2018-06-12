package br.com.projetofinal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetofinal.db.AcervoLocacaoDB;
import br.com.projetofinal.db.SessaoDB;
import br.com.projetofinal.model.AcervoLocacao;
import br.com.projetofinal.model.Sessao;


@WebServlet("/ControllerAcervoLocacao")
public class ControllerAcervoLocacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControllerAcervoLocacao() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idloc = Integer.parseInt(request.getParameter("idloc"));
		int idac = Integer.parseInt(request.getParameter("idac"));
		
		
		AcervoLocacao acloc = new AcervoLocacao();
		acloc.setIdloc(idloc);
		acloc.setIdac(idac);
		
		
		if(new AcervoLocacaoDB().insert(acloc)) {
			request.setAttribute("msg", "Registro inserido com sucesso!");
			request.getRequestDispatcher("AcervoLocacaojsp").forward(request, response);
		}else {
			request.setAttribute("msg", "Erro ao inserir registro!");
			request.getRequestDispatcher("AcervoLocacao.jsp").forward(request, response);
		}

	}

}

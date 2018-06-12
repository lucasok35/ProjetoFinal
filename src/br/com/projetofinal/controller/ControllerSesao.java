package br.com.projetofinal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.projetofinal.db.SessaoDB;
import br.com.projetofinal.model.Sessao;


@WebServlet("/ControllerSesao")
public class ControllerSesao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControllerSesao() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descricao = request.getParameter("descricao");
		String localizacao = request.getParameter("localizacao");
		
		
		Sessao s = new Sessao();
		s.setDescricao(descricao);
		s.setLocalizacao(localizacao);
		
		
		if(new SessaoDB().insert(s)) {
			request.setAttribute("msg", "Registro inserido com sucesso!");
			request.getRequestDispatcher("CadastroSessao.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "Erro ao inserir registro!");
			request.getRequestDispatcher("CadastroSessao.jsp").forward(request, response);
		}
	}

}

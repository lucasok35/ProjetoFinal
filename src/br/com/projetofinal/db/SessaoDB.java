package br.com.projetofinal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.model.Locacao;
import br.com.projetofinal.model.Sessao;
import br.com.projetofinal.util.ConnectionFactory;

public class SessaoDB {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public SessaoDB() {
		
		con = ConnectionFactory.getConnection();
	}
	
	public boolean insert(Sessao sessao) {	
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("insert into TB_SESSAO (localizacao, descricao)");
			sb.append("values (?, ?)");
			
			ps = this.con.prepareStatement(sb.toString());
			
			ps.setString(1, sessao.getLocalizacao());
			ps.setString(2, sessao.getDescricao());
			
			ps.execute();
			
			return true;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Sessao> all(){
		
		List<Sessao> lstSessao = new ArrayList<>();
			
		String sql = "SELECT idsessao, localizacao, descricao FROM TB_SESSAO";
		
		try {
			ps = this.con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Sessao sessao = new Sessao();				
				sessao.setIdsessao(rs.getInt("idsessao"));
				sessao.setLocalizacao(rs.getString("localizacao"));
				sessao.setDescricao(rs.getString("descricao"));
							
				
				
				lstSessao.add(sessao);
			}
			
		} catch (SQLException e) {
				//
			e.printStackTrace();
		}
		
		return lstSessao;
	}
	
	public boolean alterar(Sessao sessao) throws SQLException {

		try {

			PreparedStatement stmt = this.con
					.prepareStatement("UPDATE BDBIBLIOTECA SET localizacao = ?, descricao = ?  WHERE idsessao = ?");

			stmt.setString(1, sessao.getLocalizacao());
			stmt.setString(2, sessao.getDescricao());
            
            
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			con.close();

		}
		return false;
	}
	
	public boolean excluir(int idsessao) throws SQLException {

		try {

			PreparedStatement stmt = this.con
					.prepareStatement("DELETE FROM BDBIBLIOTECA WHERE IDSESSAO =?");

			stmt.setInt(1, idsessao);

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			con.close();

		}
		return false;
	}
}

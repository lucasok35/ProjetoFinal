package br.com.projetofinal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.model.Locacao;
import br.com.projetofinal.util.ConnectionFactory;

public class LocacaoDB {
	
	Connection con;	
	PreparedStatement ps;
	ResultSet rs;
	public LocacaoDB() {
		
		con = ConnectionFactory.getConnection();			
	}
	
	public boolean insert(Locacao locacao) {	
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("insert into TB_LOCACAO (valor, datalocacao, datadevolucao)");
			sb.append("values (?, ?, ?, ?)");
			
			ps = this.con.prepareStatement(sb.toString());
			
			ps.setDouble(1, locacao.getValor());
			ps.setString(2, locacao.getDatalocacao());
			ps.setString(3, locacao.getDatadevolucao());
			
			ps.execute();
			
			return true;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Locacao> all(){
		
		List<Locacao> lstLocacao = new ArrayList<>();
			
		String sql = "SELECT idlocacao, valor, datalocacao, datadevolucao FROM TB_LOCACAO";
		
		try {
			ps = this.con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Locacao locacao = new Locacao();				
				locacao.setIdlocacao(rs.getInt("idlocacao"));
				locacao.setValor(rs.getDouble("valor"));
				locacao.setDatalocacao(rs.getString("datalocacao"));
				locacao.setDatadevolucao(rs.getString("datadevolucao"));				
				
				
				lstLocacao.add(locacao);
			}
			
		} catch (SQLException e) {
				//
			e.printStackTrace();
		}
		
		return lstLocacao;
	}
	
	public boolean alterar(Locacao locacao) throws SQLException {

		try {

			PreparedStatement stmt = this.con
					.prepareStatement("UPDATE BDBIBLIOTECA SET valor = ?, datalocacao = ?, datadevolucao = ?  WHERE idlocacao = ?");

			stmt.setDouble(1, locacao.getValor());
			stmt.setString(2, locacao.getDatalocacao());
            stmt.setString(3, locacao.getDatadevolucao());
            
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			con.close();

		}
		return false;
	}
	
	public boolean excluir(int idlocacao) throws SQLException {

		try {

			PreparedStatement stmt = this.con
					.prepareStatement("DELETE FROM BDBIBLIOTECA WHERE IDLOCACAO =?");

			stmt.setInt(1, idlocacao);

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

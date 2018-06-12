package br.com.projetofinal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.model.AcervoLocacao;
import br.com.projetofinal.util.ConnectionFactory;

public class AcervoLocacaoDB {
	Connection con;	
	PreparedStatement ps;
	ResultSet rs;
	public AcervoLocacaoDB() {
		
		con = ConnectionFactory.getConnection();			
	}
	
	public boolean insert(AcervoLocacao acervolocacao) {	
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("insert into TB_ACERVOLOCACAO (idloc, idac)");
			sb.append("values (?, ?)");
			
			ps = this.con.prepareStatement(sb.toString());
			
			ps.setInt(1, acervolocacao.getIdloc());
			ps.setInt(2, acervolocacao.getIdac());
						
			ps.execute();
			
			return true;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<AcervoLocacao> all(){
		
		List<AcervoLocacao> lstAcervoLocacao = new ArrayList<>();
			
		String sql = "SELECT idloc, idac FROM TB_ACERVOLOCACAO";
		
		try {
			ps = this.con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				AcervoLocacao acervolocacao = new AcervoLocacao();				
				acervolocacao.setIdloc(rs.getInt("idloc"));
				acervolocacao.setIdac(rs.getInt("idac"));
	
				
				
				lstAcervoLocacao.add(acervolocacao);
			}
			
		} catch (SQLException e) {
				//
			e.printStackTrace();
		}
		
		return lstAcervoLocacao;
	}
	
	public boolean alterar(AcervoLocacao acervolocacao) throws SQLException {

		try {

			PreparedStatement stmt = this.con
					.prepareStatement("UPDATE BDBIBLIOTECA SET idloc = ? WHERE idac = ?");

			stmt.setDouble(1, acervolocacao.getIdloc());

            
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			con.close();

		}
		return false;
	}
	
	public boolean excluir(int idac) throws SQLException {

		try {

			PreparedStatement stmt = this.con
					.prepareStatement("DELETE FROM BDBIBLIOTECA WHERE IDAC =?");

			stmt.setInt(1, idac);

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

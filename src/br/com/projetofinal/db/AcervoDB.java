package br.com.projetofinal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.projetofinal.model.Acervo;
import br.com.projetofinal.util.ConnectionFactory;

public class AcervoDB {
	
	Connection con;	
	PreparedStatement ps;
	ResultSet rs;
	public AcervoDB() {
		
		con = ConnectionFactory.getConnection();			
	}
	
	public boolean insert(Acervo acervo) {	
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("insert into TB_ACERVO (titulo, genero, qtdestoque)");
			sb.append("values (?, ?, ?)");
			
			ps = this.con.prepareStatement(sb.toString());
			
			ps.setString(1, acervo.getTitulo());
			ps.setString(2, acervo.getGenero());
			ps.setInt(3, acervo.getQtdestoque());
			
			ps.execute();
			
			return true;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Acervo> all(){
		
		List<Acervo> lstAcervo = new ArrayList<>();
			
		String sql = "SELECT idacervo, titulo, genero, qtdestoque FROM TB_ACERVO";
		
		try {
			ps = this.con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Acervo acervo = new Acervo();				
				acervo.setIdacervo(rs.getInt("idlocacao"));
				acervo.setTitulo(rs.getString("titulo"));
				acervo.setGenero(rs.getString("genero"));
				acervo.setQtdestoque(rs.getInt("qtdestoque"));				
				
				
				lstAcervo.add(acervo);
			}
			
		} catch (SQLException e) {
				//
			e.printStackTrace();
		}
		
		return lstAcervo;
	}
	
	public boolean alterar(Acervo acervo) throws SQLException {

		try {

			PreparedStatement stmt = this.con
					.prepareStatement("UPDATE BDBIBLIOTECA SET titulo = ?, genero = ?, qtdestoque = ?  WHERE idacervo = ?");

			stmt.setString(1, acervo.getTitulo());
			stmt.setString(2, acervo.getGenero());
            stmt.setInt(3, acervo.getQtdestoque());
            
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			con.close();

		}
		return false;
	}
	
	public boolean excluir(int idacervo) throws SQLException {

		try {

			PreparedStatement stmt = this.con
					.prepareStatement("DELETE FROM BDBIBLIOTECA WHERE IDACERVO =?");

			stmt.setInt(1, idacervo);

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

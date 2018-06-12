package br.com.projetofinal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.projetofinal.model.Cliente;
import br.com.projetofinal.util.ConnectionFactory;

public class ClienteDB {
	
		Connection con;	
		PreparedStatement ps;
		ResultSet rs;
		public ClienteDB() {
			
			con = ConnectionFactory.getConnection();			
		}
		
		public boolean insert(Cliente cliente) {	
			
			try {
				
				StringBuilder sb = new StringBuilder();
				sb.append("insert into TB_CLIENTE (nome, cpf, telefone)");
				sb.append("values (?, ?, ?)");
				
				ps = this.con.prepareStatement(sb.toString());
				
				ps.setString(1, cliente.getNome());
				ps.setInt(2, cliente.getCpf());
				ps.setString(3, cliente.getTelefone());
				
				ps.execute();
				
				return true;
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return false;
		}
		
		public List<Cliente> all(){
			
			List<Cliente> lstCliente = new ArrayList<>();
				
			String sql = "SELECT id, nome, cpf, telefone FROM TB_CLIENTE";
			
			try {
				ps = this.con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					
					Cliente cliente = new Cliente();
					
					cliente.setId(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getInt("cpf"));
					cliente.setTelefone(rs.getString("telefone"));				
					
					
					lstCliente.add(cliente);
				}
				
			} catch (SQLException e) {
					//
				e.printStackTrace();
			}
			
			return lstCliente;
		}
		
}

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
				sb.append("insert into tb_cliente (nome, telefone, cpf)");
				sb.append("values (?, ?, ?)");
				
				ps = this.con.prepareStatement(sb.toString());
				
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getTelefone());
				ps.setString(3, cliente.getCpf());
				
				
				ps.execute();
				
				return true;
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return false;
		}
		
		public List<Cliente> all(){
			
			List<Cliente> lstCliente = new ArrayList<>();
				
			String sql = "SELECT id, nome, telefone, cpf FROM tb_cliente";
			
			try {
				ps = this.con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					
					Cliente cliente = new Cliente();
					
					cliente.setId(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setTelefone(rs.getString("telefone"));				
					cliente.setCpf(rs.getString("cpf"));
					
					lstCliente.add(cliente);
				}
				
			} catch (SQLException e) {
					//
				e.printStackTrace();
			}
			
			return lstCliente;
		}
		
}

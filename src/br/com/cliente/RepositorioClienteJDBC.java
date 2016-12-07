package br.com.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioClienteJDBC implements IRepositorioCliente{
	
	public RepositorioClienteJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void cadastrar(Cliente cliente) {
		String sql = "insert into cliente (id, nome, cpf) values (?,?,?)";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, cliente.getId());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getCpf());
			
			ps.execute();
			con.close();
			ps.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		String sql = "update cliente set Nome = ?, cpf = ? where Id = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setInt(3, cliente.getId());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
			} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Cliente procurar(Integer id) {
		String sql = "select * from cliente where Id = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public boolean remover(Integer id) {
		String sql = "delete from cliente where Id = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean existe(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> lista = new ArrayList<>();
		
		String sql = "select * from cliente";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				lista.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
			ps.close();
			con.close();
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}

}

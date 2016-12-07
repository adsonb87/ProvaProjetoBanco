package br.com.cliente;

import java.util.ArrayList;

public class ControladorCliente {
	
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente() {
		repositorioCliente = new RepositorioClienteJDBC();
	}
	
	public void cadastrarCliente(Cliente cliente){
		repositorioCliente.cadastrar(cliente);
	}
	
	public void atualizarCliente(Cliente cliente){
		repositorioCliente.atualizar(cliente);
	}
	
	public Cliente procurarCliente(Integer id){
		return repositorioCliente.procurar(id);
	}
	
	public boolean removerCliente(Integer id){
		return repositorioCliente.remover(id);
	}
	
	public ArrayList<Cliente> listarCliente(){
		return repositorioCliente.listar();
	}
}

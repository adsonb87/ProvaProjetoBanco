package br.com.fachada;

import java.util.ArrayList;

import br.com.cliente.Cliente;
import br.com.cliente.ControladorCliente;

public class Fachada {
	
	private ControladorCliente controladorCliente;
	
	private static Fachada fachada;
	
	public Fachada(){
		controladorCliente = new ControladorCliente();
	}
	
	public static Fachada getInstance(){
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	public void cadastrarCliente(Cliente cliente){
		controladorCliente.cadastrarCliente(cliente);
	}
	
	public void atualizarCliente(Cliente cliente){
		controladorCliente.atualizarCliente(cliente);
	}
	
	public Cliente procurarCliente(Integer id){
		return controladorCliente.procurarCliente(id);
	}
	
	public boolean removerCliente(Integer id){
		return controladorCliente.removerCliente(id);
	}
	
	public ArrayList<Cliente> listarCliente(){
		return controladorCliente.listarCliente();
	}
}

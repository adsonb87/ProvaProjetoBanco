package br.com.cliente;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RepositorioClienteArray implements IRepositorioCliente{
	
	public ArrayList<Cliente> listaCliente;
	
	public RepositorioClienteArray() {
		listaCliente = new ArrayList<Cliente>();
	}

	@Override
	public void cadastrar(Cliente cliente) {
		if(!existe(cliente.getId())){
			listaCliente.add(cliente);
		}
	}

	@Override
	public void atualizar(Cliente cliente) {
		if(existe(cliente.getId())){
			for(int i=0; i< listaCliente.size(); i++){
				if(listaCliente.get(i).getId() == cliente.getId()){
					listaCliente.set(i, cliente);
				}
			}
		}		
	}

	@Override
	public Cliente procurar(Integer id) {
		for(int i=0; i<listaCliente.size(); i++){
			if(listaCliente.get(i).getId() == id){
				return listaCliente.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean remover(Integer id) {
		if(existe(id)){
			Cliente cliente = procurar(id);
			listaCliente.remove(cliente);
			return true;
		}
		return false;
	}

	@Override
	public boolean existe(Integer id) {
		if(id == null){
			return false;			
		}else{			
			for(int i=0; i<listaCliente.size(); i++){
				if(listaCliente.get(i).getId() == id){
					return true;
				}
			}
			
			return false;
		}
	}

	@Override
	public ArrayList<Cliente> listar() {
		return listaCliente;
	}
	
	
}

package br.com.cliente;

import java.util.ArrayList;

public interface IRepositorioCliente {
	public void cadastrar(Cliente cliente);
	public void atualizar(Cliente cliente);
	public Cliente procurar (Integer id);
	public boolean remover(Integer id);
	public boolean existe(Integer id);
	public ArrayList<Cliente> listar();
}

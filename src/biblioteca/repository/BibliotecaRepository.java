package biblioteca.repository;

import biblioteca.model.Conta;

public interface BibliotecaRepository {

	// CRUD da conta
	public void procurarPorUsuario(int numero);
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	//Métodos 
	public void cadastrarLivros(int numero, int tipo);
	public void emprestar(int numero, int tipo);
	public void buscarLivros(String List);
}

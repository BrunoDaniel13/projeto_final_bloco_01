package biblioteca.repository;

import biblioteca.model.Conta;
import biblioteca.model.Livros;

public interface BibliotecaRepository {

	// CRUD da conta
	public void procurarPorUsuario(int numero);
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	//Métodos 
	public void cadastrarLivro(int usuario, Livros livro);
	public void emprestarLivro(int usuario, Livros livro);
	public void buscarLivros();
}
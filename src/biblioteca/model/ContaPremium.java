package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class ContaPremium extends Conta{

	private List<Livros> livrosCadastrados;
	
	public ContaPremium(int usuario, String nome, String email, String telefone, int tipo){
		super(usuario, nome, email, telefone, 1);
		this.livrosCadastrados = new ArrayList<>();
	}
	
	 public void cadastrarLivro(Livros livro) {
	           livrosCadastrados.add(livro);
	           System.out.println("Livro Cadastrado com sucesso: " +livro.getTitulo());
	 }
	
	 @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Livros Cadastrados (" + livrosCadastrados.size() + "):");
        livrosCadastrados.forEach(livro -> livro.visualizar());
    }
}
package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class ContaNormal extends Conta{
	
	
	private List<Livros> livrosEmprestados; 
	
	public ContaNormal(int usuario, String nome, String email, String telefone, int tipo) {
		super(usuario, nome, email, telefone, tipo);
		this.livrosEmprestados = new ArrayList<>();
	}

	public void emprestarLivro(Livros livro) {
        if (livrosEmprestados.size() < 3) {  
            livrosEmprestados.add(livro);
            System.out.println("Livro '" + livro.getTitulo() + "' emprestado com sucesso!");
        } else {
            System.out.println("Você já tem o limite de 3 livros emprestados. Não é possível emprestar mais.");
        }
    }
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Livros Emprestados (" + livrosEmprestados.size() + "):");
        livrosEmprestados.forEach(livro -> livro.visualizar());
    }
}
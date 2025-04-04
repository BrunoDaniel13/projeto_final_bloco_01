package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class ContaNormal extends Conta{
	
	private boolean basica;
	private List<Livros> livrosEmprestados; 
	
	public ContaNormal(int usuario, String nome, String email, String telefone, int tipo, boolean basica) {
		super(usuario, nome, email, telefone, tipo);
		this.basica = basica;
		this.livrosEmprestados = new ArrayList<>();
	}

	public boolean isBasica() {
		return basica;
	}

	public void setBasica(boolean basica) {
		this.basica = basica;
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
		System.out.println("Conta Básica: " + this.basica);
        System.out.println("Livros emprestados: ");
        for (Livros livro : livrosEmprestados) {
            System.out.println(livro.getTitulo());
	}

}
}

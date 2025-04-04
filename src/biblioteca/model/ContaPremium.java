package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class ContaPremium extends Conta{

	private boolean premium;
	private List<Livros> livrosCadastrados;
	
	public ContaPremium(int usuario, String nome, String email, String telefone, int tipo, boolean premium, String List){
		super(usuario, nome, email, telefone, 1);
		this.premium = true;
		this.livrosCadastrados = new ArrayList<>();
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	
	 public void cadastrarLivro(Livros livro) {
	        if ( getTipo() == 1) {
	           livrosCadastrados.add(livro);
	           System.out.println("Livro Cadastrado com sucesso: " +livro.getTitulo());
	        } else {
	            System.out.println("A funcionalidade não está disponível para este tipo de conta!" );
	        }
	    }
	
	 @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Conta Premium: "+this.premium);
		System.out.println("Livros Cadastrados: ");
        for (Livros livro : livrosCadastrados) {
            System.out.println(livro.getTitulo());

        	}
	 }
}

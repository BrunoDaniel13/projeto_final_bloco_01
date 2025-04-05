package biblioteca.controller;

import java.util.ArrayList;
import biblioteca.model.Conta;
import biblioteca.model.ContaNormal;
import biblioteca.model.ContaPremium;
import biblioteca.model.Livros;
import biblioteca.repository.BibliotecaRepository;


public class BibliotecaController implements BibliotecaRepository {
	
	private ArrayList<Conta>listaContas = new ArrayList<Conta>();
	private ArrayList<Livros> listaLivros = new ArrayList<>();
	int usuario = 0;

	@Override
	public void procurarPorUsuario(int numero) {
			var conta = buscarNaCollection(numero);
		
			if(conta != null)
				conta.visualizar();
			else
			System.out.println("\nA conta número: "+numero+ " não foi encontrada!");
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número: " +conta.getUsuario() + ", foi criada com sucesso!");	
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getUsuario());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta),conta);
			System.out.println("\nA conta número: "+conta.getUsuario()+ " foi atualizada com sucesso!");
		}else
			System.out.println("\nA conta número "+conta.getUsuario()+ " não foi encontrada.");
		
	}
		

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(usuario);
		
		if(conta != null) {
			if(listaContas.remove(conta)==true)
				System.out.println("\nA conta número: "+usuario+ " foi deletada com sucesso!");
		}else
			System.out.println("\nA conta número "+usuario+ " não foi encontrada.");
		
	}

	@Override
	public void cadastrarLivro(int usuario, Livros livro) {
		Conta conta = buscarNaCollection(usuario);
        if (conta != null && conta.getTipo() == 1) {
            ((ContaPremium) conta).cadastrarLivro(livro);
            listaLivros.add(livro);
        } else {
            System.out.println("Apenas contas Premium podem cadastrar livros!");
        }
    }
       

	@Override
	public void emprestarLivro(int usuario, Livros livro) {
		 Conta conta = buscarNaCollection(usuario);
	        if (conta != null && conta.getTipo() == 2) {
	            ((ContaNormal) conta).emprestarLivro(livro);
	        } else {
	            System.out.println("Apenas contas Normais podem pegar livros emprestados!");
	        }
	    }

	@Override
	public void buscarLivros() {
		System.out.println("\nLivros Disponíveis:");
        listaLivros.forEach(Livros::visualizar);
		
	}
	
	
	public int gerarNumero() {
		return ++ usuario;
	}
	
	public Conta buscarNaCollection(int usuario) {
		for(var conta: listaContas) {
			if(conta.getUsuario()==usuario) {
				return conta;
			}
		}
		
		return null;
	}
	

}
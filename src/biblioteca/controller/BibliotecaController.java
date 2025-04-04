package biblioteca.controller;

import java.util.ArrayList;
import biblioteca.model.Conta;
import biblioteca.model.Livros;
import biblioteca.repository.BibliotecaRepository;


public class BibliotecaController implements BibliotecaRepository {
	
	private ArrayList<Conta>listaContas = new ArrayList<Conta>();
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

	
	public void cadastrarLivros(String titulo,  String autor, String editora) {
		var conta = buscarNaCollection(usuario);
		
		if(conta != null) {
			if(conta.getTipo()== 1)
				System.out.println("\nO livro da conta numero: "+usuario+", foi cadastrado com sucesso!");
			
		}else
			System.out.println("\nA conta número "+usuario+ " não foi encontrada.");
	}
       

	@Override
	public void emprestar(int numero, int tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarLivros(String List) {
		// TODO Auto-generated method stub
		
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

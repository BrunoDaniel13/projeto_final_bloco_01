package biblioteca;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import biblioteca.model.ContaPremium;
import biblioteca.controller.BibliotecaController;
import biblioteca.model.Conta;
import biblioteca.model.ContaNormal;
import biblioteca.model.Livros;



public class Menu {
		
	    public static void main(String[] args) {
	    		    	
	    	BibliotecaController conta = new BibliotecaController();
	    	
	    	Scanner ler = new Scanner(System.in);
	    	int opcao, usuario, tipo=0, valor=0;
	        String nome, email, telefone, titulo, autor, editora;
	        
			while(true) {

				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                BIBLIOTECA COM B                     ");
				System.out.println("                                                     ");
				System.out.println("       A BIBLIOTECA QUE VOCÊ PODE CONTROLAR!         ");           
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Criar Conta na biblioteca            ");
				System.out.println("            2 - Buscar livros disponíveis            ");
				System.out.println("            3 - Atualizar Dados da Conta             ");
				System.out.println("            4 - Apagar Conta                         ");
				System.out.println("            5 - Realizar empréstimo de livro         ");
				System.out.println("            6 - Adicionar livro a biblioteca         ");
				System.out.println("            7 - Procurar dados de conta por usuário  ");
				System.out.println("            8 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("Entre com a opção desejada:                          ");
				
				try {
					opcao = ler.nextInt();
				}catch(InputMismatchException e){
					System.out.println("\nDigite valores inteiros!");
					ler.nextLine();
					opcao=0;
				}
				
					
				if (opcao == 8) {
					System.out.println("\nObrigado pela preferência! Volte Sempre! ");
					sobre();
					ler.close();
					System.exit(0);
				}
					
				switch (opcao) {
					case 1:
						System.out.println("\nCriar Conta\n\n");

						System.out.println("Digite o seu Nome completo: ");
						ler.skip("\\R");
						nome=ler.nextLine();
						System.out.println("Digite o seu email: ");				
						email=ler.nextLine();
						System.out.println("Digite o seu telefone: ");
						telefone=ler.nextLine();
												
						do {
							System.out.println("Digite o tipo da conta (1-Conta Premium ou 2-Conta Normal): ");
							tipo=ler.nextInt();
						}while(tipo < 1 && tipo >2);
						
						switch(tipo) {
						case 1 -> {
							System.out.println("Carregando....");
							conta.cadastrar(new ContaPremium(conta.gerarNumero(), nome, email, telefone, tipo));
						}
						case 2 -> {
							System.out.println("Carregando...");
							conta.cadastrar(new ContaNormal(conta.gerarNumero(), nome, email, telefone,tipo));
						}
						}					
								keyPress();
	                    		break;
					
					case 2:
						System.out.println("\nBuscar livros disponíveis\n\n");
						System.out.println("Carregando...");
						conta.buscarLivros();
	                    		break;
					
					case 3:
						System.out.println("\nAtualizar dados da Conta\n\n");
						 System.out.print("Número do Usuário: ");
		                    usuario = ler.nextInt();
		                    ler.nextLine();
		                    System.out.print("Novo Nome: ");
		                    nome = ler.nextLine();
		                    System.out.print("Novo Email: ");
		                    email = ler.nextLine();
		                    System.out.print("Novo Telefone: ");
		                    telefone = ler.nextLine();

		                    Conta contaAtualizada = conta.buscarNaCollection(usuario);
		                    if (contaAtualizada != null) {
		                        contaAtualizada.setNome(nome);
		                        contaAtualizada.setEmail(email);
		                        contaAtualizada.setTelefone(telefone);
		                        conta.atualizar(contaAtualizada);
		                    } else {
		                        System.out.println("Usuário não encontrado!");
		                    }

								keyPress();
	                    		break;
				
					case 4:
						System.out.println("\nApagar a Conta\n\n");
						System.out.println("Digite o número de usuário da conta: ");
						usuario=ler.nextInt();
						
						conta.deletar(usuario);
						
								keyPress();
	                   	 		break;
					
					case 5:
						System.out.println("\nRealizar empréstimo de livro\n\n");
						System.out.println("Digite o número de usuário da conta: ");
						usuario=ler.nextInt();
						
						if(tipo == 2) {
						do {
							System.out.println("Digite o nome do livro: ");
							ler.skip("\\R");
							titulo=ler.nextLine();
							++ valor;
						}while( valor <= 0);
						
						Livros livroEmprestimo = new Livros(titulo, "", "");
						
						conta.emprestarLivro(usuario, livroEmprestimo);	}					
						
						else
							System.out.println("Este tipo de conta não realiza empréstimos.");
								keyPress();						
	                   	 		break;
					
					case 6:
						System.out.println("\nAdicionar livro a biblioteca\n\n");
						System.out.println("Digite o número de usuário da conta: ");
						usuario=ler.nextInt();
						
						if(tipo == 1) {
						do {
							System.out.println("Digite o nome do livro: ");
							ler.skip("\\R");
							titulo=ler.nextLine();
							System.out.println("Digite o nome do autor: ");
							autor=ler.nextLine();
							System.out.println("Digite a editora: ");
							editora=ler.nextLine();
							++ valor;
						}while( valor <= 0);
						
						conta.cadastrarLivro(usuario, new Livros(titulo, autor, editora));	}					
						
						else
							System.out.println("Este tipo de conta não realiza cadastros.");
								keyPress();
								break;
					
					case 7:
						System.out.println("\nProcurar dados de conta por usuário\n\n");
						System.out.println("Digite o número de usuário da conta: ");
						usuario=ler.nextInt();
						
						conta.procurarPorUsuario(usuario);
								keyPress();
	                    		break;

					default:
						System.out.println("\nOpção Inválida!\n");
	                    		
								break;
				}
			}	
	    }

	    public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Bruno Daniel");
		System.out.println("brunodanielferreira314@gmail.com");
		System.out.println("github.com/BrunoDaniel13");
		System.out.println("*********************************************************");
	   }

	    public static void keyPress() {

			try {

				System.out.println("\n\nPressione Enter para Continuar...");
				System.in.read();

			} catch (IOException e) {

				System.out.println("Você pressionou uma tecla diferente de enter!");

			}
		}
}
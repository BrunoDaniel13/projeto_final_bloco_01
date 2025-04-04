package biblioteca;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import biblioteca.model.ContaPremium;
import biblioteca.controller.BibliotecaController;
import biblioteca.model.ContaNormal;
import biblioteca.model.Livros;



public class Menu {
		
	    public static void main(String[] args) {
	    		    	
	    	BibliotecaController conta = new BibliotecaController();
	    	
	    	Scanner ler = new Scanner(System.in);
	    	String nome, email, telefone, livrosCadastrados, livrosEmprestados;
	    	String titulo;
	    	int opcao, tipo, usuario=0;
	    	boolean premium = true, normal = true;
	    	
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
				System.out.println("            3 - Remover livro da biblioteca          ");
				System.out.println("            4 - Atualizar Dados da Conta             ");
				System.out.println("            5 - Apagar Conta                         ");
				System.out.println("            6 - Realizar empréstimo de livro         ");
				System.out.println("            7 - Adicionar livro a biblioteca         ");
				System.out.println("            8 - Procurar dados de conta por usuário  ");
				System.out.println("            9 - Sair                                 ");
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
				
					
				if (opcao == 9) {
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
							conta.cadastrar(new ContaPremium(conta.gerarNumero(), nome, email, telefone, tipo, premium, ""));
						}
						case 2 -> {
							System.out.println("Carregando...");
							conta.cadastrar(new ContaNormal(conta.gerarNumero(), nome, email, telefone, tipo, normal));
						}
						}					
								keyPress();
	                    		break;
					
					case 2:
						System.out.println("\nBuscar livros disponíveis\n\n");
								
	                    		break;
					
					case 3:
						System.out.println("\nRemover livro da biblioteca\n\n");
					
	                    		break;
					
					case 4:
						System.out.println("\nAtualizar dados da Conta\n\n");
						System.out.println("Digite o número de usuário da conta: ");
						usuario=ler.nextInt();
						
						var buscaConta = conta.buscarNaCollection(usuario);
						
						if(buscaConta != null ) {
							tipo = buscaConta.getTipo();
							
							System.out.println("Digite o seu nome: ");
							ler.skip("\\R");
							nome=ler.nextLine();
							System.out.println("Digite o seu email: ");
							email=ler.nextLine();
							System.out.println("Digite o seu telefone: ");
							telefone=ler.nextLine();
							
							switch(tipo) {
							case 1 -> {
								System.out.println("Digite o livro cadastrado: ");
								livrosCadastrados=ler.nextLine();
								conta.atualizar(new ContaPremium(usuario, nome, email, telefone, tipo, true, livrosCadastrados));
							}
							case 2 -> {
								System.out.println("Digite o livro que pegou emprestado: ");
								livrosEmprestados=ler.nextLine();
								conta.atualizar(new ContaNormal(usuario, nome, email, telefone, tipo, true));
							}
							default -> {
								System.out.println("Tipo de conta inválido!");
							}
						}
					}else {
						System.out.println("A conta não foi encontrada.");
					}
								keyPress();
	                    		break;
				
					case 5:
						System.out.println("\nApagar a Conta\n\n");
						System.out.println("Digite o número de usuário da conta: ");
						usuario=ler.nextInt();
						
						conta.deletar(usuario);
						
								keyPress();
	                   	 		break;
					
					case 6:
						System.out.println("\nRealizar empréstimo de livro\n\n");
						
						
	                   	 		break;
					
					case 7:
						System.out.println("\nAdicionar livro a biblioteca\n\n");
						System.out.println("Digite o número de usuário da conta: ");
						usuario=ler.nextInt();
						
							
	                
								break;
					
					case 8:
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
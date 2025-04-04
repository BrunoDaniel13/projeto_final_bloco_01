package biblioteca;

import java.util.Scanner;

public class Menu {
		
	    public static void main(String[] args) {
	    		    	
	    	Scanner ler = new Scanner(System.in);
	    	
	    	int opcao;
	    	
			while(true) {

				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                BIBLIOTECA COM B                     ");
				System.out.println("                                                     ");
				System.out.println("       A BIBLIOTECA QUE VOCÊ PODE CONTROLAR!         ");           

				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Criar Conta na biblioteca            ");
				System.out.println("            2 - Buscar livros disponíveis            ");
				System.out.println("            3 - Remover livro da biblioteca          ");
				System.out.println("            4 - Atualizar Dados da Conta             ");
				System.out.println("            5 - Apagar Conta                         ");
				System.out.println("            6 - Realizar empréstimo de livro         ");
				System.out.println("            7 - Adicionar livro a biblioteca         ");
				System.out.println("            8 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("Entre com a opção desejada:                          ");
				
					opcao = ler.nextInt();
				
					
				if (opcao == 8) {
					System.out.println("\nObrigado pela preferência! Volte Sempre! ");
					sobre();
					ler.close();
					System.exit(0);
				}
					
				switch (opcao) {
					case 1:
						System.out.println("\nCriar Conta\n\n");
						
	                    		break;
					case 2:
						System.out.println("\nBuscar livros disponíveis\n\n");
								
	                    		break;
					case 3:
						System.out.println("\nRemover livro da biblioteca\n\n");
					
	                    		break;
					case 4:
						System.out.println("\nAtualizar dados da Conta\n\n");
						
	                    		break;
					case 5:
						System.out.println("\nApagar a Conta\n\n");
						
	                   	 		break;
					case 6:
						System.out.println("\nRealizar empréstimo de livro\n\n");
						
	                   	 		break;
					case 7:
						System.out.println("\nAdicionar livro a biblioteca\n\n");
						
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

	   
	}
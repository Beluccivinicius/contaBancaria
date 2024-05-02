package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		
		ContaCorrente contaCorrente = new ContaCorrente(123, 123, 1, "João", 500.0f, 400.0f);
		System.out.println(contaCorrente.sacar(700.0f));
		contaCorrente.visualizar();
		ContaCorrente contaCorrente2 = new ContaCorrente(123, 123, 1, "Ericles", 500.0f, 400.0f);
		System.out.println(contaCorrente.sacar(700.0f));
		contaCorrente.visualizar();
		
		ContaPoupanca contaPoupanca = new ContaPoupanca(123, 123, 2, "Maria", 700f, 12334);
		System.out.println(contaPoupanca.sacar(800f));
		contaPoupanca.visualizar();
		
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(123, 123, 2, "Joel", 700f, 12334);
		System.out.println(contaPoupanca.sacar(800f));
		contaPoupanca.visualizar();
		
		
		
		int opcao;
		
		while(true) {
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_YELLOW_BACKGROUND + 
					"************************************************************************");
			System.out.println("                                                                        ");
			System.out.println("                        BANCO DO BRAZIL COM Z                           ");
			System.out.println("                                                                        ");
			System.out.println("************************************************************************");
			System.out.println("                                                                        ");
			System.out.println("                    1- Criar Conta                                      ");
			System.out.println("                    2- Listar todas as Contas                           ");
			System.out.println("                    3- Buscar Conta Por Numero                          ");
			System.out.println("                    4- Atualizar Dados da Conta                         ");
			System.out.println("                    5- Apagar Conta                                     ");
			System.out.println("                    6- Sacar                                            ");
			System.out.println("                    7- Depositar                                        ");
			System.out.println("                    8- Transferir Valores Entre Contas                  ");
			System.out.println("                    9- Sair                                             ");
			System.out.println("                                                                        ");
			System.out.println("************************************************************************");
			System.out.println("                                                                        ");
			System.out.println(" Entre com a opção desejada:                                            ");
			System.out.println("                                                                        " 
			+ Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!" + Cores.TEXT_YELLOW);
				sobre();
				leia.close();
				System.exit(0);
			}
			
			
			switch (opcao) {
			case 1:
				
				System.out.println("Criar Conta \n\n");
				break;
				
			case 2:
				
				System.out.println("Listar todas as Contas\n\n");
				break;
				
			case 3:
				
				System.out.println("Consultar dados da Conta - por número\n\n");
				break;
				
			case 4:
				
				System.out.println("Atualizar dados da Conta\n\n");
				break;
				
			case 5:
				
				System.out.println("Apagar a Conta\n\n");
				break;
				
			case 6:
				
				System.out.println("Saque\n\n");
				break;
				
			case 7:
				
				System.out.println("Depósito\n\n");
				
				break;
				
			case 8:
				
				System.out.println("Transferência entre Contas\n\n");
				break;
				
			default:
				
				System.out.println("\nOpção Inválida!\n");	
				break;
			}

		}
		
	

	}

	private static void sobre() {
		System.out.println("\n**********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Generation Brasil - generation@generation.org") ;
		System.out.println("github.com/conteudoGeneration");
		System.out.println("**********************************************************");
		

	}

}

package conta;

import java.io.IOException;
import java.util.InputMismatchException;

import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		ContaController contaController = new ContaController();
		
		ContaCorrente contaCorrente = new ContaCorrente(contaController.gerarCodigo(), 123, 1, "João", 500.0f, 400.0f);

		ContaCorrente contaCorrente2 = new ContaCorrente(contaController.gerarCodigo(), 123, 1, "Ericles", 500.0f, 400.0f);
		
		ContaPoupanca contaPoupanca = new ContaPoupanca(contaController.gerarCodigo(), 123, 2, "Maria", 700f, 12334);
		
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(contaController.gerarCodigo(), 123, 2, "Joel", 700f, 12334);
		
		
		contaController.cadastrar(contaPoupanca2);
		contaController.cadastrar(contaCorrente);
		contaController.cadastrar(contaCorrente2);
		contaController.cadastrar(contaPoupanca);
		
//		contaController.listarTodas();
		
		
		int opcao;
		
		int numeroConta, agencia, tipoConta = 0, aniversario,  numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		
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
			
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}
			
			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!" + Cores.TEXT_YELLOW);
				sobre();
				leia.close();
				System.exit(0);
			}
			
			
			switch (opcao) {
			case 1:
				System.out.println("Criar Conta \n\n");
				
				//Agência
				System.out.println("Digite o número agência: ");
				agencia = leia.nextInt();
				
				leia.nextLine();
				
				//Nome Titular
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				
				//Tipo da conta, aceita só o numero 1 ou o numero 2
				do {
					System.out.println("Digite o tipo de Conta:\n1-Conta Conrrente\n2-Conta Poupança");
					
					tipoConta = leia.nextInt();
					
				}while(tipoConta > 1 && tipoConta < 2);
				
				//Saldo da Conta
				System.out.println("Digite o saldo da conta: (R$) ");
				saldo = leia.nextFloat();
				
				//"Saldo da conta" ou "aniversário conta" dependendo do tipo
				if(tipoConta == 1) {
					boolean ehNumero = false;
					do {
						try {
							System.out.println("Digite o Limite de Crédito: (R$) ");
							limite = leia.nextFloat();
							
							contaController.cadastrar(new ContaCorrente(contaController.gerarCodigo(), agencia, tipoConta, titular, saldo, limite));
							ehNumero = true;
					
						}catch (InputMismatchException e) {
							System.out.println("Insira um número: (ex: 5)");
							leia.nextLine();
						}
					}while(!ehNumero);
					
				}else if(tipoConta == 2) {
					
					boolean ehDia = false;
					do {
						System.out.println("Digite o dia de aniversário da conta: ");
						try {
							aniversario = leia.nextInt();
							
							contaController.cadastrar(new ContaPoupanca(contaController.gerarCodigo(), agencia, tipoConta, titular, saldo, aniversario));
							ehDia = true;
							
						}catch (InputMismatchException e) {
							System.out.println("Insira um numero: (ex: 5)");
							leia.nextLine();
						}
				}while(!ehDia);
			}
				
				keyPress();
				break;
				
			case 2:
				
				System.out.println("Listar todas as Contas\n\n");
				contaController.listarTodas();
				keyPress();
				break;
				
			case 3:
				
				System.out.println("Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o número da conta: ");
				
				numeroConta = leia.nextInt();
				
				contaController.procurarPorNumero(numeroConta);
				keyPress();
				break;
				
			case 4:
				
				System.out.println("Atualizar dados da Conta\n\n");
				System.out.println("Digite o número da Conta: ");
				
				numeroConta = leia.nextInt();
				
				var buscaConta = contaController.buscarNaCollection(numeroConta);
				
				if(buscaConta != null) {
					
					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					leia.nextLine();
					
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					leia.nextLine();
						
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					tipoConta = buscaConta.getTipo();
					
					switch (tipoConta) {
					case 1 -> {
						
						System.out.println("Digite o limite de crédito: ");
						
						limite = leia.nextFloat();
						
						contaController.atualizar(new ContaCorrente(numeroConta, agencia, tipoConta, titular, saldo, limite));
						
					}
					case 2 -> {
						
						System.out.println("Digite o dia de aniversário da conta: ");
						aniversario = leia.nextInt();
						leia.nextLine();
						
						contaController.atualizar(new ContaPoupanca(numeroConta, agencia, tipoConta, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválida");
					}
				}
			}else {
				System.out.println("A conta não existe: ");
			}
				
				keyPress();
				break;
				
			case 5:
				
				System.out.println("Apagar a Conta\n\n");
				System.out.println("digite o número da conta: ");
				
				numeroConta = leia.nextInt();
				
				leia.nextLine();
				
				contaController.deletar(numeroConta);
				
				keyPress();
				break;
				
			case 6:
				
				System.out.println("Saque\n\n");
				System.out.println("Digite o numero da conta: ");
				
				numeroDestino = leia.nextInt();
				
				leia.nextLine();
				
				do {
				System.out.println("Digite o valor do saque: (R$) ");
				
				valor = leia.nextFloat();
				
				leia.nextLine();
				
				
				}while(valor <= 0);
				
				contaController.sacar(numeroDestino, valor);
				
				keyPress();
				break;
				
			case 7:
				
				System.out.println("Depósito\n\n");
				System.out.println("Digite o numero da conta: ");
				
				numeroDestino = leia.nextInt();
				
				leia.nextLine();
				
				do {
				System.out.println("Digite o valor do deposito: (R$) ");
				
				valor = leia.nextFloat();
				
				leia.nextLine();
				
				
				}while(valor <= 0);
				
				contaController.sacar(numeroDestino, valor);
				keyPress();
				break;
				
			case 8:
				
				System.out.println("Transferência entre Contas\n\n");
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				System.out.println("Digite o Numero da Conta de Origem: ");
				numeroConta = leia.nextInt();
				leia.nextLine();
				
				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = leia.nextInt();
				leia.nextLine();

				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contaController.transferir(numeroDestino, numeroDestino, valor);
				
				keyPress();
				break;
				
			default:
				
				System.out.println("\nOpção Inválida!\n");	
				keyPress();
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
	
	public static void keyPress() {

		try {

			System.out.println("\n\nPressione Enter para Continuar!!!");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
		

	}
}

package conta.controller;

import java.util.ArrayList;
import java.util.List;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	private List<Conta> listaContas = new ArrayList<Conta>();
	int quantidadeConta = 0;
	
	
	@Override
	public void procurarPorNumero(int numero) {
		
		var conta = this.buscarNaCollection(numero);
		
		if(conta != null) {
			conta.visualizar();
			return;
		}
		
		System.out.println("\nA Conta número: " + numero + " não foi encontrado!!");
		
	}

	@Override
	public void listarTodas() {
		listaContas.forEach((conta) -> conta.visualizar());
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número: " + conta.getNumero() + " foi criada com sucesso");
		
	}

	@Override
	public void atualizar(Conta conta) {
		int indexElemento = listaContas.indexOf(conta);
		
		if( indexElemento != -1) {
			listaContas.set(indexElemento, conta);
			return;
		}
		
		System.out.println("\nA Conta número: " + conta.getNumero() + " não foi encontrado!!");
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true) System.out.println("Conta deletada com sucesso!!!!");
		}else {
			System.out.println("\nA Conta número: " + numero + " não foi encontrado!!");

		}
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor) == true) {
				System.out.println("\nSaque na conta numero " + numero + " foi efetuada com sucesso");
				return;
			}
			
			System.out.println("\nA Conta número: " + numero + " não foi encontrado!!");
			
		}
		
	}

	@Override
	public void depositar(int numero, float valor) {
var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println("\nDeposito na conta numero " + numero + " foi efetuada com sucesso");
			return;
		}
			System.out.println("\nA Conta número: " + numero + " não foi encontrado!!");
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaDestino =  buscarNaCollection(numeroDestino);
		var contaAtual = buscarNaCollection(numeroOrigem);
		
		if(contaAtual != null && contaDestino != null) {
			if(contaAtual.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nA tranferência foi realizada com sucesso!!!");
			}
		}else {
			System.out.println("\nA conta de origem e/ou destino não foram encontrados");
		}
		
	}
	
	// Gerar o ID da conta.
	public int gerarCodigo() {
		return ++this.quantidadeConta;
	}
	
	//buscar conta na Collection
	public Conta buscarNaCollection(int numero) {
		
		for (Conta conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}

}

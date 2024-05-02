package conta.model;

public abstract class Conta {
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	float saldo;
	
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		super();
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getAgencia() {
		return agencia;
	}


	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	//sacar
	public boolean sacar(float quantia) {
		
		if(this.saldo < quantia) {
			System.out.println("\nSaldo insuficiente!!!");
			
			return false;
		}
		
		this.saldo -= quantia;
		
		return true;
	}
	
	//depositar
	public void depositar(float quantia) {
		setSaldo(this.saldo + quantia);
	}
	
	//visualizar
	public void visualizar() {
		
		String tipoConta = "";
		
		switch(this.tipo){
			
		case 1: 
			tipoConta = "Conta Corrente";
			break;
			
		case 2:
			tipoConta = "Conta Poupança";
			break;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("***********************************************************");
		System.out.println("Numero da Conta: " + this.getNumero());
		System.out.println("Agência: " + this.getAgencia());
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular: " + this.getTitular());
		System.out.println("Saldo: " + this.getSaldo());
	}
	
	//Teste
//	
//	public static void main(String[] args) {
//		Conta conta = new Conta(123, 346, 1, "Maria", 80.0f);
//		
//		System.out.println(conta.getAgencia());
//		
//		System.out.println(conta.sacar(300.0f));
//		
//		conta.visualizar();
//		
//		conta.depositar(9000.0f);
//		
//		conta.visualizar();
//		
//	}

}

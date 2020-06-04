package entidades;

public class TipoAcomodacao extends Acomodacao {
	private String descricao;
	private String nome;
	private double valor;
	
	public TipoAcomodacao() {}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public static int valorAcomodacao(int numeroTipo) {
		int valor;
		if(numeroTipo == 1) {
			valor = 100;
		} else if(numeroTipo == 2) {
			valor = 200;
		} else{
			valor = 300;
		}
		return valor; 
	}
	
	public void cadAcomodacao(int numeroTipo) {
		if(numeroTipo == 1) {
			nome = "Simples";
			descricao = "Quarto com cama de solteiro + TV";
			valor = 100;
		}
		else if(numeroTipo == 2) {
			nome = "Dupla";
			descricao = "Quarto com cama de casal + TV";
			valor = 200;
		}
		else if(numeroTipo == 3) {
			nome = "Tripla";
			descricao = "Quarto com cama de casal + cama de solteiro + TV + Wi-fi";
			valor = 300;
		}
		else {
			System.out.println("Opção inválida. Insira valor de 0 a 3.");
		}
	}
	
	public void verificaAcomodacao(int numeroTipo) {
		if(numeroTipo == 1) {
			System.out.println("Nome: Simples / Descrição: Quarto com cama de solteiro + TV/ Valor = R$100");
		} else if(numeroTipo == 2) {
			System.out.println("Nome = Dupla / Descricao = Quarto com cama de casal + TV / Valor = R$200");
		} else if(numeroTipo == 3) {
			System.out.println("Nome = Tripla / Descricao = Quarto com cama de casal + cama de solteiro + TV + Wi-fi / Valor = R$300");
		} else {
			System.out.println("Erro. Número de tipo de acomodação deve ser entre 1 e 3.");
		}
	}
}
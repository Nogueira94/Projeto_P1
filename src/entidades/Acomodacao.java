package entidades;

public class Acomodacao {
	private int numero;
	private boolean disponibilidade;
	
	public Acomodacao() {}

	public Acomodacao(int numero, boolean disponibilidade) {
		this.numero = numero;
		this.disponibilidade = disponibilidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	@Override
	public String toString() {
		return "Acomodacao [numero=" + numero + ", disponibilidade=" + disponibilidade + "]";
	}
	
}

package entidades;

import java.util.Date;

public class Cliente {
	private int codigo;
	private String nome;
	private String endereco;
	private double telefone;
	private String bairro;
	private String cidade;
	private String estado;
	private double rg;
	private Date dataNascimento;	
	
	public Cliente() {}
	
	public Cliente(int codigo) {this.codigo = codigo;}
	
	public Cliente(int codigo, String nome, String endereco, double telefone, String bairro, String cidade, String estado,
			double rg, Date dataNascimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getTelefone() {
		return telefone;
	}

	public void setTelefone(double telefone) {
		this.telefone = telefone;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getRg() {
		return rg;
	}

	public void setRg(double rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	 public int getCodigo() {
	        return codigo;
	    }
	    public void setCodigo(int codigo) {
	        this.codigo = codigo;
	    }

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + "]";
	}
}

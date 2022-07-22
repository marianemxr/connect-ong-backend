package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ong {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String cnpj;
	private Date dataFundacao;
	private List<Endereco> enderecos;
	private List<Animal> animais;
	
	public Ong() {
		super();
	}

	public Ong(String nome, String cnpj, Date dataFundacao, List<Endereco> enderecos, List<Animal> animais) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.enderecos = enderecos;
		this.animais = animais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
}

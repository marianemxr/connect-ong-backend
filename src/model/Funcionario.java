package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

	private String funcao;
	private double salario;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, Date dataNasc, char sexo, String cpfCnpj, List<Endereco> enderecos,
			List<Telefone> telefones, Usuario usuario, String funcao, double salario) {
		super(nome, dataNasc, sexo, cpfCnpj, enderecos, telefones, usuario);
		this.funcao = funcao;
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
		
}

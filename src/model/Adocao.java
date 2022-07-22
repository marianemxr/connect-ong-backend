package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import model.Pessoa;

@Entity
public class Adocao {

	@Id
	@GeneratedValue
	private Long id;
	
	private Date data;
	private Parceiro parceiro;
	private Animal animal;
	
	public Adocao() {
		super();
	}

	public Adocao(Date data, Parceiro parceiro, Animal animal) {
		super();
		this.data = data;
		this.parceiro = parceiro;
		this.animal = animal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
}

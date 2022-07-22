package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Foto {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nomeArquivo;

	public Foto() {
		super();
	}

	public Foto(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

}

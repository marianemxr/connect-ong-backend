package model;

import model.Pessoa;
import dao.DaoPessoa;

public class Programa {

	public static void main(String[] args) {
		
		//Coleta de dados do usuário e Construção dos objetos
		Pessoa a1 = new Pessoa();
		a1.setNome("Mariane");

		
		//Manipulação (inserção)		
		DaoPessoa dao = new DaoPessoa();
				
		dao.inserir(a1);
		int primeiroID = a1.getId();
		
		if(a2.getId() != primeiroID) {
			dao.inserir(a2);
		}
		
		if(a3.getId() != primeiroID) {
			dao.inserir(a3);
		}
		
		System.out.println("Lista de Pessoas: ");
		listarPessoas();
		
		dao.excluir(a2);
		
		System.out.println("\nLista de Pessoas (após a exclusão do elemento que possuía ID = 2): ");
		listarPessoas();
		
		System.out.println(dao.localizar(1));
		
	}
	
		public static void listarPessoas() {
			DaoPessoa dao = new DaoPessoa();
			
			for(Pessoa elemento : dao.listar()) {
				System.out.println(" - Pessoa: ID - " + elemento.getId() + ", Nome - " + elemento.getNome() + ".");
			}
			
		}
}
}

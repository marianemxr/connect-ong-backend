package dao;

import java.util.ArrayList;
import java.util.List;

import model.Animal;

public class DaoAnimal {

	//DAO - Data Access Object (Acesso aos Dados do Objeto)
	
		private static List<Animal> listaAnimais = new ArrayList<>();
			
//		inserir(Animal):void
//		inserir: inserir na lista, caso o id n�o seja duplicado
		public void inserir(Animal obj) {
			listaAnimais.add(obj);
			
			//conex�o
			//sql : insert int _ value ();
		}
			
//		excluir(Animal):boolean
//		excluir: retornar se foi exclu�do com sucesso (true ou false)
		public boolean excluir(Animal obj) {		
			listaAnimais.remove(obj);
			return listaAnimais.contains(obj);
		}
			
//		listar():List<Animal>
//		listar: retornar a lista com todos os animais inseridos
		public List<Animal> listar(){
			return listaAnimais;
			
			//conex�o
			//sql : select * from Animal;
		}
			
//		localizar(int):Animal
//		localizar: receber o inteiro id e imprimir �registro n�o encontrado�, caso o
//		Animal n�o esteja na lista, caso contr�rio retornar o objeto Animal
//		correspondente
		public String localizar(int id) { // key
			for(Animal elemento : listaAnimais) {
				if(elemento.getId() == id) {
					return "\nAnimal correspondente ao ID solicitado: " + elemento.getNome() 
							+ " da esp�cie " + elemento.getEspecie() + ".";
				}else {
					return "\nRegistro n�o encontrado!";
				}
			}
			
			return null;				
		}
	
}

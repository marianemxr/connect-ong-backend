package view;

import model.Animal;
import dao.DaoAnimal;
import controller.DataBase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Programa {

	public static void main(String[] args) {
		
		Scanner entradaDados = new Scanner(System.in);
		DaoAnimal dao = new DaoAnimal();
		
		DataBase bancoDeDados = new DataBase();
		
		SessionFactory sessionFactory = null;
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable e) {
			System.err.println("Erro ao conectar com BD: " + e);
		}
		
		Session session = sessionFactory.openSession();
		
		System.out.println("Ol�. Seja bem-vindo(a) ao Connect-ONG, um sistema destinado ao controle e ao gerenciamento de Organiza��o N�o-Governamentais (ONGs) ligadas � causa animal. \n\n"
				+ "Nele, � poss�vel realizar o cadastro e o controle de pessoas (funcion�rios e parceiros) e de animais.\n"
				+ "Os parceiros, como s�o chamadas as pessoas que n�o t�m v�nculo empregat�cio ou voluntariado com a ONG, t�m acesso � lista de animais resgatados pela ONG em quest�o e, \n"
				+ "devidamente cadastrados, poder�o solicitar uma ado��o. Ou seja, o principal objetivo do projeto � conectar seres humanos e animais.\n");
		
				System.out.println("1 - Cadastrar Pessoa\n"
				+ "2 - Cadastrar Animal\n"
				+ "3 - Visualizar Lista de Animais\n"
				+ "4 - Recuperar Senha do Perfil\n"
				+ "5 - Ler Perguntas Frequentes\n"
				+ "6 - Entrar em Contato com a Connect-ONG\n");
				System.out.print("Digite o n�mero referente � a��o que voc� deseja executar: ");
				int acao = entradaDados.nextInt();
				
				if(acao == 2){
					char continuar = 's';
					do{
						System.out.println("Voc� escolheu a op��o 2: Cadastrar Animal. Por favor, pe�o que responda algumas perguntas sobre o animal para que o cadastro seja realizado com sucesso.\n");
						System.out.print("Qual � o sexo do animal? Digite 'f' para f�mea e 'm' para macho: ");
						char animalSexo = entradaDados.next().charAt(0);
						if(animalSexo != 'f' && animalSexo != 'm') {
							System.out.println("Erro! Digite apenas 'f' ou 'm'.\n");
							
						}else {
							System.out.print("Qual � o nome do animal? ");
							String animalNome = entradaDados.next();
							System.out.print("Em que data o animal nasceu? (dd/MM/yyyy) Caso n�o saiba, digite uma data aproximada, de acordo com a idade atual do animal: ");
							String animalDataNascimento = entradaDados.next();
							System.out.print("Qual � a esp�cie do animal? ");
							String animalEspecie = entradaDados.next();
							System.out.print("Qual � a ra�a do animal? ");
							String animalRaca = entradaDados.next();
							System.out.print("Qual � o peso do animal, dada em kg? ");
							double animalPeso = entradaDados.nextDouble();
							System.out.print("Em que data o animal foi resgatado? ");
							String animalDataResgate = entradaDados.next();
							System.out.print("O animal � castrado? Digite 'true', caso ele seja, ou 'false', caso ele N�O seja: ");
							boolean animalCastracao = entradaDados.nextBoolean();
							
							System.out.print("O animal est� dispon�vel para ado��o? Digite 'true', caso esteja, ou 'false', caso ele N�O esteja: ");
							boolean animalAdocao = entradaDados.nextBoolean();
							
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date dataNasc = null;
							Date dataResg = null;
							
							try {
								dataNasc = formatter.parse(animalDataNascimento);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							try {
								dataResg = formatter.parse(animalDataResgate);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							Animal a = new Animal(animalNome, dataNasc, animalSexo, animalEspecie, animalRaca, animalPeso, dataResg, animalCastracao, animalAdocao);
							dao.inserir(a);
													
							//	2. Iniciar uma Transa��o
							session.beginTransaction();
							
							//	3. Execturar uma a��o (insert, delete, update, select) DML - Manipula��o
							session.save(a);
							
							//	4. Confirmar a Transa��o
							session.getTransaction().commit();
							
							System.out.print("\nVoc� deseja cadastrar mais um animal? Se sim, digite 's'. Se n�o, digite 'n': ");
							continuar = entradaDados.next().charAt(0);
						}
					}while(continuar=='s');
				}
				
				System.out.println("Excelente! O cadastro foi finalizado. Confira abaixo a lista com o animal ou animais que foram cadastrados:\n");
				listarAnimais();
				
				System.out.println("O atendimento foi encerrado. Tenha um �timo dia!");
				
				//	5. Fechar a sess�o com BD
				session.close();
	}
		
			
	public static void listarAnimais() {
		DaoAnimal dao = new DaoAnimal();
					
		for(Animal elemento : dao.listar()) {
			System.out.println("ANIMAL:\nNome: " + elemento.getNome() + ";\nSexo: " + elemento.getSexo() + ";\nData de Nascimento: " + elemento.getDataNasc() 
				+ ";\nEsp�cie: " + elemento.getEspecie() + ";\nRa�a: " + elemento.getRaca() + ";\nPeso: " + elemento.getPeso() 
				+ "kg;\nData de Resgate: " + elemento.getDataResgate() + ";\nCastra��o (true: Realizada / false: Pendente): " + elemento.isCastracao() + ";\nAdo��o (true: Dispon�vel / false: Indispon�vel): "
				+ elemento.isDisponibilidade() + ".\n");
		}
					
	}
}
		

	


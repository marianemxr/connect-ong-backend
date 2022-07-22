package conexao_bd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

	public static void main(String[] args) {
		
		//Pessoa pessoa = new Pessoa("Maria", "maria@gmail.com");
		
		//	Configurando a fábrica de Sessões com BD
		SessionFactory sessionFactory = null;
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable e) {
			System.err.println("Erro ao conectar com BD: " + e);
		}
		
		//	1. Abrir uma sessão com BD
		Session session = sessionFactory.openSession();
		
		//	2. Iniciar uma Transação
		session.beginTransaction();
		
		//	3. Execturar uma ação (insert, delete, update, select) DML - Manipulação
		session.save(null);
		
		//	4. Confirmar a Transação
		session.getTransaction().commit();
		
		//	5. Fechar a sessão com BD
		session.close();
		
	}
	
}

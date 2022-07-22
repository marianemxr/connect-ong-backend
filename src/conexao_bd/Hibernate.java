package conexao_bd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

	public static void main(String[] args) {
		
		//Pessoa pessoa = new Pessoa("Maria", "maria@gmail.com");
		
		//	Configurando a f�brica de Sess�es com BD
		SessionFactory sessionFactory = null;
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable e) {
			System.err.println("Erro ao conectar com BD: " + e);
		}
		
		//	1. Abrir uma sess�o com BD
		Session session = sessionFactory.openSession();
		
		//	2. Iniciar uma Transa��o
		session.beginTransaction();
		
		//	3. Execturar uma a��o (insert, delete, update, select) DML - Manipula��o
		session.save(null);
		
		//	4. Confirmar a Transa��o
		session.getTransaction().commit();
		
		//	5. Fechar a sess�o com BD
		session.close();
		
	}
	
}

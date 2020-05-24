package mask;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import mask.model.Sales;
import mask.model.Stores;

/**
 * <pre>
 * kr.co.swh.lecture.database.java.hibernate.annotation
 * HibernateAnnotationUtil.java
 *
 * ���� : ���̹�����Ʈ ������̼�
 * </pre>
 * 
 * @since : 2017. 10. 26.
 * @author : tobby48
 * @version : v1.0
 */
public class HibernateUtil7 {
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	
	static{
		try{
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			
			//	����1
			configuration.addAnnotatedClass(Sales.class);
			configuration.addAnnotatedClass(Stores.class);
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory(){ 
		return sessionFactory;
	}
}

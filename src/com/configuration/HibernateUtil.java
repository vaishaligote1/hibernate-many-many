package com.configuration;


	import java.util.HashMap;
	import java.util.Map;

	import org.hibernate.SessionFactory;
	import org.hibernate.boot.Metadata;
	import org.hibernate.boot.MetadataSources;
	import org.hibernate.boot.registry.StandardServiceRegistry;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Environment;

import com.model.Staff;
import com.model.Student;
//	import com.model.Teacher;



	public class HibernateUtil {
		private static StandardServiceRegistry serviceRegistry;
		private static SessionFactory sessionFactory;
		
		public static SessionFactory getSessionFactory()
		{
		
		if(sessionFactory==null)
		{        
			Map<String,Object> settings=new HashMap<String,Object>();
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/manytomany");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.SHOW_SQL, "true");
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			serviceRegistry=new StandardServiceRegistryBuilder().applySettings(settings).build();
			MetadataSources mds=new MetadataSources(serviceRegistry);
			mds.addAnnotatedClass(Student.class);
			mds.addAnnotatedClass(Staff.class);
		
			Metadata md=mds.getMetadataBuilder().build();
			sessionFactory=md.getSessionFactoryBuilder().build();
			
		}	
		return sessionFactory;
		}

	}




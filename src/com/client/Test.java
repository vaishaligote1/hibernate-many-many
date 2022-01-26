package com.client;

import org.hibernate.Session;

import com.configuration.HibernateUtil;
import com.model.Staff;
import com.model.Student;

public class Test {
	
	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		Student stu=new Student();
		stu.setRollno(1);
		stu.setName("ravi");
		

		Student stu1=new Student();
		stu1.setRollno(2);
		stu1.setName("rv");
		
		Staff t=new Staff();
		t.setSid(101);
		t.setSname("smam");
		
		Staff t1=new Staff();
		t1.setSid(102);
		t1.setSname("rmam");
		
		stu.getSt().add(t);
		stu.getSt().add(t1);
		stu1.getSt().add(t1);
		stu1.getSt().add(t);
		t.getStud().add(stu);
		t.getStud().add(stu1);
		t1.getStud().add(stu1);
		t1.getStud().add(stu);
		
		session.save(stu);
		session.save(stu1);
		session.save(t1);
		session.save(t);
		
		session.beginTransaction().commit();
		
		
	}
	

}

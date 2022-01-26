package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	private int rollno;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Staff> getSt() {
		return st;
	}
	public void setSt(Set<Staff> st) {
		this.st = st;
	}
	private String name;
	@ManyToMany
	private Set<Staff>st=new HashSet<>();

}

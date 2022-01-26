package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="abc_S")
public class Staff {
	
	@Column(name="name")
	private String sname;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Set<Student> getStud() {
		return stud;
	}
	public void setStud(Set<Student> stud) {
		this.stud = stud;
	}
	@Id
	private int sid;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="S_Staff",joinColumns = {@JoinColumn(name="s_id1")},inverseJoinColumns = {@JoinColumn(name="stu_id1")})//change the name of coloumn n table as relationship bet them
	private Set<Student>stud=new HashSet<>();

}

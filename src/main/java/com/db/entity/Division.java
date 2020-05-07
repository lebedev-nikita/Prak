package com.db.entity;

import com.db.entity.Employee;

import javax.persistence.*;

@Entity
@Table(name="divisions")
public class Division
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="div_id")
	private Integer id;

	@Column(name="div_name")
	private String name;

	@Column(name="head_div_id")
	private Integer headDivId;

	@ManyToOne
	@JoinColumn(name = "chief_id")
	// На самом деле это chief
	private Employee employees;

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Division() {}

	public Division(String name, Integer headDivId, Integer chiefId) {
		this.name = name;
		this.headDivId = headDivId;
//		this.chiefId = chiefId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeadDivId() {
		return headDivId;
	}

	public void setHeadDivId(Integer headDivId) {
		this.headDivId = headDivId;
	}

	@Override
	public String toString() {
		return "Division [id=" + id + ", name=" + name + ", headDivId=" + headDivId + "]";
//		return "Division [id=" + id + ", name=" + name + ", headDivId=" + headDivId + ", chiefId=" + chiefId + "]";
	}


}

package com.db.entity;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name="emp_pos")
public class EmpPos
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_pos_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee emp;

	@ManyToOne
	@JoinColumn(name = "pos_id")
	private Position pos;

	@Column(name="salary")
	private Integer salary;

	public EmpPos() {}

	public EmpPos(Employee emp, Position pos, int salary) {
		this.emp = emp;
		this.pos = pos;
		this.salary = salary;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "DivPos [salary=" + salary + "empId=" + emp.getId() + "posId=" + pos.getId() + "]";
	}


}

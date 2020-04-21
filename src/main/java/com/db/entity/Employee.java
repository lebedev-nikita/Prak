package com.db.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer id;

	@Column(name="surname")
	private String surname;
	@Column(name="name")
	private String name;

	@Column(name="patronymic")
	private String patronymic;

	@Column(name="education")
	private String education;

	public Employee() {}

	public Employee(String surname, String name, String patronymic, String education) {
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.education = education;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", surname=" + surname + ", name=" + name + ", patronymic=" + patronymic
				+ ", education=" + education + "]";
	}
}

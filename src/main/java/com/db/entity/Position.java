package com.db.entity;

import com.db.DAO.DivisionTableManager;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="positions")
public class Position
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pos_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "div_id")
	private Division division;

	@Column(name="pos_name")
	private String name;

	@Column(name="responsibilities")
	private String responsibilities;

	@OneToMany(mappedBy = "pos", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<EmpPos> empPos;

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Set<EmpPos> getEmpPos() {
		return empPos;
	}

	public void setEmpPos(Set<EmpPos> empPos) {
		this.empPos = empPos;
	}

	public Position() {}

	public Position(Integer divisionId, String name, String responsibilities) {
        this.division = new DivisionTableManager().getById(divisionId);
		this.name = name;
		this.responsibilities = responsibilities;
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

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", responsibilities=" + responsibilities + "]";
	}
}

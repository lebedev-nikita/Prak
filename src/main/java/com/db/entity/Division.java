package com.db.entity;

import com.db.entity.Employee;

import javax.persistence.*;
import java.util.Set;

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

	@ManyToOne
	@JoinColumn(name = "head_div_id")
	private Division headDiv;

	@OneToMany(mappedBy = "headDiv", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Division> subDivisions;

	@ManyToOne
	@JoinColumn(name = "chief_id")
	private Employee chief;

	@OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Position> positions;

	public Set<Position> getPositions() {
		return positions;
	}

	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}

	public Employee getChief() {
		return chief;
	}

	public void setChief(Employee chief) {
		this.chief = chief;
	}

	public Division getHeadDiv() {
		return headDiv;
	}

	public void setHeadDiv(Division headDiv) {
		this.headDiv = headDiv;
	}

	public Set<Division> getSubDivisions() {
		return subDivisions;
	}

	public void setSubDivisions(Set<Division> subDivisions) {
		this.subDivisions = subDivisions;
	}

	public Division() {}

	public Division(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Division [id=" + id + ", name=" + name + "]";
	}


}

package com.db.entity;

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

	@Column(name="div_id")
	private Integer divisionId;

	@Column(name="pos_name")
	private String name;

	@Column(name="responsibilities")
	private String responsibilities;

	@OneToMany(mappedBy = "pos", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<EmpPos> ep;

	public Set<EmpPos> getEp() {
		return ep;
	}

	public void setEp(Set<EmpPos> ep) {
		this.ep = ep;
	}

	public Position() {}

	public Position(Integer divisionId, String name, String responsibilities) {
		this.divisionId = divisionId;
		this.name = name;
		this.responsibilities = responsibilities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
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
		return "Position [id=" + id + ", divisionId=" + divisionId + ", name=" + name + ", responsibilities="
				+ responsibilities + "]";
	}
}

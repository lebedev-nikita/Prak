package com.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name="chief_id")
	private Integer chiefId;

	public Division() {}

	public Division(String name, Integer headDivId, Integer chiefId) {
		this.name = name;
		this.headDivId = headDivId;
		this.chiefId = chiefId;
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

	public Integer getChiefId() {
		return chiefId;
	}

	public void setChiefId(Integer chiefId) {
		this.chiefId = chiefId;
	}

	@Override
	public String toString() {
		return "Division [id=" + id + ", name=" + name + ", headDivId=" + headDivId + ", chiefId=" + chiefId + "]";
	}


}

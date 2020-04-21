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

	@Column(name="emp_id")
	private Integer employeeId;

	@Column(name="pos_id")
	private Integer positionId;

	@Column(name="start_date")
	private Date startDate;

	@Column(name="finish_date")
	private Date finishDate;

	@Column(name="salary")
	private Integer salary;

	public EmpPos() {}

	public EmpPos(Integer employeeId, Integer positionId, String startDate, String finishDate, Integer salary) {
		this.employeeId = employeeId;
		this.positionId = positionId;
		this.startDate = Date.valueOf(startDate);
		this.finishDate = Date.valueOf(finishDate);
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpId() {
		return employeeId;
	}

	public void setEmpId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getPosId() {
		return positionId;
	}

	public void setPosId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getStartDate() {
		return startDate.toString();
	}

	public void setStartDate(String startDate) {
		this.startDate = Date.valueOf(startDate);
	}

	public String getFinishDate() {
		return finishDate.toString();
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = Date.valueOf(finishDate);
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "DivPos [employeeId=" + employeeId + ", positionId=" + positionId + ", startDate=" + startDate
				+ ", finishDate=" + finishDate + ", salary=" + salary + "]";
	}


}

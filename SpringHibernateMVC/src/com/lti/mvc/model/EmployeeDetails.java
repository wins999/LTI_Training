package com.lti.mvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;


@Entity
@Table(name="EMPLOYEE_DETAILS")
public class EmployeeDetails {
		@Id
	    @Column(name="id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		private String firstName;
		private String lastName;
		private String email;
		private double salary;
		private String mobNo;
		private String password;
		private int jobId;
		private int depId;
		
		@Temporal(TemporalType.DATE)
		private Date hiredate;		
		

		public Integer getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getMobNo() {
			return mobNo;
		}

		public void setMobNo(String mobNo) {
			this.mobNo = mobNo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getJobId() {
			return jobId;
		}

		public void setJobId(int jobId) {
			this.jobId = jobId;
		}

		public int getDepId() {
			return depId;
		}

		public void setDepId(int depId) {
			this.depId = depId;
		}

		public Date getHiredate() {
			return hiredate;
		}

		public void setHiredate(Date hiredate) {
			this.hiredate = hiredate;
		}

		@Override
		public String toString() {
			return "EmployeeDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
					+ email + ", salary=" + salary + ", mobNo=" + mobNo + ", password=" + password + ", jobId=" + jobId
					+ ", depId=" + depId + ", hiredate=" + hiredate + "]";
		}		
		
		
}

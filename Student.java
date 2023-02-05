package Studentmanagement;

import java.io.Serializable;

public class Student  {

	private String name;
	private int rollNumber;
	private String department;


	// constructor
	public Student(String name, int rollNumber, String department)
	{

		this.name = name;
		this.rollNumber = rollNumber;
		this.department = department;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getRollNumber() {
		return rollNumber;
	}


	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNumber=" + rollNumber + ", department=" + department + "]";
	}



}

package assignment.week3.day1.student;

import assignment.week3.day1.department.*;

public class Student extends Department {
	
	public void studentName() {
		System.out.println("Jeevika");

	}
	public void studentDept() {
		System.out.println("IT");

	}
	public void studentId() {
		System.out.println("27");

	}

	public static void main(String[] args) {
	
		Student student = new Student();
		student.collegeName();
		student.collegeCode();
		student.collegeRank();
		student.deptName();
		student.studentName();
		student.studentDept();
		student.studentId();
	}

}

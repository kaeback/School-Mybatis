package org.example.dao;

import org.example.vo.*;

import java.util.*;

public interface SchoolMapper {
	// Person 등록
	int addPerson(Person person);
	
	// 학생 등록
	int addStudent(Student student);
	
	// 교사 등록
	int addTeacher(Teacher teacher);
	
	// 직원 등록
	int addStaff(Staff staff);
			
	// 주민번호로 검색
	Person findPersonBySsn(String ssn);

	// 학생 검색
	List<Student> findStudent(String ssn);

	// 교사 검색
	List<Teacher> findTeacher(String ssn);

	// 직원 검색
	List<Staff> findStaff(String ssn);

	// Person 수정
	int updatePerson(Person person);

	// 학생 수정
	int updateStudent(Student student);

	// 교사 수정
	int updateTeacher(Teacher teacher);

	// 직원 수정
	int updateStaff(Staff staff);
}

package org.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.checkerframework.checker.units.qual.A;
import org.example.vo.*;

public class SchoolDao {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	// 학생 등록
	public boolean addStudent(Student student) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			mapper.addPerson(student);
			Person person = mapper.findPersonBySsn(student.getSsn());
			student.setSeq_per(person.getSeq_per());
			mapper.addStudent(student);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 교사 등록
	public boolean addTeacher(Teacher teacher) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			mapper.addPerson(teacher);
			Person person = mapper.findPersonBySsn(teacher.getSsn());
			teacher.setSeq_per(person.getSeq_per());
			mapper.addTeacher(teacher);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 직원 등록
	public boolean addStaff(Staff staff) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			mapper.addPerson(staff);
			Person person = mapper.findPersonBySsn(staff.getSsn());
			staff.setSeq_per(person.getSeq_per());
			mapper.addStaff(staff);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 주민번호로 검색
	public Person searchPersonBySsn(String ssn) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			Person person = mapper.findPersonBySsn(ssn);

			if (person != null) {
				switch (person.getType()) {
					case "STUDENT":
						List<Student> students = mapper.findStudent(ssn);
						if (students.size() > 0) {
							return students.get(0);
						}
						break;
					case "TEACHER":
						List<Teacher> teachers = mapper.findTeacher(ssn);
						if (teachers.size() > 0) {
							return teachers.get(0);
						}
						break;
					case "STAFF":
						List<Staff> staffs = mapper.findStaff(ssn);
						if (staffs.size() > 0) {
							return staffs.get(0);
						}
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 회원정보 수정
	public boolean updatePerson(Person person) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			Person findPerson = searchPersonBySsn(person.getSsn());
			if (findPerson != null) {
				mapper.updatePerson(person);
				switch (findPerson.getType()) {
					case "STUDENT": mapper.updateStudent((Student) person); break;
					case "TEACHER": mapper.updateTeacher((Teacher) person); break;
					case "STAFF": mapper.updateStaff((Staff) person); break;
				}
				session.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 주민번호로 삭제
	public boolean removePerson(String ssn) {
		return false;
	}
	
	// 모든 회원정보 검색
	public List<Person> findAllPersons() {
		List<Person> result = new ArrayList<>();
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			result.addAll(mapper.findStudent(null));
			result.addAll(mapper.findTeacher(null));
			result.addAll(mapper.findStaff(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

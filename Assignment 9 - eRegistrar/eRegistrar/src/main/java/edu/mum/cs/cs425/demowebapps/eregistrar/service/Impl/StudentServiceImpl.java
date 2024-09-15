package edu.mum.cs.cs425.demowebapps.eregistrar.service.Impl;

import edu.mum.cs.cs425.demowebapps.eregistrar.domain.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.repository.StudentRepository;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        Student student1 = studentRepository.findById(student.getStudentId()).orElse(null);
        student1.setStudentNumber(student.getStudentNumber());
        student1.setFirstName(student.getFirstName());
        student1.setMiddleName(student.getMiddleName());
        student1.setLastName(student.getLastName());
        student1.setCgpa(student.getCgpa());
        student1.setEnrollmentDate(student.getEnrollmentDate());
        student1.setIsInternational(student.getIsInternational());
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}

package sn.devkiller.restapi.app.Services;

/* import java.util.List;
import java.util.Optional; */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.devkiller.restapi.app.Models.Student;
import sn.devkiller.restapi.app.Repositories.StudentRepository;

@Service
public class StudentService {
  private final StudentRepository studentRepository;
  
  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }
  
  
  public Iterable<Student> getStudents() {
		return studentRepository.findAll();
	}

  public Student save(Student student) {
    /* Optional<Student> sOptional = studentRepository.findStudentByEmail(student.getEmail());

    if (sOptional.isPresent()) {
      throw new IllegalStateException("emailTaken");
    } */
    return studentRepository.save(student);
  }

  public void delete(Long id) {
    if (!studentRepository.existsById(id)) {
      throw new IllegalStateException("NotExist");
    }
    studentRepository.deleteById(id);
  }
  
}

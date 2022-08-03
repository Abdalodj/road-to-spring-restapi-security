package sn.devkiller.restapi.app.Repositories;

import java.util.Optional;

/* import org.springframework.data.jpa.repository.JpaRepository; */
/* import org.springframework.data.jpa.repository.Query; */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.devkiller.restapi.app.Models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
  
  /* @Query("SELECT s FROM Student s WHERE s.email = ?1") */
  Optional<Student> findByEmail(String email);
}

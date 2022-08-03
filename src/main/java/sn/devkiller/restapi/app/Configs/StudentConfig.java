package sn.devkiller.restapi.app.Configs;

import java.time.ZoneId;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

import sn.devkiller.restapi.app.Models.Student;
import sn.devkiller.restapi.app.Repositories.StudentRepository;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {
      ArrayList<Student> sIterable = new ArrayList<Student>();
      Faker faker = new Faker();
      for (int i = 0; i < 20; i++) {
        sIterable.add(new Student(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),
            faker.date().birthday(16, 30).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
      }
      studentRepository.saveAll(sIterable);
    };
  }
}

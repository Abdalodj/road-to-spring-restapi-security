package sn.devkiller.restapi.app.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {@UniqueConstraint(name = "student_email_unique", columnNames = "email")})
@SQLDelete(sql = "UPDATE student SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
  private String first_name;

  @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
  private String last_name;
  @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(100)", length = 100)
  private String email;
  private LocalDate birth;
  private LocalDateTime deleted_at = null;

  @Transient
  private Integer age;

  public Student() {
  }

  public Student(Long id, String first_name, String last_name, String email, LocalDate birth) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.birth = birth;
  }

  public Student(String first_name, String last_name, String email, LocalDate birth) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.birth = birth;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.first_name;
  }

  public void setFirstName(String first_name) {
    this.first_name = first_name;
  }

  public String getLastName() {
    return this.last_name;
  }

  public void setLastName(String last_name) {
    this.last_name = last_name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirth() {
    return this.birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  public LocalDateTime getDeleted_at() {
    return this.deleted_at;
  }

  /* public void setDeleted_at(Date date) {
    this.delete_at = date;
  } */

  public Integer getAge() {
    return Period.between(this.birth, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", FirstName='" + getFirstName() + "'" +
      ", LastName='" + getLastName() + "'" +
      ", email='" + getEmail() + "'" +
      ", birth='" + getBirth() + "'" +
      ", age='" + getAge() + "'" +
      "}";
  }


}

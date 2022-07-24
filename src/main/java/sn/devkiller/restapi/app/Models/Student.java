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

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table
@SQLDelete(sql = "UPDATE student SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  private String name;
  @Column(unique = true)
  private String email;
  private LocalDate birth;
  private LocalDateTime deleted_at = null;

  @Transient
  private Integer age;

  public Student() {
  }

  public Student(Long id, String name, String email, LocalDate birth) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birth = birth;
  }

  public Student(String name, String email, LocalDate birth) {
    this.name = name;
    this.email = email;
    this.birth = birth;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
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
      ", name='" + getName() + "'" +
      ", email='" + getEmail() + "'" +
      ", birth='" + getBirth() + "'" +
      ", age='" + getAge() + "'" +
      "}";
  }


}

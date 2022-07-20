package sn.devkiller.restapi.Beans;

import java.time.LocalDate;

public class Student {
  public Long id;
  private String name;
  private String email;
  private LocalDate birth;
  private Integer age;

  public Student() {
  }

  public Student(Long id, String name, String email, LocalDate birth, Integer age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birth = birth;
    this.age = age;
  }

  public Student(String name, String email, LocalDate birth, Integer age) {
    this.name = name;
    this.email = email;
    this.birth = birth;
    this.age = age;
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

  public Integer getAge() {
    return this.age;
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

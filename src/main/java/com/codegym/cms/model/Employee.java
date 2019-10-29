package com.codegym.cms.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String birthDate;
    private String address;
    private String avatar;
    private String salary;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {}

    public Employee(Long id, String name, String birthDate, String address, String avatar, String salary  ) {
       this.id = id;
       this.name = name;
       this.birthDate = birthDate;
       this.address = address;
       this.avatar = avatar;
       this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, name='%s', birthDate='%s',address='%s',avatar='%s',salary='%s']", id, name, birthDate,address,avatar,salary);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAvatar(String avatar){
        return avatar;
    }
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getSalary(){
        return salary;
    }
    public void setSalary(String salary){
        this.salary = salary;
    }

}
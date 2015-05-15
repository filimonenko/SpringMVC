package com.filimonenko.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id" )
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Lob
    @Column(name = "employee_image")
    private byte[] image;


    @Column(name = "employee_resume")
    private boolean resume;


    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    @Temporal(value=TemporalType.DATE)
    private Date birthDate;

    private Long departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {}

    public Employee(Long departmentId, String name, byte[] image, boolean resume,  String email, Date birthDate) {

        this.departmentId = departmentId;
        this.name = name;
        this.image = image;
        this.resume = resume;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean getResume() {
        return resume;
    }

    public void setResume(boolean resume) {
        this.resume = resume;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", departmentId=" + departmentId +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", birthDate=" + birthDate +
//                '}';
//    }
}

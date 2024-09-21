package org.example.springboot.model.minitest;

import jakarta.persistence.*;

@Entity
@Table(name = "tour")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gmail")
    private String gmail;
    @Column(name = "img")
    private String img;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    // Constructors
    public Student() {
    }

    public Student(int id, String name, String phone, String gmail, String img, Province province) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gmail = gmail;
        this.img = img;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
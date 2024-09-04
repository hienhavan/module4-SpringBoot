package org.example.springboot.model.minitest;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;
    @Column(name = "destination")
    private String destination;
    @Column(name = "start")
    private Date start;
    @Column(name = "img")
    private String img;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    // Constructors
    public Tour() {
    }

    public Tour(int id, String code, String destination, Date start, String img, Province province) {
        this.id = id;
        this.code = code;
        this.destination = destination;
        this.start = start;
        this.img = img;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
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
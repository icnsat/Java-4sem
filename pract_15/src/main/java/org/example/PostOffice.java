package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "postoffice")
public class PostOffice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "city_name")
    private String cityName;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
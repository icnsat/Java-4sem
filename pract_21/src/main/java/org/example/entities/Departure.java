package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departure")
@NoArgsConstructor
public class Departure {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "date")
    private String departureDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PostOffice.class)
    @JoinColumn(name="office_id", insertable=false, updatable=false)
    public PostOffice departuresPostOffice;

    @Column(name="office_id")
    private Long postOfficeId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Long getPostOfficeId() {
        return postOfficeId;
    }

    public void setPostOfficeId(Long postOfficeId) {
        this.postOfficeId = postOfficeId;
    }

    @JsonIgnore
    public PostOffice getPostOffice() {
        return departuresPostOffice;
    }
}

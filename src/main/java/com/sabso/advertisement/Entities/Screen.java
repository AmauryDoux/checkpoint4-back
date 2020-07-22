package com.sabso.advertisement.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Screen")
@Table(name = "screen")
public class Screen {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Boolean isUsed;
    private Boolean hasAds;
    private String address;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToMany
    @JoinTable(name = "screen_ads",
            joinColumns = { @JoinColumn(name = "fk_screen") },
            inverseJoinColumns = { @JoinColumn(name = "fk_advert") })
    @JsonIdentityInfo(
            scope = Screen.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Advert> advertList = new ArrayList<Advert>();

    // Constructor
    public Screen() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Boolean getHasAds() {
        return hasAds;
    }

    public void setHasAds(Boolean hasAds) {
        this.hasAds = hasAds;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Advert> getAdvertList() {
        return advertList;
    }

    public void setAdvertList(List<Advert> advertList) {
        this.advertList = advertList;
    }
}

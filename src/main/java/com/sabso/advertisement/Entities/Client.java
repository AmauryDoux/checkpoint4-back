package com.sabso.advertisement.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Client")
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Screen> screen = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "client_ads",
            joinColumns = { @JoinColumn(name = "fk_client") },
            inverseJoinColumns = { @JoinColumn(name = "fk_advert") })
    @JsonIdentityInfo(
            scope = Client.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Advert> advertList = new ArrayList<Advert>();

    // Constructor
    public Client() {
    }

    // getters and setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }

    public List<Advert> getAdvertList() {
        return advertList;
    }

    public void setAdvertList(List<Advert> advertList) {
        this.advertList = advertList;
    }
}

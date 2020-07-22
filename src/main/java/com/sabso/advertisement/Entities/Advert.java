package com.sabso.advertisement.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Advert {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy="advertList")
    private List<Screen> screenList = new ArrayList<Screen>();

    @ManyToMany(mappedBy="advertList")
    private List<Client> clientList = new ArrayList<Client>();

    // Constructor
    public Advert() {
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

}


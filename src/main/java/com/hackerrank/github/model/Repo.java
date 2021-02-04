package com.hackerrank.github.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="REPOS")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Repo  implements Serializable {

    private static final long serialVersionUID = -1344497166638156145L;
    private @Id Long id;
    private String name;
    private String url;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Event> eventRepo;

    public Repo() {
    }

    public Repo(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

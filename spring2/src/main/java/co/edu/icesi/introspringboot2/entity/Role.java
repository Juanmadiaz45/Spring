package co.edu.icesi.introspringboot2.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "domi_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

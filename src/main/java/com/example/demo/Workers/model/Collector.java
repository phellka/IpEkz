package com.example.demo.Workers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Collector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    private int experience;
    private String name;

    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    public Collector(){

    }

    public Collector(int experience, String name, Qualification qualification) {
        this.experience = experience;
        this.name = name;
        this.qualification = qualification;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collector collector = (Collector) o;
        return Objects.equals(id, collector.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Collector{" +
                "id=" + id +
                ", Experience='" + experience + '\'' +
                ", Name='" + name + '\'' +
                ", Qualification='" + qualification + '\'' +
                '}';
    }
}

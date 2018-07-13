package com.sz.ha.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 03.05.2018.
 */
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    private Integer counter = 1;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Long id, String firstName, String lastName, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String toString(){
        return "id:" + getId()
                + ", firstName:" + firstName
                + ", lastName:" + lastName;
    }

    @Override
    public boolean equals(Object o){
        return o != null
                && o instanceof User
                && getId().equals(((User) o).getId())
                && getFirstName().equals(((User) o).getFirstName())
                && getLastName().equals(((User) o).getLastName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstNAme) {
        this.firstName = firstNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

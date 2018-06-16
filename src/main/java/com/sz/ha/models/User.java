package com.sz.ha.models;

/**
 * Created by lenovo on 03.05.2018.
 */
public class User {
    private Long id;
    private String firstName;
    private String lastName;


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
}

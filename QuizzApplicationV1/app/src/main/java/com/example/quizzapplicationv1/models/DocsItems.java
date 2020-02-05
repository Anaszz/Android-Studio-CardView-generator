package com.example.quizzapplicationv1.models;

public class DocsItems {

    private	int	id;
    private	String name;
    private  String surname;
    private	String phno;

    public DocsItems(String name, String surname,String phno) {
        this.name = name;
        this.surname = surname;
        this.phno = phno;
    }

    public DocsItems(int id, String name, String surname, String phno) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phno = phno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.name = surname;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

}

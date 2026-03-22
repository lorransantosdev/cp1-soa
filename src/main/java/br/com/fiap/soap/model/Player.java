package br.com.fiap.soap.model;

public class Player {
    private String name;

    public Player() { }

    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

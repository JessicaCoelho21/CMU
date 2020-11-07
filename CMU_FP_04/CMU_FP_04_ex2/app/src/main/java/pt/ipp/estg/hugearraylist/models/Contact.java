package pt.ipp.estg.hugearraylist.models;

public class Contact {
    private String name;

    public Contact(String nome) {
        this.name = nome;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

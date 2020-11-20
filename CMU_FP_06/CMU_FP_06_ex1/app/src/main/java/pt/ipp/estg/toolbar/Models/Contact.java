package pt.ipp.estg.toolbar.Models;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private Boolean online;

    public Contact(String name, Boolean online) {
        this.name = name;
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}

package com.eichgi.edteamfirebase;

/**
 * Created by Hiram on 12/12/2017.
 */

public class Usuario {

    String nombre, email, uuid;

    public Usuario(String name, String email, String uuid) {
        this.nombre = name;
        this.email = email;
        this.uuid = uuid;
    }

    public Usuario() {
    }
}

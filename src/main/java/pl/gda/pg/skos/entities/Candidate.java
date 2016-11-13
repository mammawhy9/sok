package pl.gda.pg.skos.entities;

import java.io.Serializable;

public class Candidate implements Serializable {

    private static final long serialVersionUID = -5339716000388191619L;
    private String token;
    private String name;
    private String email;
    private boolean canAdmin;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCanAdmin() {
        return canAdmin;
    }

    public void setCanAdmin(boolean canAdmin) {
        this.canAdmin = canAdmin;
    }
}

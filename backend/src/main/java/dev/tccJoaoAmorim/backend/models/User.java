package dev.tccJoaoAmorim.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "country")
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

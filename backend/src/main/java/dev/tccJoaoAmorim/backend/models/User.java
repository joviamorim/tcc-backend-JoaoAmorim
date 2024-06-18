package dev.tccJoaoAmorim.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_info")
public class User {

    @Id
    @Column(name = "id", unique = true)
    @JsonProperty(value = "id")
    private String id;

    @Column(name = "display_name")
    @JsonProperty(value = "display_name")
    private String displayName;

    @Column(name = "email")
    @JsonProperty(value = "email")
    private String email;

    @Column(name = "country")
    @JsonProperty(value = "country")
    private String country;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TopTracks> userTopTracks = new HashSet<>();

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

    public Set<TopTracks> getTopTracks() {
        return userTopTracks;
    }

    public void setTopTracks(Set<TopTracks> topTracks) {
        this.userTopTracks = topTracks;
    }

}

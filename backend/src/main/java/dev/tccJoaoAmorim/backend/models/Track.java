package dev.tccJoaoAmorim.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

/*@Entity
@Table(name = "tracks")*/
public class Track {

    /*@Id
    @Column(name = "id", unique = true)*/
    @JsonProperty(value = "id")
    private String id;

    /*@Column(name = "name")*/
    @JsonProperty(value = "name")
    private String name;

    /*@Column(name = "popularity")*/
    @JsonProperty(value = "popularity")
    private Integer popularity;

    /*@OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)*/
    private Set<TopTracks> userTopTracks = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public void setUserTopTracks(Set<TopTracks> userTopTracks) {
        this.userTopTracks = userTopTracks;
    }

}

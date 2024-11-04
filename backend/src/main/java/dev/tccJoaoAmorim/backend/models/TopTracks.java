package dev.tccJoaoAmorim.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/*@Entity
@Table(name = "top_tracks")*/
public class TopTracks {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private long id;

    /*@ManyToOne
    @JoinColumn(name = "user_id")*/
    private User user;

    /*@ManyToOne
    @JoinColumn(name = "track_id")*/
    private Track track;

    /*@Transient*/
    @JsonProperty(value = "items")
    private List<Track> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public List<Track> getItems() {
        return items;
    }

    public void setItems(List<Track> items) {
        this.items = items;
    }
}

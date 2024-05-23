package dev.tccJoaoAmorim.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TopArtists {

    @JsonProperty("items")
    private List<Artist> items;

    public List<Artist> getItems() {
        return items;
    }

    public void setItems(List<Artist> items) {
        this.items = items;
    }
}

package dev.tccJoaoAmorim.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackFeatures {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "energy")
    private float energy;

    @JsonProperty(value = "valence")
    private float valence;

    @JsonProperty(value = "track_href")
    private String trackHref;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getValence() {
        return valence;
    }

    public void setValence(float valence) {
        this.valence = valence;
    }

    public String getTrackHref() {
        return trackHref;
    }

    public void setTrackHref(String trackHref) {
        this.trackHref = trackHref;
    }
}

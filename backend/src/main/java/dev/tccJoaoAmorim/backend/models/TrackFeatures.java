package dev.tccJoaoAmorim.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Transient;

public class TrackFeatures {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "energy")
    private float energy;

    @JsonProperty(value = "valence")
    private float valence;

    @JsonProperty(value = "loudness")
    private float loudness;

    @JsonProperty(value = "danceability")
    private float danceability;

    @JsonProperty(value = "instrumentalness")
    private float instrumentalness;

    @JsonProperty(value = "acousticness")
    private float acousticness;

    @JsonProperty(value = "speechiness")
    private float speechiness;

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

    public float getLoudness() {
        return loudness;
    }

    public void setLoudness(float loudness) {
        this.loudness = loudness;
    }

    public float getDanceability() {
        return danceability;
    }

    public void setDanceability(float danceability) {
        this.danceability = danceability;
    }

    public float getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(float instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public float getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(float acousticness) {
        this.acousticness = acousticness;
    }

    public float getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(float speechiness) {
        this.speechiness = speechiness;
    }
}

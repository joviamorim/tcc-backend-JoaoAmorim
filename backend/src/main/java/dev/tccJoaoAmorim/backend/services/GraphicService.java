package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.models.Artist;
import dev.tccJoaoAmorim.backend.models.Track;
import dev.tccJoaoAmorim.backend.models.TrackFeatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraphicService {

    private final TrackService trackService;
    private final ArtistService artistService;

    @Autowired
    public GraphicService(TrackService trackService, ArtistService artistService) {
        this.trackService = trackService;
        this.artistService = artistService;
    }

    // inicialmente, este método estará retornando List<Track>, mas o correto
    // seria encontrar uma forma de retornar os dados diretos para colocar
    // no gráfico de forma mais simples. Nesse caso, só a List pode acabar
    // servindo, pois só usaremos as informações dessa List.
    public List<Track> getTopTracksWithPopularity() {
        return trackService.getUserTopTracks().getItems();
    }

    public ArrayList<TrackFeatures> getTopTracksWithFeatures() {
        List<Track> tracks = trackService.getUserTopTracks().getItems();
        ArrayList<TrackFeatures> tracksFeatures = new ArrayList<>();

        tracks.forEach(track -> {
            tracksFeatures.add(trackService.getTrackFeatures(track.getId()));
        });

        return tracksFeatures;
    }

    public List<Artist> getTopArtistsByPopularity() {
        return artistService.getUserTopArtists().getItems();
    }


}

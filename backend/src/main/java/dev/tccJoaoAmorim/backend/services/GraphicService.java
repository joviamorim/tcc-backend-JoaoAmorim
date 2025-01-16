package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.models.Artist;
import dev.tccJoaoAmorim.backend.models.Track;
import dev.tccJoaoAmorim.backend.models.TrackFeatures;
import jakarta.servlet.http.HttpServletRequest;
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
    public List<Track> getTopTracksWithPopularity(HttpServletRequest request) {
        return trackService.getUserTopTracks(request).getItems();
    }

    public ArrayList<TrackFeatures> getTopTracksWithFeatures(HttpServletRequest request) {
        List<Track> tracks = trackService.getUserTopTracks(request).getItems();
        ArrayList<TrackFeatures> tracksFeatures = new ArrayList<>();

        tracks.forEach(track -> {
            tracksFeatures.add(trackService.getTrackFeatures(track.getId(), request));
        });

        return tracksFeatures;
    }

    public List<Artist> getTopArtistsByPopularity(HttpServletRequest request) {
        return artistService.getUserTopArtists(request).getItems();
    }


}

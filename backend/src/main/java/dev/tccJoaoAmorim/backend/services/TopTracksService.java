package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.models.TopTracks;
import dev.tccJoaoAmorim.backend.repositories.TopTracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopTracksService {

    @Autowired
    private TopTracksRepository topTracksRepository;

    
    public void saveUserTopTracks(TopTracks obj) {
        topTracksRepository.save(obj);
    }
}

package dev.tccJoaoAmorim.backend.repositories;

import dev.tccJoaoAmorim.backend.models.TopTracks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopTracksRepository extends JpaRepository<TopTracks, Long> {
}

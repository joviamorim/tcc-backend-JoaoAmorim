package dev.tccJoaoAmorim.backend.repositories;

import dev.tccJoaoAmorim.backend.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {
}

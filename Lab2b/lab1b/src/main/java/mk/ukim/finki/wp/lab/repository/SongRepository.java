package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song,Long> {
    Optional<Song> findByTitle(String title);
    List<Song> findAllByAlbum_Id(Long albumId);

    public List<Song> findByAlbum(Album album);

}

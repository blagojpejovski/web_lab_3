package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();  // Враќа список на сите песни
    void addArtistToSong(Artist artist, Long songId);  // Додава уметник на песна

    Song findByTrackId(Long trackId);  // Наоѓа песна по trackId

   Song save(Song song);

    void deleteById(Long id);  // Брише песна по ID
    public void update(Song song);

    public List<Song> findByAlbum(Album album);

    Optional<Song> findByTitle(String title);

}

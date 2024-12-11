package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();  // Ги враќа сите песни
    }

    @Override
    public void addArtistToSong(Artist artist, Long songId) {
        // Наоѓа песна по ID
        Optional<Song> songOptional = songRepository.findById(songId);
        songOptional.ifPresent(song -> {
            // Додава уметник на песната
            song.addArtist(artist);
            // Чува во базата
            songRepository.save(song);
        });
    }

    @Override
    public Song findByTrackId(Long trackId) {
        // Наоѓа песна по trackId
        return songRepository.findById(trackId).orElse(null);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void deleteById(Long id) {
        // Брише песна по ID
        songRepository.deleteById(id);
    }
    @Override
    public void update(Song song) {
        songRepository.save(song);
    }

    @Override
    public List<Song> findByAlbum(Album album) {
        return songRepository.findByAlbum(album);
    }

    public Optional<Song> findByTitle(String title) {
        return songRepository.findByTitle(title);
    }
}
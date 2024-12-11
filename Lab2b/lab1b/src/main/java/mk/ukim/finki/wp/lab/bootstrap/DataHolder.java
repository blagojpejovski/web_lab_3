package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artists = null;
    public static List<Song> songs = null;

    public static List<Album> albums = null;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private SongService songService;
    @PostConstruct
    public void init(){
        artists = new ArrayList<>();
        artists.add(new Artist(23L,"vrcak","pandev","Biography1"));
        artists.add(new Artist(18L,"Lady","Gaga","Biography2"));
        artists.add(new Artist(58L,"Dj","Donny","Biography3"));
        artists.add(new Artist(152L,"Floy","Mennor","Biography4"));
        artists.add(new Artist(123L,"Azis","Azis","Biography5"));

        albums = new ArrayList<>();
        albums.add(new Album("album 1", "rock", "2014"));
        albums.add(new Album("album 2", "pop", "2004"));
        albums.add(new Album("album 3", "jazz", "2010"));
        albums.add(new Album("album 4", "metal", "1980"));
        albums.add(new Album("album 5", "rock", "2002"));

        for(Album album : albums) {
            albumService.save(album);
        }

        songs = new ArrayList<>();
        songs.add(new Song( "song1", "pop", 2018, albums.get(1)));
        songs.add(new Song( "song2", "rock", 2015, albums.get(3)));
        songs.add(new Song( "song3", "metal", 1980, albums.get(2)));
        songs.add(new Song("song4", "jazz", 2010, albums.get(0)));
        songs.add(new Song("song5", "electric", 2014, albums.get(4)));

        for (Song song : songs) {
            songService.save(song);
        }



    }
}

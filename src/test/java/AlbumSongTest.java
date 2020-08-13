import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class AlbumSongTest {
	@Test
	public void addAlbum() {
		GenericDao dao = new GenericDao();
				
		Album alb = new Album();
		alb.setName("Rang de Basanti");
		alb.setReleaseDate(LocalDate.now());
		alb.setCopyright("Sony");
		
		dao.add(alb);
	}
	
	@Test
	public void addSongToAnAlbum() {
		GenericDao dao = new GenericDao();
		Album alb = (Album) dao.fetch(Album.class, 317);
		
		Song song = new Song();
		song.setTitle("Rang de Basanti");
		song.setArtist("Daler Mehendi & Chitra");
		song.setDuration(5.30);
		song.setAlbum(alb);
		
		dao.add(song);
		
		song = new Song();
		song.setTitle("Roobaroo");
		song.setArtist("A R Rahman");
		song.setDuration(4.30);
		song.setAlbum(alb);
		
		dao.add(song);
	}
	
	@Test
	public void addAlbumAlongWithSongs() {
		GenericDao dao = new GenericDao();
		Album alb = new Album();
		alb.setName("Some Albus");
		alb.setReleaseDate(LocalDate.now());
		alb.setCopyright("Some Copyright");
		
		List<Song> songs = new ArrayList<>();
		
		Song s1 = new Song();
		s1.setTitle("Titile1");
		s1.setArtist("Artist 1");
		s1.setDuration(4.30);
		s1.setAlbum(alb);
		
		Song s2 = new Song();
		s1.setTitle("Titile2");
		s1.setArtist("Artist 2");
		s1.setDuration(4.30);
		s1.setAlbum(alb);
		
		songs.add(s1);
		songs.add(s2);
		
		alb.setSongs(songs);
		
		dao.add(alb);
		
	}
}

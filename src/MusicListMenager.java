import java.util.ArrayList;

public class MusicListMenager {	
	
	private ArrayList<Song> songs;	
	
	public MusicListMenager() {
		
		songs = new ArrayList<Song>();
		
	}
	
	public ArrayList<Song> getSongArray() { return songs; }
	
	public void addSong(Song song) { songs.add(song); }
	
	public Song getSongAt(int index) { return songs.get(index); }
	
	
}
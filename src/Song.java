import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Song extends SongComponent {
	

	private DefaultListModel<String> songList;
	private ArrayList<File> fileList;
	
	public Song() {
		
		songList = new DefaultListModel<>();
		fileList = new ArrayList<File>();
	}

	public void addSong(String newSong, File newFile) {
		
		songList.addElement(newSong);
		fileList.add(newFile);
		
	}
	
	public DefaultListModel<String> getSongListModel() { return songList; }
	public ArrayList<File> getFileList() { return fileList; }
	
	public File getFileAt(int index) { return fileList.get(index); }
	
}
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import jmusic.util.UtilFunctions;

public class PlayThread extends Thread{
	
	private static Player player;

	private File songFile;
	private boolean stopSong = true;
	private boolean pauseSong = false;
	
	public PlayThread() {

	}
	public PlayThread(File song) {
		try {
			songFile = song;
			player = new Player(new FileInputStream(songFile));
		} catch (FileNotFoundException | JavaLayerException e) {
			
			e.printStackTrace();
		}

	}
	public PlayThread(PlayThread newPlayThread) {
		
		this.player = newPlayThread.player;
		songFile = newPlayThread.songFile;		
		
	}
	
	
	public void setSong(File song) {				
	
		songFile = song;
		
	}
	
	public void run() {
		
		while(true) {
			if(!stopSong) {
				try {					
							player = new Player(new FileInputStream(songFile));
							player.play();					
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "No File Selected!", "Error", JOptionPane.ERROR_MESSAGE);
					
				} 
			}else {
				UtilFunctions.sleep(200);
			}
		}
	}
	
	public void playSong() {

		stopSong = false;
		
		if(pauseSong) {
			player.resume();
		}
		
	}
	
	public void stopSong() {
		
		player.stop();	
		stopSong = true;
		
	}
	
	public void pauseSong() {
		
		player.pause();
		pauseSong = true;
		
	}
	
	public void resumeSong() {
		
		player.resume();
	
	}

}
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PlayerMenager{

	private PlayThread playSong;
	private boolean pausedSong = false;
	
	public PlayerMenager() {
		
		playSong = new PlayThread();
		
	}

	public void setSong(File f) { playSong.setSong(f); }
		
	public void play() {
		
		try {			
			
			if(!playSong.isAlive()) {	
				
				playSong.start();
				
			} else {
				
				if(pausedSong) {
					
					//playSong.resumeSong();
				}
				else {
					
					//playSong.stopSong();				
					playSong.start();
					
				}
			}
			
		} catch (Exception e) {					
				JOptionPane.showMessageDialog(null, "No File Selected!", "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void stop() {
		
		//playSong.stopSong();	
		
	}

	public void pause() {
		
	
	}

	public void previous() {
		
	

		
	}

	public void next() {
		

	}
	
}


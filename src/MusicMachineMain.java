import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import javazoom.jl.player.Player;


public class MusicMachineMain {

	private JFrame frmMusicMachine;	
	private JTextField pathField;
	private JButton stopBtn;
	
	private File songFile, tempFile;
	private JButton prevBtn;
	private JButton nextBtn;
	private PlayThread play;
	
	private Song songs = new Song();
	
	JList<String> jSongList = new JList<>(songs.getSongListModel());
	
	//ArrayList<Song> songs = new ArrayList<Song>();
	
	private Song testSong = new Song();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					MusicMachineMain window = new MusicMachineMain();
					window.frmMusicMachine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MusicMachineMain() {
		initialize();
	}


	private void initialize() {
		frmMusicMachine = new JFrame();
		frmMusicMachine.getContentPane().setForeground(Color.GRAY);
		frmMusicMachine.setTitle("Music Machine");
		frmMusicMachine.setBounds(100, 100, 553, 486);
		frmMusicMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicMachine.setLocationRelativeTo(null);
		frmMusicMachine.getContentPane().setLayout(null);
		
		JButton startBtn = new JButton("Start");
		startBtn.setForeground(Color.GREEN);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(play == null) {
					
					play = new PlayThread(songs.getFileAt(0));
					
				}
				if(play.isAlive()) {
					play.playSong();	
				}
				else {
					play.start();
					play.playSong();
				}
				
			}
		});
		startBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		startBtn.setBounds(109, 359, 103, 78);
		frmMusicMachine.getContentPane().add(startBtn);
		
		pathField = new JTextField();
		pathField.setEditable(false);
		pathField.setText("Song Path");
		pathField.setBounds(10, 11, 244, 20);
		frmMusicMachine.getContentPane().add(pathField);
		pathField.setColumns(10);
		
		JButton openBtn = new JButton("Add");
		openBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				open();
				
			}
		});
		openBtn.setBounds(264, 10, 68, 23);
		frmMusicMachine.getContentPane().add(openBtn);
		
		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				play.stopSong();
				
			}
		});
		stopBtn.setForeground(Color.RED);
		stopBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		stopBtn.setBounds(321, 359, 110, 78);
		frmMusicMachine.getContentPane().add(stopBtn);
		
		JButton pauseBtn = new JButton("||");
		pauseBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		pauseBtn.setForeground(Color.YELLOW);
		pauseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				play.pauseSong();
				
			}
		});
		pauseBtn.setBounds(222, 358, 89, 78);
		frmMusicMachine.getContentPane().add(pauseBtn);
		
		prevBtn = new JButton("<<");
		prevBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				
			}
		});
		prevBtn.setBounds(10, 358, 89, 78);
		frmMusicMachine.getContentPane().add(prevBtn);
		
		nextBtn = new JButton(">>");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
			
			}
		});
		nextBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		nextBtn.setBounds(441, 358, 89, 78);
		frmMusicMachine.getContentPane().add(nextBtn);
		
		JTree songTree = new JTree();
		songTree.setVisibleRowCount(0);
		songTree.setBounds(10, 73, 80, 243);
		frmMusicMachine.getContentPane().add(songTree);
		
		JProgressBar songProgressBar = new JProgressBar();
		songProgressBar.setBounds(10, 42, 520, 20);
		frmMusicMachine.getContentPane().add(songProgressBar);
		
		JLabel songPlayed = new JLabel("New label");
		songPlayed.setBounds(10, 327, 517, 20);
		frmMusicMachine.getContentPane().add(songPlayed);		

		jSongList.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		jSongList.setBounds(109, 73, 418, 243);
		frmMusicMachine.getContentPane().add(jSongList);
	
	}
	
	private void open() {	
		
		try {					
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Choose song To Load...");
			chooser.showOpenDialog(null);
			songFile = chooser.getSelectedFile();						
			pathField.setText(songFile.getName());
			songs.addSong(songFile.getName(), songFile);
			//play = new PlayThread(testSong.getSongFile());
			if(!songFile.getName().endsWith(".mp3")) {
				JOptionPane.showMessageDialog(null, "Invalid File Type selected!", "Error", JOptionPane.ERROR_MESSAGE);
				open();				
			}
		}catch (Exception e1){					
			e1.printStackTrace();
		}		
	}
	
	private void play() {		
	
			
				
	}
	
	private void stop() {
		
				
		
	}
}

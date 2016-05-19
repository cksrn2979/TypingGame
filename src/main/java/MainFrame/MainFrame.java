package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.InputEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import MainFrame.CenterPanel.CenterPanel;
import MainFrame.EastPanel.EastPanel;
import MainFrame.NorthPanel.NorthPanel;
import MainFrame.SouthPanel.SouthPanel;
import MainFrame.WestPanel.WestPanel;
import MyDictionary.MyDictionary;

public class MainFrame extends JFrame{
	public static MainFrame mf;
	
	JMenuBar menuBar=new JMenuBar();
	JMenu fileMenu=new JMenu("파일");
	JMenu helpMenu=new JMenu("Help");
	JMenuItem newFile=new JMenuItem("새파일");
	JMenuItem open=new JMenuItem("열기");
	JMenuItem save=new JMenuItem("저장");
	JMenuItem exit=new JMenuItem("종료");
	
	public EastPanel ep;
	public NorthPanel np;
	public CenterPanel cp;
	public SouthPanel sp;
	public WestPanel wp;
	
	
	MainFrame(){
		setTitle("Typing Trainer with English!");
		setSize(800,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);//크기 고정
		setBackground(Color.WHITE);
		
		//MyDictionay 초기화 - WORDLIST.txt모든 단어 입력
		try {MyDictionary.inWordFromFile();	} 
		catch (IOException e) {e.printStackTrace();}
				
		//파일 메뉴 생성
		fileMenu.add(newFile);
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.addSeparator();//구분선 추가
		fileMenu.add(exit);
				
		//파일 메뉴 단축키 설정
		newFile.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
				
		//도움 메뉴 생성
		helpMenu.add(new JMenuItem("버전"));
		helpMenu.add(new JMenuItem("정보"));
		
		//메뉴를 메뉴바에 등록
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		//메뉴바 추가
		setJMenuBar(menuBar);
		
		Container c = getContentPane();
		
		sp= new SouthPanel();
		ep= new EastPanel();
		np= new NorthPanel();
		cp= new CenterPanel();		
		wp= new WestPanel();
		
		c.add(sp,BorderLayout.SOUTH);
		c.add(ep,BorderLayout.EAST);
		c.add(np,BorderLayout.NORTH);
		c.add(cp,BorderLayout.CENTER);		
		c.add(wp,BorderLayout.WEST);
		
	}
	
	public static void main(String[] args){
		mf= new MainFrame();		
	}
	
}

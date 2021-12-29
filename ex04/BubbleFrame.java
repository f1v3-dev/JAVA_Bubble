package bubble.test.ex04;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
		player = new Player();
		add(player);
	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initListener() {
		addKeyListener(new KeyAdapter() {
			
			//키보드 클릭 이벤트
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode());
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(!player.isLeft()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(!player.isRight()) {
						player.right();	
					}
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
				}
			}
			
			//키보드 해제 이벤트
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
						
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}

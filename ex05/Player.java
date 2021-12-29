package bubble.test.ex05;

import javax.swing.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends JLabel implements Moveable {

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2; // up, down 속도

	// 바라보는 방향 (좌, 우)
	private ImageIcon playerR, playerL;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");

		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 55;
		y = 535;

		left = false;
		right = false;
		up = false;
		down = false;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	// 이벤트 핸들러 = 큐 (FIFO)
	@Override
	public void left() {
		left = true;
		new Thread(() -> {	//Runnable이랑 동일
			while(left) {
				setIcon(playerL);
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void right() {
		right = true;
		new Thread(() -> {	//Runnable이랑 동일
			while(right) {
				setIcon(playerR);
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}).start();
	}

	// left + up, right + up 
	@Override
	public void up() {
		up = true;
		new Thread(() -> {
			for(int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED; 
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			up = false;
			down();
			
		}).start();
	}

	@Override
	public void down() {
		down = true;
		new Thread(()->{
			for(int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED; 
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();
	}
}

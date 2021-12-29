package bubble.test.ex04;

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
				x = x - 1;
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
				x = x + 1;
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
	public void up() {
		new Thread(() -> {

		}).start();
	}

	@Override
	public void down() {

	}
}

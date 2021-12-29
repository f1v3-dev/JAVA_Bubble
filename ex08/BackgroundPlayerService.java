package bubble.test.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;

import javax.imageio.ImageIO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackgroundPlayerService implements Runnable {
	private BufferedImage image;
	private Player player;

	private int leftColor;
	private int rightColor;
	private int topColor;
	private int bottomColor;

	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			Color leftColor = new Color(image.getRGB(player.getX()-10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			
			// -2가 나온다는 것 => 바닥이 흰색이 나온다는 것
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 55) // -1
					 + image.getRGB(player.getX() + 40, player.getY() + 55); // -1 => 둘다 -1 일때만 멈춤
			
			
			// 바닥 충돌 확인
			if(bottomColor != -2) {
				System.out.println("바텀컬러 : " + bottomColor);
				System.out.println("바닥에 충돌함");
				player.setDown(false);
			}
			//외벽 충돌 확인
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			}
			else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌");
				player.setRightWallCrash(true);
				player.setRight(false);
			}
			else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);


			}
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {

			}
		}

	}

}
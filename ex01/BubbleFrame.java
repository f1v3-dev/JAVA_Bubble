package bubble.test.ex01;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

// 1. ������ â�� �Ǿ���
// 2. ������ â�� ���ο� �г��� �ϳ� ������ �ִ�.
public class BubbleFrame extends JFrame{
	private JTextField textField;
	public BubbleFrame() {
		setSize(1000, 640);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(62, 150, 97, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setText("1111");
		textField.setBounds(31, 277, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		setVisible(true); //�׸��� �׷���
	}
	public static void main(String[] args) {
		new BubbleFrame();
	}
}

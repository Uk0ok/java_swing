import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class swing {
	public static void main(String[] args) {
		new swingEx();
	}
}

class swingEx extends JFrame {
	Container c;
	
	swingEx() {
		setTitle("나의 두번째 프레임");
		setSize(1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setButton();
		setVisible(true);
	}
	void setButton() {
		c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel jl = new JLabel("레이블"); 
		JTextField tf = new JTextField(30);
		JButton jb = new JButton("검색");
		c.add(jl);
		c.add(tf);
		c.add(jb);
	}
}


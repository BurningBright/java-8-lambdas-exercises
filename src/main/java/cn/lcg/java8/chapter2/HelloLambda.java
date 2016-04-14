package cn.lcg.java8.chapter2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
* @Description: 打个招呼
* @author leon
* @date 2016年3月3日 下午6:55:25
*
 */
public class HelloLambda {
	// 建一个对话框、按钮
	HelloLambda() {
		JFrame jf = new JFrame("Hello JFrame");
		jf.setSize(300, 100);
		jf.setLocation(500, 300);
		jf.setLayout(new FlowLayout());
		
		JButton button = new JButton("XXX");
		
		// 编译时通过上下文判断是ActionListener对象
		button.addActionListener(event -> {
			System.out.println("Hello Lambda Expression");
		});
		
		jf.add(button);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HelloLambda();
	}

}

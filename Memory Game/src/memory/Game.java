package memory;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game implements Runnable {
	Cards _c;
	JFrame frame;
	@Override public void run() {
		frame = new JFrame("SP13-CSE115-Lab8-Memory Game");
		GridLayout layout = new GridLayout(4,4);
		memory.GameBoard _game = new memory.GameBoard(_c);
		_game.setLayout(layout);
		frame.add(_game);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Game());
	}
}
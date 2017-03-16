package memory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LabelListener implements MouseListener {
	
	Cards cards;
	GameBoard game;
	
	public LabelListener(GameBoard _g, Cards _c){
		game = _g;
		cards = _c;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		cards.flip();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package memory;

import javax.swing.JLabel;

public class Cards extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	GameBoard _GB;

	private LabelListener _l1 = new memory.LabelListener(_GB,this);
	
	public Cards(GameBoard gb) {
		_GB = gb;
		this.addMouseListener(_l1);
	
	}
	
	public void flip()
	{
		_GB.flipCard(this);
	}
	public void removeM(){
		this.removeMouseListener(_l1);
	}
	public void addM(){
		this.addMouseListener(_l1);
	}
}
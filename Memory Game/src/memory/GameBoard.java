package memory;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
	Cards c;
	private static final long serialVersionUID = 1L;
	private ArrayList<String> bList = new ArrayList<String>();
	private ArrayList<String> fList = new ArrayList<String>();
	private ArrayList<String> cardList8 = new ArrayList<String>();
	private ArrayList<String> cardList1 = new ArrayList<String>();
	private ArrayList<Cards> cardList16 = new ArrayList<Cards>();
	private LabelListener _l1 = new memory.LabelListener(this,c);
	long _time1 = 0;
	int _state = 0;
	int z = 0;
	int x = 0;
	Cards card1;
	Cards card2;
	Cards cards;
		
	public GameBoard(Cards _card){
		cards = _card;
		makeFList();
		makeBList();
		addCards();	
	}
	public void makeFList(){
		for(int i=1;i<=22;i++){
			String imgString = "Images/F";
			if(i<10){
				imgString = imgString + "0";
			}
			imgString = imgString + i +".png";
			fList.add(imgString);
		}
		Collections.shuffle(fList);
		for(int b=1;b<=8;b++){
			cardList8.add(fList.get(b));
			cardList8.add(fList.get(b));
		}
		Collections.shuffle(cardList8);
	}
	public void makeBList(){
		for(int a=1;a<=3;a++){
			bList.add("Images/B0"+a+".png");
		}
		Collections.shuffle(bList);
		cardList1.add(bList.get(0));
	}
	public void addCards(){
		for (int v=0;v<=15;v++){
			Cards card = new memory.Cards(this);
			ImageIcon cardImgDown = new ImageIcon(cardList1.get(0));
			card.setIcon(cardImgDown);
			this.add(card);
			cardList16.add(card);
		}
	}
	
	public void flipCard(Cards _c1){
		if (_state == 4){
			_time1 = System.currentTimeMillis();
			_state = 0;
		}
		else if (_state ==1){
			findCard(_c1);
			card2 = _c1;
			card2.setIcon(_c1.getIcon());
			_state=2;
		}
		else if (_state == 2){
			card2.removeM();
			if (card1.getIcon().toString() != card2.getIcon().toString()){
				card1.setIcon(new ImageIcon(cardList1.get(0)));
				card2.setIcon(new ImageIcon(cardList1.get(0)));
				card1.addM();
				card2.addM();
			}
			else{
				card1.setIcon(null);
				card2.setIcon(null);
				x = x+1;
			}
			checkCards();
		}
		else if (_state == 0){
			if (z == 0){
				_time1 = System.currentTimeMillis();
				z = z+1;
			}
			findCard(_c1);
			card1 = _c1;
			card1.setIcon(_c1.getIcon());
			card1.removeM();
			_state = 1;
		}
	}
	public void findCard(Cards _c){
		if (_c == cardList16.get(0)){
		_c.setIcon(new ImageIcon(cardList8.get(0)));
		_c = cardList16.get(0);
		}
		if (_c == cardList16.get(1)){
		_c.setIcon(new ImageIcon(cardList8.get(1)));
		_c = cardList16.get(1);
		}
		if (_c == cardList16.get(2)){
		_c.setIcon(new ImageIcon(cardList8.get(2)));
		_c = cardList16.get(2);
		}
		if (_c == cardList16.get(3)){
		_c.setIcon(new ImageIcon(cardList8.get(3)));
		_c = cardList16.get(3);
		}
		if (_c == cardList16.get(4)){
		_c.setIcon(new ImageIcon(cardList8.get(4)));
		_c = cardList16.get(4);
		}
		if (_c == cardList16.get(5)){
		_c.setIcon(new ImageIcon(cardList8.get(5)));
		_c = cardList16.get(5);
		_c.removeMouseListener(_l1);
		}
		if (_c == cardList16.get(6)){
		_c.setIcon(new ImageIcon(cardList8.get(6)));
		_c = cardList16.get(6);

		}
		if (_c == cardList16.get(7)){
		_c.setIcon(new ImageIcon(cardList8.get(7)));
		_c = cardList16.get(7);
		}
		if (_c == cardList16.get(8)){
		_c.setIcon(new ImageIcon(cardList8.get(8)));
		_c = cardList16.get(8);
		}
		if (_c == cardList16.get(9)){
		_c.setIcon(new ImageIcon(cardList8.get(9)));
		_c = cardList16.get(9);
		}
		if (_c == cardList16.get(10)){
		_c.setIcon(new ImageIcon(cardList8.get(10)));
		_c = cardList16.get(10);
		}
		if (_c == cardList16.get(11)){
		_c.setIcon(new ImageIcon(cardList8.get(11)));
		_c = cardList16.get(11);
		}
		if (_c == cardList16.get(12)){
		_c.setIcon(new ImageIcon(cardList8.get(12)));
		_c = cardList16.get(12);
		}
		if (_c == cardList16.get(13)){
		_c.setIcon(new ImageIcon(cardList8.get(13)));
		_c = cardList16.get(13);
		}
		if (_c == cardList16.get(14)){
		_c.setIcon(new ImageIcon(cardList8.get(14)));
		_c = cardList16.get(14);
		}
		if (_c == cardList16.get(15)){
		_c.setIcon(new ImageIcon(cardList8.get(15)));
		_c = cardList16.get(15);
		}
	}
	public void checkCards(){
		if (x == 8) {
			long _time2 = System.currentTimeMillis();
			System.out.println("You beat it in "+(_time2- _time1 )/1000 +" seconds!");
			System.exit(0);
		}
		else{
			_state = 0;
		}
	}
}
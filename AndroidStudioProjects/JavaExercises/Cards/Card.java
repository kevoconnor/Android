public class Card{

	private int rank;
	private String suit;

	public Card(int num, String type){
		rank = num;
		suit = type;
	}

	public int getRank(){
		return rank;
	}

	public String getSuit(){
		return suit;
	}

}

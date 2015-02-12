//Exercise 1 in Classes

public class CardTester{

	public static void main(String [] args){
		Card ten = new Card(10, "Hearts");
		System.out.println("This card is a " + ten.getRank() + " of " + ten.getSuit());
	}

}

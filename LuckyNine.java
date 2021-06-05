import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Player{
	int number;
	int hands[]=new int[3];
	boolean requestCard= false;
	int totalHands = 0;
	
	@Override
	public String toString() {
		return "Player hands=" + Arrays.toString(hands) ;
	}

	void drawCard(int card, int index){
		hands[index]=card;
		
		
		computeTotalHands(card);
		
	}
	
	
	int computeTotalHands(int total){
			
		 totalHands+=total;
		 if (totalHands>=10 ){
			 totalHands=totalHands-10;
			
			 		
		 }
		 return totalHands;
	}
	void showHands(){
		System.out.println("Player: "+(number+1));
		System.out.println(toString());
		System.out.println("Request Card?: "+ requestCard);
		
		System.out.println("Total Hands: "+totalHands);
		System.out.println();
	}
}

class Card{
	
	int card[]= new int[40];
	
	int[] generateCard(){
		int x=0;
		for(int i=0; i<40; i++){
			
			if(i%4==0){
				x++;
			}
			card[i]=x;
		}
		return card;
	}
	
	int[] shuffleCard(int[] card){
		Random rnd = ThreadLocalRandom.current();
		for(int i=0; i<40;i++){
			int index = rnd.nextInt(i+1);
				
			int a = card[index];
			card[index]=card[i];
			card[i]=a;
		}
		return card;
	}
	
}

class Table{
	Player[] player;
	int card[] = new int[40];
	int index = 39;

	void startGame(){
		
		//generate number of player(2-5Players)
		int participant = ThreadLocalRandom.current().nextInt((5-2)+1)+2;
		System.out.println("Number of Player: "+participant);
		
		Card card = new Card();
		player = new Player[participant];
		for(int i=0;i<participant;i++){
			player[i] = new Player();
			player[i].number = i;
			
		}
		int[] deck = card.generateCard();
		deck = card.shuffleCard(deck);
		
		//distribute card 2 card each
		for(int i=0; i<participant;i++){
			for(int j=0;j<2;j++){
				player[i].drawCard(deck[index], j);			
				index--;
			}
			
		}
		//request card
		for(int i=0; i<participant;i++){
			if(player[i].totalHands<6){
				player[i].drawCard(deck[index], 2);		
				player[i].requestCard = true;
			}else{
				player[i].drawCard(0, 2);		
			}
		}

		//showcard
		for(int i=0; i<participant;i++){
			player[i].showHands();
		}

	}
}
public class LuckyNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table table= new Table();
		System.out.println("Lucky 9 ");
		System.out.println();
		table.startGame();
	}

}

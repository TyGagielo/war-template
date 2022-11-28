import java.util.*;

/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    
    private ArrayList<Card> battlingCards = new ArrayList<Card>();
    
    private Deck mainD;
    private Deck[] hands;
    
    public War()
    {
        // Initializations here...
        mainD = new Deck();
        
        mainD.initializeNewDeck();
        
        mainD.shuffle();
        
        hands = mainD.dealDeck();
        
        // ...then run the event loop
        this.runEventLoop(1);
        
        System.out.println("after:");
        
        System.out.println("Player 1's deck size - " + hands[0].getDeckSize());
        System.out.println("Player 2's deck size - " + hands[1].getDeckSize());
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(int loops) {
        //while Loop test 1
        
        int loopNum = 1;
        
        while (hands[0].getDeckSize() != 0 && hands[1].getDeckSize() != 0 && loopNum <= 3000){
            // adds cards to the array and appends the winner
            
            System.out.println("Battle #" + loopNum);
            
            if(hands[0].getCard().getRank() > hands[1].getCard().getRank()){
                
                System.out.println("Player 1's card, "+hands[0].getCard().getFace()+" of "+hands[0].getCard().getSuit()+", is greater than Player 2's card, "+hands[1].getCard().getFace()+" of "+hands[1].getCard().getSuit()+".");
                
                addCardsToCardAdder();
               
                hands[0].addCardGroup(battlingCards);
                
                arrayListClear(battlingCards);
                
            } else{
                if(hands[1].getCard().getRank() > hands[0].getCard().getRank()){
                    
                    System.out.println("Player 2's card, "+hands[1].getCard().getFace()+" of "+hands[1].getCard().getSuit()+", is greater than Player 1's card, "+hands[0].getCard().getFace()+" of "+hands[0].getCard().getSuit()+".");
                    
                    addCardsToCardAdder();
                    
                    hands[1].addCardGroup(battlingCards);
                    
                    arrayListClear(battlingCards);
                    
                } else{                
                    
                    System.out.println("It's time to d-d-d-d d-d-d- DUUUEEELLL!!!");
                    
                    for (int i = 0; i < 2; i++){
                        
                        addCardsToCardAdder();
                    }
                }
            }
            
            loopNum++;
            
            System.out.println();
        }
        
        
        if (hands[0].getDeckSize() == 0 || hands[0].getDeckSize() < hands[1].getDeckSize()){
            //p;ayer[0] win
            System.out.println("Player 2 WINS");
        }
        if (hands[1].getDeckSize() == 0 || hands[1].getDeckSize() < hands[0].getDeckSize()){
            //p;ayer[1] win
            System.out.println("Player 1 WINS");
        }
    }
    
    /**
     * Adds cards to an arrayList and removes them
     */
    public void addCardsToCardAdder(){
        battlingCards.add(hands[1].dealCardFromDeck());
        battlingCards.add(hands[0].dealCardFromDeck());
    }
    
    /**
     * Removes all Cards in an arrayList
     */
    public void arrayListClear(ArrayList<Card> full){
        
        int maxSize = full.size();
        
        for (int i = 0; i < maxSize; i++){
            
            full.remove(0);
        }
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}

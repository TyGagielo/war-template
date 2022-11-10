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
        
        hands = mainD.dealDeck();
        
        System.out.println("before:");
        System.out.println(hands[0].getDeckSize());
        System.out.println(hands[1].getDeckSize());
        // ...then run the event loop
        this.runEventLoop();
        
        System.out.println("after:");
        
        System.out.println(hands[0].getDeckSize());
        System.out.println(hands[1].getDeckSize());
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        // adds cards to the array and appends the winner
        if(hands[0].getCard().getRank() > hands[1].getCard().getRank()){
            
            addCardsToCardAdder();
           
            hands[0].addCardGroup(battlingCards);
               
        } else{
            if(hands[1].getCard().getRank() > hands[0].getCard().getRank()){
                
                addCardsToCardAdder();
                
                hands[1].addCardGroup(battlingCards);
            } else{
                
                //WAR STARTS
            }
        }
        
        if (hands[0].getDeckSize() == 0){
            //p;ayer[0] win
        }
        if (hands[1].getDeckSize() == 0){
            //p;ayer[1] win
        }
    }
    
    public void addCardsToCardAdder(){
        battlingCards.add(hands[1].dealCardFromDeck());
        battlingCards.add(hands[1].dealCardFromDeck());
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}

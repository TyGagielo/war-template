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
    
    private Deck mainD;
        
    public War()
    {
        // Initializations here...
        mainD = new Deck();
        
        mainD.initializeNewDeck();
        
        Deck[] hands = mainD.dealDeck();
        
        System.out.println(hands[0].getDeckSize());
        System.out.println(hands[1].getDeckSize());
        // ...then run the event loop
        //this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
         ArrayList<Card> battlingCards = new ArrayList<Card>();
         
         if(mainD.hands[1].cards.get(mainD.hands[1].cards.size()-1) > mainD.hands[0].get(mainD.hands[0].cards.size()-1)){
             
             battlingCards.add(Deck.hands[1].cards.get(this.cards.size-1));
                 
         } else{
             if (Deck.halves[1].cards.get(this.cards.size-1) > Deck.hands[0].get(this.cards.size-1)){
                 
                 battlingCards.add(Deck.hands[1].cards.get(this.cards.size-1));
                 
                 
                 
             }
         }
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}

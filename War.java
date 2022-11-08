
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
    public War()
    {
        // Initializations here...
        Deck mainD = new Deck();
        
        mainD.initializeNewDeck();
        
        Deck[] hands = mainD.dealDeck();
        
        System.out.println(hands[0].getDeckSize());
        System.out.println(hands[1].getDeckSize());
        // ...then run the event loop
        //this.runEventLoop();
    }
    
    /**
     * deletes cards from both decks
     */
    public void deleteCards(Card c){
        
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
         
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}

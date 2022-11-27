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
        this.runEventLoop(1);
        
        System.out.println("after:");
        
        System.out.println(hands[0].getDeckSize());
        System.out.println(hands[1].getDeckSize());
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(int loops) {
        //while Loop test 1
        
        int loopNum = 1;
        
        while (hands[0].getDeckSize() != 0 && hands[1].getDeckSize() != 0 && hands[0].getDeckSize()+hands[1].getDeckSize() <= 54){
            // adds cards to the array and appends the winner
            
            if(hands[0].getCard().getRank() > hands[1].getCard().getRank()){
                
                addCardsToCardAdder();
               
                hands[0].addCardGroup(battlingCards);
                
                arrayListClear(battlingCards);
                
                //see where extra cards come from
                System.out.println("Size After Addition:");
                System.out.println(hands[0].getDeckSize());
                System.out.println(hands[1].getDeckSize());
                
            } else{
                if(hands[1].getCard().getRank() > hands[0].getCard().getRank()){
                    
                    addCardsToCardAdder();
                    
                    hands[1].addCardGroup(battlingCards);
                    
                    arrayListClear(battlingCards);
                    
                    //see where extra cards come from
                    System.out.println("Size After Addition:");
                    System.out.println(hands[0].getDeckSize());
                    System.out.println(hands[1].getDeckSize());
                    
                } else{                
                    for (int i = 0; i < 2; i++){
                        
                        addCardsToCardAdder();
                    }
                }
            }
            
            System.out.println("Battle #" + loopNum);
            loopNum++;
        }
        
        
        if (hands[0].getDeckSize() == 0){
            //p;ayer[0] win
            System.out.println("Player 1 WINS");
        }
        if (hands[1].getDeckSize() == 0){
            //p;ayer[1] win
            System.out.println("Player 2 WINS");
        }
    }
    
    /**
     * Adds cards to an arrayList and removes them
     */
    public void addCardsToCardAdder(){
        battlingCards.add(hands[1].dealCardFromDeck());
        battlingCards.add(hands[0].dealCardFromDeck());
        
        //make sure deletion's doing its fuking job
        System.out.println("Size After Deletion:");
        System.out.println(hands[0].getDeckSize());
        System.out.println(hands[1].getDeckSize());
    }
    
    /**
     * Removes all Cards in an arrayList
     */
    public void arrayListClear(ArrayList<Card> full){
        for (int i = 0; i <= full.size(); i++){
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

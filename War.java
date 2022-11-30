import java.util.*;
import java.util.Date;

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
        this.runEventLoop(500);
        
        System.out.println("after:");
        
        printHandsSizes();
    }
    
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(int ms) {
        //while Loop test 1
        int loopNum = 1;
        
        
        while (hands[0].getDeckSize() != 0 && hands[1].getDeckSize() != 0 && loopNum <= 300){
            
            if(hands[0].getCard().getRank() > hands[1].getCard().getRank()){
                
                System.out.println("Battle #" + loopNum);
                System.out.println("Player 1's card, "
                                    +hands[0].getCard().getFace()+" of "
                                    +hands[0].getCard().getSuit()
                                    +", is greater than Player 2's card, "
                                    +hands[1].getCard().getFace()+" of "
                                    +hands[1].getCard().getSuit()+".");
                
                //adds top cards from both hands to battlingCards arraylist
                addCardsToCardAdder(); 
                
                //adds battlingCards to winning hand
                hands[0].addCardGroup(battlingCards);
                
                //clear battlingCards
                arrayListClear(battlingCards);
                
                //print
                printHandsSizes();
                loopNum++;
                
            } else{
                if(hands[1].getCard().getRank() > hands[0].getCard().getRank()){
                    
                    System.out.println("Battle #" + loopNum);
                    System.out.println("Player 2's card, "
                                        +hands[1].getCard().getFace()+" of "
                                        +hands[1].getCard().getSuit()
                                        +", is greater than Player 1's card, "
                                        +hands[0].getCard().getFace()+" of "
                                        +hands[0].getCard().getSuit()+".");
                    
                    //adds top cards from both hands to battlingCards arraylist
                    addCardsToCardAdder();
                    
                    //adds battlingCards to winning hand
                    hands[1].addCardGroup(battlingCards);
                    
                    //clear battlingCards
                    arrayListClear(battlingCards);
                    
                    //print
                    printHandsSizes();
                    loopNum++;
                    
                } else{
                    
                    System.out.println("It's time to d-d-d- DUEEEL!!!");
                    
                    //num of times the loop runs 
                    int loops = 2;
                    if (hands[0].getDeckSize() < loops || hands[1].getDeckSize() < loops){
                        loops--;
                    }
                    
                    
                    for (int i = 0; i < loops; i++){
                        
                        addCardsToCardAdder();
                        //print
                        System.out.println(i+1);
                        
                    }
                    System.out.println("3");
                }
            }
            
            System.out.println();
            //delay
            try{
                Thread.sleep(ms);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            
        }
        
        checkForWinner();
    }
    
    
    /**
     * chooses a winner
     */
    public void checkForWinner(){
        if (hands[0].getDeckSize() == 0 || hands[0].getDeckSize() < hands[1].getDeckSize()){
            //p;ayer[0] win
            System.out.println("Player 2 WINS");
            
            hands[1].addCardGroup(battlingCards);
            
        }
        else if (hands[1].getDeckSize() == 0 || hands[1].getDeckSize() < hands[0].getDeckSize()){
            //p;ayer[1] win
            System.out.println("Player 1 WINS");
            
            hands[0].addCardGroup(battlingCards);
            
        } else{
            System.out.println("It's a TIE. Nobody wins");
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
     * prints the sizes of both hands
     */
    public void printHandsSizes(){
        System.out.println("Player 1's deck size - " + hands[0].getDeckSize());
        System.out.println("Player 2's deck size - " + hands[1].getDeckSize());
    }
    
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }
}

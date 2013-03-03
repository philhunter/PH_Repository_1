/*
 * Author: Phil Hunter
 * Date: 28/9/12
 * Goal: Create cards for the Deck
 */
package practingprogramming;
import javax.swing.ImageIcon;

public class CARD {
    private int value;
    private String suite, rank;
    private int x;
    private int y;
    private ImageIcon image;    
    
    public CARD(String suite, String rank, int value, ImageIcon image){
    
        this.suite = suite;
        this.rank = rank;
        this.value = value;
        this.image = image;
    
    }
    
    public String getSuite(){
        return suite;
    }
    public String getRank(){
        return this.rank;
    }
    public int getValue(){
        return this.value;
    }
    public ImageIcon getImage(){
        return this.image;
    }   
    private enum suite{
        HEARTS, DIAMONDS, CLUBS, SPADES;
    }    
    private enum rank{
            TWO,
	    THREE,
	    FOUR,
	    FIVE,
	    SIX,
	    SEVEN,
	    EIGHT,
	    NINE,
	    TEN,
	    JACK,
	    QUEEN,
	    KING,
	    ACE;
    }
}

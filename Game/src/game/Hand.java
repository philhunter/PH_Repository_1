/*
 * Author: Phil Hunter
 * Date: 28/9/12
 * Goal: Create a hand from the deck
 */
package game;

public class Hand {
    
    private Card[] theDeck, theHand;
    private Deck deck;
    private Card card;
    private int cardNumber, compCardNumber, handValue;
    
    public HAND(CARD[] theeDeck){
        
        cardNumber=0;
        handValue=0;
        compCardNumber=0;
        
        theHand = new CARD[cardNumber];
        this.theDeck = theeDeck;

    }
    public HAND(){
    
    }
    public CARD getHandCard(){
        
        card = theDeck[cardNumber-1];
        return card;
        
    }
    
    public CARD[] getHand(){
        
        return theHand;
    }
    public int getHandValue(){
        
        int temp = 0;
        
        for (int i=0; i<cardNumber; i++ )
            temp = temp + theHand[i].getValue();
        
        handValue = temp;
        return handValue;
    }
    public void addCard(){
        
        cardNumber++;
        
        CARD tempArray[] = new CARD[cardNumber];
        for(int i=0; i<cardNumber; i++){
            tempArray[i] = theDeck[i];
            
        }
        
        theHand=tempArray;
        
    }
    public int getCardNumber(){
        return this.cardNumber;
    }
    
}

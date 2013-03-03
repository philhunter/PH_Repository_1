/*
 * Author: Phil Hunter
 * Date: 28/9/12
 * Goal: Create a deck of card objects
 */
package practingprogramming;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.ImageIcon;

public class DECK {
    
    private int numCards;
    private CARD card;
    private CARD[] theDeck;
    private String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
    private String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    private int[] value = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 }; 
    private ImageIcon C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20;
    private ImageIcon C21,C22,C23,C24,C25,C26,C27,C28,C29,C30,C31,C32,C33,C34,C35,C36,C37,C38,C39,C40;
    private ImageIcon C41,C42,C43,C44,C45,C46,C47,C48,C49,C50,C51,C52;
    private ImageIcon[] imageArray= { C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21,C22,C23,C24,C25,C26,C27,C28,C29,C30,C31,C32,C33,C34,C35,C36,C37,C38,C39,C40,C41,C42,C43,C44,C45,C46,C47,C48,C49,C50,C51,C52};
    
    public DECK(){
        
        //declares imageIcon array of 52 imageIcons
        imageArray = new ImageIcon[52];
        
        int SUITS = suit.length;
        int RANKS = rank.length;
        int N = SUITS * RANKS;
        
        //Creates a deck of 52 CARD objects
        theDeck = new CARD[N];

        for (int k = 0; k < N; k++){
            
            String temp = Integer.toString(k);
            imageArray[k] = new ImageIcon("/Users/philhunter/NetBeansProjects/PractingProgramming/src/Resources/" + temp + ".png");

        }
        
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                card = new CARD(suit[j], rank[i], value[i], imageArray[SUITS*i + j]);
                theDeck[SUITS*i + j] = card;
            }
        }

        // shuffle deck
        for (int i = 0; i < N; i++) {
            int r = i + (int) (Math.random() * (N-i));
            CARD tempCard = theDeck[r];
            theDeck[r] = theDeck[i];
            theDeck[i] = tempCard;
        }
        
    }
    public CARD[] getDeck(){
            
            return theDeck;
    }
    public void printDeck(){
        
        int SUITS = suit.length;
        int RANKS = rank.length;
        int N = SUITS * RANKS;
        
        // print shuffled deck
        for (int i = 0; i < N; i++) {
            System.out.println("suite: " + theDeck[i].getSuite());
            System.out.println("value: " + theDeck[i].getValue());
            System.out.println("rank: " + theDeck[i].getRank());
            System.out.println("iteration: "+i);
            System.out.println("");
        }
    }
}//end DECK

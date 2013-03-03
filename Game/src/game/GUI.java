/*
 * Author: Phil Hunter
 * Date: 26/9/12
 * Goal: Create GUI for BlackJack game
 */
package practingprogramming;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * 
 */
public class GUI implements ActionListener {

    private static GUI gui;
    private static JFrame frame;
    private static JPanel topPanel, bottomPanel, leftPanel, rightPanel, userPanel, compPanel, userBPanel, compBPanel;
    private static JButton hitButton, stickButton, startButton;
    private static ImageIcon deckIcon, CC, image1, image2, image3, image4, image5;
    private static JLabel iconLabel, iconLabel2, logoLabel, card1Label, card2Label, card3Label, card4Label, card5Label, labelWinLose;
    
    private static String suite, human, comp;
    private static int value;
    
    private CARD card1,card2,card3,card4,card5;
    private static DECK deck, compDeck;
    private static CARD[] theDeck, theHand, theCompDeck;
    private static HAND userHand, compHand;
    public static String newline = System.getProperty("line.separator");
    
    public static void main(String[] args) throws IOException {
        // Create the GUI for the card game
        // Create a new deck of cards and deal a hand
        // Start the new game
        gui = new GUI();
        //gui.createGUI();
        gui.startButtonClick();
        System.out.println("main setup complete");
        
    }
    private void startButtonClick(){
        
        gui = new GUI();
        gui.createGUI();
        gui.newGame();
        System.out.println("main setup complete");
        //playAgain();
        //newGame();
        
    }
    private void createGUI() {
        
        //Create frame
        frame = new JFrame("BlackJack");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add topPanel
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600,100));
        topPanel.setBackground(Color.blue);
        frame.add(topPanel, BorderLayout.NORTH);
        
        //Add bottomPanel
        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(600,50));
        bottomPanel.setBackground(Color.black);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        //Add leftPanel
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300,350));
        leftPanel.setBackground(Color.black);
        frame.add(leftPanel, BorderLayout.WEST);
        
        //Add rightPanel
        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(300,350));
        rightPanel.setBackground(Color.black);
        frame.add(rightPanel, BorderLayout.EAST);
        
        //Add userPanel and userBPanel
        userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(300,250));
        userPanel.setBackground(Color.green);
        userPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        leftPanel.add(userPanel);
        
        userBPanel = new JPanel();
        userBPanel.setPreferredSize(new Dimension(300,50));
        userBPanel.setLayout(new FlowLayout());
        userBPanel.setBackground(Color.blue);
        userBPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        leftPanel.add(userBPanel);

        //Add compPanel and compBPanel
        compPanel = new JPanel();
        compPanel.setPreferredSize(new Dimension(300,250));
        compPanel.setBackground(Color.green);
        compPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        rightPanel.add(compPanel);
        
        compBPanel = new JPanel();
        compBPanel.setPreferredSize(new Dimension(300,50));
        compBPanel.setLayout(new FlowLayout());
        compBPanel.setBackground(Color.blue);
        compBPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        rightPanel.add(compBPanel);
               
        //Create buttons for Panels
        hitButton = new JButton("Hit");
        stickButton = new JButton("Stick");
        startButton = new JButton("Play Again");
        hitButton.setEnabled(true);
        stickButton.setEnabled(true);
        startButton.setEnabled(true);
        startButton.hide();
        userBPanel.add(hitButton);
        userBPanel.add(stickButton);
        bottomPanel.add(startButton);
        
        //Add ActionListeners
        hitButton.addActionListener (this);
        stickButton.addActionListener (this);
        startButton.addActionListener (this);
        
        //Creates DeckImage and Logo as JLabel and adds it to topPanel
        Font font = new Font("Serif", Font.BOLD, 30);
        deckIcon = new ImageIcon("/Users/philhunter/NetBeansProjects/PractingProgramming/src/Resources/ph_deck.png");
        iconLabel = new JLabel(deckIcon, JLabel.LEFT);
        labelWinLose = new JLabel();
        labelWinLose.setFont(font);
        labelWinLose.setText("");
        topPanel.add(iconLabel);
        compBPanel.add(labelWinLose);
        labelWinLose.hide();
        
        logoLabel = new JLabel("BLACKJACK");
        logoLabel.setFont(font);
        logoLabel.setSize(150,150);
        logoLabel.setBackground(Color.blue);
        topPanel.add(logoLabel);
        
        frame.show();
        frame.pack();
        
    }
    
    private void newGame(){
        
        //creates deck of cards to use
        deck = new DECK();
        theDeck = deck.getDeck();
        compDeck = new DECK();
        theCompDeck = compDeck.getDeck();
        
        //Creates a new hand of 2 cards from the deck and displays them
        userHand = new HAND(theDeck);
        hitButtonClick(userHand, "human");
        hitButtonClick(userHand, "human");
        
        //Creates a new computer hand of 2 cards from the deck and displays them
        compHand = new HAND(theCompDeck);
        hitButtonClick(compHand, "comp");
        hitButtonClick(compHand, "comp");
        
        labelWinLose.hide();
        startButton.hide();
    }
    
    private void hitButtonClick(HAND hand, String user){
        
        
        hand.addCard();
        if (hand.getCardNumber() == 1){
            card1 = hand.getHandCard();
            image1 = new ImageIcon();
            image1 = card1.getImage();
            card1Label = new JLabel(image1, JLabel.LEFT);
            if (user == "human"){
                userPanel.add(card1Label);
            }
            else{
                compPanel.add(card1Label);
            }
            card1Label.setText("");
            System.out.println("card1: " + card1.getValue());
        }
        else if(hand.getCardNumber() ==2){    
            card2 = hand.getHandCard();
            image2 = new ImageIcon();
            image2 = card2.getImage();
            card2Label = new JLabel(image2, JLabel.LEFT);
            
            if (user == "human"){
                userPanel.add(card2Label);
            }
            else{
                compPanel.add(card2Label);
            }           
            card2Label.setText("");
            System.out.println("card2: " + card2.getValue());
        }
        else if (hand.getCardNumber() == 3){
            card3 = hand.getHandCard();
            image3 = new ImageIcon();
            image3 = card3.getImage();
            card3Label = new JLabel(image3, JLabel.LEFT);
            if (user == "human"){
                userPanel.add(card3Label);
            }
            else{
                compPanel.add(card3Label);
            }            
            card3Label.setText("");
            System.out.println("card3: " + card3.getValue());
        }
        else if (hand.getCardNumber() == 4){
            card4 = hand.getHandCard();
            image4 = new ImageIcon();
            image4 = card4.getImage();
            card4Label = new JLabel(image4, JLabel.LEFT);
            if (user == "human"){
                userPanel.add(card4Label);
            }
            else{
                compPanel.add(card4Label);
            }
            card4Label.setText("");
            System.out.println("card4: " + card4.getValue());
        }
        else if (hand.getCardNumber() == 5){
            card5 = hand.getHandCard();
            image5 = new ImageIcon();
            image5 = card5.getImage();
            card5Label = new JLabel(image5, JLabel.LEFT);
            if (user == "human"){
                userPanel.add(card5Label);
            }
            else{
                compPanel.add(card5Label);
            }
            userPanel.add(card5Label);
            card5Label.setText("");
            System.out.println("card5: " + card5.getValue());
        }
        
        if (userHand.getHandValue() > 21){
            stickButtonClick();
        }
    }
    
    private void stickButtonClick(){
        
        if(userHand.getHandValue() > compHand.getHandValue() && userHand.getHandValue() < 22){
            labelWinLose.show();
            labelWinLose.setText("WIN!!");
            hitButton.setEnabled(false);
            stickButton.setEnabled(false);
            startButton.show();
        }
        else{
            labelWinLose.show();
            labelWinLose.setText("LOSE..");            
            hitButton.setEnabled(false);
            stickButton.setEnabled(false);
            startButton.show();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == hitButton){
            gui.hitButtonClick(userHand, "human");
        }
        else if(ae.getSource() == stickButton){
            gui.stickButtonClick();
        }
        if(ae.getSource() == startButton){
            gui.startButtonClick();
        }
    }
    

}//end GUI

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author philhunter
 */
public abstract class GameObject {

    /**
     * @param args the command line arguments
     */
    public abstract void draw();
    
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        
        Player player1 = new Player();
        
        Dealer dealer = new Dealer();
        
        Hand hand = new Hand();
        
        GameObject[] gameObjects = new GameObject[2];
        gameObjects[0] = player1;
        gameObjects[1] = dealer;
        
        for (GameObject obj : gameObjects){
            obj.draw();
        }
        
    }
}

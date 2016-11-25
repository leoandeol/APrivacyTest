/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aprivacytest;

/**
 *
 * @author Léo Andéol
 */
public class APrivacyTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread monThread = new Thread(() -> { System.out.println("Mon traitement"); });
        monThread.start();
    }
    
}

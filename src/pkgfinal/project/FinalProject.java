package pkgfinal.project;

import DLibX.DConsole;
import java.awt.Color;
import java.awt.Font;
import java.util.*;

public class FinalProject {

    public static Random randGen = new Random();

    public static void main(String[] args) {
        DConsole dc = new DConsole(1200, 800); //Initializing consoles and array lists
        int gamestarted = 0; //int to keep repeating loading screen
        int highlightednew = 0; //when u scroll over newgame
        int highlightedload = 0; //when you scroll over load game
        int highlightedquit = 0; //when you scroll over quit
        int mousex = 0;
        int mousey = 0;

        ArrayList<Structure> structs = null;

        Player player = new Player(0, 0);
        //Replace with the actual list of structures
        //structs = levels.get(currentLevel).getStructures();

        System.out.println("Enter the name of a save file, or NEW, to start a new game.");

        //setting up background
        while (gamestarted == 0) {

            mousex = dc.getMouseXPosition();
            mousey = dc.getMouseYPosition();

            dc.setOrigin(DConsole.ORIGIN_TOP_LEFT); //background
            dc.setPaint(Color.RED);
            dc.fillRect(0, 0, 1200, 800);

            dc.setOrigin(DConsole.ORIGIN_CENTER); //Text Display
            dc.setPaint(Color.BLACK);
            dc.setFont(new Font("Arial", Font.BOLD, 50));
            dc.drawString("Adventure Quest: The Wandering", 600, 100); //generic cringe title for game

            if (mousex >= 490 && mousex <= 710 && mousey >= 385 && mousey <= 435) {
                highlightednew = 1;
            } else {
                highlightednew = 0;
            }

            if (mousex >= 490 && mousex <= 710 && mousey >= 485 && mousey <= 535) {
                highlightedload = 1;
            } else {
                highlightedload = 0;
            }

            if (highlightednew == 0) { //if mouse isnt over new game its normal

                dc.setPaint(Color.CYAN);
                dc.fillRect(600, 410, 220, 50);

                dc.setOrigin(DConsole.ORIGIN_CENTER);
                dc.setPaint(Color.BLACK);
                dc.setFont(new Font("Arial", Font.PLAIN, 40));
                dc.drawString("New Game", 600, 400);

            } else {
                dc.setPaint(Color.CYAN);
                dc.fillRect(600, 410, 240, 60);

                dc.setOrigin(DConsole.ORIGIN_CENTER);
                dc.setPaint(Color.BLACK);
                dc.setFont(new Font("Arial", Font.BOLD, 42));
                dc.drawString("New Game", 600, 400);
            }

            if (highlightedload == 0) { //if mouse isn't over load game its normal
                dc.setPaint(Color.CYAN);
                dc.fillRect(600, 510, 220, 50);

                dc.setPaint(Color.BLACK);
                dc.setFont(new Font("Arial", Font.PLAIN, 40));
                dc.drawString("Load Game", 600, 500);

            } else {
                dc.setPaint(Color.CYAN);
                dc.fillRect(600, 510, 240, 60);

                dc.setPaint(Color.BLACK);
                dc.setFont(new Font("Arial", Font.BOLD, 42));
                dc.drawString("Load Game", 600, 500);

            }
            dc.redraw();
        }
        
        
        while (player.isAlive() && !dc.getKeyPress('k')) { //Check if player has died or killed self
            dc.redraw();
            dc.pause(10);
            dc.clear();
            dc.setOrigin(DConsole.ORIGIN_TOP_LEFT);

            player.gravityForce();
            player.frictionForce();

            player.setGrounded(false);
            /* for (Structure s : structs) {
                player.isTouchingStructure(s);

            }
            
            player.moveCommands(dc);

            for (Structure s : structs) {
                player.isTouchingStructure(s);

            }

            player.recordPrevValues();
            player.move();
            player.scroll();
            player.draw(dc);

            for (Structure s : structs) {
                s.draw(dc, player);
            }
             */
        }
    }
}

package pkgfinal.project;

//HEY LESTS ADD __________
//CUSTOM MOUSE CURSOR
import DLibX.DCanvas;
import DLibX.DConsole;
import java.awt.Color;
import java.awt.Font;
import java.util.*;

public class FinalProject {

    public static Random randGen = new Random();

    public static void main(String[] args) {
        while (true) {
            DConsole dc = new DConsole(1200, 800); //Initializing consoles and array lists
            int gamestarted = 0; //int to keep repeating loading screen
            int highlightednew = 0; //when u scroll over newgame
            int highlightedload = 0; //when you scroll over load game
            int highlightedquit = 0; //when you scroll over quit
            int mousex = 0;
            int mousey = 0;
            int loadgame = 0;

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
                dc.setFont(new Font("Times New Roman", Font.BOLD, 50));
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
                    dc.setFont(new Font("Times New Roman", Font.PLAIN, 40));
                    dc.drawString("New Game", 600, 400);

                } else {
                    dc.setPaint(Color.CYAN);
                    dc.fillRect(600, 410, 240, 60);

                    dc.setOrigin(DConsole.ORIGIN_CENTER);
                    dc.setPaint(Color.BLACK);
                    dc.setFont(new Font("Times New Roman", Font.BOLD, 42));
                    dc.drawString("New Game", 600, 400);
                }

                if (highlightedload == 0) { //if mouse isn't over load game its normal
                    dc.setPaint(Color.CYAN);
                    dc.fillRect(600, 510, 220, 50);

                    dc.setPaint(Color.BLACK);
                    dc.setFont(new Font("Times New Roman", Font.PLAIN, 40));
                    dc.drawString("Load Game", 600, 500);

                } else {
                    dc.setPaint(Color.CYAN);
                    dc.fillRect(600, 510, 240, 60);

                    dc.setPaint(Color.BLACK);
                    dc.setFont(new Font("Times New Roman", Font.BOLD, 42));
                    dc.drawString("Load Game", 600, 500);

                }

                dc.redraw();

                if (dc.isMouseButton(1) && highlightedload == 1) {
                    dc.clear();
                    gamestarted = 1; //Load
                    dc.redraw();
                }
                if (dc.isMouseButton(1) && highlightednew == 1) {
                    dc.clear();
                    gamestarted = 2;//New Game
                    dc.redraw();
                }
            }
            dc.setOrigin(DConsole.ORIGIN_TOP_LEFT);
            while (gamestarted == 2) { //New Game

                dc.setPaint(Color.RED);
                dc.fillRect(0, 0, 1200, 800);

                dc.setOrigin(DConsole.ORIGIN_CENTER);
                dc.setPaint(Color.BLACK);
                dc.setFont(new Font("Times New Roman", Font.BOLD, 50));
                dc.drawString("New Game", 600, 50);

                dc.setOrigin(DConsole.ORIGIN_TOP_LEFT);
                dc.setPaint(Color.CYAN);

                dc.fillRect(171, 320, 171, 160);
                //256, 400 is the middle

                dc.fillRect(513, 320, 171, 160);
                //598, 400

                dc.fillRect(855, 320, 171, 160);
                //940, 400

                dc.setOrigin(DConsole.ORIGIN_CENTER);
                dc.setPaint(Color.BLACK);
                dc.setFont(new Font("Times New Roman", Font.BOLD, 45));
                dc.drawString("Choose a Save File", 600, 700);

                dc.setPaint(Color.MAGENTA);
                dc.setFont(new Font("Arial", Font.PLAIN, 40));
                
                dc.drawString("Save1", 256, 390);
                dc.drawString("Save2", 598, 390);
                dc.drawString("Save3", 940, 390);

                dc.redraw();

            }

            while (gamestarted == 1) { //Load Game
                dc.setPaint(Color.RED);
                dc.fillRect(0, 0, 1200, 800);

                dc.redraw();
            }

            /*while (player.isAlive() && !dc.getKeyPress('k')) { //Check if player has died or killed self
            dc.redraw();
            dc.pause(10);
            dc.clear();
            dc.setOrigin(DConsole.ORIGIN_TOP_LEFT);

            player.gravityForce();
            player.frictionForce();

            player.setGrounded(false);
            for (Structure s : structs) {
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
             
        }*/
        }
    }
}

package pkgfinal.project;

import DLibX.DConsole;
import java.awt.Color;
import java.util.*;

public class FinalProject {

    public static Random randGen = new Random();


    public static void main(String[] args) {
        DConsole dc = new DConsole(1200, 800); //Initializing consoles and array lists
        int currentLevel = 0;

        ArrayList<Structure> structs = null;

        while (true) { //The main game loop containing all menues and the game
            if (dc.getKeyPress('q')) { //Command to exit program
                System.exit(0);
            }
            if (dc.getKeyPress('i')) { //Command to enter instructions
                while (!dc.getKeyPress('q')) { //Command to exit instructions
                    dc.redraw();
                    dc.pause(10);
                    dc.clear();
                    dc.setBackground(Color.BLACK);
                    dc.setOrigin(DConsole.ORIGIN_CENTER);
                    dc.setPaint(Color.WHITE);
                    dc.drawString("'WASD' for movement. Press 'k' to kill yourself.", 600, 300);
                    dc.drawString("Hold opposite to a wall on impact to wall jump.", 600, 350);
                    dc.drawString("You have a magnetic charge and will be pushed or pulled from magnets.", 600, 400);
                    dc.drawString("Pick up little blocks to gain or lose charge.", 600, 450);
                    dc.drawString("Press 'q' to go back.", 600, 600);
                    dc.setOrigin(DConsole.ORIGIN_TOP_LEFT);
                }
            }
            if (dc.getKeyPress('p')) { //Command to play game

                Player player = new Player(0, 0);
                //Replace with the actual list of structures
                //structs = levels.get(currentLevel).getStructures();

                dc.setBackground(Color.WHITE);
                while (player.isAlive() && !dc.getKeyPress('k')) { //Check if player has died or killed self
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
                    player.checkOutOfBounds();
                    player.draw(dc);

                    for (Structure s : structs) {
                        s.draw(dc);

                    }
                }
                dc.redraw();
                dc.pause(10);
                dc.clear();
                dc.setBackground(Color.BLACK);
                dc.setOrigin(DConsole.ORIGIN_CENTER);
                dc.setPaint(Color.WHITE);
                dc.drawString("Press 'i' for instructions.", 600, 300);
                dc.drawString("Press 'p' to play.", 600, 350);
                dc.drawString("Press 'q' to quit.", 600, 600);
                dc.setOrigin(DConsole.ORIGIN_TOP_LEFT);
            }
        }
    }
}

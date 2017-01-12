package pkgfinal.project;

import DLibX.DConsole;
import java.awt.Color;
import java.util.*;

public class FinalProject {

    public static Random randGen = new Random();

    public static void main(String[] args) {
        DConsole dc = new DConsole(1200, 800); //Initializing consoles and array lists

        ArrayList<Structure> structs = null;

        Player player = new Player(0, 0);
        //Replace with the actual list of structures
        //structs = levels.get(currentLevel).getStructures();

        System.out.println("Enter the name of a save file, or NEW, to start a new game.");

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
            player.scroll();
            player.draw(dc);

            for (Structure s : structs) {
                s.draw(dc, player);
            }
        }
    }
}

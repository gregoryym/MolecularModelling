package MoleculeKit;

import javax.swing.*;

public class main {

    public static void main(String[] args) {

        startupWindow();

        //Molecule molecule = new Molecule("Li4Cl3");
        //molecule.getAtoms();

    }

    //This is the first window that is opened. This is where a new molecule can be created
    private static void startupWindow() {
        //While loop continues to open the first window
        while (true) {

            //Creates a input box for user to enter a set of commands
            String command = JOptionPane.showInputDialog(null,"Enter a molecular formula or type HELP for more Options");
            if ( command == null ) { command = "exit"; }
            //if the user enters end then the program will end
            if (command.equalsIgnoreCase("END")) { break; }
            //if the user enters help a list of commands will pop up
            else if (command.equalsIgnoreCase("HELP")) { windowCommands(1); }
            //anything else will be considered a molecule and will run the molecule function
            else {; moleculeWindow(command); }

        }
    }

    //This function controls the molecule command window. Interaction between the molecule that the user created
    private static void moleculeWindow(String moleculeString) {

        Molecule molecule = new Molecule(moleculeString);
        //Creates a new molecule instance
        //while loop continues to open the molecule window
        while (true) {
            //creates an input box for the user to enter commands
            String command = JOptionPane.showInputDialog(null, "Type HELP for commands to interact with the molecule.");
            if (command == null) {command = "exit"; }
            //If the user enters NEW then it will break the user back to the previous window and they can enter a new molecule
            if (command.equalsIgnoreCase("NEW")) { break; }
            //If the user eneters HElp then a list of commands to interact with the molecule will pop up
            else if (command.equalsIgnoreCase("HELP")) { windowCommands(2);}
            //If the user enters END then the program will end
            else if (command.equalsIgnoreCase("END")) {break; }
            //If the user enters MOLECULE then a window with the entered molecule will pop up
            else if (command.equalsIgnoreCase("MOLECULE")) { JOptionPane.showMessageDialog(null, moleculeString);}
            //If the user enters LIST then it will pop up a list of the atoms in the molecule
            else if (command.equalsIgnoreCase("LIST")) {JOptionPane.showMessageDialog(null, molecule.getAtoms()); }
        }

    }

    //This method controls the help windows
    private static void windowCommands(int window) {
        //If the window is the first one then the help box that will pop up will deal with window 1 help
        /*
        MOLECULE - See the entered molecular formula
        HELP - List of commands
        END - Ends the current window
        LIST - A list of the atoms in the molecule
         */
        if (window == 1) {
            JOptionPane.showMessageDialog(null, "Type in a molecular formula to generate a molecule." +
                    "\nType HELP for a list of commands." +
                    "\nType END to end the program.");
        }
        //If the window is the second one then the help box that will pop up will deal with window 2 help
        else if (window == 2) {
            JOptionPane.showMessageDialog(null, "Type NEW to create a new molecule." +
                    "\nType LIST to list the atoms.\nType MOLECULE to see the entered molecular formula.");
        }

    }

}

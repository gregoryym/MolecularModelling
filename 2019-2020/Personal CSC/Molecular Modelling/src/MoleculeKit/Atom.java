//Started September 4th, 2019

package MoleculeKit;
import java.util.*;

/*
*   The Atom class simulates an atom. The Atom class calls for a given atomic Number
*   (number of protons) and from there the computer will fill in the other properties associated
*   with the given atomic number. Properties of atoms are held/can be found in the given variables
*   below. This is one of the lowest parts of the program.
*
*/

public class Atom extends Nucleus {

    /*
     * the  electronArray holds Electron objects in one container to be accessed during the
     * building of the orbitals
     */
    List<Electron> electronArray;

    //Hashmap Quantum holds the Orbitals where the electrons are held. The key is the subshell and the elements are the Electrons
    HashMap<String, List<Electron>> Quantum;

    /*
    * The charge variable holds the charge of the atom. The default charge of an atom
    * is zero unless specifically changed. A charged atom has unequal protons to electrons
    * This will have a effect when bonding two atoms together. The charge of the atom can
    * change after bonding. The atom can start off neutral and end up charged after bonding.
    */
    int charge = 0;

    //The number of Electrons variable holds the count of the electrons in the atom
    int numberOfElectrons;

    /*
    * The energyLevels variable holds the value of how many energy levels are in the atom. Each energy level
    * corresponds to a shell. The last energy level is the valance shell which will be the most important level
     */
    int energyLevels;

    //Sets the x, y, z position in 3 dimensional space - variables will be used in later versions
    int x, y, z;

    /*
    * Constructor class that runs when the class is initialized
    * This function will run all the initial calculations and functions needed for the atom to have the
    * correct properties
     */
    public Atom(int AtomicNumber, int x, int y, int z) {

        //Calls the Nucleus class
        super(AtomicNumber);
        numberOfElectrons = numberOfProtons;
        //Sets up the orbitals where the electrons will be housed
        setupOrbitals();

        Random ran = new Random();
        this.x = ran.nextInt(500);
        this.y = ran.nextInt(500);
        this.z = ran.nextInt(500);


    }

    public void setCharge(int charge) {

        this.charge = charge;
        numberOfElectrons = numberOfElectrons - charge;
        setupOrbitals();

    }

    //This function sets up the each electron in the orbitals of the atom
    private void setupOrbitals() {

        /*
        * The Hashmap of Quantum simulates the subshells of an atom.
        * Hard coded the subshells as the key and the value will be an array of Electrons
        * Each subshell can hold a different amount of electrons so by manipulating the string, it can be broken up into
        * each character to find the energy level {the first character} and the subshell {the second character}
        * Determining the max amount of electrons in each subshell depends on the second character in the string
        * Keeping track of the energy level will determine which subshell comes next.
         */
        Quantum = new HashMap<String, List<Electron>>();

        //Below are the subshells for the energy levels of the atom - Hard code the setup for the subshells
        //
        //This line of code contains the s-subshell for the energy levels. Condensed to one line for easy reading
        Quantum.put("1s", null); Quantum.put("2s", null); Quantum.put("3s", null); Quantum.put("4s", null); Quantum.put("5s", null); Quantum.put("6s", null); Quantum.put("7s", null);
        //This line of code contains the p-subshell for the energy levels. Condensed to one line for easy reading
        Quantum.put("2p", null); Quantum.put("3p", null); Quantum.put("4p", null); Quantum.put("5p", null); Quantum.put("6p", null); Quantum.put("7p", null);
        //This line of code contains the d-subshell for the energy levels. Condensed to one line for easy reading
        Quantum.put("3d", null); Quantum.put("4d", null); Quantum.put("5d", null); Quantum.put("6d", null);
        //This line of code contains the f-subshell for the energy levels. Condensed to one line for easy reading
        Quantum.put("4f", null); Quantum.put("5f", null);

        /*
        Keeps track of the current energy level for the 'for loop'. This variable helps to determine
        *how many electrons should go in the subshell and what subshell comes after
         */
        String currentSubshell = "s";
        //The current shell variable helps to see which energy level comes after
        int currentShell = 1;
        //This variable holds the value of the max amount of electrons that can go into the subshell
        int maxElectronsInSubShell = 2;

        int j = 0;
        int spin = +1;
        int[] mArray = new int[]{0};

        /*
        * For loop goes through the number of electrons to indiviually place them in a proper subshell.
        * Checks which energy level and how many electrons are currently in the subshell. If all is good,
        * electron is placed in the arrayList and the next electron is ready to be placed
         */
        for (int i = 0; i < numberOfElectrons; i++) {

            /*
            * Array list of electrons are initially set to null just to set up everything
            * This if statement checks to see if it is still in the initial state. If so then a new
            * Array list is placed in the quantum hashmap
            */
            if (Quantum.get(Integer.toString(currentShell) + currentSubshell) == null) {
                //adds a arraylist inside the hashmap quantum
               Quantum.put(Integer.toString(currentShell) + currentSubshell, new ArrayList<Electron>());
            }

            //Adds a new electron to the given energy level and subshell
            Quantum.get(Integer.toString(currentShell) + currentSubshell).add(new Electron(currentShell, currentSubshell));

            //The if statements below check to see if the orbital is filled with the max number of electrons

            //This if statement checks to see if the s orbital
            if (currentSubshell.contains("s")) {

                //checks to see the shell number and if the orbital is filled with the max number of electrons
                if (currentShell == 1 && Quantum.get(Integer.toString(currentShell) + currentSubshell).size() == maxElectronsInSubShell) {
                    //if the number of electrons are maxed then it moves to the next energy level
                    currentShell ++;
                }

                //If the energy level is 2 or 3 then s will go to the p orbital. Checks to see if the orbital is maxed
                else if (currentShell >= 2 && currentShell <= 3 && Quantum.get(Integer.toString(currentShell) + currentSubshell).size() == maxElectronsInSubShell) {
                    //replaces the s orbital to the p orbital. Changes the string
                    currentSubshell = currentSubshell.replace("s", "p");
                    //changes the max amount of electrons that can be stored. P can hold 6 electrons
                    maxElectronsInSubShell = 6;
                }

                //If the energy level is 4 or 5 then s will go the d orbital. Checks to see if the orbital is maxed
                else if (currentShell >= 4 && currentShell <= 5 && Quantum.get(Integer.toString(currentShell) + currentSubshell).size() == maxElectronsInSubShell) {
                    //changes the s orbital to the d orbital. Changes the string
                    currentSubshell = currentSubshell.replace("s", "d");
                    //the d orbital is one energy level lower so the current shell is subtracted by one
                    currentShell --;
                    //the d orbital can hold 10 electrons so the max number of electrons are changed
                    maxElectronsInSubShell = 10;
                }

                //if the energy level is 6 or 7 then s will go the f orbital. Checks to see if the orbital is maxed
                else if (currentShell >= 6 && currentShell <= 7 && (Quantum.get(Integer.toString(currentShell) + currentSubshell).size() == maxElectronsInSubShell)) {
                    //changes the s orbital to the f orbital. Changes the string
                    currentSubshell = currentSubshell.replace("s", "f");
                    //The f orbital is 2 energy levels below than the current shell so current shell is subtracted by 2
                    currentShell = currentShell - 2;
                    //the f orbital can hold 14 electrons
                    maxElectronsInSubShell = 14;
                }
            }

            /*
             * Array list of electrons are initially set to null just to set up everything
             * This if statement checks to see if it is still in the initial state. If so then a new
             * Array list is placed in the quantum hashmap
             */
            if (Quantum.get(Integer.toString(currentShell) + currentSubshell) == null) {
                //adds a arraylist inside the hashmap quantum
                Quantum.put(Integer.toString(currentShell) + currentSubshell, new ArrayList<Electron>());
            }

            //Checks to see if the orbital is already in the p
            if (currentSubshell.contains("p")) {

                //Checks to see if the orbital is maxed
                if (Quantum.get(Integer.toString(currentShell) + currentSubshell).size() == maxElectronsInSubShell) {
                    //If maxed then the program moves to the next energy level
                    currentShell ++;
                    //The p orbital goes to the s orbital. Changes the string
                    currentSubshell = currentSubshell.replace("p", "s");
                    //The s orbital can only hold 2 electrons
                    maxElectronsInSubShell = 2;
                }
            }

            //Checks to see if the orbital is already in the d
            if (currentSubshell.contains("d")) {

                //Checks to see if the orbital is maxed
                if (Quantum.get(Integer.toString(currentShell) + currentSubshell).size() == maxElectronsInSubShell) {
                    //If maxed then the program moves to the p orbital which is one energy level higher
                    currentShell ++;
                    //D moves to the P. String is replaced
                    currentSubshell = currentSubshell.replace("d", "p");
                    //The p orbital can hold 6 electrons
                    maxElectronsInSubShell = 6;
                }
            }

            //Checks to see if the orbital is already in the f
            if (currentSubshell.contains("f")) {

                //Checks to see if the orbital is maxed
                if (Quantum.get(Integer.toString(currentShell) + currentSubshell).size() == maxElectronsInSubShell) {
                    //If maxed then the f orbital moves to the d orbital which is 1 energy levels above
                    currentShell++;
                    //f orbital changes to the d orbital
                    currentSubshell = currentSubshell.replace("f", "d");
                    //the d orbital can hold 10 electrons
                    maxElectronsInSubShell = 10;
                }
            }

            //System.out.println(maxElectronsInSubShell);
            /*
            if (maxElectronsInSubShell == 2) { mArray = new int[]{0}; }
            else if (maxElectronsInSubShell == 6) { mArray = new int[]{-1, 0, 1}; }
            else if (maxElectronsInSubShell == 10) { mArray = new int[]{-2, -1, 0, 1, 2}; }
            else if (maxElectronsInSubShell == 14) { mArray = new int[]{-3, -2, -1, 0, 1, 2, 3}; }
            */


            if (j == (maxElectronsInSubShell/2) - 1) {
                j = 0;
                spin *= -1;
            }

            //System.out.print(currentShell);
            //System.out.println(currentSubshell);

            //System.out.println(j);
           // Quantum.get(currentShell + currentSubshell).get(i).m = mArray[j];
            //Quantum.get(currentShell + currentSubshell).get(i).s = spin;

            //j++;

        }

        energyLevels = currentShell - 1;

    }

    private void takeElectronFromOrbital(int AmountOfElectronsTaken) {

        int valanceShell = energyLevels;



    }

    //Function that prints out the electron configuration to the console
    public void returnOrbital() {

        //Checks to see if their are electrons in the orbital and if there are it prints the amount of electrons in the given orbital
        if (Quantum.get("1s") != null) { System.out.println("{1s: " + Quantum.get("1s").size() + "} "); }
        if (Quantum.get("2s") != null) { System.out.print("{2s: " + Quantum.get("2s").size() + "} "); } if (Quantum.get("2p") != null) { System.out.println("{2p: " + Quantum.get("2p").size() + "} "); }
        if (Quantum.get("3s") != null) { System.out.print("{3s: " + Quantum.get("3s").size() + "} "); } if (Quantum.get("3p") != null) { System.out.println("{3p: " + Quantum.get("3p").size() + "} "); }
        if (Quantum.get("4s") != null) { System.out.print("{4s: " + Quantum.get("4s").size() + "} "); } if (Quantum.get("3d") != null) { System.out.print("{3d: " + Quantum.get("3d").size() + "} "); } if (Quantum.get("4p") != null) { System.out.println("{4p: " + Quantum.get("4p").size() + "} "); }
        if (Quantum.get("5s") != null) { System.out.print("{5s: " + Quantum.get("5s").size() + "} "); } if (Quantum.get("4d") != null) { System.out.print("{4d: " + Quantum.get("4d").size() + "} "); } if (Quantum.get("5p") != null) { System.out.println("{5p: " + Quantum.get("5p").size() + "} "); }
        if (Quantum.get("6s") != null) { System.out.print("{6s: " + Quantum.get("6s").size() + "} "); } if (Quantum.get("4f") != null) { System.out.print("{4f: " + Quantum.get("4f").size() + "} "); } if (Quantum.get("5d") != null) { System.out.print("{5d: " + Quantum.get("5d").size() + "} "); } if (Quantum.get("6p") != null) { System.out.println("{6p: " + Quantum.get("6p").size() + "} "); }
        if (Quantum.get("7s") != null) { System.out.print("{7s: " + Quantum.get("7s").size() + "} "); } if (Quantum.get("5f") != null) { System.out.print("{5f: " + Quantum.get("5f").size() + "} "); } if (Quantum.get("6d") != null) { System.out.print("{6d: " + Quantum.get("6d").size() + "} "); } if (Quantum.get("7p") != null) { System.out.println("{7p: " + Quantum.get("7p").size() + "} "); }

    }

    //Method that returns the properties for that given atom
    public String[] returnProperties() {
        System.out.println("Name: " + name);
        System.out.println("Symbol: " + symbol);
        System.out.println("Atomic Number: " + AtomicNumber);
        System.out.println("Atomic Weight: " + AtomicWeight + " amu");
        System.out.println("Atomic Radius: " + radius + " pm");
        System.out.println("Electronegativity: " + electronegativity);
        System.out.println("First Ionization Energy: " + firstIonizationEnergy + " kJ/mol");
        System.out.print("Oxidation States: [");
        for (int i = 0; i < oxidationStates.length; i++) {
            if (i == oxidationStates.length - 1) { System.out.print(oxidationStates[i]); }
            else { System.out.print(oxidationStates[i] + ", "); }
        }
        System.out.print("]\n");

        //String array that holds the properties of the atom
        String [] properties = new String[]{

                "Element: " + name,
                "Atomic Symbol: " + symbol,
                "Atomic Number: " + String.valueOf(AtomicNumber),
                "Atomic Weight: " + String.valueOf(AtomicWeight) + "amu",
                "Mass: " + mass + "kg",
                "Atomic Radius: " + String.valueOf(radius) + "pm",
                "Electronegativity: " + String.valueOf(electronegativity),
                "First Ionziation Energy: " + String.valueOf(firstIonizationEnergy) + "kJ/mol",

        };

        return properties;

    }
}

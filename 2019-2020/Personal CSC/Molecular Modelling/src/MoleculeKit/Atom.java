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

public class Atom {

    /*
    * Most important variable of the Atom. Gives the amount of protons in the atom
    * which gives all the properties. Most of the other variables depends on this one variable
    */

    int atomicNumber;
    /*
    * Both variables holds the mass of the atom. The difference is in the units.
    * The atomicWeight variable holds the value with the units of AMU
    * The mass variable holds the value with the units of KG
    * The mass variable depends on the atomicWeight variable and a conversion factor
    */
    double atomicWeight, mass;
    /*
    * The charge variable holds the charge of the atom. The default charge of an atom
    * is zero unless specifically changed. A charged atom has unequal protons to electrons
    * This will have a effect when bonding two atoms together. The charge of the atom can
    * change after bonding. The atom can start off neutral and end up charged after bonding.
    */
    int charge = 0;
    //These three variables holds the amount of subatomic particles that are in the atom
    int numberOfProtons, numberOfElectrons, numberOfNeutrons;
    /*
    * the  electronArray holds Electron objects in one container to be accessed during the
    * building of the orbitals
     */
    List<Electron> electronArray;
    //Hashmap Quantum holds the Orbitals where the electrons are held. The key is the subshell and the elements are the Electrons
    HashMap<String, List<Electron>> Quantum;
    //Radius Variable that holds the size of the atom. The distance from the nucleus to the valance shell
    double radius;
    /*
    * electronegativity variable holds the double value of the electronegativity. The number
    * tells how likely the atom will attract other electrons when bonded to other atoms
    */
    double electronegativity;
    /*
    * The energyLevels variable holds the value of how many energy levels are in the atom. Each energy level
    * corresponds to a shell. The last energy level is the valance shell which will be the most important level
     */
    int energyLevels;
    /*
    * The Name variable holds the name of the element and the symbol will hold the atomic symbol
    * for the given element
    */
    String symbol, name;

    //Sets the x, y, z position in 3 dimensional space - variables will be used in later versions
    int x, y, z;

    /*
    * Constructor class that runs when the class is initialized
    * This function will run all the initial calculations and functions needed for the atom to have the
    * correct properties
     */
    public Atom() {

        setAtom(17);
        setupOrbitals();
    }

    /*
    * Tester Function until JSON file is created
    * This function is to set up a basic atom for testing the program
    * Once the JSON file is created the setAtom function will load the JSON file
    * The JSON file will contain all the information for all the atoms so the user can have access to all of them
    */
    public void setAtom(int atomicNumber) {

        if (atomicNumber == 1) {

            this.atomicNumber = 1;
            atomicWeight = 1.008;
            mass = atomicWeight * 1.66e-27;
            charge = 0;
            numberOfProtons = numberOfElectrons = atomicNumber;
            radius = 53 * 1e-12;
            symbol = "H";
            name = "Hydrogen";
            electronegativity = 1.8;


        }

        else if (atomicNumber == 17) {

            this.atomicNumber = 17;
            atomicWeight = 35.45;
            mass = atomicWeight * 1.66e-27;
            charge = 0;
            numberOfProtons = numberOfElectrons = atomicNumber;
            radius = 175 * 1e-12;
            symbol = "Cl";
            name = "Chlorine";
            electronegativity = 3.2;

        }
    }

    //This function sets up the each electron in the orbitals of the atom
    private void setupOrbitals() {

        /*
        * Establishes the array with the max number of the array being the amount of electrons that are given
        * in the beginning of the program
        */
        electronArray = new ArrayList<Electron>();

        //Iterates through the amount of electrons to place an electron object in the array of electrons
        for (int i = 0; i <= numberOfElectrons; i++) {

            /* Puts an electron object in the given index in the electron Array
            *  The electron array holds all of the electron objects
            */
            electronArray.add(new Electron());

        }

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
        String currentSubshell = "1s";
        //The current shell variable helps to see which energy level comes after
        int currentShell = 1;
        //This variable holds the value of the max amount of electrons that can go into the subshell
        int maxElectronsInSubShell;

        /*
        * For loop goes through the number of electrons to indiviually place them in a proper subshell.
        * Checks which energy level and how many electrons are currently in the subshell. If all is good,
        * electron is placed in the arrayList and the next electron is ready to be placed
         */
        for (int i = 0; i < numberOfElectrons; i++) {

            //If statement checks to see if it is the s-subshell
            if (currentSubshell.contains("s") == true) {
                maxElectronsInSubShell = 2;
            }
            //If statement checks to see if it is the p-subshell
            else if (currentSubshell.contains("p")) {
                maxElectronsInSubShell = 6;
            }
            //If statement checks to see if it is the d-subshell
            else if (currentSubshell.contains("d")) {
                maxElectronsInSubShell = 10;
            }
            //If statement checks to see if it is the f-subshell
            else if (currentSubshell.contains("f")) {
                maxElectronsInSubShell = 14;
            }

            /*
            * Array list of electrons are initially set to null just to set up everything
            * This if statement checks to see if it is still in the initial state. If so then a new
            * Array list is placed in the quantum hashmap
            */
            if (Quantum.get(currentSubshell) == null) {
                //adds a arraylist inside the hashmap quantum
               Quantum.put(currentSubshell, new ArrayList<Electron>());
            }

            /*
            * This if statement checks to see if the current subshell is full {max amount depends on the shell}
            * If the energy shell is not full, then an electron will be placed inside the subshell
            * If the subshell is full then the subshell will be changed to the next level and the electron will
            * be placed in the new one.
             */

            //this if statement checks to see if the subshell is s and max electrons are 2
            if (currentSubshell.contains("s") && Quantum.get(currentSubshell).size() <= 1) {
                //Adds a new Electron Object to the orbitals
                Quantum.get(currentSubshell).add(new Electron());
            }
            //this if statement checks to see if the subshell is p and max electrons are 6
            else if (currentSubshell.contains("p") && Quantum.get(currentSubshell).size() <= 5) {
                //Adds a new Electron Object to the orbitals
                Quantum.get(currentSubshell).add(new Electron());
            }
            //this if statement checks to see if the subshell is d and max electrons are 10
            else if (currentSubshell.contains("d") && Quantum.get(currentSubshell).size() <= 9) {
                //Adds a new Electron Object to the orbitals
                Quantum.get(currentSubshell).add(new Electron());
            }
            //this if statement checks to see if the subshell is f and max electrons are 14
            else if (currentSubshell.contains("f") && Quantum.get(currentSubshell).size() <= 13) {
                //Adds a new Electron Object to the orbitals
                Quantum.get(currentSubshell).add(new Electron());
            }

            //If the shell is full then the subshell will change to the next one and the electron will be placed in there
            else {
                //Checks to see if it is the s subshell
                if (currentSubshell.contains("s")) {
                    //replaces the s subshell to the p subshell
                    currentSubshell.replace("s", "p");
                }
                //Checks to see if it is the p subshell
                else if (currentSubshell.contains("p")) {
                    //replaces the p subshell to the d subshell
                    currentSubshell.replace("p", "d");
                }
                //Checks to see if it is the d subshell
                else if (currentSubshell.contains("d")) {
                    //replaces the d subshell to the p subshell
                    currentSubshell.replace("d", "f");
                }
                //checks to see if it is the f subshell
                else if (currentSubshell.contains("f")) {
                    //changes the shell number to the next level
                    currentSubshell.replace(Integer.toString(currentShell), Integer.toString(currentShell + 1));
                    //replaces the f subshell to the s subshell
                    currentSubshell.replace("f", "s");
                }
            }

        }

    }

    public void returnOrbital() {

        

    }
}

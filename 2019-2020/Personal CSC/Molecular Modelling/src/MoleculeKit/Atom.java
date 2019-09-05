package MoleculeKit;

import java.util.HashMap;

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
    //Radius Variable that holds the size of the atom. The distance from the nucleus to the valance shell
    double radius;
    /*
    * electronegativity variable holds the double value of the electronegativity. The number
    * tells how likely the atom will attract other electrons when bonded to other atoms
    */
    double electronegativity;

    /*
    * The Name variable holds the name of the element and the symbol will hold the atomic symbol
    * for the given element
    */
    String symbol, name;

    //Sets the x, y, z position in 3 dimensional space - variables will be used in later verisions
    int x, y, z;

    public Atom() {

    }

    //Tester Function until JSON file is created
    public void setAtom(String Name) {

        if (Name == "Hydrogen") {

            atomicNumber = 1;
            atomicWeight = 1.008;
            mass = atomicWeight * 1.66e-27;
            charge = 0;
            numberOfProtons = numberOfElectrons = atomicNumber;
            radius = 53 * 1e-12;
            symbol = "H";
            name = "Hydrogen";


        }

        else if (Name == "Chlorine") {

            atomicNumber = 17;
            atomicWeight = 35.45;
            mass = atomicWeight * 1.66e-27;
            charge = 0;
            numberOfProtons = numberOfElectrons = atomicNumber;
            radius = 175 * 1e-12;
            symbol = "Cl";
            name = "Chlorine";

        }
    }

    //This function sets up the each electron in the orbitals of the atom
    private void setupOrbitals() {

        HashMap<String, Integer> Quantum = new HashMap<>();

        for (int i = 0; i <= numberOfElectrons; i++) {
            Quantum.put("s1", 0);
            Quantum.put("s2", 0);
            Quantum.put("s3", 0);

        }

    }

}

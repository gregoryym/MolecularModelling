package MoleculeKit;

import java.lang.Character;
import java.util.ArrayList;

public class Molecule {

    ArrayList<Atom> atoms;
    String[] atomNames;

    public Molecule(String molecule) {
        dissectMolecule(molecule);
    }

    //This method dissect the input molecule and creates individual atoms
    private void dissectMolecule(String molecule) {
        //Variable that holds the string of the dissected element
        String element = "";
        //Variable that holds the number of moles
        String moles = "";
        //Variable that holds the number of atoms of the dissected element
        String atomCount = "";
        //Holds the length of the molecule
        int index = molecule.length();
        //Holds the list of the molecules
        atoms = new ArrayList<Atom>();

        //This for loop goes through each character in the string molecule
        for (int i = 0; i < index; i++) {
            //This if statement checks the first index in the string of molecule
            if (i == 0) {
                //if the string starts with an uppercase letter than it is the start of a new element and it will be concatenated in the variable element
                if (Character.isUpperCase(molecule.charAt(i))) { element = String.valueOf(molecule.charAt(i)); moles = "1"; }

                //This if statement checks to see if the first index is a number
                else if (Character.isDigit(molecule.charAt(i))) {

                    //If the string starts with a number then it will check the next index + 1 to see if that is a number as well
                    if(Character.isDigit(molecule.charAt(i + 1))) { moles = molecule.charAt(i) + Integer.toString(molecule.charAt(i + 1)); }
                    //If the next index is a number then the two numbers will be concatenated together
                    else { moles = String.valueOf(molecule.charAt(i)); }

                }
            }
            //This if statement checks to see if the character at index i is a capital letter
            if (Character.isUpperCase(molecule.charAt(i)) && i != 0) {
                //This if statement checks to see if the previous string was a number
                if (Character.isDigit(molecule.charAt(i - 1)) == false) {
                    //If the previous string was not a number than the previous string will become a new atom and will be added to the list of atoms
                    atoms.add(new Atom(findAtomicNumber(element)));
                }
                //the previous string gets overwritten with the start of the new element - Capital letter is the start of a new element
                element = String.valueOf(molecule.charAt(i));
            }
            //This if statement checks to see if the character at index i is a lowercase letter
            //If the character is a lowercase then it will be concatenated with the previous string forming the final letter of the element
            else if (Character.isLowerCase(molecule.charAt(i))) {element = element + String.valueOf(molecule.charAt(i)); }
            //this if statement checks to see if the character is a number and not at index 0. If the number is not at index 0 then it shows how many of that
            //element is present in the formula
            else if (Character.isDigit(molecule.charAt(i)) && i != 0) {
                //The number is stored in a variable to keep track of the number of atoms
                atomCount = String.valueOf(molecule.charAt(i));
                //this if statement checks to see if the index is in the bounds
                if (i + 1 < index) {
                    //if the if statement is in the bounds then the two numbers will be concatenated together to make one number and moves onto the next index
                    if (Character.isDigit(molecule.charAt(i + 1))) { atomCount = atomCount + molecule.charAt(i + 1); i++;}
                }
                //This for loop converts that number to a type integer and index k loops until it reaches that index.
                for (int k = 0; k < Integer.parseInt(atomCount); k ++) {
                    //adds the previous element k times
                    atoms.add(new Atom(findAtomicNumber(element)));
                }
            }
            //This if statement checks to see if the index is the last index. If it is then the last element that was concatenated will be added to the list of atoms
            if (i == index - 1 && !Character.isDigit(molecule.charAt(i))) { atoms.add(new Atom(findAtomicNumber(element)));}
        }



    }

    //This method takes in the atomic symbol that was concatenated and outputs an atomic number that is associated with that symbol
    private int findAtomicNumber(String atomicSymbol) {

        int atomicNumber = 0;

        if (atomicSymbol.contentEquals("H")) { atomicNumber = 1;}
        else if(atomicSymbol.contentEquals("He")) { atomicNumber = 2; }
        else if(atomicSymbol.contentEquals("Li")) { atomicNumber = 3; }
        else if(atomicSymbol.contentEquals("Be")) { atomicNumber = 4; }
        else if(atomicSymbol.contentEquals("B")) { atomicNumber = 5; }
        else if(atomicSymbol.contentEquals("C")) { atomicNumber = 6; }
        else if(atomicSymbol.contentEquals("N")) { atomicNumber = 7; }
        else if(atomicSymbol.contentEquals("O")) { atomicNumber = 8; }
        else if(atomicSymbol.contentEquals("F")) { atomicNumber = 9; }
        else if(atomicSymbol.contentEquals("Ne")) { atomicNumber = 10; }
        else if(atomicSymbol.contentEquals("Na")) { atomicNumber = 11; }
        else if(atomicSymbol.contentEquals("Mg")) { atomicNumber = 12; }
        else if(atomicSymbol.contentEquals("Al")) { atomicNumber = 13; }
        else if(atomicSymbol.contentEquals("Si")) { atomicNumber = 14; }
        else if(atomicSymbol.contentEquals("P")) { atomicNumber = 15; }
        else if(atomicSymbol.contentEquals("S")) { atomicNumber = 16; }
        else if(atomicSymbol.contentEquals("Cl")) { atomicNumber = 17; }
        else if(atomicSymbol.contentEquals("Ar")) { atomicNumber = 18; }
        else if(atomicSymbol.contentEquals("K")) { atomicNumber = 19; }
        else if(atomicSymbol.contentEquals("Ca")) { atomicNumber = 20; }
        else if(atomicSymbol.contentEquals("Sc")) { atomicNumber = 21; }
        else if(atomicSymbol.contentEquals("Ti")) { atomicNumber = 22; }
        else if(atomicSymbol.contentEquals("V")) { atomicNumber = 23; }
        else if(atomicSymbol.contentEquals("Cr")) { atomicNumber = 24; }
        else if(atomicSymbol.contentEquals("Mn")) { atomicNumber = 25; }
        else if(atomicSymbol.contentEquals("Fe")) { atomicNumber = 26; }
        else if(atomicSymbol.contentEquals("Co")) { atomicNumber = 27; }
        else if(atomicSymbol.contentEquals("Ni")) { atomicNumber = 28; }
        else if(atomicSymbol.contentEquals("Cu")) { atomicNumber = 29; }
        else if(atomicSymbol.contentEquals("Zn")) { atomicNumber = 30; }
        else if(atomicSymbol.contentEquals("Ga")) { atomicNumber = 31; }
        else if(atomicSymbol.contentEquals("Ge")) { atomicNumber = 32; }
        else if(atomicSymbol.contentEquals("As")) { atomicNumber = 33; }
        else if(atomicSymbol.contentEquals("Se")) { atomicNumber = 34; }
        else if(atomicSymbol.contentEquals("Br")) { atomicNumber = 35; }
        else if(atomicSymbol.contentEquals("Kr")) { atomicNumber = 36; }
        else if(atomicSymbol.contentEquals("Rb")) { atomicNumber = 37; }
        else if(atomicSymbol.contentEquals("Sr")) { atomicNumber = 38; }
        else if(atomicSymbol.contentEquals("Y")) { atomicNumber = 39; }
        else if(atomicSymbol.contentEquals("Zr")) { atomicNumber = 40; }
        else if(atomicSymbol.contentEquals("Nb")) { atomicNumber = 41; }
        else if(atomicSymbol.contentEquals("Mo")) { atomicNumber = 42; }
        else if(atomicSymbol.contentEquals("Tc")) { atomicNumber = 43; }
        else if(atomicSymbol.contentEquals("Ru")) { atomicNumber = 44; }
        else if(atomicSymbol.contentEquals("Rh")) { atomicNumber = 45; }
        else if(atomicSymbol.contentEquals("Pd")) { atomicNumber = 46; }
        else if(atomicSymbol.contentEquals("Ag")) { atomicNumber = 47; }
        else if(atomicSymbol.contentEquals("Cd")) { atomicNumber = 48; }
        else if(atomicSymbol.contentEquals("In")) { atomicNumber = 49; }
        else if(atomicSymbol.contentEquals("Sn")) { atomicNumber = 50; }
        else if(atomicSymbol.contentEquals("Sb")) { atomicNumber = 51; }
        else if(atomicSymbol.contentEquals("Te")) { atomicNumber = 52; }
        else if(atomicSymbol.contentEquals("I")) { atomicNumber = 53; }
        else if(atomicSymbol.contentEquals("Xe")) { atomicNumber = 54; }
        else if(atomicSymbol.contentEquals("Cs")) { atomicNumber = 55; }
        else if(atomicSymbol.contentEquals("Ba")) { atomicNumber = 56; }
        else if(atomicSymbol.contentEquals("La")) { atomicNumber = 57; }
        else if(atomicSymbol.contentEquals("Ce")) { atomicNumber = 58; }
        else if(atomicSymbol.contentEquals("Pr")) { atomicNumber = 59; }
        else if(atomicSymbol.contentEquals("Nd")) { atomicNumber = 60; }
        else if(atomicSymbol.contentEquals("Pm")) { atomicNumber = 61; }
        else if(atomicSymbol.contentEquals("Sm")) { atomicNumber = 62; }
        else if(atomicSymbol.contentEquals("Eu")) { atomicNumber = 63; }
        else if(atomicSymbol.contentEquals("Gd")) { atomicNumber = 64; }
        else if(atomicSymbol.contentEquals("Tb")) { atomicNumber = 65; }
        else if(atomicSymbol.contentEquals("Dy")) { atomicNumber = 66; }
        else if(atomicSymbol.contentEquals("Ho")) { atomicNumber = 67; }
        else if(atomicSymbol.contentEquals("Er")) { atomicNumber = 68; }
        else if(atomicSymbol.contentEquals("Tm")) { atomicNumber = 69; }
        else if(atomicSymbol.contentEquals("Yb")) { atomicNumber = 70; }
        else if(atomicSymbol.contentEquals("Lu")) { atomicNumber = 71; }
        else if(atomicSymbol.contentEquals("Hf")) { atomicNumber = 72; }
        else if(atomicSymbol.contentEquals("Ta")) { atomicNumber = 73; }
        else if(atomicSymbol.contentEquals("W")) { atomicNumber = 74; }
        else if(atomicSymbol.contentEquals("Re")) { atomicNumber = 75; }
        else if(atomicSymbol.contentEquals("Os")) { atomicNumber = 76; }
        else if(atomicSymbol.contentEquals("Ir")) { atomicNumber = 77; }
        else if(atomicSymbol.contentEquals("Pt")) { atomicNumber = 78; }
        else if(atomicSymbol.contentEquals("Au")) { atomicNumber = 79; }
        else if(atomicSymbol.contentEquals("Hg")) { atomicNumber = 80; }
        else if(atomicSymbol.contentEquals("Tl")) { atomicNumber = 81; }
        else if(atomicSymbol.contentEquals("Pb")) { atomicNumber = 82; }
        else if(atomicSymbol.contentEquals("Bi")) { atomicNumber = 83; }
        else if(atomicSymbol.contentEquals("Po")) { atomicNumber = 84; }
        else if(atomicSymbol.contentEquals("At")) { atomicNumber = 85; }
        else if(atomicSymbol.contentEquals("Rn")) { atomicNumber = 86; }
        else if(atomicSymbol.contentEquals("Fr")) { atomicNumber = 87; }
        else if(atomicSymbol.contentEquals("Ra")) { atomicNumber = 88; }
        else if(atomicSymbol.contentEquals("Ac")) { atomicNumber = 89; }
        else if(atomicSymbol.contentEquals("Th")) { atomicNumber = 90; }
        else if(atomicSymbol.contentEquals("Pa")) { atomicNumber = 91; }
        else if(atomicSymbol.contentEquals("U")) { atomicNumber = 92; }
        else if(atomicSymbol.contentEquals("Np")) { atomicNumber = 93; }
        else if(atomicSymbol.contentEquals("Pu")) { atomicNumber = 94; }
        else if(atomicSymbol.contentEquals("Am")) { atomicNumber = 95; }
        else if(atomicSymbol.contentEquals("Cm")) { atomicNumber = 96; }
        else if(atomicSymbol.contentEquals("Bk")) { atomicNumber = 97; }
        else if(atomicSymbol.contentEquals("Cf")) { atomicNumber = 98; }
        else if(atomicSymbol.contentEquals("Es")) { atomicNumber = 99; }
        else if(atomicSymbol.contentEquals("Fm")) { atomicNumber = 100; }
        else if(atomicSymbol.contentEquals("Md")) { atomicNumber = 101; }
        else if(atomicSymbol.contentEquals("No")) { atomicNumber = 102; }
        else if(atomicSymbol.contentEquals("Lr")) { atomicNumber = 103; }
        else if(atomicSymbol.contentEquals("Rf")) { atomicNumber = 104; }
        else if(atomicSymbol.contentEquals("Db")) { atomicNumber = 105; }
        else if(atomicSymbol.contentEquals("Sg")) { atomicNumber = 106; }
        else if(atomicSymbol.contentEquals("Bh")) { atomicNumber = 107; }
        else if(atomicSymbol.contentEquals("Hs")) { atomicNumber = 108; }
        else if(atomicSymbol.contentEquals("Mt")) { atomicNumber = 109; }
        else if(atomicSymbol.contentEquals("Ds")) { atomicNumber = 110; }
        else if(atomicSymbol.contentEquals("Rg")) { atomicNumber = 111; }
        else if(atomicSymbol.contentEquals("Cn")) { atomicNumber = 112; }
        else if(atomicSymbol.contentEquals("Nh")) { atomicNumber = 113; }
        else if(atomicSymbol.contentEquals("Fl")) { atomicNumber = 114; }
        else if(atomicSymbol.contentEquals("Mc")) { atomicNumber = 115; }
        else if(atomicSymbol.contentEquals("Lv")) { atomicNumber = 116; }
        else if(atomicSymbol.contentEquals("Ts")) { atomicNumber = 117; }
        else if(atomicSymbol.contentEquals("Og")) { atomicNumber = 118; }

        return atomicNumber;
    }

    //This method prints out the atoms in the molecule
    public String[] getAtoms() {
        //this for loop goes through the array list of atoms
        for (int i = 0; i < atoms.size(); i++) {
            //Prints out the individual atoms in the array list
            System.out.println(i + 1 + ": " + atoms.get(i).name);
        }

        //Creates an array of atom names
        atomNames = new String[atoms.size()];

        //loops through all of the atoms in the array list
        for (int i = 0; i < atoms.size(); i++) {
            //creates an index with the atoms name
            atomNames[i] = (i + 1) + ": " + atoms.get(i).name;
        }

        //returns all of the atom names
        return atomNames;
    }
}

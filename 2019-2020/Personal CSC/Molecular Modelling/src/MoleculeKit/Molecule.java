package MoleculeKit;

import java.lang.Character;
import java.util.ArrayList;

public class Molecule {

    ArrayList<Atom> atoms;

    //This method dissect the input molecule and creates individual atoms
    public void dissectMolecule(String molecule) {

        //Variable that holds the string of the dissected element
        String element = "";
        //Variable that holds the number of moles
        String moles = "";
        //Variable that holds the number of atoms of the dissected element
        String atomCount = "";
        //
        int index = molecule.length();
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
                    //if the if statement is in the bounds then the two numbers will be concatenated together to make one number
                    if (Character.isDigit(molecule.charAt(i + 1))) { atomCount = atomCount + molecule.charAt(i + 1); }
                }
                System.out.println(atomCount);
                //This for loop converts that number to a type integer and index k loops until it reaches that index.
                for (int k = 0; k < Integer.parseInt(atomCount); k ++) {
                    //adds the previous element k times
                    atoms.add(new Atom(findAtomicNumber(element)));
                }
                i++;
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

        return atomicNumber;
    }

    //This method prints out the atoms in the molecule
    public void getAtoms() {
        //this for loop goes through the array list of atoms
        for (int i = 0; i < atoms.size(); i++) {
            //Prints out the individual atoms in the array list
            System.out.println(i + 1 + ": " + atoms.get(i).name);
        }
    }
}

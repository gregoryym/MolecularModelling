package MoleculeKit;

import java.lang.Character;
import java.util.ArrayList;

public class Molecule {

    ArrayList<Atom> atoms;

    public void getMolecule(String molecule) {

        String element = "";
        String moles = "";
        int index = molecule.length();
        atoms = new ArrayList<Atom>();

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
                //This for loop converts that number to a type integer and index k loops until it reaches that index.
                for (int k = 1; k < Integer.parseInt(String.valueOf(molecule.charAt(i))); k ++) {
                    //adds the previous element k times
                    atoms.add(new Atom(findAtomicNumber(String.valueOf(molecule.charAt(i - 1)))));
                }
            }
            //This if statement checks to see if the index is the last index. If it is then the last element that was concatenated will be added to the list of atoms
            if (i == index - 1) { atoms.add(new Atom(findAtomicNumber(element)));}
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
}

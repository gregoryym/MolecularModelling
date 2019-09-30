package MoleculeKit;

public class main {

    public static void main(String[] args) {

        Atom atom = new Atom(27);

        //atom.returnOrbital();
        //System.out.println();
        //atom.Quantum.get("3d").get(4).returnQuantumNumbers();
        //atom.returnStats();

        Molecule molecule = new Molecule();
        molecule.getMolecule("2HHe");
        System.out.println(molecule.atoms.size());

    }

}

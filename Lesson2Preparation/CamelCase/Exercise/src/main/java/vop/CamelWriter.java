package vop;

import java.io.File;

/**
 * @author erso
 */
public class CamelWriter {

    private File inFile;

    public CamelWriter(String fName) {
        //Initialiser inFile med fName
    }

    public void readLines() {
        // Benyt en Scanner til at læse inFile én linje ad gangen
        // Kald convert2camel med hver linje.
    }

    private void convert2camel(String line) {
        // Split line til et String[] af de enkelte ord i linjen
        // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        // Sammensæt ordene til ét langt ord og udskriv.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CamelWriter cw = new CamelWriter("DryLips.txt");
        cw.readLines();
    }

}

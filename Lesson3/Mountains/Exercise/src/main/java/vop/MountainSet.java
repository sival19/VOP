package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.*;

public class MountainSet {
    //variabel mountainset af typen Set
    private Set<Mountain> setOfMountains;


    public MountainSet(){
        this.setOfMountains = new TreeSet<>(Mountain::compareTo);
    }

    public Set<Mountain> getSetOfMountains() {
        return setOfMountains;
    }

    public static void main(String[] args) {
        MountainSet mountainSet = new MountainSet();

        //open file!!!!!!maybe?

        Scanner inputStream = null;
        try {
            inputStream = new Scanner(Objects.requireNonNull(MountainSet.class.getClassLoader().getResourceAsStream("vop\\FranskeBjerge.csv")));

        } catch (Exception e) {
            e.printStackTrace();
        }
        while (inputStream.hasNextLine()){
            String [] words = inputStream.nextLine().split(";");

            Mountain mountain = new Mountain(words[0],words[1],words[2], words[3], words[4], words[5]);

            mountainSet.getSetOfMountains().add(mountain);


        }
        inputStream.close();
        System.out.println(mountainSet.getSetOfMountains());
        //System.out.println(mountainSet.sortByRange(new MountainRangeComperator()));

    }

    public Set<Mountain> sortByRange(Comparator comp){
        Set<Mountain> mountains = new TreeSet<>(comp);
        mountains.addAll(setOfMountains);
        return mountains;

    }



}

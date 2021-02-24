package vop;

import java.util.Comparator;

public class MountainRangeComperator implements Comparator<Mountain> {

    @Override
    public int compare(Mountain mountain, Mountain t1){
        if(mountain.getRange().compareTo(t1.getRange())==0){
            return t1.compareTo(mountain);
        }
        return mountain.getRange().compareTo(t1.getRange());
    }

    
}

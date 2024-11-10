package One;

import java.util.LinkedList;

public class Dc {
//Por que seria LinkedList uma opção para uma lista de jobs?
    public void linkedList() {

        LinkedList<String> jobsToRun = new LinkedList<>();
        jobsToRun.add("For un the bell tolls - Metallica");
        jobsToRun.add("City of Rock - Kiss");
        jobsToRun.add("Remember you - SkidRow");
        jobsToRun.add(null);
        jobsToRun.add("Point of Authority - Linking Park");
        jobsToRun.getFirst(); // City of Rock
    }

}

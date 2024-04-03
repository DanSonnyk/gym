package leetcode.various;

import java.util.*;

//I receive 2 arrays with a list of booking hours periods and 2 arrays with bounds of the day to book, then return a list
//with available hours periods

//Example input
// array1 = [["09:00", "10:30"],["12:00","13:00"].["16:00","18:00"]]
// bound1 = ["09:00", "20:00"]
// array2 = [["10:00", "11:30"],["12:00", "14:30"],["16:00", "17:00"],["14:30", "15:00"]]
// bound1 = ["09:00", "22:30"]

//Example output
//intervals available = [[11:30, 12:00], [15:00, 16:00], [18:00, 22:30]]

// method ass = public List<String[]> availableIntervals(List<String[]> agenda1, List<String[]> agenda2,
//                List<String> bound1, List<String> bound2) {...}
public class returnAvailable {

    public static void main(String[] args) {

        List<String[]> agenda1 = new ArrayList<>(List.of(
                        new String[]{"09:00", "10:30"},
                        new String[]{"12:00", "13:00"},
                        new String[]{"16:00", "18:00"}));
        List<String> bound1 = new ArrayList<>(List.of("09:00", "20:00"));

        List<String[]> agenda2 = new ArrayList<>(List.of(
                        new String[]{"10:00", "11:30"},
                        new String[]{"12:00", "14:30"},
                        new String[]{"16:00", "17:00"},
                        new String[]{"14:30", "15:00"}));
        List<String> bound2 = new ArrayList<>(List.of("09:00", "22:30"));

        List<String[]> response = availableIntervals(agenda1, agenda2, bound1, bound2);
        System.out.println(Arrays.deepToString(response.toArray()));
    }

    private static List<String[]> availableIntervals(List<String[]> agenda1, List<String[]> agenda2,
                                           List<String> bound1, List<String> bound2) {
        //Prepare bounds to be selected smaller and greatest
        List<String[]> ma = new ArrayList<>();
        List<String> bounds = new ArrayList<>();
        bounds.addAll(bound1);
        bounds.addAll(bound2);
        Collections.sort(bounds);

        //Merge bookings and set bounds
        ma.addAll(agenda1);
        ma.addAll(agenda2);
        ma.add(new String[]{bounds.getFirst(), bounds.getFirst()});
        ma.add(new String[]{bounds.getLast(), bounds.getLast()});
        Collections.sort(ma, Comparator.comparing(arr -> arr[0]));

        //Apply rule: if iniHour have duplicated delete line with lower endHour value
        for (int i = 0; i < ma.size(); i++) {
            String iniHourRef = ma.get(i)[0];

            for (int j = 0; j < ma.size(); j++) {
                String iniHour = ma.get(j)[0];
                if(iniHourRef.equals(iniHour) && i!=j){
                    int endRef = Integer.parseInt(ma.get(i)[1].replace(":", ""));
                    int end = Integer.parseInt(ma.get(j)[1].replace(":", ""));
                    if(endRef>end){
                        ma.remove(j);
                    }else{
                        ma.remove(i);
                    }
                }

            }
         }

        //Apply rule: if endHour is greatest then iniHour of the next booking
        for (int i = 0; i < ma.size(); i++) {
            if(i<ma.size()-1){
                int endRef = Integer.parseInt(ma.get(i)[1].replace(":", ""));
                int iniNext = Integer.parseInt(ma.get(i+1)[0].replace(":", ""));

                if(endRef>=iniNext){
                    ma.set(i, new String[]{ma.get(i)[0],ma.get(i+1)[1]});
                    ma.remove(i+1);
                }
            }
        }

        //Process return
        List<String[]> response = new ArrayList<>();

        for (int i = 0; i < ma.size()-1; i++) {
            response.add(i,new String[]{ma.get(i)[1],ma.get(i+1)[0]});
        }

        return response;
    }
}

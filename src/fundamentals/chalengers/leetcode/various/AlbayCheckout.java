package fundamentals.chalengers.leetcode.various;

import java.util.*;

/*To attract tourists, a casino in Las Vegas offers an all-you-can-eat buffet
where everyone pays what they want to pay.

Given what each guest is ready to pay, you have to compute the restaurant's gains
for the day:
• At the beginning of the day the restaurant is empty.
• A guest arrives, finds a seat, eats, pays and then leaves.
• There are only nbSeats seats available. Guests can only eat and pay when they
can be seated.
• A guest which enters the restaurant and cannot find a seat waits in line until a
seat is made available or until he/she gets bored and leaves.
• A guest may come several times during the day, in that case, he/she will pay at
most once.
Implement the method computeDayGains (nbSeats, payingGuests, guestMovements)
which returns the gains for the day:
• The array payingGuests gives what guests are ready to pay (for example if
payingGuests [5] value is 25, it means that guest with id 5 is ready to pay $25
for the buffet.
• The array guestMovements gives in order the arrivals and departures of guests.
The first time you see an id, it indicates an arrival. The second time you see the
same id, it indicates a departure. An arrival is always followed later in the day
by a departure.*/
public class AlbayCheckout {
    public static void main(String[] args) {
        int[] payingGuests = {12,15,8,4,13,17};
        int[] guestMovements = {1,6, 2,5, 3,4, 4,3, 5,2, 6,1};

        List<Integer> list = new ArrayList<>();

        Arrays.stream(guestMovements).forEach(value -> list.add(value));

        int seats = 4;
        int resultOfDay = computeDayGains(seats, payingGuests, guestMovements);
        System.out.println(resultOfDay);
    }

    public  static  int  computeDayGains ( int nbSeats , int [] payingGuests , int [] guestMovements ) {
        List<Integer> seatedGuests = new LinkedList<>();
        List<Integer> waitingList = new LinkedList<>();
        int gains = 0;
        for (int guestId : guestMovements) {
            // if this is guestId's arrival
            if (!seatedGuests.contains(guestId) && !waitingList.contains(guestId)) {

                // if no seat available, make him wait
                if (seatedGuests.size() >= nbSeats) {
                    waitingList.add(guestId);
                } else {
                    // or just give him a seat
                    seatedGuests.add(guestId);
                }

            } else {
                // this is guestId's departure
                if (seatedGuests.contains(guestId)) {
                    // this guest has sat & eaten & paid
                    gains += payingGuests[guestId - 1];
                    payingGuests[guestId - 1] = 0;

                    seatedGuests.remove(seatedGuests.indexOf(guestId));

                    // if atleast someone is waiting, now that we have an empty seat
                    if (waitingList.size() > 0) {
                        // let's make the first person in waitingList have the empty seat
                        seatedGuests.add(waitingList.get(0));
                        waitingList.remove(0);
                    }

                } else if (waitingList.contains(guestId)) {
                    // this guest did not sit

                    waitingList.remove(waitingList.indexOf(guestId));
                }
            }

        }

        return gains;
    }
}

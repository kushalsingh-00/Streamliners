package Task3.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;

public class Menu {
    Scanner s=new Scanner(System.in);
    HashMap<String,TouristPlace> mp=new HashMap<>();
    TouristPlace place=new TouristPlace();

    private int Choices()
    {
        System.out.println("These are the choices we have");
        System.out.println(1+" Add a new Place");
        System.out.println(2+" Find a Place");
        System.out.println(3+" Rate a Place");
        System.out.println(4+" Remove a place");

        System.out.println("Enter what you want (choice)");
        return new Scanner(System.in).nextInt();
    }

    public void show() throws IOException {
        while (true) {
            int x=Choices();
            switch (x) {
                case 1:
                    System.out.println("Enter city name \nWorking Hour \nTicket Price");
                    addPlace(new TouristPlace(s.nextLine(), s.nextLine(), s.nextInt()));
                    break;
                case 2:
                    findPlace();

                    break;
                case 3:
                    ratePlace();
                    break;
                case 4:
                    removePlace();
                    break;
                default:
                    System.out.println("please enter in range as shown in choices");
                    break;
            }
            if (wantsToExit()) {
                break;
            }
        }
        place.savePlacesToFile();
    }

    private boolean wantsToExit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue y/n?");
        String input = scanner.next();
        return input.equals("n");
    }
    private void removePlace() {
        place.removePlace();
        System.out.println(place.placeList.size());
    }

    private void findPlace() {
        place.findPlace();
    }

    private void ratePlace() {
        place.rate();
    }

    private void addPlace(TouristPlace t) {
        place.addPlace(t);
    }
}

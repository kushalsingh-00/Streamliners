package Task3.model;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TouristPlace implements Serializable {
    String path="/root/IdeaProjects/Streamliners/src/Task3/places.txt";
    String name;
    String workingHour;
    int entryTicketPrice;
    int noOfRatings;
    public float starRating;
    List<String> famousFor;
    public HashMap<String,TouristPlace> placeList=new HashMap<>();

    public TouristPlace(String name, String workingHour, int entryTicketPrice) {
        this.name = name;
        this.workingHour = workingHour;
        this.entryTicketPrice = entryTicketPrice;

        famousFor = new ArrayList<>();
        noOfRatings = 0;
        starRating = 0;
    }

    public TouristPlace(){
    }

    public void savePlacesToFile() throws IOException {
        FileOutputStream saveFile=new FileOutputStream(path);
        ObjectOutputStream stream= new ObjectOutputStream(saveFile);
        
        stream.writeObject(placeList.values().toString());
    }
    @Override
    public String toString() {
        return String.format("%s", placeList.values());
    }

    public void getValuesFromFile() throws FileNotFoundException {
        FileInputStream file=new FileInputStream(path);
        try {
            ObjectInputStream stream=new ObjectInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addPlace(TouristPlace newPlace)
    {
        placeList.put(newPlace.name,newPlace);
        System.out.println(placeList.size());
    }

    public void findPlace()
    {
        System.out.println("Enter the name of place you looking for");
        String a=new Scanner(System.in).nextLine();
        if(placeList.containsKey(a)) {
            System.out.println("place present");
            System.out.println(string(a));
        }
        else System.out.println("not present");
    }

    public String string(String a) {
        return "TouristPlace{" +
                "name='" + placeList.get(a).name + '\'' +
                ", workingHour='" + placeList.get(a).workingHour + '\'' +
                ", entryTicketPrice=" + placeList.get(a).entryTicketPrice +
                ", noOfRatings=" + placeList.get(a).noOfRatings +
                ", starRating=" + placeList.get(a).starRating +
                ", famousFor=" + placeList.get(a).famousFor +
                ", placeList=" + placeList.get(a).placeList +
                '}';
    }

    public void rate() {
        System.out.println("Enter the name of place you want to rate");
        String a=new Scanner(System.in).nextLine();
        int stars=new Scanner(System.in).nextInt();
        starRating+=(stars-starRating)/++noOfRatings;
        placeList.get(a).starRating=starRating;
    }

    public TouristPlace addFamousFor(String s) {
        famousFor.add(s);
        return this;
    }

    public void removePlace()
    {
        if(placeList.size()==0) {
            System.out.println("please first add the place");
        }
        else {
            System.out.println("Enter name of place");
            String name=new Scanner(System.in).nextLine();
            if (placeList.containsKey(name)) {
                System.out.println("place removed");
                placeList.remove(name);
            } else System.out.println(name + " does not exists");
        }
    }

    public boolean isPlaceOpen() {
        LocalTime currTime=LocalTime.now();

        String[] lt=workingHour.split(" to ");
        LocalTime startTime=LocalTime.parse(lt[0],DateTimeFormatter.ofPattern("hh:mma"))
                , endTime=LocalTime.parse(lt[1],DateTimeFormatter.ofPattern("hh:mma"));


        //startTime.compare(currTime) : -1, 0
        //endTime.compareTo(currTime) : 1, 0
        return  startTime.compareTo(currTime) <=0  && endTime.compareTo(currTime) >=0;

    }

}

//package collab.atul;
//
//        import java.time.LocalTime;
//        import java.time.format.DateTimeFormatter;
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
//public class TouristPlace {
//    String name, workingHour,city;
//    int entryTicPrice;
//    float starRating;
//    List<String> famousFor;
//    String category;
//    int noOfRatings;
//
//    public TouristPlace(String name, String workingHour, String city, int entryTicPrice, String category) {
//        this.name = name;
//        this.workingHour = workingHour;
//        this.city = city;
//        this.entryTicPrice = entryTicPrice;
//        this.category = category;
//        famousFor=new ArrayList<>();
//    }
//
//    public TouristPlace() {
//    }
//
//    public TouristPlace addFamousFor(String s){
//        famousFor.add(s);
//        return this;
//    }
//    //calculating the total rating.
//    public void rate(float... ratings) {
//        //calculating total no of stars till now
//        for (float rating:ratings) starRating += (rating - starRating) / ++noOfRatings;
//    }
//    //Checking if the spot is open or not.
//    public boolean isOpen(){
//        String[] times = workingHour.split(" to ");
//        //Parse times
//        LocalTime startTime = LocalTime.parse(times[0], DateTimeFormatter.ofPattern("hh:mma"))
//                , endTime = LocalTime.parse(times[1], DateTimeFormatter.ofPattern("hh:mma"))
//                , currTime = LocalTime.now();
//
//        return startTime.compareTo(currTime) <=0  && endTime.compareTo(currTime) >=0;
//    }
//
//    public static TouristPlace newFromUserinput(){
//        Scanner scanner = new Scanner(System.in);
//        TouristPlace place=new TouristPlace();
//        System.out.println("Enter name : ");
//        place.name = scanner.next();
//        return place;
//    }
//
//
//}
/*package collab.atul;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Int, Float, Object -> Bytes
//Objects ->(Serialize / Creating String) Bytes

public class TouristPlace implements Serializable {
    String name, workingHour,city;
    int entryTicPrice;
    float starRating;
    List<String> famousFor;
    String category;
    int noOfRatings;
    String review;

    public TouristPlace(String name, String workingHour, String city, int entryTicPrice, String category) {
        this.name = name;
        this.workingHour = workingHour;
        this.city = city;
        this.entryTicPrice = entryTicPrice;
        this.category = category;
        famousFor=new ArrayList<>();
    }

    public TouristPlace() {
    }

    public TouristPlace addFamousFor(String s){
        famousFor.add(s);
        return this;
    }
    //calculating the total rating.
    public void rate(float... ratings) {
        //calculating total no of stars till now
        for (float rating:ratings) starRating += (rating - starRating) / ++noOfRatings;
    }
    //Checking if the spot is open or not.
    public boolean isOpen(){
        String[] times = workingHour.split(" to ");
        //Parse times
        LocalTime startTime = LocalTime.parse(times[0], DateTimeFormatter.ofPattern("hh:mma"))
                , endTime = LocalTime.parse(times[1], DateTimeFormatter.ofPattern("hh:mma"))
                , currTime = LocalTime.now();

       return startTime.compareTo(currTime) <=0  && endTime.compareTo(currTime) >=0;
    }

    public static TouristPlace newFromUserInput(){
        Scanner scanner = new Scanner(System.in);
        TouristPlace place=new TouristPlace();
        System.out.println("Enter name : ");
        place.name = scanner.next();
        System.out.println("What are its speciality?");
        place.famousFor = Collections.singletonList(scanner.next());
        System.out.println("Your review: ");
        place.review = scanner.next();
        return place;
    }

    @Override
    public String toString() {
        return String.format("Your place "+ name+" is rated "+starRating+" by "+noOfRatings+" users. Its famous for"+famousFor+" and its reviews as rated by user are "+review+" .");
    }
}
*/

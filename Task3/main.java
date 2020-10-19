package Task3;

import Task3.model.Menu;
import Task3.model.TouristPlace;

import java.io.IOException;
import java.util.Scanner;

import static java.util.Calendar.PM;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner s=new Scanner(System.in);
        Menu menu=new Menu();
        menu.show();
    }
}

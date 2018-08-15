package ru.shekhovtsov.nikita.geekbrains;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ru.shekhovtsov.nikita.geekbrains.AirportDB.AirlineDB.Aircraft;
import ru.shekhovtsov.nikita.geekbrains.AirportDB.AirlineDB.Airline;
import ru.shekhovtsov.nikita.geekbrains.AirportDB.AirlineDB.Crew;
import ru.shekhovtsov.nikita.geekbrains.AirportDB.Airport;
import ru.shekhovtsov.nikita.geekbrains.AirportDB.DispatcherDB.Dispatcher;
import ru.shekhovtsov.nikita.geekbrains.AirportDB.RunwayDB.Runway;

public class Main {


    // Инициализация коллекций, в которых хранятся данные об аэропортах и тп
    private static ArrayList<Airport> airports = new ArrayList<>();
    private static ArrayList<Airline> airlines = new ArrayList<>();
    private static ArrayList<Aircraft> aircrafts = new ArrayList<>();
    private ArrayList<Crew> crews = new ArrayList<>();
    private static ArrayList<Dispatcher> dispatchers = new ArrayList<>();
    private static ArrayList<Runway> runways = new ArrayList<>();

    // Первоначальное заполнение БД
    private static void initDB() {
        Airport UUDD = new Airport("UUDD", "Domodedovo", 30000);
        Airport ULLI = new Airport("ULLI", "Pulkovo", 34000);
        airports.add(UUDD);
        airports.add(ULLI);


        Runway l14r32 = new Runway(UUDD, "14L-32R", "Concrete", 12444);
        Runway r14l32 = new Runway(UUDD, "14R-32L", "Concrete", 11483);
        runways.add(l14r32);
        runways.add(r14l32);
        Runway l10r28 = new Runway(ULLI, "10L-28R", "Concrete",  11145);
        Runway r10l28 = new Runway(ULLI, "10R-28L", "Concrete",   12402);
        runways.add(l10r28);
        runways.add(r10l28);

        Dispatcher uuddTWR = new Dispatcher(UUDD, "UUDD_TWR", "121.250 Mhz");
        Dispatcher ulliTWR = new Dispatcher(ULLI, "ULLI_APP", "129.725 Mhz");
        dispatchers.add(uuddTWR);
        dispatchers.add(ulliTWR);


        Airline S7 = new Airline(UUDD, "S7", "B");
        Airline Russia = new Airline(ULLI, "Russia", "B");
        airlines.add(S7);
        airlines.add(Russia);


        Aircraft RA80103 = new Aircraft(UUDD, S7, "Jet", "B737-800", 36.2, 2400, 122);
        Aircraft RA80106 = new Aircraft(ULLI, Russia, "Jet", "A320-CFM", 40.5, 2400, 112);
        aircrafts.add(RA80103);
        aircrafts.add(RA80106);
    }

    // Пример работы с БД, добавление элементов
    private static void createNewAirport(String ICAO, String Name, int PaxFlow) {
        for (int i = 0; i < airports.size(); i++) {
            if (!airports.get(i).getAirportID().equals(ICAO)) {
                Airport ZZZZ = new Airport(ICAO, Name, PaxFlow);
                airports.add(ZZZZ);
                System.out.println("Successfully created new airport");
                break;
            } else {
                System.out.println("This airport is created already");
                break;
            }
        }
    }

    // Пример работы с БД, получение информации
    private static void getAirportInfo() {
        Scanner scanner = new Scanner(System.in);
        String ICAO = scanner.nextLine();
        for (Airport airport : airports) {
            if (airport.AirportID.equals(ICAO)) {
                airport.viewInfo();
                break;
            } else {
                System.out.println("Not founded this airport");
                break;
            }
        }
    }



    public static void main(String[] args) {

        initDB();
        createNewAirport("URSS", "Sochi", 123123);
        getAirportInfo();


    }



}

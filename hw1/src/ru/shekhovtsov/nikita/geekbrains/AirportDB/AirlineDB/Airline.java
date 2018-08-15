package ru.shekhovtsov.nikita.geekbrains.AirportDB.AirlineDB;


import ru.shekhovtsov.nikita.geekbrains.AirportDB.Airport;

/*
    Таблица/класс авиакомпаний. (См. даталогическую схему)

    Содержит следующие поля:
        AirlineID                   - уникальный идентификатор авиакомпании (первичный ключ)
        AirlineName                 - название авиакомпании (например: S7 airlines)
        AirlineAllowableTransition  - допустимые для авиакомпании воздушные пространства
                                      (например: VFR (правила визульных полетов)
                                      пространство C - чарли)
        AirlineFlightNum            - число полетов данной авиакомпании (изменяется при регистрации полета)

*/


public class Airline extends Airport {

    private static int AirlineID;
    int AirlineFlightNum;
    private String AirlineName;
    private String AirlineAllowableTransition;


    public Airline(Airport airport, String airlineName, String airlineAllowableTransition) {
        super(airport.AirportID, airport.getAirportName(), airport.getAirportPaxFlow());
        AirlineName = airlineName;
        AirlineAllowableTransition = airlineAllowableTransition;
        AirlineFlightNum = 0;
    }


    // viewInfo - вывести информацию о данной авиакомпании
    @Override
    public void viewInfo() {
        System.out.println("---Airline info---");
        System.out.println("Airline                       - " + AirlineName);
        System.out.println("Airline allowable transition  - " + AirlineAllowableTransition);
        System.out.println();
    }


    // Скучный раздел геттеров и сеттеров
    public int getAirlineFlightNum() {
        return AirlineFlightNum;
    }

    public String getAirlineName() {
        return AirlineName;
    }

    public int getAirlineID() {
        return AirlineID;
    }

    public String getAirlineAllowableTransition() {
        return AirlineAllowableTransition;
    }

    public void setAirlineName(String airlineName) {
        AirlineName = airlineName;
    }

    public void setAirlineAllowableTransition(String airlineAllowableTransition) {
        AirlineAllowableTransition = airlineAllowableTransition;
    }
}

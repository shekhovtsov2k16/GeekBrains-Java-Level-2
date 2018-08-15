package ru.shekhovtsov.nikita.geekbrains.AirportDB;

/*
    Таблица/класс аэропортов. (См. даталогическую схему)

    Содержит следующие поля:
        AirportID          - уникальный международный четырёхзначный идентификатор аэропорта
                             (например: ULLI - Пулково (Санкт-Петербург)
        AirportName        - название аэропорта (например: Внуково)
        AirportPaxFlow     - число обслуживаемых пассажиров в год (например: аэропорт
                             Шпицбергена - 136345 чел. в год)
*/

public class Airport {

    public String AirportID;
    private String AirportName;
    private int AirportPaxFlow;

    public Airport(String airportID, String airportName, int airportPaxFlow) {
        if (airportID.length() == 4) {
            AirportID = airportID;
        } else {
            System.out.println("Incorrect ICAO code");
            AirportID = "ZZZZ";
        }
        AirportName = airportName;
        AirportPaxFlow = airportPaxFlow;
    }

    public void viewInfo() {
        System.out.println("---Airport info---");
        System.out.println("Airport ICAO code             - " + AirportID);
        System.out.println("Airport name                  - " + AirportName);
        System.out.println("Airport PAX flow              - " + AirportPaxFlow);
        System.out.println();
    }


    // Скучный раздел геттеров и сеттеров
    public String getAirportID() {
        return AirportID;
    }

    public String getAirportName() {
        return AirportName;
    }

    public int getAirportPaxFlow() {
        return AirportPaxFlow;
    }

    public void setAirportName(String airportName) {
        AirportName = airportName;
    }

    public void setAirportPaxFlow(int airportPaxFlow) {
        AirportPaxFlow = airportPaxFlow;
    }
}

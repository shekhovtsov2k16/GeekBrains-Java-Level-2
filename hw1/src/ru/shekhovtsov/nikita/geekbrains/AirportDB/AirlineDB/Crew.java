package ru.shekhovtsov.nikita.geekbrains.AirportDB.AirlineDB;


import ru.shekhovtsov.nikita.geekbrains.AirportDB.Airport;

/*
    Таблица/класс экипажей. (См. даталогическую схему)

    Содержит следующие поля:
        CrewID        - уникальный идентификатор экипажа (первичный ключ)
        CrewType      - тип воздушного судна, на который обучен данный экипаж
                      (например: B737-300)
        CrewNum       - число членов экипажа (например: 8 чел. (как для Tу-154:
                      4 бортпроводника, Командир, Второй пилот, Бортмеханник,
                      Штурман)
        CrewCapitan   - ФИО Командира ВС
        CrewAirlineID - вторичный ключ для реализации связей между таблицами
*/



public class Crew extends Airline {

    protected static int CrewID;
    private String CrewType;
    private int CrewNum;
    private String CrewCapitan;
    private int CrewAirlineID;


    public Crew(Airport airport, Airline airline, String crewType, int crewNum, String crewCapitan, int crewAirlineID) {
        super(airport, airline.getAirlineName(), airline.getAirlineAllowableTransition());
        CrewType = crewType;
        CrewNum = crewNum;
        CrewCapitan = crewCapitan;
        CrewAirlineID = crewAirlineID;
    }

    @Override
    public void viewInfo() {
        System.out.println("---Crew info---");
        System.out.println("Crew belongs to      - " + super.getAirlineName());
        System.out.println("Crew's Aircraft type - " + CrewType);
        System.out.println("Crew count           - " + CrewNum);
        System.out.println("Crew's capitan       - " + CrewCapitan);
        System.out.println();
    }
}

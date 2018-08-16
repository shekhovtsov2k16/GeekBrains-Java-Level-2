package ru.shekhovtsov.nikita.geekbrains.AirportDB.AirlineDB;

/*
    Таблица/класс Воздушных судов (далее ВС). (См. даталогическую схему)

    Содержит следующие поля:
        AircraftID          - уникальный идентификатор ВС (первичный ключ)
        AircraftType        - тип ВС (например: Turboprop (турбовинтовой))
        AircraftModel       - модель ВС (например: A320-CFM)
        AircraftMaxZFW      - максимальная (Zero Fuel Weight) полезная нагрузка ВС (например: 36.4 т.)
        AircraftFlightHours - число налета ВС (например : 65536 ч.)
        AircraftPAX         - максимальное число пассажиров на борту (например: 4 чел.)
        AircraftAirlineID   - вторичный ключ для реализации связей между таблицами
*/


import ru.shekhovtsov.nikita.geekbrains.AirportDB.Airport;

public class Aircraft extends Airline implements GroundWorks, FlightsRegistration {

    protected static int AircraftID;
    private String AircraftType;
    private String AircraftModel;
    private double AircraftMaxZFW;
    private int AircraftFlightHours;
    private int AircraftPAX;
    private int AircraftAirlineID;

    /*
        Для создания нового ВС для авиакомпании, необходимо в конструктор передать
        аэропорт базирования ВС, саму авиакомпанию, а так же все параметры
        данного ВС. AircraftAirlineID будет определен автоматически. Он
        служит для дальнейшего расширения СУБД (реализация
        связей Многим-ко-Многим и т.п.)
     */

    public Aircraft(Airport airport, Airline airline, String aircraftType, String aircraftModel, double aircraftMaxZFW, int aircraftFlightHours, int aircraftPAX) {
        super(airport, airline.getAirlineName(), airline.getAirlineAllowableTransition());
        AircraftType = aircraftType;
        AircraftModel = aircraftModel;
        AircraftMaxZFW = aircraftMaxZFW;
        AircraftFlightHours = aircraftFlightHours;
        AircraftPAX = aircraftPAX;
        AircraftAirlineID = airline.getAirlineID();
    }


    // viewInfo - вывести информацию о данном ВС
    @Override
    public void viewInfo() {
        System.out.println("---Aircraft info---");
        System.out.println("Aircraft belongs to           - " + super.getAirlineName());
        System.out.println("Aircraft type                 - " + AircraftType);
        System.out.println("Aircraft model                - " + AircraftModel);
        System.out.println("Aircraft max Zero Fuel Weight - " + AircraftMaxZFW);
        System.out.println("Aircraft flight hours         - " + AircraftFlightHours);
        System.out.println("Aircraft PAX                  - " + AircraftPAX);
        System.out.println();
    }

    /*
        registerIFRFlight - зарегистрировать полет по ППП (правила полетов по приборам)
        с указанием эшелона. При вызове будет добавлены часы налета ВС
     */
    @Override
    public void registerIFR(Airport dep, Airport arr, int flightTime, double flightLevel) {
        if (super.getAirlineAllowableTransition().equals("B")) {
            if ((dep.AirportID.equals(super.getAirportID())) | (arr.AirportID.equals(super.getAirportID()))) {
                System.out.println("Successfully registered IFR flight");
                System.out.println("From: " + dep.getAirportName() + " to: " + arr.getAirportName());
                System.out.println("Flight level: " + flightLevel);
                System.out.println("Flight time: " + flightTime);
                System.out.println();
                super.AirlineFlightNum++;
                System.out.println("Current flights number: " + super.getAirlineFlightNum());
                AircraftFlightHours += flightTime;
            } else {
                System.out.println("This airline is not allowed to fly to this airports");
                System.out.println("TIP: one of the airports (dep or arr) must me based airport");
            }
        } else {
            System.out.println("Flight cannot be registered");
            System.out.println(super.getAirlineName() + " is not allowed to fly by the IFR rules");
            System.out.println("You can change AllowableTransition with .setAirlineAllowableTransition to B");
        }
    }

    /*
        registerVFRFlight - зарегистрировать полет по ПВП (правила визуальных полетов)
        без указания эшелона. При вызове будет добавлены часы налета ВС
     */
    @Override
    public void registerVFR(Airport dep, Airport arr, int flightTime) {
        System.out.println("Successfully registered VFR flight");
        System.out.println("From: " + dep.getAirportName() + " to: " + arr.getAirportName());
        System.out.println("Flight time: " + flightTime);
        System.out.println();
        super.AirlineFlightNum++;
        System.out.println("Current flights number: " + super.getAirlineFlightNum());
        AircraftFlightHours += flightTime;
    }

    // changeEngines - замена двигателей (минус 5000 часов к налёту ВС)
    @Override
    public void changeEngines() {
        if (this.AircraftFlightHours > 5000) {
            this.AircraftFlightHours = this.AircraftFlightHours - 5000;
        } else {
            this.AircraftFlightHours = 0;
        }
    }

    // changeGears - замена стоек шасси (минус 2500 часов к налёту ВС)
    @Override
    public void changeGears() {
        if (this.AircraftFlightHours > 2500) {
            this.AircraftFlightHours = this.AircraftFlightHours - 2500;
        } else {
            this.AircraftFlightHours = 0;
        }
    }

    // changeAvionics - замена радиооборудования (минус 1000 часов к налёту ВС)
    @Override
    public void changeAvionics() {
        if (this.AircraftFlightHours > 1000) {
            this.AircraftFlightHours = this.AircraftFlightHours - 1000;
        } else {
            this.AircraftFlightHours = 0;
        }
    }

    // Скучный раздел геттеров и сеттеров

    public String getAircraftType() {
        return AircraftType;
    }

    public String getAircraftModel() {
        return AircraftModel;
    }

    public double getAircraftMaxZFW() {
        return AircraftMaxZFW;
    }

    public int getAircraftPAX() {
        return AircraftPAX;
    }

    public int getAircraftAirlineID() {
        return AircraftAirlineID;
    }

    public void setAircraftType(String aircraftType) {
        AircraftType = aircraftType;
    }

    public void setAircraftModel(String aircraftModel) {
        AircraftModel = aircraftModel;
    }

    public void setAircraftMaxZFW(double aircraftMaxZFW) {
        AircraftMaxZFW = aircraftMaxZFW;
    }

    public void setAircraftPAX(int aircraftPAX) {
        AircraftPAX = aircraftPAX;
    }

    public void setAircraftAirlineID(int aircraftAirlineID) {
        AircraftAirlineID = aircraftAirlineID;
    }
}

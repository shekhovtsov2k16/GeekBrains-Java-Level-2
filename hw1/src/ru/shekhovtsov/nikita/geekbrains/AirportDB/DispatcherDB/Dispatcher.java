package ru.shekhovtsov.nikita.geekbrains.AirportDB.DispatcherDB;

import ru.shekhovtsov.nikita.geekbrains.AirportDB.Airport;


/*
    Класс/Таблица Диспетчер

    Содержит следующие поля:
        DispatcherCallsign  - позывной диспетчера (например: UUDD_TWR - Домодедово Вышка, ULLI_APP - Пулково подход)
        DispatcherFrequency - частота данного диспетчера (например: частота UNICOM (общая) - 122.800 Мгц)
 */

public class Dispatcher extends Airport {

    private String DispatcherCallsign;
    private String DispatcherFrequency;

    public Dispatcher(Airport airport, String callsign, String frequency) {
        super(airport.AirportID, airport.getAirportName(), airport.getAirportPaxFlow());
        DispatcherCallsign = callsign;
        DispatcherFrequency = frequency;
    }

    @Override
    public void viewInfo() {
        System.out.println("---Dispatcher info---");
        System.out.println("Belongs to " + super.getAirportName());
        System.out.println("Callsign  - " + DispatcherCallsign);
        System.out.println("Frequency - " + DispatcherFrequency);
        System.out.println();
    }

    // Скучный раздел геттеров и сеттеров
    public String getCallsign() {
        return DispatcherCallsign;
    }

    public String getFrequency() {
        return DispatcherFrequency;
    }

    public void setCallsign(String callsign) {
        DispatcherCallsign = callsign;
    }

    public void setFrequency(String frequency) {
        DispatcherFrequency = frequency;
    }
}

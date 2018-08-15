package ru.shekhovtsov.nikita.geekbrains.AirportDB.RunwayDB;

import java.util.Random;

import ru.shekhovtsov.nikita.geekbrains.AirportDB.Airport;

/*
    Таблица/класс ВПП (Взлетно Посадочных Полос). (См. даталогическую схему)

    Содержит следующие поля:
        RunwayNumber  - номер полосы в обоих направлениях (номер полосы определяется не случайно,
                        а по ближайшему круглому курсу, в сторону которого идёт полоса, например:
                        если курс полосы 349, то ее номер - 35, если полосы расположены параллельно
                        то добавляются буквы L или R (left/right)/
        RunwayCoating - тип покрытия ВПП
        RunwayLength  - длинна ВПП (указывается в футах)

*/

public class Runway extends Airport implements ATIS {


    private String RunwayNumber;
    private String RunwayCoating;
    private int RunwayLength;

    public Runway(Airport airport, String runwayNumber, String runwayCoating, int runwayLength) {
        super(airport.AirportID, airport.getAirportName(), airport.getAirportPaxFlow());
        RunwayNumber = runwayNumber;
        RunwayCoating = runwayCoating;
        RunwayLength = runwayLength;
    }

    @Override
    public void viewInfo() {
        System.out.println("---Runway info---");
        System.out.println("Runway belongs to - " + super.getAirportName());
        System.out.println("Runway number     - " + RunwayNumber);
        System.out.println("Runway coating    - " + RunwayCoating);
        System.out.println("Runway length     - " + RunwayLength + "ft");
        System.out.println();
    }


    // Запросить METAR данной ВПП (подробнее в описании интерфейса ATIS)
    /*
        METAR (METeorological Aerodrome Report) — авиационный метеорологический
        код для передачи сводок о фактической погоде на аэродроме.
        Также является кодовым названием регулярной сводки, составленной в одноимённом коде.
     */
    @Override
    public void requestATIS() {
        // Генерация кода погоды не случайна, я же, сделаю наоборот :D
        Random random = new Random();
        String weatherCode = weatherInfoCode[random.nextInt(weatherInfoCode.length)];
        System.out.println("_______________________________________");
        System.out.println("Weather information " + weatherCode);
        // Здесь должна быть загрузка метара из интернета, я сделаю статично
        System.out.println(super.AirportID + " 141300Z 25005MPS 210V280 CAVOK 24/06 Q1015 R88/010095 NOSIG");
    }


    // Скучный раздел геттеров и сеттеров
    public String getRunwayNumber() {
        return RunwayNumber;
    }

    public String getRunwayCoating() {
        return RunwayCoating;
    }

    public int getRunwayLength() {
        return RunwayLength;
    }

    public void setRunwayNumber(String runwayNumber) {
        RunwayNumber = runwayNumber;
    }

    public void setRunwayCoating(String runwayCoating) {
        RunwayCoating = runwayCoating;
    }

    public void setRunwayLength(int runwayLength) {
        RunwayLength = runwayLength;
    }
}

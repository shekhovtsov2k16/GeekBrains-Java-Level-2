package ru.shekhovtsov.nikita.geekbrains;


public class Main {

    public static void main(String[] args) {

        // Инициализация ВС
        Aircraft b7373 = new Aircraft(6800, 2);
        Aircraft b7378 = new Aircraft(6800, 3);
        Aircraft a319  = new Aircraft(5600, 0);
        // Инициализация ВПП
        Runway l14 = new Runway(6000);
        // По умолчанию метеоминимум 0, сгенерируем случайное
        l14.generateWeatherConditions();
        l14.viewInfo();
        try {
            l14.landTheAircraft(a319);
        } catch (NotClearedToLandException e) {
            System.out.println(e.getMessage());
        }


    }
}


// With best wishes Shekhovtsov N.D.
// BLESS RNG

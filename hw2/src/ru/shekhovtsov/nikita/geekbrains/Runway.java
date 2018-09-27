package ru.shekhovtsov.nikita.geekbrains;

import java.util.Random;

/*
    Класс ВПП реализующий генерацию погодных условий

    Генерация погодных условий происходит случайно.
    Текущая погода в аэропорту - число (от 0 до 2).
    Чем больше число, тем хуже погода.
        0 - штиль, максимальная видимость, CAVOK
        1 - ветер с порывами до 10-15 узлов, облачность выше 5000 футов, видимость
            в пределах аэропорта
        2 - сильный боковой ветер с порывами до 40 узлов, гроза, нижний уровень облачности
            ниже 2000 футов, видимость уровня CAT III (оч плохая, лучше на запасной)

    Имя аэропорта, к которому принадлежит данная ВПП генерируется автоматически
    для упрощения процесса реализации.
    Длина ВПП передается В ФУТАХ в конструктор

    Подробнее о каждом методе см. тело класса


 */

public class Runway implements WeatherConditionsInterface {

    // Массив названий аэропортов из которого берется случайное
    private final static String[] icaoCodes = { "URSS(Sochi)", "UWWW(Kurumoch)", "UUWW(Vnukovo)",
            "UUEE(Sheremetevo)", "UUDD(Domodedovo)", "ULLI(Pulkovo)"};
    // Переменные класса
    // Длина ВПП
    private int runwayLength;
    // Имя аэропорта, в котором расположена данная ВПП
    private String airportName;
    // Погодные условия (по умолчанию - 0)
    private int airportWeatherCondition;

    // Конструктор класса ВПП, всё как я и говорил
    // случайное Имя, погодные условия - 0
    Runway(int length) {
        Random random = new Random();
        airportName = icaoCodes[random.nextInt(icaoCodes.length)];
        this.runwayLength = length;
        airportWeatherCondition = 0;
    }

    // Метод "сажающий самолет"
    // АХТУНГ: может выкинуть исключение NotClearedToLandException
    //         если: полоса короче чем минимум ВС, погодные условия
    //         хуже чем минимум погодных условий ВС
    void landTheAircraft(Aircraft aircraft) throws NotClearedToLandException {
        if (aircraft.getMinLangingLength() <= this.runwayLength) {
            if (aircraft.getMinWeatherCondition() >= this.airportWeatherCondition) {
                System.out.println("Aircraft successfully landed at " + this.airportName);
            } else {
                throw new NotClearedToLandException("Forbidden landing at " + this.airportName + " due to weather conditions");
            }
        } else {
            throw new NotClearedToLandException("Forbidden landing at " + this.airportName + " due to short runway");
        }
    }


    // Метод выводящий информацию о ВПП
    void viewInfo() {
        System.out.println(airportName);
        System.out.println("Runway length: " + runwayLength);
        System.out.println("Weather near airport: " + airportWeatherCondition);
    }


    // Генерация погоды (случайно)
    @Override
    public void generateWeatherConditions() {
        Random random = new Random();
        airportWeatherCondition = random.nextInt(3);
    }
}

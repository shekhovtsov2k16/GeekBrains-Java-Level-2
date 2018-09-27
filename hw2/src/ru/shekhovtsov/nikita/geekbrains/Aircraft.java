package ru.shekhovtsov.nikita.geekbrains;

/*
    Класс ВС

    Для создания ВС в конструктор передать минимальную длину ВПП для посадки
    и минимальные погодные условия в пределах которых можно посадить самолет.
 */

class Aircraft {

    // Минимум длины ВПП
    private int minLangingLength;
    // Метеоминимум
    private int minWeatherCondition;

    // Конструктор класса ВС, передать минимум длины ВПП и метеоминимум
    Aircraft(int minLangingLength, int minWeatherCondition) {
        this.minLangingLength = minLangingLength;

        // Защита от дурака, в моей программе погодные условия - число от 0 до 2ух
        if (minWeatherCondition >= 0 & minWeatherCondition <= 2) {
            this.minWeatherCondition = minWeatherCondition;
        } else {
            this.minWeatherCondition = 2;
        }
    }

    // Скучный раздел геттеров и сеттеров
    int getMinLangingLength() {
        return minLangingLength;
    }

    int getMinWeatherCondition() {
        return minWeatherCondition;
    }
}

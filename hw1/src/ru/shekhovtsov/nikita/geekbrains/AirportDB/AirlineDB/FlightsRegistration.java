package ru.shekhovtsov.nikita.geekbrains.AirportDB.AirlineDB;

import ru.shekhovtsov.nikita.geekbrains.AirportDB.Airport;

public interface FlightsRegistration {

    /*
        register - зарегестрировать перелёт ВС
        указать аэропорт вылета и аэропорт прилёта, один из них
        ДОЛЖЕН быть аэропортом базирования данной авиакомпании. Указать время пути.

        В мире гражданской авиации существует два известных мне типов перелёта.
        ППП - Правила Полетов по Приборам
        ПВП - Правила Визаульных Полетов
        К ППП допускаются судна оборудованные специальными радиосредствами
        К ПВП любое "корыто" способное летать

        Привязку допуска ВС к одному из типов перелета добавлять не стал, так
        как и так уже много "ерунды" добавил в свой проект
    */

    void registerVFR(Airport dep, Airport arr, int flightTime);
    void registerIFR(Airport dep, Airport arr, int flightTime, double flightLevel);
}

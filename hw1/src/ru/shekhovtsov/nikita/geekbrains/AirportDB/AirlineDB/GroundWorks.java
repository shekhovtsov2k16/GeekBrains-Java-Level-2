package ru.shekhovtsov.nikita.geekbrains.AirportDB.AirlineDB;

/*
    Интерфейс описывающий наземные работы над ВС

    Содержит следующие методы:
        changeEngines  - замена двигателей        (минус 5000 часов к налёту ВС)
        changeGears    - замена стоек шасси       (минус 2500 часов к налёту ВС)
        changeAvionics - замена радиооборудования (минус 1000 часов к налёту ВС)
 */

public interface GroundWorks {

    void changeEngines();
    void changeGears();
    void changeAvionics();

}

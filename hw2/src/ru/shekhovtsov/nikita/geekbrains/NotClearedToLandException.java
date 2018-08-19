package ru.shekhovtsov.nikita.geekbrains;

/*
    Класс исключение запрещающее ВС садиться в аэропорту
 */

class NotClearedToLandException extends Exception {

    NotClearedToLandException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

package ru.java;

import ru.java.lesson8.models.TableModel;
import ru.java.lesson8.presenters.BookingPresenter;
import ru.java.lesson8.presenters.Model;
import ru.java.lesson8.presenters.View;
import ru.java.lesson8.views.BookingView;

import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /**
         * TODO: ДОМАШНЕЕ ЗАДАНИЕ: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
         * @param args
         */
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 2, "Станислав");
        //Старая бронь удалена, новая зарегистрирована
        view.changeReservationTable(1001, new Date(), 3, "Станислав");
    }
}

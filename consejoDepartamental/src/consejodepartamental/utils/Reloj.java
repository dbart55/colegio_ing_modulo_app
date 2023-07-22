package consejodepartamental.utils;

import java.util.Calendar;
import javax.swing.Timer;

/**
 *
 * @author Diego
 */
public class Reloj {

    private final String[] dayNames = new String[]{"domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
    private final String[] monthNames = new String[]{"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "setiembre", "octubre", "noviembre", "diciembre"};

    public Reloj(TimerFunction callback) {
        Timer timer = new Timer(1000, e -> actualizarTiempo(callback));
        timer.start();
    }

    private void actualizarTiempo(TimerFunction callback) {
        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH);
        int year = now.get(Calendar.YEAR);

        int dayWeek = now.get(Calendar.DAY_OF_WEEK);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minutes = now.get(Calendar.MINUTE);
        int seconds = now.get(Calendar.SECOND);

        //11:40:10 a. m.
        //viernes, 14 de abril de 2023
        String amOrPm = (12 <= hour && hour <= 23) ? "p. m." : "a. m.";
        int formatedHour = (13 <= hour && hour <= 23) ? (hour - 12) : (hour == 0) ? 12 : hour;
        String formatedTime = String.format("%02d", formatedHour) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds) + " " + amOrPm;

        String dayName = this.dayNames[dayWeek - 1];
        String monthName = this.monthNames[month];

        String formatedDate = dayName + ", " + day + " de " + monthName + " de " + year;

        callback.getTime(formatedDate, formatedTime);
    }

}

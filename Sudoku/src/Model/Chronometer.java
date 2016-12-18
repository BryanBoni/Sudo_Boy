package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 * This class is use to set a chronometer for the window.
 *
 * @author BryanBoni
 */
public class Chronometer extends Thread {

    private Thread thread = null;

    private SimpleDateFormat chronoFormat;

    private String[] split;

    private SimpleStringProperty hour;
    private SimpleStringProperty min;
    private SimpleStringProperty sec;
    private SimpleStringProperty timeCurrent;

    private long time;

    /**
     * The constructor where the time, format and properties are initiated.
     */
    public Chronometer() {
        chronoFormat = new SimpleDateFormat("h:mm:ss");

        min = new SimpleStringProperty("00");
        sec = new SimpleStringProperty("00");
        hour = new SimpleStringProperty("00");
        timeCurrent = new SimpleStringProperty("00:00:00");
    }

    /**
     * Used to start or pause the chronometer.
     * 
     * @param time the chronometer to start/pause.
     */
    public void startPauseTimer(long time) {
        this.time = time;
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

    /**
     * Used to stop the chronometer.
     *
     * @param time the chronometer we want to stop.
     */
    public void stopTimer(long time) {
        if (thread != null) {
            thread.interrupt();
        }
        this.time = time;
        setTime(time);
    }

    /**
     * Used to set the current time of the chronometer.
     *
     * @param time the new value of the chronometer.
     */
    public void setTime(long time) {
        this.time = time;
        split = chronoFormat.format(new Date(time)).split(":");

        hour.set(split[0]);
        min.set(split[1]);
        sec.set(split[3]);
        /*
        if (split[2].length() == 1) {
            split[2] = "0" + split[2];
        }*/
        //millis.set(split[2].substring(0, 2));

        timeCurrent.set(hour.get() + ":" + min.get() + ":" + sec.get());
    }

    /**
     *
     * @return in a long value the var time.
     */
    public long getTime() {
        return time;
    }

    /**
     *
     * @return the current time value.
     */
    public SimpleStringProperty getCurrentTime() {
        return timeCurrent;
    }

    /**
     * use to run the chronometer.
     */
    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                setTime(time);
                sleep(10);
                time = time + 10;
            }
        } catch (Exception e) {
        }

    }
}

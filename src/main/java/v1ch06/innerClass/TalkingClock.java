package v1ch06.innerClass;

import javafx.scene.control.TableColumn;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * A clock that prints the time in regular intervals.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     *
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start() {
        // 使用内部类
        ActionListener listener = new TimePrinter(this); // this.new TimePrinter()
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class TimePrinter implements ActionListener {

        private TalkingClock outer;


        public TimePrinter(TalkingClock clock) // automatically generated code

        {
            this.outer = clock; // outer 不是 Java 的关键字。 我们只是用它说明内部类中的机制
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is " + new Date());
            if (outer.beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
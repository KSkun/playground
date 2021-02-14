package moe.ksmeow.design.observer;

import moe.ksmeow.design.IDesignExample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

// an example of observer pattern
// using some observable objects in javax.swing.*
public class ObserverExample implements IDesignExample {
    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public ObserverExample() {
        button = new JButton("Test"); // observable
        button.addActionListener(new TestListener()); // add observer

        panel = new JPanel();
        panel.add(button);

        frame = new JFrame("Observer Pattern Example"); // observable
        frame.addWindowListener(new WindowAdapter() { // add observer
            @Override
            public void windowClosing(WindowEvent e) {
                // set action for the specified event
                // when the close button is clicked, the program will exit
                System.exit(0);
            }
        });
        frame.getContentPane().add(panel);
        frame.pack();
    }

    private class TestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // set action for the specified event
            // when the test button is clicked, the logger will output one line as below
            Logger.getLogger("observer_example").info("Test button is clicked");
        }
    }

    @Override
    public void runExample() {
        frame.setVisible(true);
    }
}

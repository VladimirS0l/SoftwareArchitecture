package ru.java.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.java.views.panel.ClientsPanel;
import ru.java.views.panel.ConsultationsPanel;
import ru.java.views.panel.PetPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ru.java.constant.ConstantsViews.*;

/**
 * Главное окно программы с вкладками
 */
public class MainWindow extends JFrame{
    JButton allClient = new JButton("Обновить");
    JButton exit = new JButton("Exit");

    public MainWindow() throws JsonProcessingException {
        JFrame jFrame = new JFrame("Clinic");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setLocation(WINDOW_POSX, WINDOW_POSY);
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Clients", new ClientsPanel());
        jTabbedPane.addTab("Consultation", new ConsultationsPanel());
        jTabbedPane.addTab("Pet", new PetPanel());

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        allClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTabbedPane.repaint();
            }
        });

        jFrame.add(jTabbedPane);
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(allClient);
        panBottom.add(exit);
        jFrame.add(panBottom, BorderLayout.SOUTH);
        jFrame.setVisible(true);

    }
}

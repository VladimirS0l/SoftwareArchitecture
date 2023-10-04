package ru.java.views.panel.client;

import ru.java.constant.ConstantsViews;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Отправка формы с ID клиента, которого нужно удалить
 */
public class DeleteClient extends JFrame {
    JTextField field;
    public DeleteClient() {
        setLayout(new GridLayout(1, 2));
        setSize(500, 300);
        setLocation(700, 250);
        // Создание текстовых полей
        field = new JTextField( 25);
        field.setToolTipText("Длиное поле");
        field.setFont(new Font("Dialog", Font.PLAIN, 14));
        field.setHorizontalAlignment(JTextField.LEFT);

        JButton send = new JButton("Удалить");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClient(field.getText());
                setVisible(false);
                dispose();
            }
        });

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(new JLabel("Введите ID: "));
        contents.add(field);

        contents.add(send);
        setContentPane(contents);
        // Определяем размер окна и выводим его на экран
        setSize(400, 300);
        setVisible(true);
    }

    private void deleteClient(String id) {
        String url = ConstantsViews.URL+"client/" + id + "/delete";
        ConstantsViews.restTemplate.delete(url);
    }
}

package ru.java.views.panel.client;

import org.springframework.http.HttpEntity;
import ru.java.constant.ConstantsViews;
import ru.java.model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Отправка формы с редактированными данными клиента
 */
public class UpdateClient extends JFrame {
    JTextField field1, field, field2, field3, field4;
    public UpdateClient() {
        setLayout(new GridLayout(1, 6));
        setSize(500, 300);
        setLocation(700, 250);
        // Создание текстовых полей
        field = new JTextField( 25);
        field.setToolTipText("Длиное поле");
        field.setFont(new Font("Dialog", Font.PLAIN, 14));
        field.setHorizontalAlignment(JTextField.LEFT);

        field1 = new JTextField(25);
        field1.setToolTipText("Длиное поле");
        field1.setFont(new Font("Dialog", Font.PLAIN, 14));
        field1.setHorizontalAlignment(JTextField.LEFT);

        field2 = new JTextField(25);
        field2.setToolTipText("Длиное поле");
        field2.setFont(new Font("Dialog", Font.PLAIN, 14));
        field2.setHorizontalAlignment(JTextField.LEFT);

        field3 = new JTextField(25);
        field3.setToolTipText("Длиное поле");
        field3.setFont(new Font("Dialog", Font.PLAIN, 14));
        field3.setHorizontalAlignment(JTextField.LEFT);

        field4 = new JTextField( 25);
        field4.setToolTipText("Длиное поле");
        field4.setFont(new Font("Dialog", Font.PLAIN, 14));
        field4.setHorizontalAlignment(JTextField.LEFT);

        JButton send = new JButton("Редактировать");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClient(field.getText(), field1.getText(), field2.getText(), field3.getText(), field4.getText());
                setVisible(false);
                dispose();
            }
        });

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(new JLabel("ID"));
        contents.add(field);
        contents.add(new JLabel("Document"));
        contents.add(field1);
        contents.add(new JLabel("Surname"));
        contents.add(field2);
        contents.add(new JLabel("Firstname"));
        contents.add(field3);
        contents.add(new JLabel("Birthday"));
        contents.add(field4);
        contents.add(send);
        setContentPane(contents);
        // Определяем размер окна и выводим его на экран
        setSize(400, 350);
        setVisible(true);
    }

    private void updateClient(String id, String document, String surname, String firstname, String birthday) {
        String url = ConstantsViews.URL+"client/" + id + "/update";
        HashMap<String, String> map = new HashMap<>();
        map.put("clientId", id);
        map.put("document", document);
        map.put("surName", surname);
        map.put("firstName", firstname);
        map.put("birthday", birthday);
        HttpEntity<HashMap<String, String>> request = new HttpEntity<>(map);
        ConstantsViews.restTemplate.put(url, request, Client.class);
    }
}

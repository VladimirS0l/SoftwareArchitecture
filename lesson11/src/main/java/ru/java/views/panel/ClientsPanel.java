package ru.java.views.panel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.java.model.Client;
import ru.java.views.panel.client.CreateClient;
import ru.java.views.panel.client.DeleteClient;
import ru.java.views.panel.client.UpdateClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import static ru.java.constant.ConstantsViews.URL;
import static ru.java.constant.ConstantsViews.restTemplate;

/**
 * Блок с таблицей Клиенты
 */

public class ClientsPanel extends JPanel {
    JButton create = new JButton("Создать");
    JButton update = new JButton("Редактировать");
    JButton delete = new JButton("Удалить");
    JButton refresh = new JButton("Обновить таблицу");

    public ClientsPanel() throws JsonProcessingException {
        DefaultTableModel tableModel = new DefaultTableModel(getAllClientsVector(getColumnHeaderVector()),
                getColumnHeaderVector());
//Set data and columns in tableModel to JTable
        JTable yourTable= new JTable(tableModel);

//After data Changed fire change detector

        JPanel panCenter = new JPanel();
        JPanel panSouth = new JPanel(new GridLayout(4, 1));
        panCenter.add(yourTable);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateClient();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateClient();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteClient();
            }
        });
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ClientsPanel();
                } catch (JsonProcessingException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(panCenter, BorderLayout.NORTH);
        panSouth.add(create);
        panSouth.add(update);
        panSouth.add(delete);
        panSouth.add(refresh);
        add(panSouth, BorderLayout.SOUTH);
        setVisible(true);

    }

    private JTable updateTable(Vector<Vector<String>> data, Vector<String> headers) {
        JTable table1 = new JTable(data, headers);
        table1.setRowHeight(30);
        table1.setRowHeight(1, 20);
        table1.setIntercellSpacing(new Dimension(10, 10));
        table1.setGridColor(Color.black);
        table1.setShowVerticalLines(true);
        table1.setForeground(Color.black);
        table1.setSelectionForeground(Color.yellow);
        table1.setSelectionBackground(Color.blue);
        table1.setShowGrid(true);
        return table1;
    }

    private Vector<String> getColumnHeaderVector() {
        return new Vector<>(java.util.List.of("ID", "Document", "Surname", "Firstname", "Birthday"));
    }

    private java.util.List<Client> getAllClients() throws JsonProcessingException {
        String url = URL+"client/all";
        String responce = restTemplate.getForObject(url, String.class);

        System.out.println(responce);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responce);

        int count = 0;
        java.util.List<Client> clients = new ArrayList<>();
        while (jsonNode.has(count) ) {
            Integer id = Integer.parseInt(String.valueOf(jsonNode.get(count).get("clientId")));
            String document = String.valueOf(jsonNode.get(count).get("document"));
            String surname = String.valueOf(jsonNode.get(count).get("surName"));
            String firstname = String.valueOf(jsonNode.get(count).get("firstName"));
            Long temp = Long.parseLong(String.valueOf(jsonNode.get(count).get("birthday")));
            Instant i = Instant.ofEpochMilli(temp);
            i = i.truncatedTo(ChronoUnit.SECONDS);
            Date birthday = Date.from(i);
            clients.add(new Client(id, document, surname, firstname, birthday));
            count++;
        }
        return clients;
    }

    private Vector<Vector<String>> getAllClientsVector(Vector<String> header) throws JsonProcessingException {
        String url = URL+"client/all";
        String responce = restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responce);

        int count = 0;
        Vector<Vector<String>> clients = new Vector<>();
        clients.add(header);
        while (jsonNode.has(count) ) {
            String id = String.valueOf(jsonNode.get(count).get("clientId"));
            String document = String.valueOf(jsonNode.get(count).get("document"));
            String surname = String.valueOf(jsonNode.get(count).get("surName"));
            String firstname = String.valueOf(jsonNode.get(count).get("firstName"));
            Long temp = Long.parseLong(String.valueOf(jsonNode.get(count).get("birthday")));
            Instant i = Instant.ofEpochMilli(temp);
            i = i.truncatedTo(ChronoUnit.SECONDS);
            String birthday = String.valueOf(Date.from(i));
            clients.add(new Vector<>(List.of(id, document, surname, firstname, birthday)));
            count++;
        }
        return clients;
    }

}

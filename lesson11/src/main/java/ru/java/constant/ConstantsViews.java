package ru.java.constant;

import org.springframework.web.client.RestTemplate;

public class ConstantsViews {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int WINDOW_POSX = 500;
    public static final int WINDOW_POSY = 200;
    public static final String URL = "http://localhost:8080/";
    public static RestTemplate restTemplate = new RestTemplate();
}

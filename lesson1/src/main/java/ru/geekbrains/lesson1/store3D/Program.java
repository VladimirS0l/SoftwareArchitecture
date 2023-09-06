package ru.geekbrains.lesson1.store3D;

import ru.geekbrains.lesson1.store3D.inmemory.ModelStore;
import ru.geekbrains.lesson1.store3D.inmemory.Observer1;
import ru.geekbrains.lesson1.store3D.models.*;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        Observer1 observer1 = new Observer1();

        ModelStore store = new ModelStore();
        store.RegisterModelChanger(observer1);

        Poligon p1 = new Poligon();
        List<Poligon> poligons = new ArrayList<>();
        poligons.add(p1);
        PoligonalModel poligonalModel = new PoligonalModel(poligons);
        store.add(poligonalModel);
        Color color = new Color("green");
        Point3D point3D = new Point3D(3, 3.1, 5);
        Angle3D angle3D = new Angle3D(20, 30, 40);
        Flash flash = new Flash(point3D, angle3D, color, 330F);
        List<Flash> flashes = new ArrayList<>();
        flashes.add(flash);
        List<PoligonalModel> poligonalModels = new ArrayList<>();
        poligonalModels.add(poligonalModel);
        Camera camera = new Camera(point3D, angle3D);
        Scene scene = new Scene(poligonalModels,flashes);
        store.add(flash);
        store.add(scene);
        store.add(camera);
        System.out.println(store);

    }

}

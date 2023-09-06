package ru.geekbrains.lesson1.store3D.inmemory;

import ru.geekbrains.lesson1.store3D.models.Camera;
import ru.geekbrains.lesson1.store3D.models.Flash;
import ru.geekbrains.lesson1.store3D.models.PoligonalModel;
import ru.geekbrains.lesson1.store3D.models.Scene;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModelStore implements IModelChanger {

    private List<ModelChangedObserver> observers = new ArrayList<>();

    private List<PoligonalModel> models = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();

    public void add(PoligonalModel model){
        models.add(model);
        notifyChange();
    }

    public void add(Camera camera){
        cameras.add(camera);
        notifyChange();
    }

    public void add(Flash flash){
        flashes.add(flash);
        notifyChange();
    }

    public void add(Scene scene){
        scenes.add(scene);
        notifyChange();
    }
    public Scene getScene(int id) {
        return scenes.stream().filter((c) -> c.getId() == id).findFirst().get();
    }

    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : observers){
            observer.applyUpdateModel();
        }
    }

    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {
        observers.remove(o);
    }

    @Override
    public String toString() {
        return "ModelStore{" +
                "\nobservers=" + observers +
                ", \nmodels=" + models +
                ", \nflashes=" + flashes +
                ", \nscenes=" + scenes +
                ", \ncameras=" + cameras +
                '}';
    }
}

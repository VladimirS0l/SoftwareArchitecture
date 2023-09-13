package ru.java.project3d.service;

import ru.java.project3d.db.DatabaseAccess;
import ru.java.project3d.entity.Entity;
import ru.java.project3d.entity.Model3D;
import ru.java.project3d.entity.Texture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class EditorBusinessLogicalLayer implements BusinessLogicalLayer{

    private DatabaseAccess databaseAccess;


    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels())
            processRender(model);
    }

    private Random random = new Random();

    private void processRender(Model3D model){
        try
        {
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public void addModel() {
        Model3D model = new Model3D();
        Collection<Texture> collectionTexture = new ArrayList<>();
        for (int i = 0; i < random.nextInt(3); i++) {
            Texture tx = new Texture();
            collectionTexture.add(tx);
        }
        databaseAccess.addEntity(model);
    }

    public void deleteModel(int id) {
        databaseAccess.removeEntity(id);
    }

    @Override
    public void editModel(int id) {
        //Просто рандомно создаю новые текстуры для изменения модели, ID модели останется тот же, содержание изменится
        Model3D model = new Model3D();
        Collection<Texture> collectionTexture = new ArrayList<>();
        for (int i = 0; i < random.nextInt(3); i++) {
            Texture tx = new Texture();
            collectionTexture.add(tx);
        }
        databaseAccess.editEntity(model, id);
    }
}

package ru.java.project3d.service;

import ru.java.project3d.entity.Model3D;
import ru.java.project3d.entity.Texture;

import java.util.Collection;

public interface BusinessLogicalLayer{
    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();

    public void addModel();
    public void deleteModel(int id);

    public void editModel(int id);
}

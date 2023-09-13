package ru.java.project3d.db;



import ru.java.project3d.entity.Entity;
import ru.java.project3d.entity.Model3D;
import ru.java.project3d.entity.Texture;

import java.util.Collection;

public interface DatabaseAccess{
    void addEntity(Entity entity);
    void removeEntity(int id);
    void editEntity(Entity entity, int id);
    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();
}

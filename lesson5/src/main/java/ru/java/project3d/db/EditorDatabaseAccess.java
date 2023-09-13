package ru.java.project3d.db;



import ru.java.project3d.entity.Entity;
import ru.java.project3d.entity.Model3D;
import ru.java.project3d.entity.Texture;
import ru.java.project3d.exception.NotFoundModelInDbException;

import java.util.ArrayList;
import java.util.Collection;

public class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity: editorDatabase.getAll()) {
            if (entity instanceof Model3D)
            {
                models.add((Model3D)entity);
            }
        }
        return models;
    }
    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> models = new ArrayList<>();
        for (Entity entity: editorDatabase.getAll()) {
            if (entity instanceof Texture)
            {
                models.add((Texture)entity);
            }
        }
        return models;
    }

    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(int id) {
        Entity entity = editorDatabase.getOneEntityById(id);
        editorDatabase.getAll().remove(entity);
    }

    @Override
    public void editEntity(Entity entity, int id) {
        Model3D temp = (Model3D) entity;
        Model3D updateEntity = (Model3D) editorDatabase.getOneEntityById(id);
        editorDatabase.getAll().remove(updateEntity);
        updateEntity.setTextures(temp.getTextures());
        editorDatabase.getAll().add(updateEntity);
    }
}

package ru.java.project3d.db;

import ru.java.project3d.config.ProjectFile;
import ru.java.project3d.entity.Entity;
import ru.java.project3d.entity.Model3D;
import ru.java.project3d.entity.Texture;
import ru.java.project3d.exception.NotFoundModelInDbException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Random;

public class EditorDatabase implements Database {

    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: Загрузка всех сущностей проекта (модели, текстуры и т. д)
    }

    @Override
    public void save() {
        //TODO: Сохранение текущего состояния всех сущностей проекта
    }

    public Collection<Entity> getAll(){
        if (entities == null){
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures(){
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++){
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }

    @Override
    public Entity getOneEntityById(int id) {
        return entities.stream().filter((c) -> c.getId() == id).findFirst().
                orElseThrow(() -> new NotFoundModelInDbException("Модели с id#" + id + " нет в базе данных"));
    }
}

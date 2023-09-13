package ru.java.project3d.db;

import ru.java.project3d.entity.*;

import java.util.Collection;
import java.util.Optional;

public interface Database{
    void load();

    void save();

    Collection<Entity> getAll();

    Entity getOneEntityById(int id);
}
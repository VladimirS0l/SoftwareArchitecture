package ru.java.project3d.ui;

interface UILayer{

    void openProject(String fileName);
    void showProjectSettings();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int i);

    void addNewModel();

    void deleteModel(int idModel);
    void editModel(int idModel);

}

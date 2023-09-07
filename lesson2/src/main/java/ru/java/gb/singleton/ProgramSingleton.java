package ru.java.gb.singleton;

public class ProgramSingleton {
    public static void main(String[] args) {
        ClassSingleton classSingleton1 = ClassSingleton.getInstance();
        System.out.println(classSingleton1.getInfo() + " ---> class1" + "\n------------------------------------");
        ClassSingleton classSingleton2 = ClassSingleton.getInstance();

        classSingleton2.setInfo("Edit singleton 2, Singleton 2 getInfo");

        System.out.println(classSingleton1.getInfo() + " ---> class1");
        System.out.println(classSingleton2.getInfo() + " ---> class2");
    }
}

package ru.geekbrains.lesson1.store3D.models;

public class Camera {

    private Point3D location;
    private Angle3D angle;

    public Camera() {
    }

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public void rotate(Angle3D angle) {
        System.out.println("Camera rotated " + angle + " degrees");
    }

    public void move(Point3D point) {
        System.out.println("Camera moved to the point " + point);
    }

    public Point3D getLocation() {
        return location;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void setAngle(Angle3D angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "location=" + location +
                ", angle=" + angle +
                '}';
    }
}

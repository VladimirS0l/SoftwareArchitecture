package ru.geekbrains.lesson1.store3D.models;

public class Flash {

    private Point3D location;
    private Angle3D angle;
    private Color color;
    private Float power;

    public Flash(Point3D location, Angle3D angle, Color color, Float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Flash() {
    }

    public void rotate(Angle3D angle) {
        System.out.println("Flash rotated " + angle + " degrees");
    }

    public void move(Point3D point) {
        System.out.println("Flash moved to the point " + point);
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Flash{" +
                "location=" + location +
                ", angle=" + angle +
                ", color=" + color +
                ", power=" + power +
                '}';
    }
}


package Lectures.wk4;

class Rectangle {
    private double width, length;

    Rectangle(double w, double l) {
        width = w;
        length = l;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double w) {
        width = w;
    }

    public void getLength(double l) {
        length = l;
    }

    public double getArea() {
        return width * length;
    }

    public String toString() {
        return "width: " + width +
                "\tlength: " + length +
                "\tVolume: " + getArea();
    }
}
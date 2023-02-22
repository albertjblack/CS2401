public class Box<DIM> {
    DIM length;
    DIM width;
    DIM height;

    Box() {
        System.out.println("Hello");
    }

    Box(DIM length, DIM width, DIM height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

};
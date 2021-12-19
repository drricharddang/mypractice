package working;

class Box {
    double width;
    double length;
    double depth;

    Box (double width, double length, double depth) {
        this.width = width;
        this.length = length;
        this.depth = depth;
    }

    Box (Box box) {
        this.width = box.width;
        this.length = box.length;
        this.depth = box.depth;
    }

    Box (double d) {
        this.width = this.length = this.depth = d;
    }

    double volume() {
        return width * length * depth;
    }

    static void doubleBox(Box b) {
        b.width *= 2;
        b.length *= 2;
        b.depth *=2;
    }
}
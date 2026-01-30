public class calculate {
    void area(int length , int width){
        int tarea = length * width;
        System.out.println("Area of rectangle = " + tarea);
    }
    void area(double radius){
        double carea = 3.14 * radius * radius;
        System.out.println("Area of circle = " + carea);
    }
    public static void main(String[] args) {
        calculate cal = new calculate();
        cal.area(10 , 20);
        cal.area(10);
    }
}

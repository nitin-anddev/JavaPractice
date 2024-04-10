package oops.polymorphism;

class Triangle extends Shape {
    private void so(){
        area(); //accessing area through inheritance
    }
    //overriding area through runtime polymorphism
    @Override
    public void area() {
        System.out.println("Triangle is 1/2 * base * height");
    }
}

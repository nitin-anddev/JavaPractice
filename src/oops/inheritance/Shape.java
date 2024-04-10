package oops.inheritance;

public class Shape {

    protected Shape(){}
    private String color;

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int doubleHeight(int height){
        return height * 2;
    }


}

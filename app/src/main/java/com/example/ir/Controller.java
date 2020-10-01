package com.example.ir;

public class Controller {
    public  int frequency;
    public String name;
   public String top_button;
   public String bottom_button;
   public String left_button;
   public String right_button;
   public String plus_button;
   public String minus_button;

    public Controller(int frequency, String name, String top_button, String bottom_button, String left_button, String right_button, String plus_button, String minus_button, String ok_button) {
        this.frequency = frequency;
        this.name = name;
        this.top_button = top_button;
        this.bottom_button = bottom_button;
        this.left_button = left_button;
        this.right_button = right_button;
        this.plus_button = plus_button;
        this.minus_button = minus_button;
        this.ok_button = ok_button;
    }

    String ok_button;

}

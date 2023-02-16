package com.home.spring.util;
class Product   {   

         int price, bonusPoint;    

         Product(int price) { 

              this.price = price; 

              bonusPoint =(int)(price/10.0);   

         }

}

class Tv extends Product {

    Tv() {

         super(1);

    }

   public String toString() {

       return "Tv";

   }

}

public class Test5 {   

     public static void main(String[] args) { 

           Tv t = new Tv();

          System.out.println(t);

      }

}
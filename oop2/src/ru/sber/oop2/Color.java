package ru.sber.oop2;

public enum Color {
   Orange("Оранжевый"),
   Green("Зеленый"),
   Purple("Фиолетовый"),
   White("Белый"),
    Black("Чёрный");




    private String colorName;
       Color(String colorName){
           this.colorName = colorName;
       }


    @Override
    public String toString(){
           return colorName;
           }
}

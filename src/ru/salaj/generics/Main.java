package ru.salaj.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    //Ковариантность — это сохранение иерархии наследования исходных типов в производных типах в том же порядке.
    // Например, если Кошка — это подтип Животные, то Множество<Кошки> — это подтип Множество<Животные>.
    // Следовательно, с учетом принципа подстановки можно выполнить такое присваивание:
    //Множество<Животные>  = Множество<Кошки>
private static void covariance(){
    String[] str = new String[] {"a","b","c"};
    Object[] obj = str;
    obj[0] = "q";
    obj[1] = 23; //java.lang.ArrayStoreException in RunTime
}

//Инвариантность — отсутствие наследования между производными типами.
// Если Кошка — это подтип Животные, то Множество<Кошки> не является подтипом Множество<Животные> и Множество<Животные> не является подтипом Множество<Кошки>
private static  void invariance(){
    List<Integer> list = Arrays.asList(1,2,3);
   // List<Number> numberList = list; //ompile-time error. Проблема обнаружилась на этапе компиляции
}
private static void  wildCards(){
    List<Integer> ilst = new ArrayList<>();
    List<? extends Number> lnum = ilst;//pздесь мы ограничили сверху тем самым избавились от ошибки инвариантности

    List<Number> lnum2 = new ArrayList<>();
    List<? super Integer> sint = lnum2; //здесь ограничили снизу

    //lnum.add(12); //Если контейнер объявлен с wildcard ? extends, то можно только читать значения. В список нельзя ничего добавить, кроме null.
    lnum.add(null); //только null можем добавить

    lnum2.add(12); // Для того чтобы добавить объект в список нам нужен другой тип wildcard — ? super
    //Нельзя прочитать элемент из контейнера с wildcard ? super, кроме объекта класса Object
}


    public static void main(String[] args) {
    //  covariance();
      wildCards();


    }
}

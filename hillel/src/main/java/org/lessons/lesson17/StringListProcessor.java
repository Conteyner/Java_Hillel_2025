package org.lessons.lesson17;

public class StringListProcessor {

    static int countUppercase(String s){
        return (int) s.chars() .filter(Character::isUpperCase) .count();

    }
}


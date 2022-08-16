package factory;

import entities.Student;

public class StudentFactory {
    public Student randomStudent (){
        String[] names = {"Вася","Петя","Коля","Женя","Толя","Саша","Тема"};
        String[] surnames = {"Иванов","Петров","Сидоров","Печкин","Шариков","Кусков"};
        String randomName = names[(int) (Math.random()*names.length)];
        String randomSurname = surnames[(int) (Math.random()*surnames.length)];
        int randomAge = (int) (Math.random()*10+17);

        return new Student(randomName,randomSurname,randomAge);

    }
}

package controller;

import entities.Student;
import factory.StudentFactory;

import java.sql.*;

public class Controller {
  private final String URL ="jdbc:h2:mem:new";
    private Connection connection;
    private final String user ="user";
    private final String password = "user";

    public void addTable() {
        try {
            connection = DriverManager.getConnection(URL,user,password);
            Statement statement = connection.createStatement();
            String s = """
                    create table STUDENTS
                    (
                        ID      INT auto_increment,
                        NAME    VARCHAR,
                        SURNAME VARCHAR,
                        AGE     INTEGER,
                        constraint STUDENTS_PK
                            primary key (ID)
                    );
                    """;
            statement.execute(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {

        Student student = new StudentFactory().randomStudent();
        try {
           // Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL,user,password);
            Statement statement = connection.createStatement();
            String s = String.format("INSERT INTO students (name, surname, age) VALUES('%s', '%s', '%d')", student.getName(), student.getSurname(), student.getAge());
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printer() {
        try {
            connection = DriverManager.getConnection(URL,user,password);
            Statement statement = connection.createStatement();
            String s = "SELECT * FROM students";
            try (ResultSet resultSet = statement.executeQuery(s)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    int age = resultSet.getInt("age");
                    print(new Student(name, surname, age));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void print(Student student) {
        System.out.println("name: "+
                student.getName()+
                " surname: "+
                student.getSurname()+
                " age: "+
                student.getAge()
        );
    }
}

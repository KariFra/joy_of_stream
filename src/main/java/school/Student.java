package school;

import java.util.ArrayList;
import java.util.HashMap;

enum Gender{
    MALE,FEMALE
}

public class Student {

    String name;
    String surname;
    Gender gender;
    int age;
    ArrayList<Double> twoPreviousAverages;
    HashMap<String,Integer> notes;


    public Student(String name, String surname, Gender gender, int age, ArrayList<Double> twoPreviousAverages, HashMap<String, Integer> notes) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.twoPreviousAverages = twoPreviousAverages;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Double> getTwoPreviousAverages() {
        return twoPreviousAverages;
    }

    public HashMap<String, Integer> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (!name.equals(student.name)) return false;
        if (!surname.equals(student.surname)) return false;
        if (!twoPreviousAverages.equals(student.twoPreviousAverages)) return false;
        return notes.equals(student.notes);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + twoPreviousAverages.hashCode();
        result = 31 * result + notes.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", twoPreviousAverages=" + twoPreviousAverages +
                ", notes=" + notes +
                '}';
    }
}

package school;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestSuite {

    @Test
    public void streamTest() {

        //given
        ArrayList<Double> averageOne = new ArrayList<>();
        averageOne.add(3.4);
        averageOne.add(4.4);

        ArrayList<Double> averageTwo = new ArrayList<>();
        averageTwo.add(4.4);
        averageTwo.add(4.4);

        ArrayList<Double> averageThree = new ArrayList<>();
        averageThree.add(4.2);
        averageThree.add(3.3);

        ArrayList<Double> averageFour = new ArrayList<>();
        averageFour.add(4.5);
        averageFour.add(4.3);

        HashMap<String, Integer> oneNotes = new HashMap<>();
        oneNotes.put("Math", 4);
        oneNotes.put("Chemistry", 3);
        oneNotes.put("Biology", 2);
        oneNotes.put("Physics", 2);
        oneNotes.put("English", 3);

        HashMap<String, Integer> twoNotes = new HashMap<>();
        twoNotes.put("Math", 5);
        twoNotes.put("Chemistry", 5);
        twoNotes.put("Biology", 2);
        twoNotes.put("Physics", 4);
        twoNotes.put("English", 4);

        HashMap<String, Integer> threeNotes = new HashMap<>();
        threeNotes.put("Math", 5);
        threeNotes.put("Chemistry", 5);
        threeNotes.put("Biology", 4);
        threeNotes.put("Physics", 3);
        threeNotes.put("English", 5);

        HashMap<String, Integer> fourNotes = new HashMap<>();
        fourNotes.put("Math", 4);
        fourNotes.put("Chemistry", 5);
        fourNotes.put("Biology", 4);
        fourNotes.put("Physics", 4);
        fourNotes.put("English", 5);

        Student studentOne = new Student("John", "Snow", "male", 20, averageOne, oneNotes);
        Student studentTwo = new Student("Marry", "Watt", "female", 21, averageTwo, twoNotes);
        Student studentThree = new Student("Jack", "Nicholson", "male", 19, averageThree, threeNotes);
        Student studentFour = new Student("Vera", "May", "female", 20, averageFour, fourNotes);

        ArrayList<Student> membersA = new ArrayList<>();
        membersA.add(studentOne);
        membersA.add(studentTwo);
        membersA.add(studentThree);
        membersA.add(studentFour);

        ArrayList<Student> membersB = new ArrayList<>();
        membersB.add(studentOne);
        membersB.add(studentFour);

        Group groupOne = new Group(membersA);
        Group groupTwo = new Group(membersB);

        ArrayList<Group> groups = new ArrayList<>();
        groups.add(groupOne);
        groups.add(groupTwo);

//When
//        Obliczenie średniej wieku w grupie
        OptionalDouble avarageGroup = groupOne.getGroups().stream()
                .mapToDouble(e -> e.getAge())
                .average();



//        Najstarszy student w grupie

        Optional<Student> oldestStudent = groupOne.getGroups().stream()
                .max(Comparator.comparing(Student::getAge));
                Student optional = oldestStudent.get();


//        Najlepsza meska ocena z matematyki

        Optional bestMathNote = groupOne.getGroups().stream()
                .filter(e -> e.getGender().equals("male"))
                .flatMap(e -> e.notes.entrySet().stream())
                .filter(f -> f.getKey().equals("Math"))
                .max(Comparator.comparing(Map.Entry::getValue));





//       Najgorsza żenska ocena

        groupOne.getGroups().stream()
                .filter(e -> e.getGender().equals("Female"))
                .flatMap(e -> e.notes.entrySet().stream())
                .map(o->o.getValue())
                .min(Double::compare)
                .ifPresent(System.out::println);





//than
        Assert.assertEquals(OptionalDouble.of(20.0),avarageGroup);
        Assert.assertEquals(21,optional.getAge());


    }
}

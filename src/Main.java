import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

class SurveySystem {
    private ArrayList<Person> participants;

    public SurveySystem() {
        participants = new ArrayList<>();
    }

    public void addParticipant(Person person) {
        participants.add(person);
    }

    public double calculateAverageSalary() {
        if (participants.isEmpty()) {
            return 0.0;
        }

        double totalSalary = 0.0;
        for (Person person : participants) {
            totalSalary += person.getSalary();
        }

        return totalSalary / participants.size();
    }

    public double calculateAverageAge() {
        if (participants.isEmpty()) {
            return 0.0;
        }

        double totalAge = 0.0;
        for (Person person : participants) {
            totalAge += person.getAge();
        }

        return totalAge / participants.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SurveySystem survey = new SurveySystem();

        System.out.println("Welcome to the Survey System");

        while (true) {
            System.out.print("Enter name (or type 'exit' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();

            scanner.nextLine();

            if (age < 0 || salary < 0) {
                System.out.println("Age and salary must be non-negative values.");
                continue;
            }

            Person person = new Person(name, age, salary);
            survey.addParticipant(person);
        }

        double averageSalary = survey.calculateAverageSalary();
        double averageAge = survey.calculateAverageAge();

        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Average Age: " + averageAge);
    }
}
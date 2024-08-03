import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Student {
    String name;
    LocalDate birthday;

    public Student(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        long totalDays = ChronoUnit.DAYS.between(birthday, today);
        long days = totalDays % 30;
        return period.getYears() + " years, " + period.getMonths() + " months, " + days + " days";
    }
}

public class StudentAgeCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

System.out.println("###################################");

            // Step 1: Input Student Details
            System.out.println("Enter the name of the student:");
            String name = scanner.nextLine();

            System.out.println("Enter the birthday of the student (dd/MM/yyyy):");
            String birthdayStr = scanner.nextLine();
            LocalDate birthday = null;
            try {
                // Step 2: Parse Birthday
                birthday = LocalDate.parse(birthdayStr, dtf);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            // Step 3: Create Student Object
            Student student = new Student(name, birthday);

            // Step 4: Calculate Age
            String age = student.getAge();

            // Step 5: Output Student Details
            System.out.println("\nStudent Details:");
            System.out.println("Name: " + student.getName());
            System.out.println("Birthday: " + student.getBirthday().format(dtf));
            System.out.println("Age: " + age);
        }

	//System.out.println("###################################");
    }
}

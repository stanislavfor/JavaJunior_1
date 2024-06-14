import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Results :");

        // Создание департаментов
        Homework.Department it = new Homework.Department();
        it.setName("Разработка");
        Homework.Department analytics = new Homework.Department();
        analytics.setName("Аналитика");
        Homework.Department finance = new Homework.Department();
        finance.setName("Финансы");

//        Department finance = new Department("Финансы");
//        Department it = new Department("Разработка");
//        Department analytics = new Department("Аналитика");
//
//        List<Person> people = Arrays.asList(
//                new Person("Денис", 50, 80000.0, finance),
//                new Person("Николай", 30, 7000.0, finance),
//                new Person("Алиса", 30, 60000.0, it),
//                new Person("Андрей", 40, 70000.0, it),
//                new Person("Игорь", 25, 50000.0, analytics),
//                new Person("Елена", 35, 55000.0, analytics)
//        );


        // Создание сотрудников
        Homework.Person alice = new Homework.Person();
        alice.setName("Алиса");
        alice.setAge(30);
        alice.setSalary(60000);
        alice.setDepartment(it);

        Homework.Person and = new Homework.Person();
        and.setName("Андрей");
        and.setAge(40);
        and.setSalary(70000);
        and.setDepartment(it);

        Homework.Person igor = new Homework.Person();
        igor.setName("Игорь");
        igor.setAge(25);
        igor.setSalary(50000);
        igor.setDepartment(analytics);

        Homework.Person denis = new Homework.Person();
        denis.setName("Денис");
        denis.setAge(50);
        denis.setSalary(80000);
        denis.setDepartment(finance);

        Homework.Person nik = new Homework.Person();
        nik.setName("Николай");
        nik.setAge(30);
        nik.setSalary(7000);
        nik.setDepartment(finance);

        Homework.Person elena = new Homework.Person();
        elena.setName("Елена");
        elena.setAge(35);
        elena.setSalary(55000);
        elena.setDepartment(analytics);

        // Добавление сотрудников в список
        List<Homework.Person> people = new ArrayList<>(Arrays.asList(alice, and, igor, denis, nik, elena));

        // Вывод результатов задания
        Optional<Homework.Person> youngestPerson = Homework.findMostYoungestPerson(people);
        youngestPerson.ifPresent(person -> System.out.println("Самый молодой сотрудник : " + person));


        Optional<Homework.Department> mostExpensiveDepartment = Homework.findMostExpensiveDepartment(people);
        mostExpensiveDepartment.ifPresent(department -> System.out.println("Отдел с самой высокой зарплатой сотрудника : " + department));


        Map<Homework.Department, List<Homework.Person>> peopleByDepartment = Homework.groupByDepartment(people);
        System.out.println("Сотрудники Департамента (специалисты) : " + formatOutput(peopleByDepartment));


        Map<String, List<Homework.Person>> peopleByDepartmentName = Homework.groupByDepartmentName(people);
        System.out.println("Сотрудники по отделам : "  + formatOutput2(peopleByDepartmentName));


        Map<String, Homework.Person> oldestPersonInDepartment = Homework.getDepartmentOldestPerson(people);
        System.out.println("Самый старший сотрудник по отделам : " + formatOutput3(oldestPersonInDepartment));


        List<Homework.Person> cheapestPersonsInDepartments = Homework.cheapPersonsInDepartment(people);
        System.out.println("Сотрудник с минимальной зарплатой в отделе : " + cheapestPersonsInDepartments);


    }

    private static String formatOutput(Map<Homework.Department, List<Homework.Person>> map) {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<Homework.Department, List<Homework.Person>> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }

    private static String formatOutput2(Map<String, List<Homework.Person>> map) {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<String, List<Homework.Person>> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }

    private static String formatOutput3(Map<String, Homework.Person> map) {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<String, Homework.Person> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }




}
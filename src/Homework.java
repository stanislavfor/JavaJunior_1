import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework {

    static class Department {
        private String name;

        // геттеры, сеттеры
        public String getName() {


            return name;
        }

        public void setName(String name) {


            this.name = name;
        }

        @Override
        public String toString() {
            return "`отд. " +  name + '`' ;
        }
    }

    static class Person {
        private String name;
        private int age;
        private double salary;
        private Department department;

//        public Person(String name, int age, double salary, Department department) {
//            this.name = name;
//            this.age = age;
//            this.salary = salary;
//            this.department = department;
//        }


        // геттеры, сеттеры
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "спец. " + name +  ", `отд. " + department.getName() +  "`, " + age +  ", " + salary;
        }
    }

    // Найти самого молодого сотрудника
    static Optional<Person> findMostYoungestPerson(List<Person> people) {
        return people.stream().min(Comparator.comparingInt(Person::getAge));
    }

    // Найти департамент, в котором работает сотрудник с самой большой зарплатой
    static Optional<Department> findMostExpensiveDepartment(List<Person> people) {
        return people.stream().max(Comparator.comparingDouble(Person::getSalary)).map(Person::getDepartment);
    }

    // Сгруппировать сотрудников по департаментам
    static Map<Department, List<Person>> groupByDepartment(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getDepartment));
    }

    // Сгруппировать сотрудников по названиям департаментов
    static Map<String, List<Person>> groupByDepartmentName(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(person -> person.getDepartment().getName()));
    }

    // В каждом департаменте найти самого старшего сотрудника
    static Map<String, Person> getDepartmentOldestPerson(List<Person> people) {
        return people.stream().collect(Collectors.toMap(person -> person.getDepartment().getName(), Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Person::getAge))));
    }

    // Найти сотрудников с минимальными зарплатами в своем отделе
    static List<Person> cheapPersonsInDepartment(List<Person> people) {
        Map<Department, Optional<Person>> minSalaryPerDepartment = people.stream()
                .collect(Collectors.groupingBy(Person::getDepartment,
                        Collectors.minBy(Comparator.comparingDouble(Person::getSalary))));
        return minSalaryPerDepartment.values().stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
    }




}

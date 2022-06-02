package Level1.Lesson5;

public class Employee {
    String fio;
    String position;
    String email;
    long phoneNumber;
    int salary;
    int age;

    public Employee(String fio, String position, String email, long phoneNumber, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("ФИО: " + fio + ". Должность: " + position + ". Email: " + email + ". Номер телефона: " + phoneNumber + ". Зарплата: " + salary + ". Возраст: " + age);
    }
}


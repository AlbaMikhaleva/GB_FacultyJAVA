package Level1.Lesson5;

public class HomeWorkApp5 {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee ("Иванов Иван Иванович", "Директор", "ivanov@mail.ru", 89059055345L,
                150000, 45);
        employees[1] = new Employee ("Сидорова Татьяна Сергеевна", "Бухгалтер", "Sidorova@mail.ru",
                89632457624L, 55000, 51);
        employees[2] = new Employee ("Попов Сергей Васильевич", "Менеджер", "Vasilev@mail.ru", 89064256764L,
                40000, 30);
        employees[3] = new Employee ("Петрова Надежда Александровна", "Специалист", "Petrova@mail.ru",
                89264567532L, 45000, 41);
        employees[4] = new Employee ("Михалева Альбина Витальевна", "Программист", "Mikhaleva@mail.ru",
                89075642864L,90000, 29);

        for (int i = 0; i < 5; i++) {
            if (employees [i].age > 40) {
                employees [i].info(); }
        }
    }
}

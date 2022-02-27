package StaticTest;


/**
 * Ten program demonstruje użycie metod statycznych.
 * This program demonstrates the use of static methods.
 * @author Tomek
 *
 */
public class StaticTest {
    public static void main(String[] args) {
        //Wstawianie do tablicy trzech obiektów reprezentujących pracowników.
        //Inserting three objects representing employees into the array.
        var staff = new Employee[3];	//"var"
        //na podstawie wartosci poczatkowych okreslony jest typ.

        staff[0] = new Employee("Tomasz", 40000);
        staff[1] = new Employee("Dariusz", 60000);
        staff[2] = new Employee("Grzegorz", 65000);

        //Drukowanie informacji o wszystkich obiektach klasy Employee.
        //Printing information about all Employee class objects.

        for(Employee e : staff) {
            e.setID();
            System.out.println("name: " + e.getName()
                    + ", id: " + e.getID()
                    + ", salary: "
                    + e.getSalary());
        }

        int n = Employee.getNextId(); //Wywołanie metody statycznej.
        System.out.println("Następny dostępny identyfikator: " + n);
    }
}

class Employee {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getID() {
        return id;
    }

    public void setID() {
        id = nextId;	//Ustawienie identyfikatora na kolejny dostępny numer.
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void main(String[] args) {	//test jednostkowy
        var e = new Employee("Grzegorz", 50000); //"var"
        //na podstawie wartosci poczatkowych okreslony jest typ.

        System.out.println(e.getName() + " " + e.getSalary());
    }
}
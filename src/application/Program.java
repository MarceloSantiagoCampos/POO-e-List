package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);  // Para que o separador de decimais seja no padrão americano [ponto final em vez de virgula]
        Scanner sc = new Scanner(System.in);
        List <Employee> list = new ArrayList<>(); // Java 7 em diante, não há a necessidade de especificar o tipo da ArrayList. Ja entende que é a mesma do List.

        System.out.print("How many employees will be registered ? ");
        int N = sc.nextInt();

        for (int i = 0; i<N; i++){
            System.out.println();
            System.out.println("Employee #" + (i+1) + ": ");
            System.out.print("Id: ");
            Integer id = sc.nextInt();

            System.out.print("Name: ");
            sc.nextLine(); // Limpar o Buffer de entrada.
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            list.add(new Employee(id,name,salary));
            /* Acima esta uma forma abreviada onde foi adicionado uma instanciação do objeto dentro do list.add.

                De forma menos direta, foi feito o seguinte:

                Employee emp = new Employee(id,name,salary);
                list.add(emp);

             */
        }
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        Integer employeeId = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == employeeId).findFirst().orElse(null);

        if (emp == null){
            System.out.println("This id doesn't exit!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);
        }
        System.out.println();
        System.out.println("List of employees: ");

        for (Employee e: list)  System.out.println(e);



        sc.close();
    }


}

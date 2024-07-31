package manager;

import models.Employee;
import operations.EmpManageOps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager implements EmpManageOps {
    private static EmployeeManager employeeManager = null;
    private static List<Employee> allEmployee;
    private  final Scanner sc = new Scanner(System.in);

    private EmployeeManager(){
        allEmployee = new ArrayList<>();
    }

    public static EmployeeManager getEmployeeManager(){
        if (employeeManager == null){
            employeeManager = new EmployeeManager();
        }
        return employeeManager;
    }

    @Override
    public void addEmployee() {
        Employee employee = createEmployee();
        allEmployee.add(employee);
        int j = allEmployee.size() - 1;
        while (j > 0 && allEmployee.get(j).getEmployeeId() < allEmployee.get(j - 1).getEmployeeId()){
            Employee temp = allEmployee.get(j);
            allEmployee.set(j, allEmployee.get(j - 1));
            allEmployee.set(j - 1, temp);
            j--;
        }
    }

    @Override
    public void searchEmployeeByName() {
        System.out.println("Enter employee name: ");
        String employeeName = sc.nextLine();
        Employee emp = null;
        for (Employee employee : allEmployee){
            if (employee.getName().equals(employeeName)){
                emp = employee;
            }
        }
        if (emp == null){
            System.out.println("Employee not found");
        }else {
            System.out.println("Employee found!");
            System.out.println(emp);
        }

    }

    @Override
    public void searchEmployeeById() {
        System.out.println("Enter employeeId: ");
        int employeeId = sc.nextInt();
        sc.nextLine();
        int ub = allEmployee.size() - 1;
        int lb = 0;

        while (lb <= ub){
            int mid = (ub - lb) / 2 + lb;
            if (allEmployee.get(mid).getEmployeeId() == employeeId){
                System.out.println("Employee Found!");
                System.out.println(allEmployee.get(mid));
                return;
            }else if(allEmployee.get(mid).getEmployeeId() > employeeId){
                ub = mid - 1;
            }else {
                lb = mid + 1;
            }
        }
        System.out.println("Employee Not Found!");
    }

    @Override
    public void traverseEmployeeList() {
        System.out.println("Employee List:");
        if (allEmployee.isEmpty()){
            System.out.println("No employee found!");
            return;
        }
        for (Employee employee : allEmployee){
            System.out.println(employee);
        }
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Enter employeeId: ");
        int employeeId = sc.nextInt();
        sc.nextLine();
        int ub = allEmployee.size() - 1;
        int lb = 0;
        Employee employee = null;
        int j = -1;

        while (lb <= ub){
            int mid = (ub - lb) / 2 + lb;
            if (allEmployee.get(mid).getEmployeeId() == employeeId){
                employee = allEmployee.get(mid);
                j = mid;
                break;
            }else if(allEmployee.get(mid).getEmployeeId() > employeeId){
                ub = mid - 1;
            }else {
                lb = mid + 1;
            }
        }
        if (employee == null){
            System.out.println("Employee not found!");
        }
        while (j < allEmployee.size() - 1){
            allEmployee.set(j, allEmployee.get(j + 1));
            j++;
        }
        allEmployee.remove(j);
    }
    private Employee createEmployee(){
        Employee employee = new Employee();
        System.out.println("Enter employeeId: ");
        employee.setEmployeeId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter employee name: ");
        employee.setName(sc.nextLine());
        System.out.println("Enter employee position");
        employee.setPosition(sc.nextLine());
        System.out.println("Enter employee salary");
        employee.setSalary(sc.nextInt());
        sc.nextLine();
        return employee;
    }
}

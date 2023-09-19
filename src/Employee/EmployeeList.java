package Employee;

import java.io.*;
import java.util.Stack;
import Login.LoginPage;

public class EmployeeList extends ExceptionClass {
    /***** Stack to store Employee objects *****/
    public static Stack<Employee> employeeList = new Stack<Employee>();

    /***** method to add an Employee *****/
    public void addEmployee(Employee e) {
        try {
            for (Employee ep : employeeList) {
                if (e.getID() == ep.getID()) {
                      throw new ExceptionClass("Employee with same 'ID' already added");
                }

                if (e.getPhoneNumber().equals(ep.getPhoneNumber())) {
                       throw new ExceptionClass("Employee with same 'phone number' already added");
                }

                if (e.getEmail().equals(ep.getEmail())) {
                        throw new ExceptionClass("Employee with same 'email' already added");
                }
            }
            employeeList.push(e);
        } catch (ExceptionClass exception) {
            exception.showMessage();
        }

    }

    /***** method to remove an Employee *****/
    public void removeEmployee(Employee e) {
        employeeList.remove(e);
        LoginPage.remove(e.getID());
    }


    /***** method to update Employee details *****/
    public void updateEmployee(Employee prevE, Employee newE) {
        try {
            int indOfPrevEp = (employeeList.size() - employeeList.search(prevE));
            if (indOfPrevEp >= 0 && indOfPrevEp < employeeList.size()) {
                employeeList.set(indOfPrevEp, newE);
            } else {
                throw new ExceptionClass("Previous Employee Not Found");
            }
        } catch (ExceptionClass exception) {
            exception.showMessage();
        }

    }

    /***** searches for an Employee using ID *****/
    public Employee searchEmployeeByID(int ID) {
        try {
            for (Employee ep : employeeList) {
                if (ep.getID() == ID) {
                    return ep;
                }
            }
          throw new ExceptionClass("Employee Not Found");
        } catch (ExceptionClass exception) {
          exception.showMessage();
        }
         return null;
    }

    /***** returns an employee *****/
    public Employee getEmployee(int i) {
        try {
            if (i < employeeList.size()) {
                return employeeList.get(i);
            } else {
                throw new ExceptionClass("Index Out Of Bound");
            }
        } catch (ExceptionClass exception) {
            exception.showMessage();
        }
        return null;
    }

    /***** method to get data from file *****/
    public void getDataFromFile() {
        String filePath = "C:/Users/gurki/OneDrive/Desktop/Java Project/src/Employee/employee.txt";
        File input = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));

            String x;
            while( (x = br.readLine()) != null) {
                String[] info = x.split(" , ");
                if(info[0].compareTo("") == 0 || info[2].compareTo("") == 0) {
                    continue;
                }
                employeeList.add(new Employee(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2]),
                        info[3], info[4], info[5], info[6]));
            }
            br.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /***** method to store data to file *****/
    public void dataToFile () {
        String filePath = "C:/Users/gurki/OneDrive/Desktop/Java Project/src/Employee/employee.txt";
        File output = new File(filePath);
        try {
            FileWriter fw = new FileWriter(output);
            for (Employee ep : employeeList) {
                fw.write(ep.getID() + " , " + ep.getName() + " , " + ep.getAge() + " , " +
                        ep.getAddress() + " , " + ep.getPhoneNumber() + " , " + ep.getEmail() + " , "
                        + ep.getDesignation() + '\n');
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }



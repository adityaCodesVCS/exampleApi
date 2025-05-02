package com.exampleApi;

                          //Java-73(18 Dec-24)-Remaining...

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Predicate Functional Interface
//public class A {
//    public static void main(String[] args) {
//        Predicate<Integer> val = x -> x>5; //Comparison happens & Generic Type should be given in Wrapper Class.
//        boolean result = val.test(6); /* Here test() method takes any input and return a boolean output
//                                           & 6 is supplying to 'x'. */
//        System.out.println(result); //true for 6.
//    }
//}
//********************************************************
//Predicate Functional Interface
//public class A {
//    public static void main(String[] args) {
//        Predicate<String> val = t -> t.startsWith("a") ; //Filtering happens
//        boolean result = val.test("mike"); //test() method came from Predicate Interface(@FunctionalInterface).
//        System.out.println(result); //false for "mike".
//    }
//}
//*************************************************************
//Predicate Functional Interface
//public class A {
//    public static void main(String[] args) {
//        Predicate<String> val = t -> t.length()>4 ; //Comparison happens
//        boolean result = val.test("Stallin");
//        System.out.println(result); //true for "Stallin".
//    }
//}
//************************************************************************************
//Let's use Predicate Functional Interface with Stream API...
//public class A {
//    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(10, 20, 35, 36, 17);
//        List<Integer> result = data.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
//                                           //filter() method use Predicate Functional Interface internally.
//        System.out.println(result); //[10, 20, 36]
//    }
//}
//*******************************************************************************
//public class A {
//    public static void main(String[] args) {
//        List<Integer> result = Arrays.asList(10, 20, 35, 36, 17).
//                               stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
//        System.out.println(result); //[35, 17]
//    }
//}
//*****************************************************************************************

                              //Java-74(19 Dec-24)

//public class A {
//    public static void main(String[] args) {
//        List<String> data = Arrays.asList("mike", "michel", "stallin", "robert");
//        List<String> val1 = data.stream().filter(x -> x.length() > 4).collect(Collectors.toList());
//        List<String> val2 = data.stream().filter(x -> x.startsWith("M")).collect(Collectors.toList());
//        List<String> val3 = data.stream().filter(x -> x.endsWith("n")).collect(Collectors.toList());
//        List<String> val4 = data.stream().filter(x -> x.equals("mike")).collect(Collectors.toList());
//        System.out.println(val1); //[michel, stallin, robert]
//        System.out.println(val2); //[]
//        System.out.println(val3); //[stallin]
//        System.out.println(val4.size()); //1
//    }
//}
//***********************************************************************
//public class A {
//    public static void main(String[] args) {
//        Employee john = new Employee(1, "john", 10000);
//        Employee jenny = new Employee(2, "jenny", 15000);
//        Employee bill = new Employee(3, "bill", 8000);
//        Employee merry = new Employee(4, "merry", 12000);
//        List<Employee> data = Arrays.asList(john, jenny, bill, merry); //Arrays.asList() can also store objects addresses in itself.
//
//        List<Employee> newEmp1 = data.stream().filter(e1 -> e1.getSalary()>10000).collect(Collectors.toList());
//        for (Employee employee1 : newEmp1) {
//            System.out.println(employee1.getId());
//            System.out.println(employee1.getName());
//            System.out.println(employee1.getSalary());
//        }
//        List<Employee> newEmp2 = data.stream().filter(e2 -> e2.getName().startsWith("j")).collect(Collectors.toList());
//        for (Employee employee2 : newEmp2) {
//            System.out.println(employee2.getId());
//            System.out.println(employee2.getName());
//            System.out.println(employee2.getSalary());
//        }
//        List<Employee> newEmp3 = data.stream().filter(e3 -> e3.getName().length()<5).collect(Collectors.toList());
//        for (Employee employee3 : newEmp3) {
//            System.out.println(employee3.getId());
//            System.out.println(employee3.getName());
//            System.out.println(employee3.getSalary());
//        }
//    }
//}
//*************************************************************************
//public class A {
//    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(10, 20, 10, 39, 20);
//        List<Integer> newList = data.stream().distinct().collect(Collectors.toList());
//        //distinct() is used to remove duplicate elements from a stream
//        System.out.println(newList); //[10, 20, 39]
//    }
//}
//*******************************************************************************
//Function Functional Interface
//public class A {
//    public static void main(String[] args) {
//        Function<Integer, Integer> val1 = x -> x*x;
//        Integer result1 = val1.apply(10); //apply() method came from Function Interface(@FunctionalInterface).
//        System.out.println(result1); //100
//
//        Function<Float, String> val2 = x -> "The value of g is "+x;
//        String result2 = val2.apply(9.8f);
//        System.out.println(result2); //The value of g is 9.8
//    }
//}
//*************************************************************
//Let's use Function Functional Interface with Stream API...
//public class A {
//    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(10, 20, 22, 30);
//        List<Integer> val1 = data.stream().map(t -> t * t).collect(Collectors.toList());
//                                         //map() method use Function Functional Interface internally.
//        System.out.println(val1); //[100, 400, 484, 900]
//        List<Integer> val2 = data.stream().map(t -> t + 20).collect(Collectors.toList());
//        System.out.println(val2); //[30, 40, 42, 50]
//    }
//}
//***************************************************************************
//public class A {
//    public static void main(String[] args) {
//        List<Float> data = Arrays.asList(10.0f, 20.0f, 22.0f, 30.0f);
//        List<Float> val = data.stream().map(t -> t/4 ).collect(Collectors.toList());
//        System.out.println(val); //[2.5, 5.0, 5.5, 7.5]
//    }
//}
//*****************************************************************************
//public class A {
//    public static void main(String[] args) {
//        List<String> data = Arrays.asList("mike", "stallin", "john");
//        List<String> val = data.stream().map(t -> t.toUpperCase()).collect(Collectors.toList());
//        System.out.println(val); //[MIKE, STALLIN, JOHN]
//    }
//}
//*********************************************************************************

                             //Java-75(20 Dec-24)

//Consumer Functional Interface
//public class A {
//    public static void main(String[] args) {
//        Consumer<Integer> val = x -> System.out.println(x);
//        val.accept(100); //100
//          //accept() method came from Consumer Interface(@FunctionalInterface).
//    }
//}
//**********************************************************************************
//Supplier Functional Interface
//public class A {
//    public static void main(String[] args) {
//        Supplier<String> val = () -> "Hello World!";
//        System.out.println(val.get()); //Hello World!
//                             //get() method came from Supplier Interface(@FunctionalInterface).
//    }
//}
//***********************************************************************************
//Let's use Consumer Functional Interface with Stream API...
//public class A {
//    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        numbers.stream().forEach(x -> System.out.println(x));
//                       //forEach() method use Consumer Functional Interface internally.
//    }
//}
//**************************************************************************************
//Here, filters(like distinct(), filter(), map() etc) can be re-arranged.
//public class A {
//    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(5, 1, 2, 3, 2, 4, 5);
//        numbers.stream().distinct().filter(t -> t%2==0).map(r -> r*r).forEach(x -> System.out.println(x));
//                       //distinct() can also use after filter() or after map().
//                                                             //map() can also use before filter() or before distinct() and can be re-arranged.
//                                  //filter() can also rearranged like distinct() and map().
//    }
//}
//*********************************************************************************************
//QUESTION:- In the given list, take the numbers above then 50 and give 10% discount and give final value.
//public class A {
//    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(20, 40, 60, 10, 70, 50);
//        numbers.stream().filter(t -> t>50).map(r -> r-(r/10)).forEach(x -> System.out.println(x));
//    }
//}
//*********************************************************************************************
//let's see Grouping in Stream API...
//public class A {
//    public static void main(String[] args) {
//        List<Employee> employeeList = Arrays.asList(
//                new Employee(1, "Adam", 5000),
//                new Employee(2, "John", 10000),
//                new Employee(3, "Tom", 5000)
//        );
//        //Group by Salary...
//        Map<Integer, List<Employee>> employeesBySalary = employeeList.stream().collect(Collectors.groupingBy(e -> e.getSalary()));
//                                                                                   //groupingBy() use Function Functional Interface internally.
//        //System.out.println(employeesBySalary); //'employeesBySalary' should be print in Key,Value pair due to Map Interface.
//                                    //{10000=[com.exampleApi.Employee@5a2e4553], 5000=[com.exampleApi.Employee@28c97a5, com.exampleApi.Employee@6659c656]}
//        Set<Integer> keysBySalary = employeesBySalary.keySet();
//        //System.out.println(keysBySalary); //[10000, 5000]
//        for (int key : keysBySalary) {
//            System.out.println("Group By Salary: "+key);
//            List<Employee> newEmployeeBySalaryList = employeesBySalary.get(key);
//            for (Employee e : newEmployeeBySalaryList) {
//                System.out.println(e.getName());
//            }
//            System.out.println("-----------------------");
//        }
//    }
//}
//*************************************************************************************
//public class A {
//    public static void main(String[] args) {
//        List<String> val = Arrays.asList("mike", "stallin", "mike");
//        //Group by Name...
//
//    }
//}
//********************************************************************************

                           //Java-76(26 Dec-24)

//public class A {
//    public static void main(String[] args) {
//        List<Employee> employeeList = Arrays.asList(
//                new Employee(1, "mike", 20000),
//                new Employee(2, "john", 30000),
//                new Employee(3, "tom", 40000),
//                new Employee(4, "jerry", 10000)
//        );
//        /* Here in map(), We called mapToDto() directly(bcz of it is static) from main() method(static),
//           Otherwise If mapToDto is non-static then we have to called it through instance of this class by creating it. */
//        //List<EmployeeDto> employeeDtoList = employeeList.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
//                  //OR
//        /* Instead of through lambda expression-'e->mapToDto(e)', Here we called through method reference(A::mapToDto) in map() method.
//           If mapToDto() is non-static then it's like a1::mapToDto in map() where a1 is object address of class A that I have to create.  */
//        List<EmployeeDto> employeeDtoList = employeeList.stream().map(A::mapToDto).collect(Collectors.toList());
//
//        for (EmployeeDto employeeDto : employeeDtoList) {
//            System.out.println(employeeDto.getId()+": "+employeeDto.getName()+" - $"+employeeDto.getSalary());
//        }
//    }
//    //A static method can only call other static methods directly without creating an instance of the class.
//    public static EmployeeDto mapToDto(Employee employee) {
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setId(employee.getId());
//        employeeDto.setName(employee.getName());
//        employeeDto.setSalary(employee.getSalary());
//        return employeeDto;
//    }
//}
//********************************************************************************
//MAX & MIN number using Stream API...
//public class A {
//    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 8, 9, 7);
//        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);
//        Optional<Integer> minNumber = numbers.stream().min(Integer::compareTo);
//        System.out.println("Max Number is: "+maxNumber.get()+" & Min Number is: "+minNumber.get());
//    }
//}
//***************************************************************************
//public class A {
//    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 9, 3, 4, 5, 8, 9, 7, 11);
//        List<Integer> data = numbers.stream().sorted().distinct().collect(Collectors.toList());
//        System.out.println("Max Number is: "+data.get(data.size()-1)+" & Min Number is: "+data.get(0));
//        System.out.println("2nd_Max Number is: "+data.get(data.size()-2)+" & 2nd_Min Number is: "+data.get(1));
//    }
//}
//************************************************************************************

                              //Java-77(30 Dec-24)

//Debug & Debugging
//public class A {
//    public static void main(String[] args) {
//        A a1 = new A();
//        int x = a1.test();
//        System.out.println(x);
//        System.out.println(200);
//    }
//
//    private int test() {
//        System.out.println(10);
//        System.out.println(20);
//        return 100;
//    }
//}
//*********************************************************************



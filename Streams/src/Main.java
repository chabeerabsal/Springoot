import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//       List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,12,23,14,5,5));
//
////       List<Integer> list1=list.stream().filter((Integer i) -> i % 2 == 0).collect(Collectors.toList());
////       System.out.println(list1);
//
////       Stream<Integer> stream = list.stream();
////       stream.map(String::valueOf).filter((String s)->s.startsWith("1")).forEach(System.out::println);
//        List<Integer> list3=list.stream().collect(Collectors.groupingBy((i->i),Collectors.counting())).entrySet().stream()
//                .filter(i->i.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
//        System.out.println(list3);
//        Set<Integer> seen = new HashSet<>();
//        List<Integer> duplicates = list.stream()
//                .filter(n -> !seen.add(n))  // add returns false if element already exists
//                .collect(Collectors.toList()); // collect duplicates into a set
//
//        System.out.println(duplicates);

//        Optional<Integer>min=list.stream().min((Integer i,Integer j)->i-j);
//        Optional<Integer> max=list.stream().max((Integer i,Integer j)->i-j);

//        System.out.println(min.get());
//        System.out.println(max.get());
//           List<String> s=Arrays.asList("Apple", "Ant", "Dog", "Air", "Cat");
//           s.stream().filter(i->i.startsWith("A")).forEach(System.out::println);

//           List<Integer> list1=Arrays.asList(1,12,23,1,5,5);
//
//           list1.stream().collect(Collectors.groupingBy(i->i,()->new LinkedHashMap<>(),Collectors.counting())).entrySet()
//                   .stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);
//        String ch="chabeer";
//        ch.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream().forEach(e->System.out.println(e.getKey()+"+"+e.getValue()));
//

        List<Employee> employeeList=new ArrayList<>(Arrays.asList(
                new Employee("Alice",1000),
                new Employee("Bob",2000),
                new Employee("Alice",2000),
                new Employee("Alice",3000)
                )
        );

       List<Integer>s= employeeList.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).distinct().peek(System.out::println).toList();
       System.out.println(s.get(1));

    }


}
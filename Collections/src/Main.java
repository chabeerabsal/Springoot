import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         String s="chabeer";
//         String s2="Absal";
//         String s3="Absal";
//         String s4="chabeer";
//         String s5="123";
//        System.out.println(s.charAt(0));
//        System.out.println(s.charAt(1));
//        System.out.println(s.substring(0,2));
//        System.out.println(s.substring(1));
//        //System.out.println(s.toUpperCase());
//        //System.out.println(s.toLowerCase());
//        System.out.println(Integer.parseInt(s5));
//        System.out.println((int)s5.charAt(0));
//      //  System.out.println(s.replace('a','z'));
//        System.out.println(s);
//        System.out.println(s.equals(s2));
//        System.out.println(s.equals(s4));
//        System.out.println(s2==s3);
//        //s.contains("he");
//        System.out.println(s.contains("he"));
//        System.out.println(s2.startsWith("cha"));
//        System.out.println(s2.endsWith("a"));
//        for(char c : s.toCharArray()){
//            System.out.println(c);
//        }
//
//        StringBuilder stringBuilder = new StringBuilder(s);
//        for(char c : stringBuilder.toString().toCharArray()){
//            System.out.println(c);
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append('a');
//        sb.append('b');
//        System.out.println(sb);
//        sb.insert(2,'c');
//        System.out.println(sb.length());
//        System.out.println(sb.charAt(2));
//        sb.setCharAt(2,'d');
//        System.out.println(sb.reverse());
//        System.out.println(sb.deleteCharAt(2));
//      //  System.out.println(sb.deleteCharAt(2));

//        List<Integer> arraylist=new ArrayList<>();
//        arraylist.add(1);
//        arraylist.add(2);
//        arraylist.add(3);
//        arraylist.add(4);
//        arraylist.get(0);
//        List<Integer> arraylist1=new ArrayList<>();
//        arraylist1.add(1);
//        arraylist1.add(2);
//        arraylist1.addAll(2,arraylist);
//        System.out.println(arraylist1);
//        for(int i=0;i<arraylist.size();i++){
//            System.out.print(arraylist.get(i));
//        }
//        arraylist1.remove(2);
//        System.out.println(arraylist1.contains(2));
//
//        arraylist1.set(1,10);
//        Collections.sort(arraylist1);
//        //arraylist.sort()
//        System.out.println(arraylist1.indexOf(2));
//        System.out.println(arraylist1);
//
//        List<List<Integer>> list=new ArrayList<>();
//        list.add(new ArrayList<>());
//        list.add(new ArrayList<>());
//        list.get(0).add(1);
//        list.get(0).add(2);
//        list.get(1).add(3);
//        list.get(1).add(4);
//        for(List<Integer> list1:list){
//            for(Integer integer : list1){
//                System.out.println(integer);
//            }
//        }
        List<Integer> list=new ArrayList<>(Arrays.asList(21,5,7,3,6,10));

        int target=100;
//        Map<Integer,Integer> map=new ConcurrentHashMap<>();
      int presum=0;
//       map.put(1,10);
//       map.put(2,20);
//       map.put(3,30);
//       map.put(4,40);
//       map.put(20,5);
//       map.put(15,20);
//       map.putIfAbsent(1,20);
//      // System.out.println(map.get(1));
//       map.getOrDefault(2,0);
//       map.put(1,map.getOrDefault(1,0)+1);
//       for(Map.Entry<Integer,Integer> mp:map.entrySet()){
//           System.out.println(mp.getKey()+" "+mp.getValue());
//       }

        Set<Integer> set=new TreeSet<>();
        Set<Integer> set1=new TreeSet<>(list);
       for(int i=0;i<list.size();i++){
           presum+=list.get(i);
           if(set.contains(presum-target)){
               System.out.println("true");
               break;
           }
           set.add(presum);
       }
       for(Integer i:set1){
           System.out.println(i);
       }







        }
    }

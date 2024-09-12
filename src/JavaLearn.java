import java.util.*;

public class JavaLearn {

    public static void main(String[] args) {
        int num = 5,i;
        ArrayList array1 = new ArrayList();  //declaring arraylist
        ArrayList<String> str = new ArrayList<String>(); //declaring string list
        str.add("hi"); // adding data in string list
        str.add("yo");
        int[] arr = new int[25]; //initialising an array
        int [] arr1 = {1,2,3,4,5}; // making an fixed array
        String [] name ={"hi","hello","yes"}; // making a string list
        String website = "www.samsung.com"; // declaring string
        char r = 'a';  // character type
        float f = 5.99f;  //float type
        double d = 5.88; //double type
        boolean a = true;  //boolean type
        //System.out.println(num+"\n"+"hello");
        arr[0]=1;
        //System.out.println(arr[0]);
        //looping in array
        for(i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
        /*
        for(i=0;i<name.length;i++){
            System.out.println(name[i]);
        }*/
        //looping in array values directly
        for(String s : name){
            if(s.equals("hi")){
                System.out.println(s);
            }

        }
        //getting indexed string list value
        System.out.println(str.get(1));

        for(int k=0;k<str.size();k++){
            System.out.println(str.get(k));
        }
        System.out.println(str.contains("yo"));
        //converting normal string list in array list type
        List<String> nameArrayList = Arrays.asList(name);
        boolean m=nameArrayList.contains("yes");
        System.out.println("This is the answer--->"+m);
    }
}

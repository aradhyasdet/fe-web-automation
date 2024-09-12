public class MethodsDemo {

    public static void main(String[] args){
    //MethodsDemo d = new MethodsDemo();
    MethodsDemo2 r = new MethodsDemo2();
    String name = getData();
    String name2 = r.getData();
    System.out.println(name);
    System.out.println(name2);
    getData();
    }
    public static String getData(){
        //System.out.println("hello world");
        return "hello world";
    }
}

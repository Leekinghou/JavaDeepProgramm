//// <T> 代表引用类型
//
//
//public class Generics<T> {
//    private T lower;
//    private T upper;
//
//    public Generics(T lower, T upper){
//        this.lower = lower;
//        this.upper = upper;
//    }
//
//    public T getLower(){
//        return lower;
//    }
//
//    public T getUpper(){
//        return upper;
//    }
//
//
//
//}
////class IntegerInterval {
////    private int lower;
////    private int upper;
////
////    public IntegerInterval(int lower, int upper){
////        this.lower = lower;
////        this.upper = upper;
////    }
////
////    public int getLower(){
////        return lower;
////    }
////
////    public int getUpper(){
////        return upper;
////    }
////}
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generics<T>{
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generics(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
    //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
    public static void main(String[] args) {
        Generics<Integer> genericInteger = new Generics<Integer>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generics<String> genericString = new Generics<String>("key_vlaue");
        System.out.println("泛型测试" + "key is " + genericInteger.getKey());
        System.out.println("泛型测试" + "key is " + genericString.getKey());
    }
}



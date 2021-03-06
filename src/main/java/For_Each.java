import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class For_Each {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<String>();

        hs.add("This");
        hs.add("is");
        hs.add("SD");

        for(Iterator<String> i = hs.iterator();i.hasNext();){
            System.out.println(i.next());
        }

        System.out.println("================");

        for(String i : hs){
            System.out.println(i);
        }
        print("abc");
        print("123","345","456");

    }
    public static void print(String ... args){
        System.out.println(args.length);
        for(String arg : args){
            System.out.println(arg);
        }
    }

}

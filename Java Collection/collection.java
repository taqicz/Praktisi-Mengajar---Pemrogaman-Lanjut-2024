import java.util.ArrayList;
import java.util.Collection;

public class collection {
    public static void main(String[] args) {

        Collection<String> nama = new ArrayList<String>();
        nama.add("Bagus");
        nama.add("Radian");
        nama.add("Septi");
        
        nama.remove("Radian");

        for(var i : nama){
            System.out.println(i);
        }

        System.out.println(nama.contains("Bagus"));
    }
    
}

import java.util.List;

public class iterable {
    public static void main(String[] args) {
        Iterable <String> nama = List.of("Supri","Bagus");
        for (var i : nama){
            System.out.println(i);
        }
    }
}

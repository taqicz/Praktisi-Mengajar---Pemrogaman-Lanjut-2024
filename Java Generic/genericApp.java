package generic;


public class genericApp {
    public static void main(String[] args) {
        
        genericClass <Integer> dataKu = new genericClass<> (7);
        System.out.println(dataKu.getData());
    }
}

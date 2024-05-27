public class Patient<T> {
    private T name;
    private int number;

    public Patient(T name, int number) {
        this.name = name;
        this.number = number;
    }

    public T getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}

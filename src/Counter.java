// Класс-счетчик
public class Counter implements AutoCloseable {
    private static int count = 0;

    public Counter() {
        count++;
    }

    public void add() {
        count++;
    }

    @Override
    public void close() throws Exception {
        count--;
        if (count > 0) {
            throw new Exception("Ресурс счетчика не был закрыт.");
        }
    }
}

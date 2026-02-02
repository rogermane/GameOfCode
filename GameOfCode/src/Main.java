import Core.*;

public class Main {
    public static void main(String[] args) {

        Guerrero test1 = new Guerrero();
        Mago test2 = new Mago();

        test1.atacar(test2);
        test2.atacar(test1);

    }
}

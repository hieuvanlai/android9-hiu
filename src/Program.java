import java.io.IOException;

/**
 * Created by hieuv on 4/10/2017.
 */
public class Program {
    public static void main(String[] args) {
        try {
            new GameWinDow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

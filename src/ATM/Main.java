package ATM;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        GUI g = new GUI();
        g.frame.setVisible(false);
        login t = new login();
    }
}
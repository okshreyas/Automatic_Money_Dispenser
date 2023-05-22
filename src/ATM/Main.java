package ATM;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        GUI MainScreen = new GUI();
        MainScreen.MainFrame.setVisible(false);
        Login login = new Login();
    }
}
package ATM;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import static java.lang.System.out;

public class Login {
    static String AccountName, AccountType,a, Details;
    static int AccountNumber, Money,pt;
    public static JFrame MainFrame2 = new JFrame("NOWHERE BANK");
    public static boolean HHH;
    Login() {
        JLabel Comment = new JLabel("");

        JTextField GetAccID = new JTextField("");
        GUI GUI = new GUI();
        GUI.MainFrame.setVisible(false);
        Font Font1 = new Font("Arial Black", Font.BOLD, 30);
        Font Font2 = new Font("Courier New", Font.BOLD, 25);
        Font Font3 = new Font("Courier New", Font.BOLD, 20);
        Font Font4 = new Font("Courier New", Font.PLAIN,20);

        JPanel Panel11 = new JPanel();
        JPanel Panel12 = new JPanel();
        Panel12.setLayout(null);
        Panel11.setLayout(null);
        Panel11.setBackground(new Color(0x4949AA));
        Panel12.setBackground(new Color(0x070734));

       JLabel Account = new JLabel("Account : ");
        Account.setBounds(100, 20, 200, 100);
        Account.setFont(Font2);
        Account.setForeground(Color.white);

        JLabel Password = new JLabel("Password : ");
        Password.setBounds(100, 100, 300, 100);
        Password.setFont(Font2);
        Password.setForeground(Color.white);

        Comment.setBounds(20, 240, 400, 100);
        Comment.setFont(Font4);
        Comment.setForeground(Color.RED);
        GetAccID.setFont(Font2);
        GetAccID.setBounds(300, 60, 170, 30);

        JTextField Getinput = new JTextField("");
        Getinput.setFont(Font2);
        Getinput.setBounds(300, 130, 170, 30);

        JButton LoginButton = new JButton("LOGIN");
        LoginButton.setFocusPainted(false);
        LoginButton.setBounds(90, 230, 200, 40);
        LoginButton.setFont(Font3);
        Password.setVisible(false);
        Getinput.setVisible(false);
        LoginButton.addActionListener(e -> {a = (GetAccID.getText().trim());


                String url = "jdbc:ucanaccess://ac.accdb";
                try {
                    Connection con = DriverManager.getConnection(url);
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select Password from Account where AccountID="+a);
                    while (rs.next()){if(GetAccID.getText()!=null && rs!=null){Password.setVisible(true);}
                        int PasswordCheck=rs.getInt("pass");
                        out.println(PasswordCheck);
                        Password.setVisible(true);
                        Getinput.setVisible(true);

                        try {
                             pt= Integer.parseInt(Getinput.getText());

                            if(PasswordCheck==pt){
                                System.out.println("Okkk..!");
                                HHH=true;
                                GUI L=new GUI();
                                Password.setVisible(false);
                                try {

                                    rs = st.executeQuery("select * from Account where AccountID=" + a);
                                    while (rs.next()) {
                                        AccountName = rs.getString("name");
                                        AccountType = rs.getString("atype");
                                        Money =rs.getInt("acmoney");
                                        AccountNumber =rs.getInt("acid");
               Details =("ID : "+ AccountNumber +"\nName : "+ AccountName +"\nAccount Type : "+ AccountType +"\nMoney : "+ Money +"/-");
                                        out.println(Details);
                                        L.bn();
                                        Comment.setText("Success..!");


                                    }
                                } catch (SQLException I) {
                                    I.printStackTrace();
                                }

                            }
                            else{
                                System.out.println("Wrong password entered");
                                Comment.setText("ENTER VALID PASSWORD");
                            }
                        } catch(NumberFormatException ex){
                            System.err.println(" ");
                        }
                    }
                } catch (SQLException | InterruptedException I) {
                    I.printStackTrace();
                }
});


        JButton Cancel = new JButton("CANCEL");
        Cancel.setFocusPainted(false);
        Cancel.setBounds(330, 230, 200, 40);
        Cancel.setFont(Font3);
        Cancel.addActionListener(e -> System.exit(0));
        Panel11.setBounds(0, 0, 600, 100);
        Panel12.setBounds(0, 100, 600, 600);
        Panel12.add(Account);
        Panel12.add(Password);
        Panel12.add(GetAccID);
        Panel12.add(Getinput);
        Panel12.add(LoginButton);
        Panel12.add(Cancel);
        JLabel Login = new JLabel("Login");
        Login.setFont(Font1);
        Login.setForeground(new Color(0xEEC113));
        Login.setBounds(250, 10, 300, 100);
        Panel11.add(Login);
        Panel12.add(Comment);


        MainFrame2().setVisible(true);
        MainFrame2().setSize(600, 500);
        MainFrame2().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainFrame2().setResizable(false);
        MainFrame2().add(Panel11);
        MainFrame2().add(Panel12);
        MainFrame2().setLayout(null);
        SwingUtilities.getRootPane(LoginButton).setDefaultButton(LoginButton);


    }

    public JFrame MainFrame2() {
        return MainFrame2;
    }
}
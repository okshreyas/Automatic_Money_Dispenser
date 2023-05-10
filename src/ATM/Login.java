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
        JLabel res = new JLabel("");

        JTextField a1 = new JTextField("");
        GUI r = new GUI();
        r.MainFrame.setVisible(false);
        Font f4 = new Font("Courier New", Font.PLAIN, 20);
        Font fe = new Font("Arial Black", Font.BOLD, 30);
        Font f2 = new Font("Courier New", Font.BOLD, 25);
        Font f3 = new Font("Courier New", Font.BOLD, 20);

        JPanel Panel11 = new JPanel();
        JPanel Panel12 = new JPanel();
        Panel12.setLayout(null);
        Panel11.setLayout(null);
        Panel11.setBackground(new Color(0x4949AA));
        Panel12.setBackground(new Color(0x070734));
        //Panel11.setSize(400,400);
        JLabel Acc = new JLabel("Account : ");
        Acc.setBounds(100, 20, 200, 100);
        Acc.setFont(f2);
        Acc.setForeground(Color.white);

        JLabel passe = new JLabel("Password : ");
        passe.setBounds(100, 100, 300, 100);
        passe.setFont(f2);
        passe.setForeground(Color.white);

        res.setBounds(20, 240, 400, 100);
        res.setFont(f4);
        res.setForeground(Color.RED);
        a1.setFont(f2);
        a1.setBounds(300, 60, 170, 30);

        JTextField p1 = new JTextField("");
        p1.setFont(f2);
        p1.setBounds(300, 130, 170, 30);

        JButton jb = new JButton("LOGIN");
        jb.setFocusPainted(false);
        jb.setBounds(90, 230, 200, 40);
        jb.setFont(f3);
        passe.setVisible(false);
        p1.setVisible(false);
        jb.addActionListener(e -> {a = (a1.getText().trim());


                String url = "jdbc:ucanaccess://ac.accdb";
                try {
                    Connection con = DriverManager.getConnection(url);
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select pass from Acc where acid="+a);
                    while (rs.next()){if(a1.getText()!=null && rs!=null){passe.setVisible(true);}
                        int ppe=rs.getInt("pass");
                        out.println(ppe);
                        passe.setVisible(true);
                        p1.setVisible(true);
                                //acname=rs.getString("name");
                                //actype=rs.getString("atype");

                        try {
                             pt= Integer.parseInt(p1.getText());

                            if(ppe==pt){
                                System.out.println("Okkk..!");
                                HHH=true;
                                GUI L=new GUI();
                                passe.setVisible(false);
                                try {

                                    rs = st.executeQuery("select * from Acc where acid=" + a);
                                    while (rs.next()) {
                                        AccountName = rs.getString("name");
                                        AccountType = rs.getString("atype");
                                        Money =rs.getInt("acmoney");
                                        AccountNumber =rs.getInt("acid");
               Details =("ID : "+ AccountNumber +"\nName : "+ AccountName +"\nAccount Type : "+ AccountType +"\nMoney : "+ Money +"/-");
                                        out.println(Details);
                                        L.bn();
                                        res.setText("Success..!");


                                    }
                                } catch (SQLException I) {
                                    I.printStackTrace();
                                }

                            }
                            else{
                                System.out.println("Wrong password entered");
                                res.setText("ENTER VALID PASSWORD");
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
        Cancel.setFont(f3);
        Cancel.addActionListener(e -> System.exit(0));
        Panel11.setBounds(0, 0, 600, 100);
        Panel12.setBounds(0, 100, 600, 600);
        Panel12.add(Acc);
        Panel12.add(passe);
        Panel12.add(a1);
        Panel12.add(p1);
        Panel12.add(jb);
        Panel12.add(Cancel);
        JLabel lgn = new JLabel("Login");
        lgn.setFont(fe);
        lgn.setForeground(new Color(0xEEC113));
        lgn.setBounds(250, 10, 300, 100);
        Panel11.add(lgn);
        Panel12.add(res);


        MainFrame2().setVisible(true);
        MainFrame2().setSize(600, 500);
        MainFrame2().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainFrame2().setResizable(false);
        MainFrame2().add(Panel11);
        MainFrame2().add(Panel12);
        MainFrame2().setLayout(null);
        SwingUtilities.getRootPane(jb).setDefaultButton(jb);


    }

    public JFrame MainFrame2() {
        return MainFrame2;
    }
}
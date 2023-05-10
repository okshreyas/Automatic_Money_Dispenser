package ATM;


import javax.swing.*;
import java.awt.*;
import java.sql.*;

import static java.lang.System.out;

public class login {
    static String acname,actype,a,detail;
    static int acno,money,pt;
    public static JFrame jf = new JFrame("NOWHERE BANK");
    public static boolean HHH;
    login() {
        JLabel res = new JLabel("");

        JTextField a1 = new JTextField("");
        GUI r = new GUI();
        r.frame.setVisible(false);
        Font f4 = new Font("Courier New", Font.PLAIN, 20);
        Font fe = new Font("Arial Black", Font.BOLD, 30);
        Font f2 = new Font("Courier New", Font.BOLD, 25);
        Font f3 = new Font("Courier New", Font.BOLD, 20);

        JPanel j11 = new JPanel();
        JPanel j12 = new JPanel();
        j12.setLayout(null);
        j11.setLayout(null);
        j11.setBackground(new Color(0x4949AA));
        j12.setBackground(new Color(0x070734));
        //j11.setSize(400,400);
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
                                        acname = rs.getString("name");
                                        actype= rs.getString("atype");
                                        money=rs.getInt("acmoney");
                                        acno=rs.getInt("acid");
               detail=("ID : "+acno+"\nName : "+acname+"\nAccount Type : "+actype+"\nMoney : "+money+"/-");
                                        out.println(detail);
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


        JButton cl = new JButton("CANCEL");
        cl.setFocusPainted(false);
        cl.setBounds(330, 230, 200, 40);
        cl.setFont(f3);
        cl.addActionListener(e -> System.exit(0));
        j11.setBounds(0, 0, 600, 100);
        j12.setBounds(0, 100, 600, 600);
        j12.add(Acc);
        j12.add(passe);
        j12.add(a1);
        j12.add(p1);
        j12.add(jb);
        j12.add(cl);
        JLabel lgn = new JLabel("Login");
        lgn.setFont(fe);
        lgn.setForeground(new Color(0xEEC113));
        lgn.setBounds(250, 10, 300, 100);
        j11.add(lgn);
        j12.add(res);


        getJf().setVisible(true);
        getJf().setSize(600, 500);
        getJf().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getJf().setResizable(false);
        getJf().add(j11);
        getJf().add(j12);
        getJf().setLayout(null);
        SwingUtilities.getRootPane(jb).setDefaultButton(jb);


    }

    public JFrame getJf() {
        return jf;
    }
}
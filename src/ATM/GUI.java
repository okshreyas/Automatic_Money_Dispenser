package ATM;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import static ATM.def.*;
import static ATM.login.*;
import static java.lang.System.out;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class GUI {

    static JButton Home = new JButton("HOME");
    public float didamt;
    JFrame frame = new JFrame("ATM Machine");
    float remcash = money;
    float wcash = money;

    String tran = "";

    private int amt;
    private String billname;


    void bn() throws InterruptedException {

        actions(t2);
        frame.setResizable(true);
        t2.setEditable(false);
        t1.setEditable(false);
        t2.setFont(f1);
        t2.setSelectedTextColor(Color.BLUE);
        t2.setHorizontalAlignment(JTextField.CENTER);
        t1.setFont(f1);
        t1.setSelectedTextColor(Color.BLUE);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t2.setBackground(new Color(0xECDD84));
        t1.setBackground(new Color(0x042152));

        //Set bounds
        bounds();
        setfont();

        //Jlabel - title

        ttl.setFont(new Font("Copperplate Gothic", Font.BOLD, 40));
        ttl.setForeground(new Color(0xFFFFFF));
        //ttl.setHorizontalAlignment((int) JPanel.LEFT_ALIGNMENT);

        JLabel pl1 = new JLabel("WELCOME");
        pl1.setForeground(new Color(0x0803A0));
        pl1.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        pl1.setFont(f1);
        pp1.setVisible(false);
        pp2.setVisible(true);
        p1.setVisible(true);
        p1.setLayout(null);

//Panels

        JPanel title = new JPanel(); //Title
        title.setBackground(new Color(0x4949AA));
        title.setBounds(0, 0, 1300, 50);
        title.setLayout(null);
        ttl.setBounds(150, 0, 1000, 50);
        title.add(ttl);
        ttl.setFont(f1);

        pp1.setBackground(new Color(0xE71F1F));
        pp1.setBounds(50, 50, 600, 150);
        pp1.setLayout(new BorderLayout());
        pp1.add(pl1);
        pp1.add(t2);


        pp2.setBackground(new Color(0x070734));
        pp2.setBounds(0, 100, 700, 150);
        pp2.setLayout(new BorderLayout());
        pp2.add(t1);

        transfer.addActionListener(e -> {
            try {
                transfer();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        p1.setBackground(new Color(0xC783FF));
        p1.setBounds(0, 50, 700, 400);
        p1.setLayout(null);
        p1.add(pp1);
        p1.add(pp2);


        p2.setBackground(new Color(0x070734));
        p2.setBounds(700, 50, 500, 550);
        p2.setLayout(null);


        p3.setBackground(new Color(0x070734));
        p3.setBounds(0, 450, 700, 600);
        p3.setLayout(null);
        enter.setForeground(Color.white);
        enter.setBackground(new Color(0x2BAC3D));
        enter.setBorder(bd);
        clear.setForeground(Color.red);
        clear.setBackground(Color.yellow);
        clear.setBorder(bd);
        Home.setForeground(Color.white);
        Home.setBackground(Color.red);
        Home.setBorder(bd);
        UIManager.put("OptionPane.MessageFont", new FontUIResource(new Font(
                "CONSOLAS", Font.BOLD, 18)));
        JOptionPane.showMessageDialog(frame, "Welcome..\n"+detail);
        t1.setText("For Start ->press 'HOME' button");
      t1.setForeground(Color.white);
        Home.addActionListener(e -> frame.getContentPane().invalidate());
        focus();
        p3butns(p3);
        Home.addActionListener(e -> actype()
        );
        p4.setBackground(new Color(0x070734));
        p4.setBounds(700, 700, 500, 300);
        p4.setLayout(null);


        //Jframe Here

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(702, 1000);
        frame.setVisible(true);
        frame.setLayout(null);

        //sidebars --
        frame.add(title); //title
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);

        ///////////////
        login l = new login();
        l.getJf().setVisible(false);
        //////////////////
    }

    private void focus() {
        j0.setFocusPainted(false);
        j1.setFocusPainted(false);
        j2.setFocusPainted(false);
        j3.setFocusPainted(false);
        j4.setFocusPainted(false);
        j5.setFocusPainted(false);
        j6.setFocusPainted(false);
        j7.setFocusPainted(false);
        j8.setFocusPainted(false);
        j9.setFocusPainted(false);
        j10.setFocusPainted(false);
        Home.setFocusPainted(false);
        exit.setFocusPainted(false);
        enter.setFocusPainted(false);
        clear.setFocusPainted(false);
    }

    public void actype() {login.jf.setVisible(false);
        JButton z1 = new JButton("SAVINGS");//goes to database actype with user type
        JButton z2 = new JButton("CURRENT");//goes to database actype with user type
        z1.setFont(f1);
        z2.setFont(f1);
        pp1.setVisible(false);
        p1.setVisible(true);
        p1.setLayout(null);
        p1.add(z1);
        p1.add(z2);

        t1.setText("CHOOSE ACCOUNT TYPE");
        t1.setForeground(new Color(0xFDF075));
        z1.setFont(f3);
        z2.setFont(f3);

        z1.setBounds(100, 300, 200, 70);
        z2.setBounds(400, 300, 200, 70);

        z1.addActionListener(e -> {
            actype = "SAVINGS";//with user type
            z1.setVisible(false);
            z2.setVisible(false);
            todo();
        });

        z2.addActionListener(e -> {
            actype = "CURRENT";//with user type
            z1.setVisible(false);
            z2.setVisible(false);
            todo();
        });


    }

    private void p3butns(JPanel p3) {
        p3.add(j1);
        p3.add(j2);
        p3.add(j3);
        p3.add(j4);
        p3.add(j5);
        p3.add(j6);
        p3.add(j7);
        p3.add(j8);
        p3.add(j9);
        p3.add(j10);
        p3.add(j0);
        p3.add(j00);
        p3.add(enter);
        p3.add(exit);
        p3.add(clear);
        p3.add(Home);
    }

    private void setfont() {

        j1.setFont(f1);
        j2.setFont(f1);
        j3.setFont(f1);
        j4.setFont(f1);
        j5.setFont(f1);
        j6.setFont(f1);
        j7.setFont(f1);
        j8.setFont(f1);
        j9.setFont(f1);
        j10.setFont(f1);
        exit.setFont(f2);
        clear.setFont(f2);
        Home.setFont(f2);
        enter.setFont(f2);
        j0.setFont(f1);
        j00.setFont(f1);
    }

    private void bounds() {
        j1.setBounds(20, 20, 150, 70);
        j2.setBounds(190, 20, 150, 70);
        j3.setBounds(360, 20, 150, 70);
        enter.setBounds(530, 20, 150, 70);
        j4.setBounds(20, 140, 150, 70);
        j5.setBounds(190, 140, 150, 70);
        j6.setBounds(360, 140, 150, 70);
        clear.setBounds(530, 140, 150, 70);
        j7.setBounds(20, 260, 150, 70);
        j8.setBounds(190, 260, 150, 70);
        j9.setBounds(360, 260, 150, 70);
        Home.setBounds(530, 260, 150, 70);
        j10.setBounds(20, 380, 150, 70);
        j0.setBounds(190, 380, 150, 70);
        j00.setBounds(360, 380, 150, 70);
        exit.setBounds(530, 380, 150, 70);
    }

    public void actions(JTextField t2) {
        j1.addActionListener(e -> t2.setText(t2.getText() + "1"));
        j2.addActionListener(e -> t2.setText(t2.getText() + "2"));
        j3.addActionListener(e -> t2.setText(t2.getText() + "3"));
        j4.addActionListener(e -> t2.setText(t2.getText() + "4"));
        j5.addActionListener(e -> t2.setText(t2.getText() + "5"));
        j6.addActionListener(e -> t2.setText(t2.getText() + "6"));
        j7.addActionListener(e -> t2.setText(t2.getText() + "7"));
        j8.addActionListener(e -> t2.setText(t2.getText() + "8"));
        j9.addActionListener(e -> t2.setText(t2.getText() + "9"));
        j0.addActionListener(e -> t2.setText(t2.getText() + "0"));
        j00.addActionListener(e -> t2.setText(t2.getText() + "00"));
        j10.addActionListener(e -> t2.setText(t2.getText() + "."));
        exit.addActionListener(e -> System.exit(0));
    }

    /*void count() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt(); } }*/
    private void todo() {

        t1.setText("What to Do...?");
        p1.setLayout(null);
        t1.setVisible(false);
        pp2.setVisible(false);


        z1.setBounds(100, 250, 200, 100);
        z2.setBounds(400, 100, 200, 100);
        z3.setBounds(100, 100, 200, 100);
        z4.setBounds(400, 250, 200, 100);
        z1.setFont(f4);
        z1.addActionListener(e -> wid());
        z2.setFont(f4);
        z2.addActionListener(e -> {
            try {
                stmt();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        z3.setFont(f4);
        z3.addActionListener(e -> bill());
        z4.setText("transfer");
        z4.addActionListener(e -> {
            try {
                transfer();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        z4.setFont(f4);
        p1.add(z1);
        p1.add(z2);
        p1.add(z3);
        p1.add(z4);


    }

    void stmt() throws SQLException {
        sttmt.dispose();
        frame.setSize(700, 500);
        p3.setVisible(false);
        p2.setVisible(true);
        p2.setBorder(bd);
        JTextPane stm = new JTextPane();
        stm.setFont(new Font("Courier New", Font.BOLD, 25));
        stm.setText("" +
                "*****************************\n" +
                "\t-BANK OF ICCS-\n" +
                "****************************\n" +
                "\tAcc No.: xxxxxxxx" + acno + "\n" +
                "\tAcc Type : " + actype +
                "\n\tName : " + acname + "" +
                "\n\tMoney : " + money + "/-" + "\n\tDate : " +
                LocalDate.now() + "\n\tTime : "
                + LocalTime.now() + "\n" + "-------------------------------\n" + tran + "\n" +
                "\n\tHave A nice Day...!\n\n\n" + "\n\tFor any Enquiries\n\tToll free No: 1000 200 800" +
                "\n****************************\n");
        stm.setEditable(false);
        stm.setBounds(0, 0, 500, 1200);
        sttmt.add(stm);
        sttmt.setSize(500, 900);
        sttmt.setResizable(false);
        sttmt.setLayout(null);
        sttmt.setVisible(true);


        try {
            Connection con = DriverManager.getConnection(url);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from Acc where acid="+acno);
            while(rs.next()) {
                Statement st2 = con.createStatement();
                st2.executeUpdate("UPDATE Acc SET acmoney ="+money+" WHERE acid ="+acno);
        }}
                 catch (SQLException I) {I.printStackTrace();}
        }


        void bill() {



            try {
                Connection con = DriverManager.getConnection(url);
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from Acc where acid="+acno);
              while (rs.next()) {
                  amt=rs.getInt("billpay");
                   billname=rs.getString("billno");
                           System.out.println(amt+billname);

                }
                }
            catch (SQLException I) {I.printStackTrace();}


        p3.setVisible(false);
        p2.setVisible(false);
        frame.setLayout(null);
        pp1.setVisible(false);
        pp2.setVisible(false);
        p1.setVisible(false);
        JPanel xx = new JPanel();
        JPanel xx3 = new JPanel();
        JPanel xx2 = new JPanel();
        xx.setBounds(0, 300, 600, 20);
        xx2.setBounds(0, 170, 600, 20);
        xx.setBackground(Color.green);
        xx2.setBackground(new Color(0xff37612));
        xx3.setBounds(0, 0, 600, 600);
        xx3.setBackground(new Color(0x111136));
        frame.setSize(600, 600);


        JPanel x = new JPanel();
        x.setVisible(true);
        x.setBackground(new Color(0x090949));
        x.setSize(300, 200);
        x.setLayout(null);
        x.setBounds(50, 150, 450, 300);
        x.setBorder(bd2);

        JLabel t2 = new JLabel("Amount : ");
        JLabel t1 = new JLabel("Bill No : ");
        JLabel nn=new JLabel("Name : "+acname);
        JLabel amtt = new JLabel(billname);
        JLabel bil = new JLabel(amt +"/-");
        JButton pay = new JButton("Pay");
        JButton cacel = new JButton("Cancel");

        bil.setFont(f2);
        t1.setFont(f2);
            nn.setFont(f2);
        amtt.setFont(f2);
        t2.setFont(f2);
        bil.setFont(f2);
        pay.setFont(f3);
        cacel.setForeground(Color.white);
        cacel.setFont(f3);

        t1.setForeground(Color.white);
        nn.setForeground(Color.white);
        t2.setForeground(Color.white);
        amtt.setForeground(Color.white);
        pay.setForeground(Color.ORANGE);
        pay.setBackground(Color.BLUE);
        pay.setBorder(bd);
        cacel.setBackground(Color.red);
        pay.setForeground(Color.white);
        bil.setForeground(Color.white);
        cacel.setBorder(bd);

        pay.addActionListener(e -> {
            if (money > amt) {
                money = money - amt;
                wcash = remcash;
                JOptionPane.showMessageDialog(frame, "Paid Successfully...!");
                x.setVisible(false);
                xx.setVisible(false);
                xx2.setVisible(false);
                xx3.setVisible(false);
                p3.setVisible(true);
                p1.setVisible(true);
                tran = (LocalDateTime.now()) + "\t Paid bill Rs."+amt+"/-" + "\n" + "-------------------------------\n" + tran;
                frame.setSize(700, 1000);
            } else {
                JOptionPane.showMessageDialog(frame, "Insufficient Funds.!\n Please see Statement");
            }
        });
        cacel.addActionListener(e -> {

            JOptionPane.showMessageDialog(frame, "cancelled operation");
            x.setVisible(false);
            for (JPanel jPanel : Arrays.asList(xx, xx2, xx3)) {
                jPanel.setVisible(false);
            }
            p3.setVisible(true);
            p2.setVisible(true);
            p1.setVisible(true);
            frame.setSize(700, 1000);
        });
            nn.setBounds(100,0,400,100);
        t1.setBounds(100, 50, 250, 100);
        t2.setBounds(100, 100, 250, 100);
        amtt.setBounds(200, 50, 250, 100);
        bil.setBounds(200, 100, 250, 100);
        pay.setBounds(80, 200, 150, 50);
        cacel.setBounds(240, 200, 150, 50);

        x.add(nn);
        x.add(t1);
        x.add(pay);
        x.add(t2);
        x.add(amtt);
        x.add(bil);
        x.add(cacel);
        frame.add(x);
        frame.add(xx2);
        frame.add(xx);
        frame.add(xx3);

    }

    void wid() {


        bb.setVisible(true);
        p1.setVisible(false);
        pp1.setVisible(false);
        pp2.setVisible(false);
        ttl.setText("Withdraw Money");

        JLabel hd = new JLabel("Withdraw Money");
        hd.setFont(f1);
        hd.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        hd.setVerticalAlignment((int) JFrame.CENTER_ALIGNMENT);
        hd.setForeground(Color.white);

        JPanel body = new JPanel();
        body.setBackground(new Color(0xC783FF));
        body.setBounds(0, 50, 700, 500);
        body.setLayout(null);
        body.setSize(700, 500);

        JLabel bb = new JLabel("Enter Amount : ");
        bb.setFont(f3);
        bb.setBounds(100, 100, 300, 50);

        JButton w1 = new JButton("Confirm");
        w1.setSize(100, 100);
        w1.setBounds(100, 250, 200, 60);
        JButton w2 = new JButton("Cancel");
        w2.setSize(100, 100);
        w2.setBounds(350, 250, 200, 60);
        JButton w3 = new JButton("collected");
        w3.setSize(100, 100);
        w3.setBounds(350, 300, 200, 60);
        w3.setVisible(false);
        w1.setFont(f3);
        w2.setFont(f3);
        w3.setFont(f3);


        JLabel mes = new JLabel();
        mes.setFont(f3);
        mes.setForeground(new Color(0x150617));
        mes.setBounds(50, 200, 450, 100);
        JTextField ammt = new JTextField("");
        ammt.setBounds(400, 100, 200, 40);
        ammt.setFont(f3);
        clear.addActionListener(e -> ammt.setText(""));
        actions(ammt);

        w1.addActionListener(e -> {
            didamt = Float.parseFloat(ammt.getText());

            out.println(didamt);
            if (didamt == 0 || (didamt > money && didamt <=0)) {
                mess = "invalid";
            } else if (didamt <= money) {
                money = (int) (money - didamt);
                mess = "Collect Your Cash Rs : " + didamt + "/-";
                w3.setVisible(true);
                wcash = remcash;
                ammt.setVisible(false);
                w1.setVisible(false);
                w2.setVisible(false);
                bb.setVisible(false);
                tran = (LocalDateTime.now()) + "\n Withdraw Cash Rs." + didamt + "/-" + "\n" + "-------------------------------\n" + tran;
                try {
                    stmt();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                sttmt.setDefaultCloseOperation(EXIT_ON_CLOSE);
                mes.setText("Thank you Come Again...!");
                w3.setText("exit");
                w3.addActionListener(e1 -> System.exit(0));
            } else {
                JOptionPane.showMessageDialog(frame, "Insufficient Amount");
            }});

        w2.addActionListener(e -> {
            p1.setVisible(true);
            body.remove(w1);
            body.remove(w2);
            body.remove(w3);
            body.remove(mes);
            body.remove(ammt);
            body.remove(bb);
            JOptionPane.showMessageDialog(frame, "Cancelled..!");
        });

        w3.addActionListener(e -> {p3.setVisible(true);
            tran = (LocalDateTime.now()) + "\n Withdraw Cash Rs." + didamt + "/-" + "\n" + "-------------------------------\n" + tran;
            try {
                stmt();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            mes.setText("Thank you Come Again...!");
            w3.setText("exit");
            w3.addActionListener(e1 -> System.exit(0)); });

        body.add(bb);
        body.add(ammt);
        body.add(hd);
        body.add(w1);
        body.add(w2);
        body.add(w3);
        body.add(mes);
        frame.add(body);


    }

   void transfer() throws SQLException {

       ////////




               p1.setVisible(false);
               JPanel trw = new JPanel();
               trw.setLayout(null);
               trw.setVisible(true);
               trw.setBackground(new Color(0xFF0E0257, true));
               trw.setBounds(0, 50, 700, 400);
               JButton cnf = new JButton("CONFIRM");
               cnf.setFocusPainted(false);
               cnf.setBounds(90, 230, 200, 40);
               cnf.setFont(f3);
               //cnf.addActionListener();

               JButton cl = new JButton("CANCEL");
               cl.setFocusPainted(false);
               cl.setBounds(330, 230, 200, 40);
               cl.setFont(f3);
               cl.addActionListener(e -> System.exit(0));

               JLabel eac = new JLabel("Enter A/C No : ");
               eac.setForeground(Color.white);
               eac.setBounds(100, 70, 300, 100);
               eac.setFont(f3);
       JLabel eac2 = new JLabel();
       eac2.setForeground(Color.white);
       eac2.setBounds(70, 20, 500,100);
       eac2.setFont(f3);
       eac2.setVisible(true);

               JTextField eactxt = new JTextField();
               eactxt.setFont(f3);
               actions(eactxt);
               eactxt.setBounds(420, 110, 170, 30);
       JTextField eactxt2 = new JTextField();
       eactxt2.setFont(f3);
       actions(eactxt2);
       eactxt2.setBounds(420, 110, 170, 30);

               cnf.addActionListener(e -> {
                   actotr = Integer.parseInt(eactxt.getText());
                   cnf.addActionListener(e3 -> {eac.setText("Amount : ");
                       eactxt.setVisible(false);
                       System.out.println(actotr);
                       try {
                           Connection con = DriverManager.getConnection(url);
                           Statement st = con.createStatement();
                           ResultSet rs = st.executeQuery("select * from Acc where acid=" + actotr);
                           while (rs.next()) {
                               if (rs != null && eactxt.getText() != null) {
                                   out.println(acno);
                                   out.println(rs.getString("name") + " " + rs.getInt("acid") + " " + rs.getString("atype"));
                                   aid1 = rs.getInt("acid");
                                   an1 = rs.getString("name");
                                   actmon = Integer.parseInt(rs.getString("acmoney"));
                                   out.println(actmon);

eac2.setText("Transfer Money to : "+an1);
                                   cnf.addActionListener(e1 -> {
                                       amnt = Integer.parseInt(eactxt2.getText());
if(amnt<=money){
                                       int result = (money - amnt);
                                       try {
                                           Connection conn = DriverManager.getConnection(url);
                                           Statement stmt = conn.createStatement();
                                           {
                                               stmt.executeUpdate("UPDATE Acc SET acmoney = " + result + " WHERE acid = " + acno);
                                               ResultSet rss = stmt.executeQuery("select * from Acc where acid = " + acno);
                                               while (rss.next()) {
                                               }
                                           }
                                       } catch (SQLException i) {
                                           i.printStackTrace();
                                       }

                                       try {
                                           Connection conn = DriverManager.getConnection(url);
                                           Statement stmt = conn.createStatement();
                                           {
                                               stmt.executeUpdate("UPDATE Acc SET acmoney = acmoney+" + amnt + " WHERE acid = " + actotr);
                                               ResultSet rss = stmt.executeQuery("select * from Acc where acid = " + actotr);
                                               while (rss.next()) {
                                               }
                                           }
                                       } catch (SQLException i) {
                                           i.printStackTrace();
                                       }
                                       cnf.setVisible(false);
                                       eac.setVisible(false);
                                       eactxt2.setVisible(false);
                                JOptionPane.showMessageDialog(frame, "Transeferred Rs."+amnt+"/- From "+acname+" TO "+ an1);
                                       cl.setText("Exit");
                                   }
                                    else{ JOptionPane.showMessageDialog(frame, "Insufficient Funds...!");
}
                                   });
                               } else {
                                   //res.setVisible(true);
                               }
                           }
                           con.close();
                       } catch (SQLException sqlException) {
                           sqlException.printStackTrace();
                       }
                   });
               });
       //trw.add(res);
               trw.add(eactxt);
               trw.add(eac);
       trw.add(eac2);
               trw.add(cl);
               trw.add(cnf);
               trw.add(eactxt2);
               frame.add(trw);

   }

    }



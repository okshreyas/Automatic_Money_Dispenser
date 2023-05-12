package ATM;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import static ATM.Definition.*;
import static ATM.Login.*;
import static java.lang.System.out;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class GUI {

    static JButton Home = new JButton("HOME");
    public float DeductedAmount;
    JFrame MainFrame = new JFrame("ATM Machine");
    float RemainingCash = Money;
    float wcash = Money;

    String tran = "";

    private int Amount;
    private String BillNumber;


    void bn() throws InterruptedException {

        actions(TextBox2);
        MainFrame.setResizable(true);
        TextBox2.setEditable(false);
        TextBox1.setEditable(false);
        TextBox2.setFont(Font1);
        TextBox2.setSelectedTextColor(Color.BLUE);
        TextBox2.setHorizontalAlignment(JTextField.CENTER);
        TextBox1.setFont(Font1);
        TextBox1.setSelectedTextColor(Color.BLUE);
        TextBox1.setHorizontalAlignment(JTextField.CENTER);
        TextBox2.setBackground(new Color(0xECDD84));
        TextBox1.setBackground(new Color(0x042152));

        //Set bounds
        bounds();
        setfont();




        PanelP1.setVisible(false);
        PanelP2.setVisible(true);
        Panel1.setVisible(true);
        Panel1.setLayout(null);

        //Panels

        JPanel title = new JPanel(); //Title
        title.setBackground(new Color(0x4949AA));
        title.setBounds(0, 0, 1300, 50);
        title.setLayout(null);

        PanelP1.setBackground(new Color(0xE71F1F));
        PanelP1.setBounds(50, 50, 600, 150);
        PanelP1.setLayout(new BorderLayout());
        //PanelP1.add(pl1);
        PanelP1.add(TextBox2);


        PanelP2.setBackground(new Color(0x070734));
        PanelP2.setBounds(0, 100, 700, 150);
        PanelP2.setLayout(new BorderLayout());
        PanelP2.add(TextBox1);

        transfer.addActionListener(e -> {
            try {
                transfer();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        });

        Panel1.setBackground(new Color(0xC783FF));
        Panel1.setBounds(0, 50, 700, 400);
        Panel1.setLayout(null);
        Panel1.add(PanelP1);
        Panel1.add(PanelP2);


        Panel2.setBackground(new Color(0x070734));
        Panel2.setBounds(700, 50, 500, 550);
        Panel2.setLayout(null);


        Panel3.setBackground(new Color(0x070734));
        Panel3.setBounds(0, 450, 700, 600);
        Panel3.setLayout(null);
        Enter.setForeground(Color.white);
        Enter.setBackground(new Color(0x2BAC3D));
        Enter.setBorder(BorderType1);
        Clear.setForeground(Color.red);
        Clear.setBackground(Color.yellow);
        Clear.setBorder(BorderType1);
        Home.setForeground(Color.white);
        Home.setBackground(Color.red);
        Home.setBorder(BorderType1);
        UIManager.put("OptionPane.MessageFont", new FontUIResource(new Font(
                "CONSOLAS", Font.BOLD, 18)));
        JOptionPane.showMessageDialog(MainFrame, "Welcome..\n"+ Details);
        TextBox1.setText("For Start ->press 'HOME' button");
        TextBox1.setForeground(Color.white);
        Home.addActionListener(e -> MainFrame.getContentPane().invalidate());
        focus();
        p3butns(Panel3);
        Home.addActionListener(e -> actype()
        );
        Panel4.setBackground(new Color(0x070734));
        Panel4.setBounds(700, 700, 500, 300);
        Panel4.setLayout(null);


        //Jframe Here

        MainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainFrame.setSize(702, 1000);
        MainFrame.setVisible(true);
        MainFrame.setLayout(null);

        //sidebars --
        MainFrame.add(title); //title
        MainFrame.add(Panel1);
        MainFrame.add(Panel2);
        MainFrame.add(Panel3);
        MainFrame.add(Panel4);

        ///////////////
        Login LoginClass = new Login();
        LoginClass.MainFrame2().setVisible(false);
        //////////////////
    }

    private void focus() {
        B0.setFocusPainted(false);
        B1.setFocusPainted(false);
        B2.setFocusPainted(false);
        B3.setFocusPainted(false);
        B4.setFocusPainted(false);
        B5.setFocusPainted(false);
        B6.setFocusPainted(false);
        B7.setFocusPainted(false);
        B8.setFocusPainted(false);
        B9.setFocusPainted(false);
        BDot.setFocusPainted(false);
        Home.setFocusPainted(false);
        Exit.setFocusPainted(false);
        Enter.setFocusPainted(false);
        Clear.setFocusPainted(false);
    }

    public void actype() {
        Login.MainFrame2.setVisible(false);
        JButton SavingsAcc = new JButton("SAVINGS");//goes to database actype with user type
        JButton CurrentAcc = new JButton("CURRENT");//goes to database actype with user type
        SavingsAcc.setFont(Font1);
        CurrentAcc.setFont(Font1);
        PanelP1.setVisible(false);
        Panel1.setVisible(true);
        Panel1.setLayout(null);
        Panel1.add(SavingsAcc);
        Panel1.add(CurrentAcc);

        TextBox1.setText("CHOOSE ACCOUNT TYPE");
        TextBox1.setForeground(new Color(0xFDF075));
        SavingsAcc.setFont(Font3);
        CurrentAcc.setFont(Font3);

        SavingsAcc.setBounds(100, 300, 200, 70);
        CurrentAcc.setBounds(400, 300, 200, 70);

        SavingsAcc.addActionListener(e -> {
            AccountType = "SAVINGS";//with user type
            SavingsAcc.setVisible(false);
            CurrentAcc.setVisible(false);
            todo();
        });

        CurrentAcc.addActionListener(e -> {
            AccountType = "CURRENT";//with user type
            SavingsAcc.setVisible(false);
            CurrentAcc.setVisible(false);
            todo();
        });


    }

    private void p3butns(JPanel p3) {
        p3.add(B1);
        p3.add(B2);
        p3.add(B3);
        p3.add(B4);
        p3.add(B5);
        p3.add(B6);
        p3.add(B7);
        p3.add(B8);
        p3.add(B9);
        p3.add(BDot);
        p3.add(B0);
        p3.add(B00);
        p3.add(Enter);
        p3.add(Exit);
        p3.add(Clear);
        p3.add(Home);
    }

    private void setfont() {

        B1.setFont(Font1);
        B2.setFont(Font1);
        B3.setFont(Font1);
        B4.setFont(Font1);
        B5.setFont(Font1);
        B6.setFont(Font1);
        B7.setFont(Font1);
        B8.setFont(Font1);
        B9.setFont(Font1);
        BDot.setFont(Font1);
        Exit.setFont(Font2);
        Clear.setFont(Font2);
        Home.setFont(Font2);
        Enter.setFont(Font2);
        B0.setFont(Font1);
        B00.setFont(Font1);
    }

    private void bounds() {
        B1.setBounds(20, 20, 150, 70);
        B2.setBounds(190, 20, 150, 70);
        B3.setBounds(360, 20, 150, 70);
        Enter.setBounds(530, 20, 150, 70);
        B4.setBounds(20, 140, 150, 70);
        B5.setBounds(190, 140, 150, 70);
        B6.setBounds(360, 140, 150, 70);
        Clear.setBounds(530, 140, 150, 70);
        B7.setBounds(20, 260, 150, 70);
        B8.setBounds(190, 260, 150, 70);
        B9.setBounds(360, 260, 150, 70);
        Home.setBounds(530, 260, 150, 70);
        BDot.setBounds(20, 380, 150, 70);
        B0.setBounds(190, 380, 150, 70);
        B00.setBounds(360, 380, 150, 70);
        Exit.setBounds(530, 380, 150, 70);
    }

    public void actions(JTextField t2) {
        B1.addActionListener(e -> t2.setText(t2.getText() + "1"));
        B2.addActionListener(e -> t2.setText(t2.getText() + "2"));
        B3.addActionListener(e -> t2.setText(t2.getText() + "3"));
        B4.addActionListener(e -> t2.setText(t2.getText() + "4"));
        B5.addActionListener(e -> t2.setText(t2.getText() + "5"));
        B6.addActionListener(e -> t2.setText(t2.getText() + "6"));
        B7.addActionListener(e -> t2.setText(t2.getText() + "7"));
        B8.addActionListener(e -> t2.setText(t2.getText() + "8"));
        B9.addActionListener(e -> t2.setText(t2.getText() + "9"));
        B0.addActionListener(e -> t2.setText(t2.getText() + "0"));
        B00.addActionListener(e -> t2.setText(t2.getText() + "00"));
        BDot.addActionListener(e -> t2.setText(t2.getText() + "."));
        Exit.addActionListener(e -> System.exit(0));
    }

    /*void count() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt(); } }*/
    private void todo() {

        TextBox1.setText("What to Do...?");
        Panel1.setLayout(null);
        TextBox1.setVisible(false);
        PanelP2.setVisible(false);


        Withdraw.setBounds(100, 250, 200, 100);
        Statement.setBounds(400, 100, 200, 100);
        BillPay.setBounds(100, 100, 200, 100);
        Transfer.setBounds(400, 250, 200, 100);
        Withdraw.setFont(Font4);
        Withdraw.addActionListener(e -> Withdraw());
        Statement.setFont(Font4);
        Statement.addActionListener(e -> {
            try {
                Statement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        BillPay.setFont(Font4);
        BillPay.addActionListener(e -> bill());
        Transfer.setText("transfer");
        Transfer.addActionListener(e -> {
            try {
                transfer();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        Transfer.setFont(Font4);
        Panel1.add(Withdraw);
        Panel1.add(Statement);
        Panel1.add(BillPay);
        Panel1.add(Transfer);


    }

    void Statement() throws SQLException {
        GetStatement.dispose();
        MainFrame.setSize(700, 500);
        Panel3.setVisible(false);
        Panel2.setVisible(true);
        Panel2.setBorder(BorderType1);
        JTextPane Statement = new JTextPane();
        Statement.setFont(new Font("Courier New", Font.BOLD, 25));
        Statement.setText( "*****************************\n" +
                "\t-BANK OF ICCS-\n" +
                "****************************\n" +
                "\tAcc No.: xxxxxxxx" + AccountNumber + "\n" +
                "\tAcc Type : " + AccountType +
                "\n\tName : " + AccountName +
                "\n\tMoney : " + Money + "/-" + "\n\tDate : " +
                LocalDate.now() + "\n\tTime : "
                + LocalTime.now() + "\n" + "-------------------------------\n" + tran + "\n" +
                "\n\tHave A nice Day...!\n\n\n" + "\n\tFor any Enquiries\n\tToll free No: 1000 200 800" +
                "\n****************************\n" );
        Statement.setEditable(false);
        Statement.setBounds(0, 0, 500, 1200);
        GetStatement.add(Statement);
        GetStatement.setSize(500, 900);
        GetStatement.setResizable(false);
        GetStatement.setLayout(null);
        GetStatement.setVisible(true);


        try {
            Connection con = DriverManager.getConnection(url);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from Account where AccountID="+ AccountNumber);
            while(rs.next()) {
                Statement st2 = con.createStatement();
                st2.executeUpdate("UPDATE Account SET AccMoney ="+ Money +" WHERE AccountID ="+ AccountNumber);
        }}
                 catch (SQLException I) {I.printStackTrace();}
        }


        void bill() {



            try {
                Connection con = DriverManager.getConnection(url);
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from Account where AccountId="+ AccountNumber);
              while (rs.next()) {
                  Amount =rs.getInt("Bills");
                   BillNumber =rs.getString("Bill Number");
                           System.out.println(Amount + BillNumber);

                }
                }
            catch (SQLException I) {I.printStackTrace();}


        Panel3.setVisible(false);
        Panel2.setVisible(false);
        MainFrame.setLayout(null);
        PanelP1.setVisible(false);
        PanelP2.setVisible(false);
        Panel1.setVisible(false);
        JPanel xx = new JPanel();
        JPanel xx3 = new JPanel();
        JPanel xx2 = new JPanel();
        xx.setBounds(0, 300, 600, 20);
        xx2.setBounds(0, 170, 600, 20);
        xx.setBackground(Color.green);
        xx2.setBackground(new Color(0xff37612));
        xx3.setBounds(0, 0, 600, 600);
        xx3.setBackground(new Color(0x111136));
        MainFrame.setSize(600, 600);


        JPanel x = new JPanel();
        x.setVisible(true);
        x.setBackground(new Color(0x090949));
        x.setSize(300, 200);
        x.setLayout(null);
        x.setBounds(50, 150, 450, 300);
        x.setBorder(BorderType2);

        JLabel t2 = new JLabel("Amount : ");
        JLabel t1 = new JLabel("Bill No : ");
        JLabel nn=new JLabel("Name : "+ AccountName);
        JLabel amtt = new JLabel(BillNumber);
        JLabel bil = new JLabel(Amount +"/-");
        JButton pay = new JButton("Pay");
        JButton cacel = new JButton("Cancel");

        bil.setFont(Font2);
        t1.setFont(Font2);
        nn.setFont(Font2);
        amtt.setFont(Font2);
        t2.setFont(Font2);
        bil.setFont(Font2);
        pay.setFont(Font3);
        cacel.setForeground(Color.white);
        cacel.setFont(Font3);

        t1.setForeground(Color.white);
        nn.setForeground(Color.white);
        t2.setForeground(Color.white);
        amtt.setForeground(Color.white);
        pay.setForeground(Color.ORANGE);
        pay.setBackground(Color.BLUE);
        pay.setBorder(BorderType1);
        cacel.setBackground(Color.red);
        pay.setForeground(Color.white);
        bil.setForeground(Color.white);
        cacel.setBorder(BorderType1);

        pay.addActionListener(e -> {
            if (Money > Amount) {
                Money = Money - Amount;
                wcash = RemainingCash;
                JOptionPane.showMessageDialog(MainFrame, "Paid Successfully...!");
                x.setVisible(false);
                xx.setVisible(false);
                xx2.setVisible(false);
                xx3.setVisible(false);
                Panel3.setVisible(true);
                Panel1.setVisible(true);
                tran = (LocalDateTime.now()) + "\t Paid bill Rs."+ Amount +"/-" + "\n" + "-------------------------------\n" + tran;
                MainFrame.setSize(700, 1000);
            } else {
                JOptionPane.showMessageDialog(MainFrame, "Insufficient Funds.!\n Please see Statement");
            }
        });
        cacel.addActionListener(e -> {

            JOptionPane.showMessageDialog(MainFrame, "cancelled operation");
            x.setVisible(false);
            for (JPanel jPanel : Arrays.asList(xx, xx2, xx3)) {
                jPanel.setVisible(false);
            }
            Panel3.setVisible(true);
            Panel2.setVisible(true);
            Panel1.setVisible(true);
            MainFrame.setSize(700, 1000);
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
        MainFrame.add(x);
        MainFrame.add(xx2);
        MainFrame.add(xx);
        MainFrame.add(xx3);

    }

    void Withdraw() {


        GetAmount.setVisible(true);
        Panel1.setVisible(false);
        PanelP1.setVisible(false);
        PanelP2.setVisible(false);

        JLabel LabelW = new JLabel("Withdraw Money");
        LabelW.setFont(Font1);
        LabelW.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        LabelW.setVerticalAlignment((int) JFrame.CENTER_ALIGNMENT);
        LabelW.setForeground(Color.white);

        JPanel MainBody = new JPanel();
        MainBody.setBackground(new Color(0xC783FF));
        MainBody.setBounds(0, 50, 700, 500);
        MainBody.setLayout(null);
        MainBody.setSize(700, 500);

        JLabel GetAmountLabel = new JLabel("Enter Amount : ");
        GetAmountLabel.setFont(Font3);
        GetAmountLabel.setBounds(100, 100, 300, 50);

        JButton ConfirmButton = new JButton("Confirm");
        ConfirmButton.setSize(100, 100);
        ConfirmButton.setBounds(100, 250, 200, 60);
        JButton CancelButton = new JButton("Cancel");
        CancelButton.setSize(100, 100);
        CancelButton.setBounds(350, 250, 200, 60);
        JButton Confirmed = new JButton("collected");
        Confirmed.setSize(100, 100);
        Confirmed.setBounds(350, 300, 200, 60);
        Confirmed.setVisible(false);
        ConfirmButton.setFont(Font3);
        CancelButton.setFont(Font3);
        Confirmed.setFont(Font3);


        JLabel Message2 = new JLabel();
        Message2.setFont(Font3);
        Message2.setForeground(new Color(0x150617));
        Message2.setBounds(50, 200, 450, 100);
        JTextField Amount = new JTextField("");
        Amount.setBounds(400, 100, 200, 40);
        Amount.setFont(Font3);
        Clear.addActionListener(e -> Amount.setText(""));
        actions(Amount);

        ConfirmButton.addActionListener(e -> {
            DeductedAmount = Float.parseFloat(Amount.getText());

            out.println(DeductedAmount);
            if (DeductedAmount == 0 || (DeductedAmount > Money && DeductedAmount <=0)) {
                Message = "invalid";
            } else if (DeductedAmount <= Money) {
                Money = (int) (Money - DeductedAmount);
                Message = "Collect Your Cash Rs : " + DeductedAmount + "/-";
                Confirmed.setVisible(true);
                wcash = RemainingCash;
                Amount.setVisible(false);
                ConfirmButton.setVisible(false);
                CancelButton.setVisible(false);
                GetAmountLabel.setVisible(false);
                tran = (LocalDateTime.now()) + "\n Withdraw Cash Rs." + DeductedAmount + "/-" + "\n" + "-------------------------------\n" + tran;
                try {
                    Statement();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                GetStatement.setDefaultCloseOperation(EXIT_ON_CLOSE);
                Message2.setText("Thank you Come Again...!");
                Confirmed.setText("exit");
                Confirmed.addActionListener(e1 -> System.exit(0));
            } else {
                JOptionPane.showMessageDialog(MainFrame, "Insufficient Amount");
            }});

        CancelButton.addActionListener(e -> {
            Panel1.setVisible(true);
            for (JButton jButton : Arrays.asList( ConfirmButton, CancelButton, Confirmed )) {
                MainBody.remove( jButton );
            }
            MainBody.remove(Message2);
            MainBody.remove(Amount);
            MainBody.remove(GetAmountLabel);
            JOptionPane.showMessageDialog(MainFrame, "Cancelled..!");
        });

        Confirmed.addActionListener(e -> {
            Panel3.setVisible(true);
            tran = (LocalDateTime.now()) + "\n Withdraw Cash Rs." + DeductedAmount + "/-" + "\n" + "-------------------------------\n" + tran;
            try {
                Statement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Message2.setText("Thank you Come Again...!");
            Confirmed.setText("exit");
            Confirmed.addActionListener(e1 -> System.exit(0)); });

        MainBody.add(GetAmountLabel);
        MainBody.add(Amount);
        MainBody.add(LabelW);
        MainBody.add(ConfirmButton);
        MainBody.add(CancelButton);
        MainBody.add(Confirmed);
        MainBody.add(Message2);
        MainFrame.add(MainBody);


    }

   void transfer() throws SQLException {

       ////////




               Panel1.setVisible(false);
               JPanel TransferWindow = new JPanel();
               TransferWindow.setLayout(null);
               TransferWindow.setVisible(true);
               TransferWindow.setBackground(new Color(0xFF0E0257, true));
               TransferWindow.setBounds(0, 50, 700, 400);
               JButton Confirm = new JButton("CONFIRM");
               Confirm.setFocusPainted(false);
               Confirm.setBounds(90, 230, 200, 40);
               Confirm.setFont(Font3);
               //Confirm.addActionListener();

               JButton Cancel = new JButton("CANCEL");
               Cancel.setFocusPainted(false);
               Cancel.setBounds(330, 230, 200, 40);
               Cancel.setFont(Font3);
               Cancel.addActionListener(e -> System.exit(0));

               JLabel GetAccNo = new JLabel("Enter A/C No : ");
               GetAccNo.setForeground(Color.white);
               GetAccNo.setBounds(100, 70, 300, 100);
               GetAccNo.setFont(Font3);
                JLabel AccNumberToTransfer = new JLabel();
                AccNumberToTransfer.setForeground(Color.white);
                AccNumberToTransfer.setBounds(70, 20, 500,100);
                AccNumberToTransfer.setFont(Font3);
                AccNumberToTransfer.setVisible(true);

               JTextField GetAccNumber = new JTextField();
               JTextField GetAccNumber2 = new JTextField();
               GetAccNumber.setFont(Font3);
               GetAccNumber2.setFont(Font3);
               GetAccNumber.setBounds(420, 110, 170, 30);
               GetAccNumber2.setBounds(420, 110, 170, 30);
               actions(GetAccNumber);
               actions(GetAccNumber2);

               Confirm.addActionListener(e -> {
                   AccToTransfer = Integer.parseInt(GetAccNumber.getText());
                   Confirm.addActionListener(e3 -> {GetAccNo.setText("Amount : ");
                       GetAccNumber.setVisible(false);
                       System.out.println( AccToTransfer );
                       try {
                           Connection con = DriverManager.getConnection(url);
                           Statement st = con.createStatement();
                           ResultSet rs = st.executeQuery("select * from Account where AccountID=" + AccToTransfer );
                           while (rs.next()) {
                               if (rs != null && GetAccNumber.getText() != null) {
                                   out.println(Login.AccountNumber);
                                   out.println(rs.getString("AccName") + " " + rs.getInt("AccountID") + " " + rs.getString("AccType"));
                                   AccountId1 = rs.getInt("AccountID");
                                   AccName1 = rs.getString("AccName");
                                   AccountMoney = Integer.parseInt(rs.getString("AccMoney"));
                                   out.println( AccountMoney );

                                   AccNumberToTransfer.setText("Transfer Money to : "+ AccName1 );
                                   Confirm.addActionListener(e1 -> {
                                       Definition.Amount = Integer.parseInt(GetAccNumber2.getText());
                                            if(Definition.Amount <= Money){
                                       int result = (Money - Definition.Amount);
                                       try {
                                           Connection conn = DriverManager.getConnection(url);
                                           Statement stmt = conn.createStatement();
                                           {
                                               stmt.executeUpdate("UPDATE Account SET AccMoney = " + result + " WHERE AccountID = " + Login.AccountNumber);
                                               ResultSet rss = stmt.executeQuery("select * from Account where AccountID = " + Login.AccountNumber);
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
                                               stmt.executeUpdate("UPDATE Account SET AccMoney = AccMoney+" + Definition.Amount + " WHERE AccountID = " + AccToTransfer );
                                               ResultSet rss = stmt.executeQuery("select * from Account where AccountID = " + AccToTransfer );
                                               while (rss.next()) {
                                               }
                                           }
                                       } catch (SQLException i) {
                                           i.printStackTrace();
                                       }
                                       Confirm.setVisible(false);
                                       GetAccNo.setVisible(false);
                                       GetAccNumber2.setVisible(false);
                                JOptionPane.showMessageDialog(MainFrame, "Transeferred Rs."+ Definition.Amount +"/- From "+ AccountName +" TO "+ AccName1 );
                                       Cancel.setText("Exit");
                                   }
                                    else{ JOptionPane.showMessageDialog(MainFrame, "Insufficient Funds...!");
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
                   } );
               } );


               TransferWindow.add(GetAccNumber);
               TransferWindow.add(GetAccNo);
               TransferWindow.add(AccNumberToTransfer);
               TransferWindow.add(Cancel);
               TransferWindow.add(Confirm);
               TransferWindow.add(GetAccNumber2);
               MainFrame.add(TransferWindow);

   }

    }

/////

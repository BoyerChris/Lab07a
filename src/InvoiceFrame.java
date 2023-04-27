import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class InvoiceFrame extends JFrame {

    JPanel mainPnl, topPnl, midPnl, quitPnl;
    JButton addressSubmit, productSubmit, somethingBtn, quitBtn;
    JTextField textbox1, textbox2, textbox3, textbox4, textbox5, textbox6;
    JFormattedTextField textbox7, textbox8;
    Invoice custInvoice;


    public InvoiceFrame() {
        createGUI();
        setTitle("Invoice");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        Address samsAddress = new Address("", "", "", "");
        Customer samsCustomer = new Customer("", samsAddress);
        custInvoice = new Invoice(samsCustomer);

    }

    private void createGUI() {
        mainPnl = new JPanel();
        topPnl = new JPanel();
        midPnl = new JPanel();
        quitPnl = new JPanel();


        mainPnl.setLayout(new GridLayout());
        mainPnl.add(topPnl, BorderLayout.CENTER);
        mainPnl.add(midPnl, BorderLayout.CENTER);
        mainPnl.add(quitPnl, BorderLayout.SOUTH);

        add(mainPnl);
        createTopPnl();
        createMidPnl();
        createQuitPnl();
    }

    private void createTopPnl()
    {
        topPnl.setLayout(new GridLayout(6,1));
        topPnl.setVisible(true);
        //topPnl.setSize(new Dimension(700, 400));

        textbox1 = new JTextField();
        textbox1.setBorder(new TitledBorder(new EtchedBorder(), "Q1: Enter Customer Name"));
        topPnl.add(textbox1);

        textbox2 = new JTextField();
        textbox2.setBorder(new TitledBorder(new EtchedBorder(), "Q2: Enter Customer Street"));
        topPnl.add(textbox2);

        textbox3 = new JTextField();
        textbox3.setBorder(new TitledBorder(new EtchedBorder(), "Q3: Enter Customer City"));
        topPnl.add(textbox3);

        textbox4 = new JTextField();
        textbox4.setBorder(new TitledBorder(new EtchedBorder(), "Q4: Enter Customer State"));
        topPnl.add(textbox4);

        textbox5 = new JTextField();
        textbox5.setBorder(new TitledBorder(new EtchedBorder(), "Q5: Zip"));
        topPnl.add(textbox5);



        addressSubmit = new JButton("Submit");
        addressSubmit.addActionListener((ActionEvent ae) ->
        {
            setAddressSubmit();
        });
        topPnl.add(addressSubmit);

    }

    private void createMidPnl()
    {
        midPnl.setLayout(new GridLayout(4,1));
        midPnl.setVisible(false);

        textbox6 = new JTextField();
        textbox6.setBorder(new TitledBorder(new EtchedBorder(), "Q6: Enter Product Name"));
        midPnl.add(textbox6);

        NumberFormat doubleFormat = NumberFormat.getNumberInstance();
        doubleFormat.setMinimumFractionDigits(2);
        textbox7 = new JFormattedTextField(new DecimalFormat());
        textbox7.setBorder(new TitledBorder(new EtchedBorder(), "Q7: Enter Product Price"));
        midPnl.add(textbox7);

        textbox8 = new JFormattedTextField(new DecimalFormat());
        textbox8.setBorder(new TitledBorder(new EtchedBorder(), "Q8: Enter Product Quantity"));
        midPnl.add(textbox8);


        productSubmit = new JButton("Submit");
        productSubmit.addActionListener((ActionEvent ae) ->
        {
            setProductSubmit();
        });
        midPnl.add(productSubmit);


    }

    private void createQuitPnl()
    {
        quitBtn = new JButton("Quit");
        somethingBtn = new JButton("Create Invoice");
        quitBtn.setPreferredSize(new Dimension(150, 50));
        somethingBtn.setPreferredSize(new Dimension(150, 50));

        quitBtn.addActionListener((ActionEvent ae) ->
        {
            if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION) == 0)
            {
                System.exit(0);
            }
        });
        quitPnl.add(quitBtn);

        somethingBtn.addActionListener((ActionEvent ae) ->
        {
            createInvoice();
        });
        quitPnl.add(somethingBtn);



    }

    private void setProductSubmit()
    {

        String productName = textbox6.getText();
        double productPrice = Double.parseDouble(textbox7.getText());
        int quantity = Integer.parseInt(textbox8.getText());


        custInvoice.add(new Product(productName, productPrice), quantity);

        textbox6.setText("");
        textbox7.setText("");
        textbox8.setText("");

    }


    private void setAddressSubmit()
    {
        midPnl.setVisible(true);
        topPnl.setVisible(false);

        String cName = textbox1.getText();
        String street = textbox2.getText();
        String city = textbox3.getText();
        String state = textbox4.getText();
        String zip = textbox5.getText();





        Address custAddress = new Address(street, city, state, zip);
        Customer newCustomer = new Customer(cName, custAddress);
        custInvoice = new Invoice(newCustomer);



    }


    private void createInvoice()
    {
        System.out.println(custInvoice.format());
        midPnl.setVisible(false);
        topPnl.setVisible(true);


        textbox1.setText("");
        textbox2.setText("");
        textbox3.setText("");
        textbox4.setText("");
        textbox5.setText("");
        textbox6.setText("");
        textbox7.setText("");
        textbox8.setText("");




    }
}

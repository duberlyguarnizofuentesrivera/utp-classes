package week_eleven.javabank;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import java.util.Objects;

public class JavaBank extends JFrame {
    //no hay necesidad de hacer este objeto serializable, si no se hace "bind" con ningún objeto
    //private static final long serialVersionUID = 1L
    // Make these variables publicly available
    private String name;
    private int accountNum;
    private int balance;
    private AccountType actType = AccountType.SAVINGS;
    //Dimensiones para ordenar los elementos dentro del panel que contiene los controles
    // margen derecho, margen superior, altura y ancho standard de los elementos.
    int leftMargin = 8;
    int topMargin = 32;
    int elementHeight = 25;
    int elementWidth = 104;
    CompanyColor companyColor = new CompanyColor();
    private final Color myColor = new Color(companyColor.getR(), companyColor.getG(), companyColor.getB());

    private JTextField nameJTextField;

    private JTextField accountNumJTextField;

    private JTextField balanceJTextField;

    private JTextField depositJTextField;

    private JTextField withdrawJTextField;

    private  JTextArea displayJTextArea;


    // constants
    //Maximum Accounts that can be created
    public static final int MAX_ACCOUNTS = 10;

    // one-dimensional array to store Account names as Empty or Used
    private final String[] accountNames = new String[MAX_ACCOUNTS];

    // two-dimensional array to store Account details

    private final AbstractBankAccount[] myAccounts = new AbstractBankAccount[MAX_ACCOUNTS];

    private int noAccounts = 0;

    // constructor
    public JavaBank() {
        for (int i = 0; i < 10; i++) {
            accountNames[i] = "EMPTY";
        }
        createUserInterface();
    }//end constructor method

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();
        contentPane.setBackground(myColor);
        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up inputDetailJPanel
        // JPanel for user inputs
        JPanel inputDetailJPanel = new JPanel();
        inputDetailJPanel.setBounds(leftMargin * 2, topMargin / 2, elementWidth * 2, topMargin + elementHeight * 10);
        inputDetailJPanel.setBorder(new TitledBorder("Input Details"));
        inputDetailJPanel.setLayout(null);
        inputDetailJPanel.setBackground(myColor);

        contentPane.add(inputDetailJPanel);

        // set up NameJLabel
        // JLabel and JTextField for account name
        JLabel nameJLabel = new JLabel();
        nameJLabel.setBounds(leftMargin, topMargin, 90, 23);
        nameJLabel.setText("Name:");
        inputDetailJPanel.add(nameJLabel);

        // set up NameJTextField
        nameJTextField = new JTextField();
        nameJTextField.setBounds(leftMargin + elementWidth, topMargin, 80, 21);
        nameJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputDetailJPanel.add(nameJTextField);

        // set up AccountNumJLabel
        // JLabel and JTextField for account number
        JLabel accountNumJLabel = new JLabel();
        accountNumJLabel.setBounds(leftMargin, topMargin + elementHeight, 100, 23);
        accountNumJLabel.setText("Account Number:");
        inputDetailJPanel.add(accountNumJLabel);

        // set up AccountNumTextField
        accountNumJTextField = new JTextField();
        accountNumJTextField.setBounds(leftMargin + elementWidth, topMargin + elementHeight, 80, 21);
        accountNumJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputDetailJPanel.add(accountNumJTextField);

        JLabel accountTypeJLabel = new JLabel();
        JComboBox<AccountType> accountTypes;
        accountTypeJLabel.setBounds(leftMargin, topMargin + elementHeight * 2, 60, 23);
        accountTypeJLabel.setText("Act. Type:");
        inputDetailJPanel.add(accountTypeJLabel);
        accountTypes = new JComboBox<>();
        accountTypes.setBounds(leftMargin + elementWidth, topMargin + elementHeight * 2, 80, 21);
        accountTypes.addItem(AccountType.SAVINGS);
        accountTypes.addItem(AccountType.CREDIT);
        inputDetailJPanel.add(accountTypes);

        // set up BalanceJLabel
        // JLabel and JTextField for balance
        JLabel balanceJLabel = new JLabel();
        balanceJLabel.setBounds(leftMargin, topMargin + elementHeight * 3, 60, 23);
        balanceJLabel.setText("Balance:");
        inputDetailJPanel.add(balanceJLabel);

        // set up BalanceTextField
        balanceJTextField = new JTextField();
        balanceJTextField.setBounds(leftMargin + elementWidth, topMargin + elementHeight * 3, 80, 21);
        balanceJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputDetailJPanel.add(balanceJTextField);

        // set up DepositJLabel
        // JLabel and JTextField for withdraw
        JLabel depositJLabel = new JLabel();
        depositJLabel.setBounds(leftMargin, topMargin + elementHeight * 4, 80, 23);
        depositJLabel.setText("Deposit:");
        inputDetailJPanel.add(depositJLabel);

        // set up DepositJTextField
        depositJTextField = new JTextField();
        depositJTextField.setBounds(leftMargin + elementWidth, topMargin + elementHeight * 4, 80, 21);
        depositJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputDetailJPanel.add(depositJTextField);

        // set up WithdrawJLabel
        // JLabel and JTextField for Withdraw
        JLabel withdrawJLabel = new JLabel();
        withdrawJLabel.setBounds(leftMargin, topMargin + elementHeight * 5, 60, 23);
        withdrawJLabel.setText("Withdraw:");
        inputDetailJPanel.add(withdrawJLabel);

        // set up WithdrawJTextField
        withdrawJTextField = new JTextField();
        withdrawJTextField.setBounds(leftMargin + elementWidth, topMargin + elementHeight * 5, 80, 21);
        withdrawJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputDetailJPanel.add(withdrawJTextField);

        // set up CreateAccountButton
        // JButton to create account
        JButton createAccountJButton = new JButton();
        createAccountJButton.setBounds(leftMargin * 2, topMargin + elementHeight * 6, 80, 24);
        createAccountJButton.setText("Create");
        createAccountJButton.setBackground(Color.GREEN);
        inputDetailJPanel.add(createAccountJButton);
        // event handler called when CreateAccountJButton
// is clicked
//end method actionPerformed
        createAccountJButton.addActionListener(
                this::createAccountJButtonActionPerformed//end ActionListener
        ); // end call to addActionListener

        // set up DeleteAccountButton
        // JButton to delete account
        JButton deleteAccountJButton = new JButton();
        deleteAccountJButton.setBounds(leftMargin + elementWidth, topMargin + elementHeight * 6, 80, 24);
        deleteAccountJButton.setText("Delete");
        deleteAccountJButton.setBackground(Color.RED);
        deleteAccountJButton.setForeground(Color.WHITE);
        inputDetailJPanel.add(deleteAccountJButton);
        // anonymous inner class
// event handler called when DeleteAccountJButton is clicked
//end method actionPerformed
        deleteAccountJButton.addActionListener(
                this::deleteAccountJButtonActionPerformed//end ActionListener
        ); // end call to addActionListener

        // set up TransactionJButton
        // JButton to make transaction
        JButton transactionJButton = new JButton();
        transactionJButton.setBounds(leftMargin * 2, topMargin + elementHeight * 7, 176, 24);
        transactionJButton.setText("Make Transaction");
        inputDetailJPanel.add(transactionJButton);
        // anonymous inner class
// event handler called when TransactionJButton
// is clicked
//end method actionPerformed
        transactionJButton.addActionListener(
                event -> {
                    try {
                        transactionJButtonActionPerformed(event);
                    } catch (MyException e) {
                        System.out.println("Excepción encontrada... revisar la salida de la terminal!");
                    }
                }//end ActionListener
        ); // end call to addActionListener

        // set up DisplayJButton
        // JButton to display account
        JButton displayJButton = new JButton();
        displayJButton.setBounds(leftMargin * 2, topMargin + elementHeight * 8, 176, 24);
        displayJButton.setText("Display Accounts");
        inputDetailJPanel.add(displayJButton);
        // anonymous inner class
// event handler called when TransactionJButton
// is clicked
//end method actionPerformed
        displayJButton.addActionListener(
                this::displayJButtonActionPerformed//end ActionListener
        ); // end call to addActionListener

        // set up displayJLabel
        // JLabel and JTextArea to display account details
        JLabel displayJLabel = new JLabel();
        displayJLabel.setBounds(240, 16, 150, 23);
        displayJLabel.setText("Account Details:");
        contentPane.add(displayJLabel);

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayJTextArea);
        scrollPane.setBounds(240, 48, 402, 184);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);
        displayJTextArea.setText("Welcome to Java Bank - There are currently no Accounts created");

        // clear other JTextFields for new data
        resetFields();

        // set properties of application's window
        setTitle("Java Bank"); // set title bar string
        setSize(670, 340); // set window size
        setVisible(true); // display window

        accountTypes.addActionListener(e -> actType = (AccountType) accountTypes.getSelectedItem());

    } // end method createUserInterface

    private void displayAccountDetails(AbstractBankAccount account) {
        displayJTextArea.setText(account.toString());
    }//end method displayAccountDetails

    private void createAccountJButtonActionPerformed(ActionEvent event) {
        displayJTextArea.setText("");
        name = "";

        //Get Name from Text Field
        name = nameJTextField.getText();
        try {
            //Get Accountnum from Text Field and convert to int unless blank then set to 0
            if (Objects.equals(accountNumJTextField.getText(), "0")) {
                accountNum = 0;
            } else {
                accountNum = Integer.parseInt(accountNumJTextField.getText());
            }//endif

            //Get Balance from Text Field and convert to int unless blank then set to 0
            if (Objects.equals(balanceJTextField.getText(), "0")) {
                balance = 0;
            } else {
                balance = Integer.parseInt(balanceJTextField.getText());
            }//endif
        }//endtry
        catch (NumberFormatException | InputMismatchException e) {
            name = ("");
            JOptionPane.showMessageDialog(null, "Incorrect numeric value entered.");
        }//end catch
        catch (Exception e) {
            System.out.println(e);
        }//end catch
        finally {
            // clear the JTextFields for new data
            resetFields();
        }//end finally

        if ((noAccounts <= 9) && (!Objects.equals(name, "")) && (accountNum != 0)) {
            if (actType == AccountType.SAVINGS) {
                myAccounts[noAccounts] = new Account(name, accountNum, balance, actType);
            } else {
                //no hay instrucciones para calcular el crédito disponible por cuenta, así que se crea con
                //el primer constructor.
                myAccounts[noAccounts] = new CreditAccount(name, accountNum, balance, actType);
            }
            accountNames[noAccounts] = "USED";
            displayAccountDetails(myAccounts[noAccounts]);
            noAccounts++;
            System.out.println(noAccounts);
        } else {
            displayJTextArea.setText("Both the Name field and Account Number must be completed");
        }//endif

        if (noAccounts == 10) {
            // Once account 10 is created. All accounts full.
            displayJTextArea.setText("All Accounts Full!");
        }//endif


    }//end method CreateAccountJButtonActionPerformed

    private void deleteAccountJButtonActionPerformed(ActionEvent event) {
        displayJTextArea.setText("Oops this isn't coded in this version!");

        // Enter code to delete here

        // clear JTextFields for new data
        resetFields();
    }//end method DeleteAccountJButtonActionPerformed

    private void transactionJButtonActionPerformed(ActionEvent event) throws MyException {
        displayJTextArea.setText("");

        if (noAccounts == 0) {
            displayJTextArea.setText("No Accounts currently created");
        } else {
            try {
                // get user input
                int accountNumber = Integer.parseInt(accountNumJTextField.getText());
                int deposit = Integer.parseInt(depositJTextField.getText());
                int withdraw = Integer.parseInt(withdrawJTextField.getText());

                for (int i = 0; i < noAccounts; i++) {
                    if ((myAccounts[i].getAccountNum() == accountNumber) && (deposit > 0)) {
                        myAccounts[i].setBalance(myAccounts[i].getBalance() + deposit);
                        displayAccountDetails(myAccounts[i]);
                    }//endif

                    if ((myAccounts[i].getAccountNum() == accountNumber) && (withdraw > 0)) {
                        myAccounts[i].setBalance(myAccounts[i].getBalance() - withdraw);
                        displayAccountDetails(myAccounts[i]);
                    }
                }
            } catch (NumberFormatException | InputMismatchException e) {
                name = ("");
                JOptionPane.showMessageDialog(null, "Incorrect numeric value entered.");
            }
            catch (Exception e) {
                throw new MyException("An unhandled error occurred!!");
            }
            finally {
                resetFields();
            }
        }
    }

    private void resetFields() {
        nameJTextField.setText(" ");
        accountNumJTextField.setText("0");
        balanceJTextField.setText("0");
        depositJTextField.setText("0");
        withdrawJTextField.setText("0");
    }

    private void displayJButtonActionPerformed(ActionEvent event) {
        name = nameJTextField.getText();
        displayJTextArea.setText("");

        if (noAccounts == 0) {
            displayJTextArea.setText("No Accounts currently created");
        } else {
            for (int i = 0; i < noAccounts; i++) {
                displayJTextArea.append(myAccounts[i].toString());
            }//endfor
        }//endif

        // clear other JTextFields for new data
        resetFields();
    }//end method DisplayJButtonActionPerformed

    public static void main(String[] args) {
        // Populate arrays with the word EMPTY,
        // so we can check to see if the values are empty later
        JavaBank application = new JavaBank();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }//end method main

}//end class JavaBank

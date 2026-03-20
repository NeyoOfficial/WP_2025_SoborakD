import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JFrame
{
    private JTextField textFieldScreen = new JTextField(10);
    private JButton JButton1 = new JButton("1");
    private JButton JButton2 = new JButton("2");
    private JButton JButton3 = new JButton("3");
    private JButton JButton4 = new JButton("4");
    private JButton JButton5 = new JButton("5");
    private JButton JButton6 = new JButton("6");
    private JButton JButton7 = new JButton("7");
    private JButton JButton8 = new JButton("8");
    private JButton JButton9 = new JButton("9");
    private JButton JButton0 = new JButton("0");
    private JButton JButtonAdd = new JButton("+");
    private JButton JButtonMinus = new JButton("-");
    private JButton JButtonMultiply = new JButton("*");
    private JButton JButtonDivide = new JButton("/");
    private JButton JButtonCE = new JButton("CE");
    private JButton JButtonC = new JButton("C");
    private JButton JButtonResult = new JButton("=");
    private JButton JButtonBackspace = new JButton("<-");

    private int value1;
    private int value2;
    private String operator = "";

    public Kalkulator()
    {
        DigitListener digitListener = new DigitListener();

        JPanel panelButtons = new JPanel(new GridLayout());

        panelButtons.add(JButton7);
        JButton7.addActionListener(this);
        panelButtons.add(JButton8);
        JButton8.addActionListener(this);
        panelButtons.add(JButton9);
        JButton9.addActionListener(this);
        panelButtons.add(JButtonCE);
        panelButtons.add(digitListener);

        panelButtons.add(JButton4);
        JButton4.addActionListener(this);
        panelButtons.add(JButton5);
        JButton5.addActionListener(this);
        panelButtons.add(JButton6);
        JButton6.addActionListener(this);
        panelButtons.add(digitListener);

        panelButtons.add(JButton1);
        JButton1.addActionListener(this);
        panelButtons.add(JButton2);
        JButton2.addActionListener(this);
        panelButtons.add(JButton3);
        JButton3.addActionListener(this);

        panelButtons.add(JButtonMinus);

        panelButtons.add(new JLabel());
        panelButtons.add(JButton0);
        panelButtons.add(new JLabel());
        panelButtons.add(JButtonMultiply);

        panelButtons.add(JButtonBackspace);
        panelButtons.add(JButtonC);
        panelButtons.add(JButtonResult);
        panelButtons.add(JButtonDivide);

        JPanel panelMain = new JPanel(new BorderLayout());

        panelMain.add(BorderLayout.CENTER.panelButtons);
        panelMain.add(BorderLayout.NORTH.textFieldScreen);

        setContentPanel(panelMain);

        setSize(200, 300);
        setVisible(true);

        //Zaimplementować backspace, C i CE
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run()
            {
                new Kalkulator();
            }
        });
    }

    @Override
    public void actionPerforemed(ActionEvent e)
    {
        String value = textFieldScreen.getText();
        String digit = ((JButton) (e.getSource())).getText();
        textFieldScreen.setText(value + digit);
    }

    class DigitListener implements ActionListener
    {
        @Override
        public void actionPerforemed(ActionEvent e)
        {
            operator = ((JButton) (e.getSource())).getText();
            //textFieldScreen.setText(textFieldScreen.getText() + operator);
        }
    }
}

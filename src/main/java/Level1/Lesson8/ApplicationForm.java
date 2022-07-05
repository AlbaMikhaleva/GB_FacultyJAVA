package Level1.Lesson8;

import Level1.Lesson8.components.NumberJButton;
import Level1.Lesson8.components.OperatorJButtons;
import Level1.Lesson8.listeners.ButtonListener;
import Level1.Lesson8.listeners.ClearButtonActionListener;
import Level1.Lesson8.listeners.ExitButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;
    private final CalcEngine calcEngine;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(500, 150, 250, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        calcEngine = new CalcEngine();


        setJMenuBar(createMenu());

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");
        JMenu menuAbout = new JMenu("About");

        menuBar.add(menuFile);
        menuBar.add(new JMenuItem("Help"));
        menuBar.add(new JMenuItem("About"));


        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        menuBar.add(exitItem);

        exitItem.addActionListener(new ExitButtonListener());

        return menuBar;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

       ActionListener buttonListener = new ButtonListener(inputField);

        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(buttonListener), BorderLayout.WEST);



        return centerPanel;
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton minus = new OperatorJButtons("-");
        minus.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("-");
        });

        panel.add(minus);

        JButton plus = new OperatorJButtons("+");
        plus.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("+");
        });
        panel.add(plus);

        JButton multiply = new OperatorJButtons("*");
        multiply.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("*");
        });
        panel.add(multiply);

        JButton divide = new OperatorJButtons("/");
        divide.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("/");
        });
        panel.add(divide);



        return panel;
    }

    private void buttonOperatorHandling(String operator) {
        String inputStr = inputField.getText();

        if (String.valueOf(inputStr.charAt(inputStr.length() - 1)).matches("\\D")) {
            inputField.setText(inputStr.substring(0, inputStr.length() - 1) + operator);
            calcEngine.setOperator(operator);
            return;
        }

        Double result = calcEngine.addOperand(getLastInputNum());
        if (result != null) {
            showResult(result, operator);
        } else {
            inputField.setText(inputStr + operator);
        }

        calcEngine.setOperator(operator);
    }

    private String getLastInputNum() {
        var arr = inputField.getText().split("[^0-9\\.]");
        return arr[arr.length - 1];
    }

    private void showResult(double result) {
        showResult(result, null);
    }

    private void showResult(double result, String operator) {
        String resultStr = (result % 1 == 0) ? String.valueOf((int) result) : String.format("%.3f", result);
        if (operator != null) {
            resultStr += operator;
        }
        inputField.setText(resultStr);
    }



    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitPanel = new JPanel();

        digitPanel.setLayout( (new GridLayout(4,3)));
        for (int i = 0; i < 10 ; i++) {
            String buttonTitle = (i==9) ? "0" : String.valueOf(i+1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitPanel.add (btn);
        }

        JButton calc = new OperatorJButtons("=");
        calc.addActionListener(e -> {
            Double result = calcEngine.addOperand(getLastInputNum());
            showResult(result);
            calcEngine.reset();
        });
        digitPanel.add(calc);

    JButton clear = new OperatorJButtons("c");
        digitPanel.add(clear);
        clear.addActionListener(new ClearButtonActionListener(inputField));

        return digitPanel;
    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        inputField.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        inputField.setMargin(new Insets(8, 0, 8, 0 ));
        inputField.setBackground(new Color(255, 255, 255));

        //inputField.setText("kjjjhhkj");

        return top;
    }
}

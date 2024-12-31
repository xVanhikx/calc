import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UI implements ActionListener {

    private final JFrame frame;

    private final JPanel panel;
    private final JPanel panelSub1;
    private final JPanel panelSub2;
    private final JPanel panelSub3;
    private final JPanel panelSub4;
    private final JPanel panelSub5;
    private final JPanel panelSub6;
    private final JPanel panelSub7;
    private final JPanel panelSub8;

    private final JTextArea text;

    private final JButton but[], butAdd, butSubtract, butMultiply, butDivide, butXPowerOfY, butEqual,
        butCancel, butSquare, butRootSquare, butOneDivide, butCos, butSin, butTan, butLog, butLn,
            butPercent, butAbs, butBinary;
    private final Calculator calc;
    
    private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    
    private final Font font;
    private final Font textFont;

    private Calculator.TwoNumMode pendingPercentOperation = Calculator.TwoNumMode.normal;
    private Double operand1 = null;

    public UI() throws IOException {
        frame = new JFrame("Calculator");
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelSub1 = new JPanel(new FlowLayout());
        panelSub2 = new JPanel(new FlowLayout());
        panelSub3 = new JPanel(new FlowLayout());
        panelSub4 = new JPanel(new FlowLayout());
        panelSub5 = new JPanel(new FlowLayout());
        panelSub6 = new JPanel(new FlowLayout());
        panelSub7 = new JPanel(new FlowLayout());
        panelSub8 = new JPanel(new FlowLayout());
        
        font = new Font("Times New Roman", Font.PLAIN, 18);
        
        text = new JTextArea(1, 10);
        
        textFont = new Font("Times New Roman", Font.BOLD, 24);
        
        but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }
        butAdd = new JButton("+");
        butSubtract = new JButton("-");
        butMultiply = new JButton("*");
        butDivide = new JButton("/");
        butEqual = new JButton("=");
        butRootSquare = new JButton("sqrt");
        butSquare = new JButton("x^2");
        butOneDivide = new JButton("1/x");
        butCos = new JButton("cos");
        butSin = new JButton("sin");
        butTan = new JButton("tan");
        butLn = new JButton("ln");
        butLog = new JButton("log(x)");
        butPercent = new JButton("%");
        butXPowerOfY = new JButton("x^y");
        butAbs = new JButton("|x|");
        butCancel = new JButton("C");
        butBinary = new JButton("bin");
        
        calc = new Calculator();
    }
    
    public void init() {
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        text.setFont(textFont);
        text.setEditable(false);
        
        for (int i = 0; i < 10; i++) {
            but[i].setFont(font);
        }
        butAdd.setFont(font);
        butSubtract.setFont(font);
        butMultiply.setFont(font);
        butDivide.setFont(font);
        butEqual.setFont(font);
        butSquare.setFont(font);
        butRootSquare.setFont(font);
        butOneDivide.setFont(font);
        butCos.setFont(font);
        butSin.setFont(font);
        butTan.setFont(font);
        butLog.setFont(font);
        butLn.setFont(font);
        butXPowerOfY.setFont(font);
        butPercent.setFont(font);
        butAbs.setFont(font);
        butCancel.setFont(font);
        butBinary.setFont(font);
        
        panel.add(Box.createHorizontalStrut(100));
        panelSub1.add(text);
        panel.add(panelSub1);
        
        panelSub2.add(but[1]);
        panelSub2.add(but[2]);
        panelSub2.add(but[3]);
        panelSub2.add(Box.createHorizontalStrut(15));
        panelSub2.add(butAdd);
        panelSub2.add(butSubtract);
        panel.add(panelSub2);
        
        panelSub3.add(but[4]);
        panelSub3.add(but[5]);
        panelSub3.add(but[6]);
        panelSub3.add(Box.createHorizontalStrut(15));
        panelSub3.add(butMultiply);
        panelSub3.add(butDivide);
        panel.add(panelSub3);
        
        panelSub4.add(but[7]);
        panelSub4.add(but[8]);
        panelSub4.add(but[9]);
        panelSub4.add(Box.createHorizontalStrut(15));
        panelSub4.add(butEqual);
        panelSub4.add(butCancel);
        panel.add(panelSub4);
        
        panelSub5.add(Box.createHorizontalStrut(92));
        panelSub5.add(but[0]);
        panelSub5.add(Box.createHorizontalStrut(210));
        panel.add(panelSub5);
        
        panelSub6.add(butSquare);
        panelSub6.add(butRootSquare);
        panelSub6.add(butOneDivide);
        panelSub6.add(butXPowerOfY);
        panel.add(panelSub6);

        panelSub5.add(butLn);
        panelSub7.add(butCos);
        panelSub7.add(butSin);
        panelSub7.add(butTan);
        panel.add(panelSub7);
        
        panelSub8.add(butLog);
        panelSub8.add(butPercent);
        panelSub8.add(butAbs);
        panelSub8.add(butBinary);
        panel.add(panelSub8);
        
        for (int i = 0; i < 10; i++) {
            but[i].addActionListener(this);
        }
        butAdd.addActionListener(this);
        butSubtract.addActionListener(this);
        butMultiply.addActionListener(this);
        butDivide.addActionListener(this);
        butSquare.addActionListener(this);
        butRootSquare.addActionListener(this);
        butOneDivide.addActionListener(this);
        butCos.addActionListener(this);
        butSin.addActionListener(this);
        butTan.addActionListener(this);
        butLn.addActionListener(this);
        butLog.addActionListener(this);
        butXPowerOfY.addActionListener(this);
        butPercent.addActionListener(this);
        butAbs.addActionListener(this);
        butBinary.addActionListener(this);
        butCancel.addActionListener(this);
        butEqual.addActionListener(this);
        
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        Double checkNum = null;
        
        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }
        
        
        try {
            checkNum = Double.parseDouble(text.getText());
        } catch (NumberFormatException ex) {
            ex.getMessage();
        }
        
        if (checkNum != null || source == butCancel) {
            if (source == butAdd) {
                pendingPercentOperation = Calculator.TwoNumMode.addPercent;
                writer(calc.calculateTwo(Calculator.TwoNumMode.add, reader()));
                text.replaceSelection(butAdd.getText());
            } else if (source == butSubtract) {
                pendingPercentOperation = Calculator.TwoNumMode.subtractPercent;
                writer(calc.calculateTwo(Calculator.TwoNumMode.subtract, reader()));
                text.replaceSelection(butSubtract.getText());
            } else if (source == butMultiply) {
                pendingPercentOperation = Calculator.TwoNumMode.multiplyPercent;
                writer(calc.calculateTwo(Calculator.TwoNumMode.multiply, reader()));
                text.replaceSelection(butMultiply.getText());
            } else if (source == butDivide) {
                pendingPercentOperation = Calculator.TwoNumMode.dividePercent;
                writer(calc.calculateTwo(Calculator.TwoNumMode.divide, reader()));
                text.replaceSelection(butDivide.getText());
            } else if (source == butXPowerOfY) {
                writer(calc.calculateTwo(Calculator.TwoNumMode.xPowerOfY, reader()));
                text.replaceSelection(butXPowerOfY.getText());
            } else if (source == butSquare) {
                writer(calc.calculateOne(Calculator.OneNumMode.square, reader()));
            } else if (source == butRootSquare) {
                writer(calc.calculateOne(Calculator.OneNumMode.rootSquare, reader()));
            } else if (source == butOneDivide) {
                writer(calc.calculateOne(Calculator.OneNumMode.oneDivided, reader()));
            } else if (source == butCos) {
                writer(calc.calculateOne(Calculator.OneNumMode.cos, reader()));
            } else if (source == butSin) {
                writer(calc.calculateOne(Calculator.OneNumMode.sin, reader()));
            } else if (source == butTan) {
                writer(calc.calculateOne(Calculator.OneNumMode.tan, reader()));
            } else if (source == butLog) {
                 writer(calc.calculateOne(Calculator.OneNumMode.log, reader()));
            } else if (source == butLn) {
                writer(calc.calculateOne(Calculator.OneNumMode.ln, reader()));
            } else if (source == butPercent) {
                if (pendingPercentOperation != Calculator.TwoNumMode.normal) {
                    writer(calc.calculateEqual(reader()));
                    pendingPercentOperation = Calculator.TwoNumMode.normal;
                } else {
                    writer(calc.calculateOne(Calculator.OneNumMode.rate, reader()));
                }
            } else if (source == butAbs) {
                writer(calc.calculateOne(Calculator.OneNumMode.abs, reader()));
            } else if (source == butEqual) {
                writer(calc.calculateEqual(reader()));
            } else if (source == butCancel) {
                writer(calc.reset());
            } else if (source == butBinary) {
                parseToBinary();
            }
        }
        text.selectAll();
    }

    private void parseToBinary() {
        try {
            text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
        } catch (NumberFormatException exception) {
            System.err.println("Ошибка при переводе в двоичную систему счисления" + exception.toString());
        }
    }

    public Double reader() {
        Double num;
        String str;
        str = text.getText();
        num = Double.valueOf(str);
        
        return num;
    }
    
    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
}

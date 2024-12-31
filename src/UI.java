import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static java.lang.Double.NaN;

public class UI implements ActionListener, KeyListener {

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
    private Double result = null;
    private Calculator.TwoNumMode pendingOperation = Calculator.TwoNumMode.normal;
    private boolean percentMode = false;
    private Double lastInput = null;
    private boolean afterEqual = false;

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
        text.addKeyListener(this);
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

        panelSub7.add(butPercent);
        panelSub7.add(butCos);
        panelSub7.add(butSin);
        panelSub7.add(butTan);
        panel.add(panelSub7);
        
        panelSub8.add(butLog);
        panelSub8.add(butLn);
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
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isDigit(c)) {
            if (afterEqual) {
                text.setText("");
                afterEqual = false;
                result = null;
                pendingOperation = Calculator.TwoNumMode.normal;
            }
            if(pendingOperation != Calculator.TwoNumMode.normal && lastInput != null) { //КЛЮЧЕВОЕ ИЗМЕНЕНИЕ
                text.setText("");
            }
            text.replaceSelection(String.valueOf(c));
            lastInput = reader();
        } else if (c == '\b') {
            handleCancel();
        } else if (c == '\n') {
            try {
                double currentNum = reader();
                handleEqual(currentNum);
            } catch (NumberFormatException ex) {

            }
        } else if (c == '+' || c == '-' || c == '*' || c == '/') { // Обработка операций
            try {
                double currentNum = reader();
                switch (c) {
                    case '+':
                        handleTwoOperandOperation(Calculator.TwoNumMode.add, currentNum);
                        break;
                    case '-':
                        handleTwoOperandOperation(Calculator.TwoNumMode.subtract, currentNum);
                        break;
                    case '*':
                        handleTwoOperandOperation(Calculator.TwoNumMode.multiply, currentNum);
                        break;
                    case '/':
                        handleTwoOperandOperation(Calculator.TwoNumMode.divide, currentNum);
                        break;
                }
            } catch (NumberFormatException ex) {
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        Double currentNum = null;
        
        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                if (afterEqual) {
                    text.setText("");
                    afterEqual = false;
                    result = null;
                    pendingOperation = Calculator.TwoNumMode.normal;
                }
                text.replaceSelection(buttonValue[i]);
                lastInput = reader();
                return;
            }
        }
        
        
        try {
            currentNum = Double.parseDouble(text.getText());
        } catch (NumberFormatException ex) {
            ex.getMessage();
        }

        if (source == butAdd || source == butSubtract || source == butMultiply ||
                source == butDivide || source == butXPowerOfY) {
            handleTwoOperandOperation(getOperationMode(source), currentNum);
            afterEqual = false;
        } else if (source == butPercent) {
            handlePercent(currentNum);
            afterEqual = false;
        } else if (source == butEqual) {
            handleEqual(currentNum);
        } else if (source == butSquare || source == butRootSquare || source == butOneDivide ||
                source == butCos || source == butSin || source == butTan || source == butLog ||
                source == butLn || source == butAbs) {
            handleOneOperandOperation(getOneOperandMode(source), currentNum);
            afterEqual = false;
        } else if (source == butCancel) {
            handleCancel();
            afterEqual = false;
        } else if (source == butBinary) {
            parseToBinary();
            afterEqual = false;
        }
        text.selectAll();
    }

    private void handleTwoOperandOperation(Calculator.TwoNumMode operation, Double currentNum) {
        if (result == null && !currentNum.isNaN()) {
            result = currentNum;
            pendingOperation = operation;
            text.setText("");
        } else {
            if (percentMode) {
                currentNum = result * currentNum / 100;
                percentMode = false;
            }
            double tempResult = calc.calculateTwo(pendingOperation, result, currentNum);
            writer(result);
            if (!Double.isNaN(tempResult)) {
                result = tempResult;
            }
        }
        pendingOperation = operation;
        text.setText(result.toString()); // *КЛЮЧЕВОЕ ИЗМЕНЕНИЕ*
    }

    private void handleEqual(Double currentNum) {
        if (pendingOperation != Calculator.TwoNumMode.normal) {
            if (result == null) {
                result = lastInput;
            }
            if (percentMode) {
                currentNum = result * currentNum / 100;
                percentMode = false;
            }
            double tempResult = calc.calculateTwo(pendingOperation, result, currentNum);
            writer(tempResult);
            if (!Double.isNaN(tempResult)) {
                result = tempResult;
            }
            pendingOperation = Calculator.TwoNumMode.normal;
        } else if (lastInput != null && result != null && afterEqual) {
            double tempResult = calc.calculateTwo(pendingOperation, result, lastInput);
            writer(tempResult);
            if (!Double.isNaN(tempResult)) {
                result = tempResult;
            }
        } else if (lastInput != null) {
            writer(lastInput);
            result = lastInput;
        } else if (result != null) {
            writer(result);
        } else {
            writer(0.0);
            result = 0.0;
        }
        afterEqual = true;
    }

    private void parseToBinary() {
        try {
            text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
        } catch (NumberFormatException exception) {
            System.err.println("Ошибка при переводе в двоичную систему счисления" + exception.toString());
        }
    }

    private Calculator.TwoNumMode getOperationMode(Object source) {
        if (source == butAdd) return Calculator.TwoNumMode.add;
        if (source == butSubtract) return Calculator.TwoNumMode.subtract;
        if (source == butMultiply) return Calculator.TwoNumMode.multiply;
        if (source == butDivide) return Calculator.TwoNumMode.divide;
        if (source == butXPowerOfY) return Calculator.TwoNumMode.xPowerOfY;
        return Calculator.TwoNumMode.normal;
    }

    private Calculator.OneNumMode getOneOperandMode(Object source) {
        if (source == butSquare) return Calculator.OneNumMode.square;
        if (source == butRootSquare) return Calculator.OneNumMode.rootSquare;
        if (source == butOneDivide) return Calculator.OneNumMode.oneDivided;
        if (source == butCos) return Calculator.OneNumMode.cos;
        if (source == butSin) return Calculator.OneNumMode.sin;
        if (source == butTan) return Calculator.OneNumMode.tan;
        if (source == butLog) return Calculator.OneNumMode.log;
        if (source == butLn) return Calculator.OneNumMode.ln;
        if (source == butAbs) return Calculator.OneNumMode.abs;
        return null;
    }

    private void handleOneOperandOperation(Calculator.OneNumMode operation, Double currentNum) {
        if (!Double.isNaN(currentNum)) {
            writer(calc.calculateOne(operation, currentNum));
        }
    }

    private void handlePercent(Double currentNum) {
        if (result != null) {
            percentMode = true;
        } else {
            writer(calc.calculateOne(Calculator.OneNumMode.rate, currentNum));
        }
    }

    private void handleCancel() {
        writer(calc.reset());
        pendingOperation = Calculator.TwoNumMode.normal;
        result = null;
        percentMode = false;
        text.setText("");
    }

    public Double reader() {
        Double num;
        String str;
        str = text.getText();
        num = Double.valueOf(str);
        
        return num;
    }
    
    public void writer(Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

class Translator_App implements ActionListener  
{
    //Declaring Objects
    String language;
    JFrame f=new JFrame();
    JLabel label = new JLabel();

    JButton b1=new JButton("Go");
    Translator_App()
    {
        f.getContentPane().setLayout(null);
        label.setBounds(247, 5, 0, 0);
        f.getContentPane().add(label);

        Label label_1 = new Label("Welcome to Java Translator");
        label_1.setAlignment(Label.CENTER);
        label_1.setFont(new Font("Dialog", Font.BOLD, 25));
        label_1.setBackground(new Color(255, 165, 0));
        label_1.setForeground(new Color(0, 0, 0));
        label_1.setBounds(118, 31, 344, 89);
        f.getContentPane().add(label_1);

        Label label_2 = new Label("Choose translated language ");
        label_2.setFont(new Font("Dialog", Font.BOLD, 14));
        label_2.setForeground(new Color(0, 0, 0));
        label_2.setBounds(333, 161, 210, 24);
        f.getContentPane().add(label_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setEditable(true);
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.addItem("French");
        comboBox.addItem("Dutch");
        comboBox.addItem("Spanish");
        comboBox.setSelectedItem(null);
        comboBox.setBounds(333, 191, 196, 24);
        f.getContentPane().add(comboBox);

        TextArea value_1 = new TextArea();
        value_1.setFont(new Font("Dialog", Font.PLAIN, 14));
        value_1.setText("Enter Text");
        value_1.setBackground(new Color(255, 140, 0));
        value_1.setForeground(new Color(220, 220, 220));
        value_1.setBounds(51, 221, 196, 96);
        f.getContentPane().add(value_1);

        value_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent arg0) {
                    value_1.setCaretPosition(0);
                }
            });
            
        value_1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent arg0) {
                    if (value_1.getForeground()!=Color.BLACK)
                    {
                        if(value_1.getText().equals("Enter Text"))
                        {
                            value_1.setText("");
                        }

                    }
                    value_1.setForeground(Color.BLACK);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if(value_1.getText().isEmpty()==true)
                    {
                        value_1.setText("Enter Text");
                        value_1.setCaretPosition(0);
                        value_1.setForeground(new java.awt.Color(220,220,220));
                    }
                }
            });

        TextArea textField = new TextArea();
        textField.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField.setBackground(new Color(255, 140, 0));
        textField.setForeground(new Color(0, 0, 0));
        textField.setBounds(333, 221, 196, 96);

        Label label_3 = new Label("English");
        label_3.setBackground(new Color(255, 255, 255));
        label_3.setFont(new Font("Dialog", Font.BOLD, 15));
        label_3.setForeground(new Color(0, 0, 0));
        label_3.setBounds(51, 191, 196, 24);
        f.getContentPane().add(label_3);

        b1.setBounds(450,100,100,20);

        b1.addActionListener(this);
        f.getContentPane().setForeground(Color.LIGHT_GRAY);
        f.getContentPane().setBackground(new Color(255, 165, 0));

        JButton btnTranslate = new JButton("Translate");
        btnTranslate.setBackground(new Color(255, 140, 0));
        btnTranslate.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnTranslate.setForeground(new Color(0, 0, 0));
        btnTranslate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    try
                    {
                        language = (String) comboBox.getSelectedItem();
                        if (language.equals(""))
                        {
                            JOptionPane.showMessageDialog(null,"Please select language");
                        }
                    }
                    catch(Exception e1)
                    {
                        JOptionPane.showMessageDialog(null,"Please select language");
                    }
                    
                    try
                    {
                        Translator translatorObj = new Translator();
                        //CSVReader CSVReaderObj =new CSVReader();
                        //CSVReaderObj.FilePath(language);
                        //translatorObj.setFilePath(language);
                        String s = translatorObj.input(value_1.getText(),language);
                        textField.setText(s);

                    }
                    catch(Exception e1)
                    {
                        //JOptionPane.showMessageDialog(null, "Please enter value");
                    }
                }
            });
        btnTranslate.setBounds(210, 401, 163, 68);
        f.getContentPane().add(btnTranslate);

        JButton button = new JButton("?");
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "The need for translation has existed since time immemorial \nand translating important literary works from one language \ninto others has contributed significantly to the development \nof world culture. The history of translation is related to the \nhistory of the often invisible cross cultural interactions of \nthe world. Thus translators have made important \ncontribution over the centuries in dissemination of ideas \nand information to a larger audience, in shaping of cultures \nand in a sense helped unite the world.");
                }
            });
        
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Tahoma", Font.BOLD, 13));
        button.setBackground(new Color(255, 140, 0));
        button.setBounds(514, 41, 41, 24);
        f.getContentPane().add(button);

        f.getContentPane().add(textField);
        
        f.setVisible(true);
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        f.setJMenuBar(menuBar);

        JMenu file = new JMenu("file");
        file.setFont(new Font("Segoe UI", Font.BOLD, 16));
        file.setBackground(Color.BLACK);
        menuBar.add(file);

        JMenuItem instructions = new JMenuItem("instructions");
        instructions.setFont(new Font("Segoe UI", Font.BOLD, 15));
        instructions.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog(null,"Hello dear user, the following are the instructions to use the translator we have developed... \n \n********************* \n\n"
                        +"Step 1: Select 'Enter text' in the text field below 'English' \n\n"
                        +"Step 2: Type the text u want to translate in the text field below 'English' \n\n"
                        +"Step 3: Select the language u want to translate into \n\n"
                        +"Step 4: Click on the 'Translate button' \n\n"
                        +"Step 5: Read the translated text and do whatever u want to do with it\n\n"
                        +"Step 6: Thank god that the translator works..... \n\n THE END \n\n *********************");
                }
            });
        file.add(instructions);

        JMenuItem about_us = new JMenuItem("about_us");
        about_us.setFont(new Font("Segoe UI", Font.BOLD, 15));
        about_us.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    JOptionPane.showMessageDialog(null," Hmmm....So you want to about us,who developed the translator huh?.... \n\n"
                        +"Well........\n\n"
                        +"We, who have developed this translator are a group of three members \n"
                        +"who are Mihir, Karthik and Dhina who are diligent students of Cambridge Public School....\n being java addicts, we have always longed to develop such an awesome software and we truly hope to \n"
                        +"do so in the future too....");
                }
            });
        file.add(about_us);

        JMenuItem exit = new JMenuItem("exit");
        exit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        file.add(exit);
    }

    public void actionPerformed(ActionEvent e)
    {
        //Translator ob =new Translator(); 

        //t2.setText(String.valueOf(ob.input(s)));
        //if(e.getSource()==b8)
        //{
        //    System.exit(0);
        //}
        
        // I DONT KNOW WHY DO I NEED THIS FUNCTION
    }
    
    
    public static void main(String...s)
    {
        new Translator_App();
    }
}
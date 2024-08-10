import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem INew, IOpen, ISave, ISaveAs, IExit;

    Function_File file = new Function_File(this);
    public static void main(String[] args) {

        new GUI();

    }
    public GUI() {

        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();

        window.setVisible(true);

    }
    public void createWindow() {

        window = new JFrame("NotePad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void createTextArea() {
        
        textArea = new JTextArea();

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }
    public void createFileMenu() {

        INew = new JMenuItem("New");
        INew.addActionListener(this);
        INew.setActionCommand("New");
        menuFile.add(INew);

        IOpen = new JMenuItem("Open");
        IOpen.addActionListener(this);
        IOpen.setActionCommand("Open");
        menuFile.add(IOpen);

        ISave = new JMenuItem("Save");
        ISave.addActionListener(this);
        ISave.setActionCommand("Save");
        menuFile.add(ISave);

        ISaveAs = new JMenuItem("Save As");
        ISaveAs.addActionListener(this);
        ISaveAs.setActionCommand("Save As");
        menuFile.add(ISaveAs);

        IExit = new JMenuItem("Exit");
        IExit.addActionListener(this);
        IExit.setActionCommand("Exit");
        menuFile.add(IExit);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch(command) {
        case "New": file.newFile(); break;
        case "Open": file.openFile(); break;
        case "Save As": file.saveAs(); break;
        case "Save": file.save(); break;
        case "Exit": file.exit(); break;



        }
    }
}

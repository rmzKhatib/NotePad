import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {

    JFrame window;

    // TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    // TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // FILE MENU
    JMenuItem INew, IOpen, ISave, ISaveAs, IExit;
    // FORMAT MENU
    JMenuItem IWrap, IFontArial, IFontCSMS, IFontTMR, IFontBroadway, IFontBS7, IFontBOS, IFontBMT, IFontSize4, IFontSize8, IFontSize12, IFontSize16, IFontSize20, IFontSize24, IFontSize28, IFontSize100;
    JMenu menuFont, menuFontSize;
    // COLOR MENU
    JMenuItem IColor1, IColor2, IColor3, IColor4, IColor5;
    // EDIT MENU
    JMenuItem IUndo, IRedo;

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);

    UndoManager um = new UndoManager();

    public static void main(String[] args) {

        new GUI();

    }
    public GUI() {

        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();

        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();
        color.changeColor("White");
        window.setVisible(true);

    }
    public void createWindow() {

        window = new JFrame("NotePad");
        window.setSize(400,650);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void createTextArea() {
        
        textArea = new JTextArea();

        textArea.getDocument().addUndoableEditListener(

            new UndoableEditListener() {
                public void undoableEditHappened(UndoableEditEvent e) {
                    um.addEdit(e.getEdit());
                }
                
            });

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
    public void createFormatMenu() {

        IWrap = new JMenuItem("Word Wrap: Off");
        IWrap.addActionListener(this);
        IWrap.setActionCommand("Word Wrap");
        menuFormat.add(IWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        IFontArial = new JMenuItem("Arial");
        IFontArial.addActionListener(this);
        IFontArial.setActionCommand("Arial");
        menuFont.add(IFontArial);

        IFontCSMS = new JMenuItem("Comic Sans MS");
        IFontCSMS.addActionListener(this);
        IFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(IFontCSMS);

        IFontTMR = new JMenuItem("Times New Roman");
        IFontTMR.addActionListener(this);
        IFontTMR.setActionCommand("Times New Roman");
        menuFont.add(IFontTMR);

        IFontBroadway = new JMenuItem("Broadway");
        IFontBroadway.addActionListener(this);
        IFontBroadway.setActionCommand("Broadway");
        menuFont.add(IFontBroadway);

        IFontBS7 = new JMenuItem("Bookshelf Symbol 7");
        IFontBS7.addActionListener(this);
        IFontBS7.setActionCommand("Bookshelf Symbol 7");
        menuFont.add(IFontBS7);

        IFontBOS = new JMenuItem("Bookman Old Style");
        IFontBOS.addActionListener(this);
        IFontBOS.setActionCommand("Bookman Old Style");
        menuFont.add(IFontBOS);

        IFontBMT = new JMenuItem("Bell MT");
        IFontBMT.addActionListener(this);
        IFontBMT.setActionCommand("Bell MT");
        menuFont.add(IFontBMT);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        IFontSize4 = new JMenuItem("4");
        IFontSize4.addActionListener(this);
        IFontSize4.setActionCommand("size4");
        menuFontSize.add(IFontSize4);

        IFontSize8 = new JMenuItem("8");
        IFontSize8.addActionListener(this);
        IFontSize8.setActionCommand("size8");
        menuFontSize.add(IFontSize8);

        IFontSize12 = new JMenuItem("12");
        IFontSize12.addActionListener(this);
        IFontSize12.setActionCommand("size12");
        menuFontSize.add(IFontSize12);

        IFontSize16 = new JMenuItem("16");
        IFontSize16.addActionListener(this);
        IFontSize16.setActionCommand("size16");
        menuFontSize.add(IFontSize16);

        IFontSize20 = new JMenuItem("20");
        IFontSize20.addActionListener(this);
        IFontSize20.setActionCommand("size20");
        menuFontSize.add(IFontSize20);

        IFontSize24 = new JMenuItem("24");
        IFontSize24.addActionListener(this);
        IFontSize24.setActionCommand("size24");
        menuFontSize.add(IFontSize24);

        IFontSize28 = new JMenuItem("28");
        IFontSize28.addActionListener(this);
        IFontSize28.setActionCommand("size28");
        menuFontSize.add(IFontSize28);

        IFontSize100 = new JMenuItem("100");
        IFontSize100.addActionListener(this);
        IFontSize100.setActionCommand("size100");
        menuFontSize.add(IFontSize100);

    }
    public void createColorMenu() {

        IColor1 = new JMenuItem("White");
        IColor1.addActionListener(this);
        IColor1.setActionCommand("White");
        menuColor.add(IColor1);

        IColor2 = new JMenuItem("Black");
        IColor2.addActionListener(this);
        IColor2.setActionCommand("Black");
        menuColor.add(IColor2);

        IColor3 = new JMenuItem("Gray");
        IColor3.addActionListener(this);
        IColor3.setActionCommand("Gray");
        menuColor.add(IColor3);

        IColor4 = new JMenuItem("Blue");
        IColor4.addActionListener(this);
        IColor4.setActionCommand("Blue");
        menuColor.add(IColor4);

        IColor5 = new JMenuItem("Red");
        IColor5.addActionListener(this);
        IColor5.setActionCommand("Red");
        menuColor.add(IColor5);

    }
    public void createEditMenu() {

        IUndo = new JMenuItem("Undo");
        IUndo.addActionListener(this);
        IUndo.setActionCommand("Undo");
        menuEdit.add(IUndo);

        IRedo = new JMenuItem("Redo");
        IRedo.addActionListener(this);
        IRedo.setActionCommand("Redo");
        menuEdit.add(IRedo);

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
        case "Undo": edit.undo(); break;
        case "Redo": edit.redo(); break;
        case "Word Wrap": format.wordWrap(); break;
        case "Arial": format.setFont(command); break;
        case "Comic Sans MS": format.setFont(command); break;
        case "Times New Roman": format.setFont(command); break;
        case "Broadway": format.setFont(command); break;
        case "Bookshelf Symbol 7": format.setFont(command); break;
        case "Bookman Old Style": format.setFont(command); break;
        case "Bell MT": format.setFont(command); break;
        case "size4": format.createFont(4); break;
        case "size8": format.createFont(8); break;
        case "size12": format.createFont(12); break;
        case "size16": format.createFont(16); break;
        case "size20": format.createFont(20); break;
        case "size24": format.createFont(24); break;
        case "size28": format.createFont(28); break;
        case "size100": format.createFont(100); break;
        case "White": color.changeColor(command); break;
        case "Black": color.changeColor(command); break;
        case "Gray": color.changeColor(command); break;
        case "Blue": color.changeColor(command); break;
        case "Red": color.changeColor(command); break;

        }
    }
}

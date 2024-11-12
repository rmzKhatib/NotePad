import java.awt.Font;

public class Function_Format {

    GUI gui;
    Font arial, comicSansMS, timesNewRoman, broadway, bookshelfSymbol7, bookmanOldStyle, bellMT;
    String selectedFont;

    public Function_Format(GUI gui) {

        this.gui = gui;
    }
    public void wordWrap() {

        if(gui.wordWrapOn == false) {

            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.IWrap.setText("Word Wrap: On");

        }
        else if(gui.wordWrapOn == true) {

            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.IWrap.setText("Word Wrap: Off");

        }
    }
    public void createFont(int fontSize) { 

        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        broadway = new Font("Broadway", Font.PLAIN, fontSize);
        bookshelfSymbol7 = new Font("Bookshelf Symbol 7", Font.PLAIN, fontSize);
        bookmanOldStyle = new Font("Bookman Old Style", Font.PLAIN, fontSize);
        bellMT = new Font("Bell MT", Font.PLAIN, fontSize);

        setFont(selectedFont);

    }
    public void setFont(String font) {

        selectedFont = font;

        switch(selectedFont) {
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
            case "Broadway":
                gui.textArea.setFont(broadway);
                break;
            case "Bookshelf Symbol 7":
                gui.textArea.setFont(bookshelfSymbol7);
                break;
            case "Bookman Old Style":
                gui.textArea.setFont(bookmanOldStyle);
                break;
            case "Bell MT":
                gui.textArea.setFont(bellMT);
                break;
            
        }

    }
}


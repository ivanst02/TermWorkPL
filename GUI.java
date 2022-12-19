import java.awt.*;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame {
    public static int obj;
    public static Color workColor;
    GUI() {
        setTitle("Menu");
        setSize(700, 100);
        setVisible(true);

        MenuBar mb = new MenuBar();
        Menu menuItem = new Menu("Item");
        MenuItem itemRect = new MenuItem("Rectangle");
        MenuItem itemLine = new MenuItem("Line");
        MenuItem itemFill = new MenuItem("Filled Rectangle");
        menuItem.add(itemLine); menuItem.add(itemRect); menuItem.add(itemFill);
        Menu menuColor = new Menu("Color");
        MenuItem itemBlue = new MenuItem("Blue");
        MenuItem itemRed = new MenuItem("Red");
        menuColor.add(itemBlue); menuColor.add(itemRed);
        mb.add(menuColor); mb.add(menuItem);
        setMenuBar(mb);

        itemRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj = 2;
            }
        });
        itemLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj = 1;
            }
        });
        itemFill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj = 3;
            }
        });
        itemBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workColor = Color.BLUE;
            }
        });
        itemRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workColor = Color.RED;
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    public static Color getWorkColor(){
        return workColor;
    }
    public static int getObj(){
        return obj;
    }
}

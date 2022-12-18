import java.awt.*;
import java.awt.event.*;

public class GUI extends Frame {
    int objChoice = 0;
    Color workColor = null;
    boolean filled = false;
    Point startPoint = null;
    Point endPoint = null;
    Frame canvas = new Frame();
    Frame menu = new Frame();
    Label objLab = new Label("Object:");
    Label colorLab = new Label("Select color:");
    CheckboxGroup objGroup = new CheckboxGroup();
    Checkbox rectCB = new Checkbox("Rectangle", objGroup, false);
    Checkbox lineCB = new Checkbox("Line", objGroup, false);
    CheckboxGroup colorGroup = new CheckboxGroup();
    Checkbox blueCB = new Checkbox("Blue", colorGroup, false);
    Checkbox redCB = new Checkbox("Red", colorGroup, false);
    Checkbox fillCB = new Checkbox("Fill", false);
    public void makeFrames() {
        //Потребителският интерфейс и самите графични примитиви да сa разположени в два отделни прозореца
        // Canvas & Menu
        canvas.setSize(700, 450);
        canvas.setLayout(null);
        canvas.setTitle("Canvas");
        canvas.setVisible(true);
        menu.setSize(200, 450);
        menu.setLayout(null);
        menu.setTitle("Menu");
        menu.setVisible(true);

        //Изборът на примитив, който ще се въвежда, да става чрез меню
        objLab.setBounds(10, 0, 90, 75);
        colorLab.setBounds(10, 225, 90, 75);
        lineCB.setBounds(10, 75, 90, 75);
        rectCB.setBounds(10, 150, 90, 75);
        blueCB.setBounds(10, 300, 90, 75);
        redCB.setBounds(10, 375, 90, 75);
        fillCB.setBounds(110, 150, 90, 75);
        menu.add(objLab); menu.add(colorLab); menu.add(lineCB);
        menu.add(rectCB); menu.add(redCB); menu.add(blueCB); menu.add(fillCB);
    }

    GUI() {
        ItemListener objListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (lineCB.getState()) {
                    objChoice = 1;
                    System.out.println("obj 1");
                }
                else if (rectCB.getState()) {
                    objChoice = 2;
                    System.out.println("obj 2");
                }
            }
        };
        ItemListener colorListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(redCB.getState()) {
                    workColor = Color.RED;
                    System.out.println(workColor);
                }
                else if (blueCB.getState()) {
                    workColor = Color.BLUE;
                    System.out.println(workColor);
                }

            }
        };
        ItemListener checkFilled = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                filled = fillCB.getState();
                System.out.println("filled changed");
            }
        };
        redCB.addItemListener(colorListener);
        blueCB.addItemListener(colorListener);
        lineCB.addItemListener(objListener);
        rectCB.addItemListener(objListener);
        fillCB.addItemListener(checkFilled);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                System.out.println("mouse pressed" + startPoint);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                startPoint = null;
                System.out.println("mouse released");
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                endPoint = e.getPoint();
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                canvas.repaint();
            }
        });

        canvas.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                canvas.dispose();
                menu.dispose();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("asd");
        if (startPoint != null) {
            g.setColor(Color.RED);
            g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }

    public Point getStartPoint() {
        return startPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public Color getWorkColor() {
        return workColor;
    }
}

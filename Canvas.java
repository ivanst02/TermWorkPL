import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Canvas extends Frame {
    int j = 0;
    static Point startPoint, endPoint;
    GPrimitive[] objArr = new GPrimitive[100];
    int obj = 0;
    Canvas() {
        new GUI();
        setTitle("Canvas");
        setSize(700, 450);
        setLayout(null);
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                endPoint = e.getPoint();
                obj = GUI.getObj();
                if(obj == 1) {
                    objArr[j] = new GLine();
                    j++;
                    repaint();
                } else if (obj == 2) {
                    objArr[j] = new GRect();
                    j++;
                    repaint();
                } else if (obj == 3) {
                    objArr[j] = new GFilled();
                    j++;
                    repaint();
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void paint(Graphics g) {
        for(int i = 0; i < j; i++) {
            objArr[i].drawPrimitive(g);
        }
    }

    public static Point getEndPoint() {
        return endPoint;
    }

    public static Point getStartPoint() {
        return startPoint;
    }
}

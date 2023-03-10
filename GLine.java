import java.awt.*;

public class GLine implements GPrimitive {
    Color workColor;
    Point startPoint, endPoint;
    GLine() {
        startPoint = Canvas.getStartPoint();
        endPoint = Canvas.getEndPoint();
        workColor = GUI.getWorkColor();
    }
    @Override
    public void drawPrimitive(Graphics g) {
        g.setColor(workColor);
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
}

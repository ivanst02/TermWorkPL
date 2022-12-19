import java.awt.*;

public class GRect implements GPrimitive{
    Color workColor;
    Point startPoint, endPoint;
    GRect() {
        startPoint = Canvas.getStartPoint();
        endPoint = Canvas.getEndPoint();
        workColor = GUI.getWorkColor();
    }
    @Override
    public void drawPrimitive(Graphics g) {
        g.setColor(workColor);
        g.drawRect(startPoint.x, startPoint.y, endPoint.x - startPoint.x, endPoint.y - startPoint.y);
    }
}

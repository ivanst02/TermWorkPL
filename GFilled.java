import java.awt.*;

public class GFilled implements GPrimitive{
    Color workColor;
    Point startPoint, endPoint;
    GFilled() {
        startPoint = Canvas.getStartPoint();
        endPoint = Canvas.getEndPoint();
        workColor = GUI.getWorkColor();
    }
    @Override
    public void drawPrimitive(Graphics g) {
        g.setColor(workColor);
        g.fillRect(startPoint.x, startPoint.y, endPoint.x - startPoint.x, endPoint.y - startPoint.y);
    }
}

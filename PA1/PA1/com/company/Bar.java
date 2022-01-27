package com.company;
// Name:
// USC NetID:
// CS 455 PA1
// Spring 2022

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   private int bottomBar;
   private int leftBar;
   private int barWidth;
   private int verticalBuffer;
   private Color colorBar;
   private String labelBar;
   private int appHeight;
   private double scaleUnits;
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale).
  
      @param bottom  location of the bottom of the bar
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param applicationHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label under the bar
   */
   public Bar(int bottom, int left, int width, int applicationHeight, 
              double scale, Color color, String label) {
   bottomBar=bottom;
   leftBar=left;
   barWidth=width;
   appHeight=applicationHeight;
   scaleUnits=scale;
   colorBar=color;
   labelBar=label;
   }
   
   /**
      Draw the labeled bar.
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {

      //Drawing BAR Graph rectangle.
      g2.setColor(colorBar);
      int finalHeight= (int) (appHeight*scaleUnits);
      int finalY = leftBar-finalHeight;
      Rectangle barGraph = new Rectangle(bottomBar,finalY,barWidth,finalHeight);
      g2.fill(barGraph);

      //Drawing String label.
      g2.setColor(Color.BLACK);
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(labelBar,context);
      int labelWidth = (int)labelBounds.getWidth();
      int labelHeight = (int)labelBounds.getHeight();
      int labelX =(int) bottomBar+50-(labelWidth/2);
      int labelY = finalY+finalHeight+15;
      g2.drawString(labelBar,labelX,labelY);

   }
}

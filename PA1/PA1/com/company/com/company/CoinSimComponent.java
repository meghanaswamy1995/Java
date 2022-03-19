package com.company;

import javax.swing.JComponent;

import java.awt.*;

/**
 * CoinSimComponent class.
 * This class draws the bar graph.
 */
public class CoinSimComponent extends JComponent{

    private int numTrials;
    private int twoHeads;
    private int twoTails;
    private int tailhead;
    private int twoHeadPercent;
    private int twoTailPercent;
    private int tailHeadPercent;
    private int horizontalBuff;
    private double scale;
    private int numOfTrials;
    private int gapsBetweenBars=4;
    private final int TOTAL_BARS=3;
    public final int BAR_WIDTH=100;
    private final int VERTICAL_BUFFER=25;
    private final Color TWO_HEAD_COLOR = Color.RED;
    private final Color TWO_TAIL_COLOR = Color.BLUE;
    private final Color HEAD_TAIL_COLOR = Color.GREEN;

    /**
     Constructor which calls the simulator class and
     gets the details of the toss for a given number of trials.
     @param trialsNum  takes the number of trials to be performed
     */
    public CoinSimComponent(int trialsNum){
        scale = 0.0;
        horizontalBuff = 0;
        numTrials = trialsNum;

        CoinTossSimulator toss = new CoinTossSimulator();
        toss.run(numTrials);
        numTrials = toss.getNumTrials();
        twoHeads = toss.getTwoHeads();
        twoTails = toss.getTwoTails();
        tailhead = toss.getHeadTails();
        twoHeadPercent = toss.getTwoHeadsPercent();
        twoTailPercent=toss.getTwoTailsPercent();
        tailHeadPercent=toss.getTailHeadPercent();
    }
    /**
     PaintComponent method which actually draws Bar by calling Bar class.
     @param g  the graphics context
     */
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //System.out.println("inside paintComponent");
        int totalWidth = getWidth();
        int totalHeight = getHeight();
        int barY= totalHeight-VERTICAL_BUFFER;
        horizontalBuff=(totalWidth-(TOTAL_BARS*BAR_WIDTH))/gapsBetweenBars;
        scale = (totalHeight-(2*VERTICAL_BUFFER))/(double)numTrials;

        int barX = horizontalBuff;
        int appHeight=twoHeads;
        String label="Two Heads: "+twoHeads+" ("+twoHeadPercent+"%)";
        Bar b1 = new Bar(barX,barY,BAR_WIDTH,appHeight,scale, TWO_HEAD_COLOR,label);

        barX=(2*horizontalBuff)+BAR_WIDTH;
        appHeight=tailhead;
        label="A Head and a Tail: "+tailhead+" ("+tailHeadPercent+"%)";
        Bar b2 = new Bar(barX,barY,BAR_WIDTH,appHeight,scale,HEAD_TAIL_COLOR,label);

        barX=(3*horizontalBuff)+(2*BAR_WIDTH);
        appHeight=twoTails;
        label="Two Tails: "+twoTails+" ("+twoTailPercent+"%)";
        Bar b3 = new Bar(barX,barY,BAR_WIDTH,appHeight,scale,TWO_TAIL_COLOR,label);

        b1.draw(g2);
        b2.draw(g2);
        b3.draw(g2);
    }
}

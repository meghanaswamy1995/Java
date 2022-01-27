package com.company;

import javax.swing.JComponent;
import java.awt.*;

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
    private final int BAR_WIDTH=100;
    private final int VERTICAL_BUFFER=25;
    private final Color TWO_HEAD_COLOR = Color.RED;
    private final Color TWO_TAIL_COLOR = Color.BLUE;
    private final Color HEAD_TAIL_COLOR = Color.GREEN;

    public CoinSimComponent(int trialsNum){
        scale = 0.0;
        horizontalBuff = 0;
        CoinTossSimulator toss = new CoinTossSimulator();
        toss.run(trialsNum);
        numTrials = toss.getNumTrials();
        twoHeads = toss.getTwoHeads();
        twoTails = toss.getTwoTails();
        tailhead = toss.getHeadTails();
        twoHeadPercent = toss.getTwoHeadsPercent();
        twoTailPercent=toss.getTwoTailsPercent();
        tailHeadPercent=toss.getTailHeadPercent();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //System.out.println("inside paintComponent");
        int totalWidth = getWidth();
        int totalHeight = getHeight();
        int y= totalHeight-VERTICAL_BUFFER;
        horizontalBuff=(totalWidth-(3*BAR_WIDTH))/4;
        scale = (totalHeight-(2*VERTICAL_BUFFER))/(double)numTrials;


        int x = horizontalBuff;
        int appHeight=twoHeads;
        String label="Two Heads: "+twoHeads+" ("+twoHeadPercent+"%)";
        Bar b1 = new Bar(x,y,BAR_WIDTH,appHeight,scale, TWO_HEAD_COLOR,label);

        x=(2*horizontalBuff)+BAR_WIDTH;
        appHeight=tailhead;
        label="A Head and a Tail: "+tailhead+" ("+tailHeadPercent+"%)";
        Bar b2 = new Bar(x,y,BAR_WIDTH,appHeight,scale,HEAD_TAIL_COLOR,label);

        x=(3*horizontalBuff)+(2*BAR_WIDTH);
        appHeight=twoTails;
        label="Two Tails: "+twoTails+" ("+twoTailPercent+"%)";
        Bar b3 = new Bar(x,y,BAR_WIDTH,appHeight,scale,TWO_TAIL_COLOR,label);

        b1.draw(g2);
        b2.draw(g2);
        b3.draw(g2);
    }
}

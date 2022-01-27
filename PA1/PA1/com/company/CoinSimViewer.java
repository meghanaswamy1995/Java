package com.company;

import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of trials: ");
        int numTrials = input.nextInt();
        while(numTrials<=0){
            System.out.println("ERROR: Number entered must be greater than 0");
            System.out.print("Enter the number of trials: ");
            numTrials = input.nextInt();
        }

    /*
    Creating JFrame window with details.
    */
        final int WINDOW_WIDTH = 800;
        final int WINDOW_HEIGHT = 500;
    JFrame frame = new JFrame();
    frame.setSize(800,500);
    frame.setTitle("CoinSim");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    CoinSimComponent barComponent = new CoinSimComponent(numTrials);
        frame.add(barComponent);
        frame.setVisible(true);

    }
}

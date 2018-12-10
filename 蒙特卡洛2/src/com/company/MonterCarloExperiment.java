package com.company;

import java.awt.*;

public class MonterCarloExperiment {
    private int squareSide;
    private int N;
    private int outputInterval=100;
    public MonterCarloExperiment(int squareSide,int N){
        if(squareSide<=0||N<=0){
            throw new IllegalArgumentException("SquareSide and N must larger");

        }
        this.squareSide=squareSide;
        this.N=N;

    }
    public void setOutputInterval(int interval){
        if(interval<=0)
            throw new IllegalArgumentException("interval must be larger than 0");
    }
    public void run(){
        Circle circle=new Circle(squareSide/2,squareSide/2,squareSide/2);
        MonterCarioPiData data=new MonterCarioPiData(circle);

        for(int i=0;i<N;i++)
            if(i%outputInterval==0)
                System.out.println(data.estimaterPI());

        int x=(int)(Math.random()*squareSide);
        int y=(int)(Math.random()*squareSide);
        data.addPoint(new Point(x,y));
    }
    public static void main(String[] args){
        int squareSide=800;
        int N=10000000;
        MonterCarloExperiment exp=new MonterCarloExperiment(squareSide,N);
        exp.setOutputInterval(10000);
        exp.run();
    }
}

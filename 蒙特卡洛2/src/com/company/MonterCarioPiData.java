package com.company;

import java.awt.*;
import java.util.LinkedList;

public class MonterCarioPiData {
    private Circle circle;
    private int insideCircle=0;
    private LinkedList<Point> points;

    public MonterCarioPiData(Circle circle){
        this.circle=circle;
        points=new LinkedList<Point>();

    }

    public Circle getCircle() {
        return circle;
    }
    public Point getPoint(int i){
        if(i<0||i>=points.size())
            throw new IllegalArgumentException("Out of bound in getPoint");
        return points.get(i);
    }
    public int getPointsNumber(){
        return points.size();
    }
    public void addPoint(Point p){
        points.add(p);
        if(circle.contain(p))
            insideCircle++;
    }
    public double estimaterPI(){
        if(points.size()==0)
            return 0.0000;
        int circleArea=insideCircle;
        int squareArea=points.size();
        return (double)circleArea*4/squareArea;
    }

}

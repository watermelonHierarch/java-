package com.company;

public class ThreeGatesExperiment {
    private int N;
    public ThreeGatesExperiment(int N){
        if(N<=0)
            throw new IllegalArgumentException("N must be larger than0!");
        this.N=N;

    }
    public void run(boolean changeDoor){
        int win=0;
        for(int i=0;i<N;i++){
            if(play(changeDoor))
                win++;
        }
        System.out.println(changeDoor?"Change":"Not Change");
        System.out.println("winning rate:"+(double)win/N);
    }

    private boolean play(boolean changeDoor){
        int prizeDoor=(int)(Math.random()*3);
        int playChoice=(int)(Math.random()*3);

        if(playChoice==prizeDoor)
            return changeDoor?false:true;
        else
            return changeDoor?true:false;
    }
    public static void main(String[] args){
        int N=1000000;
        ThreeGatesExperiment exp=new ThreeGatesExperiment(N);
        exp.run(true);
        exp.run(false);

    }
}

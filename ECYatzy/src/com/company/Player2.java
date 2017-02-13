package com.company;

import java.util.stream.IntStream;

/**
 * Created by simon blank on 2017-01-24.
 */
public class Player2 {

    int[] Score = new int[13];



    public Player2() {
        for(int i=0;i<=12;i++){
            Score[i]=-1;
        }

    }




    public int GetScore(int Demand){


        if(Score[Demand]!=-1)

            return Score[Demand];

        return -1;
    }

    public int GetTotalScore(){


        int sum = IntStream.of(Score).sum();

        return sum;
    }




    public Boolean UsedSlot(int Slot){
        System.out.println(Score[Slot]);

        if(Score[Slot] == -1){
            System.out.println("used slot false");
            return true;}
        else
            System.out.println("used slot true");
            return false;
    }






    public String SetOnes(int Dice[]){

        if(Score[0]==-1) {


            for(int i=0;i<=4;i++) {

                if (Dice[i]==1){  Score[0] = Score[0] + Dice[i];}



            }
            Score[0]++;
            return "Player 2 Scored "+ Score[0] + " in ones With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetTwos(int Dice[]){

        if(Score[1]==-1) {


            for(int i=0;i<=4;i++) {

                if (Dice[i]==2){  Score[1] = Score[1] + Dice[i];}



            }
            Score[1]++;
            return "Player 2 Scored "+ Score[1] + " in twos With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetThrees(int Dice[]){

        if(Score[2]==-1) {


            for(int i=0;i<=4;i++) {

                if (Dice[i]==3){  Score[2] = Score[2] + Dice[i];}



            }
            Score[2]++;
            return "Player 2 Scored "+ Score[2] + " in threes With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetFours(int Dice[]){

        if(Score[3]==-1) {


            for(int i=0;i<=4;i++) {

                if (Dice[i]==4){  Score[3] = Score[3] + Dice[i];}



            }
            Score[3]++;
            return "Player 2 Scored "+ Score[3] + " in fours With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetFives(int Dice[]){

        if(Score[4]==-1) {


            for(int i=0;i<=4;i++) {

                if (Dice[i]==5){  Score[4] = Score[4] + Dice[i];}



            }
            Score[4]++;
            return "Player 2 Scored "+ Score[4] + " in fives With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetSixes(int Dice[]){

        if(Score[5]==-1) {


            for(int i=0;i<=4;i++) {

                if (Dice[i]==6){  Score[5] = Score[5] + Dice[i];}



            }
            Score[5]++;
            return "Player 2 Scored "+ Score[5] + " in sixes With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    //////////////////////////////////middle of upper / lower/////////////////////////////////////////

    public String SetThreeOfAKind(int Dice[]){


        if(Score[6]==-1) {



            for(int i=0;i<=2;i++) {
                System.out.println(Dice[i] + Dice[i+1]+ Dice[i+2]);

                if (Dice[i] == Dice[i+1]&& Dice[i]==Dice[i+2]){
                    Score[6] =Score[6] +Dice[i] * 3;}



            }
            Score[6]++;
            return "Player 2 Scored "+ Score[6] + " in threeOfAKind With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetFourOfAKind(int Dice[]){

        if(Score[7]==-1) {

            for(int i=0;i<=1;i++) {
                System.out.println(Dice[i] + Dice[i+1]+ Dice[i+2]);

                if (Dice[i] == Dice[i+1]&& Dice[i]==Dice[i+2]&& Dice[i]==Dice[i+3]){
                    Score[7] =Score[7] +Dice[i] * 4;}



            }
            Score[7]++;
            return "Player 2 Scored "+ Score[7] + " in FourOfAKind With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetFullHouse(int Dice[]){

        if(Score[8]==-1) {




            if (Dice[0]==Dice[1]&& Dice[2]==Dice[3] && Dice[2]==Dice[4]){

                Score[8] = 24;

            }
            else if(Dice[0]==Dice[1] && Dice[0]==Dice[2] && Dice[3]==Dice[4]){

                Score[8] = 24;
            }



            Score[8]++;
            return "Player 2 Scored "+ Score[8] + " in FullHouse With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetSmallStraight(int Dice[]){

        if(Score[9]==-1) {
            String Temp="";


            for(int i=0 ;i<4;i++){
                if(Dice[i]==Dice[i+1]){}
                else{
                    Temp=Temp+Dice[i];

                }

            }

            Temp=Temp+Dice[4];

            System.out.println("unique number combination = " +Temp);

            if(Temp.equals("6543")){Score[9] = 29;
                System.out.println("unique number combination = " +Temp);
            }
            if(Temp.equals("5432")){Score[9] = 29;
                System.out.println("unique number combination = " +Temp);
            }
            if(Temp.equals("4321")){Score[9] = 29;
                System.out.println("unique number combination = " +Temp);

            }


            Score[9]++;
            return "Player 2 Scored "+ Score[9] + " in SmallStraight With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetLargeStraight(int Dice[]){


        if(Score[10]==-1) {




            if (Dice[0]==Dice[1]+1 && Dice[1]==Dice[2]+1 && Dice[2]==Dice[3]+1 && Dice[3]==Dice[4]+1){

                Score[10] = 39;

            }




            Score[10]++;
            return "Player 2 Scored "+ Score[10] + " in LargeStraight With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetYahtzee(int Dice[]){

        if(Score[11]==-1) {


            if(Dice[0]==Dice[1]&& Dice[0]==Dice[2] && Dice[0]==Dice[3]&& Dice[0]==Dice[4]){
                Score[11] = 49;
            }



            Score[11]++;
            return "Player 2 Scored "+ Score[11] + " in Yahtzee With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

    public String SetChance(int Dice[]){

        if(Score[12]==-1) {




            Score[12] = Score[12] + Dice[0]+ Dice[1]+ Dice[2]+ Dice[3]+ Dice[4];




            Score[12]++;
            return "Player 2 Scored "+ Score[12] + " in Chance With " + Dice[0]+" "+ Dice[1]+" "+ + Dice[2]+" "+ + Dice[3]+" "+ + Dice[4];


        }
        else

            return "This slot is alredy filled";
    }

















}


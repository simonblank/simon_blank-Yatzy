package com.company;

import java.util.Random;

/**
 * Created by simon blank on 2017-01-24.
 */
public class Dice {

    int [] Dice = new int[5];
    Random random = new Random();
    int Reroll =2;


    public void RollAllDice(){
        for(int i=0;i<=4;i++){
            Dice[i]=random.nextInt(6)+1;
            System.out.println("dice"+i+" Rolled " +Dice[i]);

        }


    }

    public int[] GetValueOfAllDice(){

        return Dice;
    }

    public String ReturnAllDice(){
        String DiceValue ="Dice 1 ="+ Dice[0] +" \nDice 2 ="+ Dice[1] +" \nDice 3 = "+ Dice[2] +" \nDice 4 =" +Dice[3] +" \nDice 5 = "+Dice[4] +"\nRerolls left "+ Reroll;

        return DiceValue;
    } /// läggs in i Dice result textfielden

    public void SortDiceBySize(){
        int temp;
        for(int i=0;i<=4;i++){
            for(int x=0;x<=4;x++)
            if(Dice[i]>Dice[x]){
                temp=Dice[i];
                Dice[i]=Dice[x];
                Dice[x]=temp;
            }


        }
        System.out.println("Dice sorted , Dice= " + Dice[0]+" "+Dice[1]+" "+Dice[2]+" "+Dice[3]+" "+Dice[4]);
    }




    public void RerollDiceOne(){
        Dice[0]=random.nextInt(6)+1;

    }

    public void RerollDiceTwo(){
        Dice[1]=random.nextInt(6)+1;

    }

    public void RerollDiceThree(){
        Dice[2]=random.nextInt(6)+1;

    }

    public void RerollDiceFour(){
        Dice[3]=random.nextInt(6)+1;

    }

    public void RerollDiceFive(){
        Dice[4]=random.nextInt(6)+1;

    }




    public int GetAmountOfRerolls(){

        return Reroll;
    }

    public void UseReroll(){
        Reroll--;
    }

    public void ResetReroll(){
        Reroll=2;
    }



}

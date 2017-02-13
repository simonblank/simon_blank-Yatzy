package com.company;



import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by simon blank on 2017-01-24.
 */
public class gui {


    Player1 player1= new Player1();
    Player2 player2= new Player2();
    sql_Connection sql = new sql_Connection();
    Scanner scan;
    Dice Dice = new Dice();
    ArrayList<String> Logg =new ArrayList<>();


    String PlayerCurrentlyPlaying= "Player1";
    String User1= "Player1", User2 ="Player2";
    int Turn=1;
    Boolean NPlayersTurn= false;




    private   JFrame HighScoreBoardFrame =new JFrame();
    private   JPanel HighScoreBoardPanel = new JPanel();
    private   JTextArea HighScoreTextArea = new JTextArea();


    private   JFrame HistoryFrame =new JFrame();
    private   JFrame GameHistoryFrame =new JFrame();
    private   JPanel HistoryPanel = new JPanel();
    private   JTextArea HistoryTextArea = new JTextArea();
    private   JTextArea HistoryNameSearchTextArea = new JTextArea();
    private   JButton  HistorySearchNameButton = new JButton("Search");
    private   JTextArea GameHistoryTextArea = new JTextArea();
    private   JTextArea GameHistoryNameSearchTextArea = new JTextArea();
    private   JButton  GameHistorySearchNameButton = new JButton("Search");


    private   JFrame MainFrame =new JFrame();
    private   JPanel MainPanel = new JPanel();
    private   JPanel GameHistoryPanel = new JPanel();



    private  JTextArea WhichPlayersTurn = new JTextArea("player 1 turn");
    private  JTextArea Player1NameTextArea = new JTextArea();
    private  JTextArea Player2NameTextArea = new JTextArea();
    private  JTextArea LoggTextArea = new JTextArea("logg av vad som händer här");
    private  JTextArea Player1ScoreboardTextArea = new JTextArea();
    private  JTextArea Player2ScoreboardTextArea = new JTextArea();
    private  JTextArea DiceResult = new JTextArea();


    private  JComboBox ResultsLeft = new JComboBox();


    private JButton  ReRollButton = new JButton("reroll");
    private JButton  SetNameButton = new JButton("Setname");
    private JButton  AddScoreButton = new JButton("add score");
    private JButton  HighScoreButton = new JButton("Highscore");
    private JButton  HistoryButton = new JButton("UserHistory");
    private JButton  GameHistoryButton = new JButton("GameHistory");


    private JCheckBox Dice1 = new JCheckBox();
    private JCheckBox Dice2 = new JCheckBox();
    private JCheckBox Dice3 = new JCheckBox();
    private JCheckBox Dice4 = new JCheckBox();
    private JCheckBox Dice5 = new JCheckBox();




    public gui() {}

    public void loadGUI(){

        MainFrameProperties();
        MainPanelProperties();


        WhichPlayersTurn_TextAreaProperties();
        HistoryButton_ButtonProperties();

        DiceResult_TextAreaProperities();
        LoadCheckBoxes();
        ReRollButton_ButtonProperties();
        AddScoreButton_ButtonProperties();

        ResultsLeft_ComboboxProperties();

        Logg_TextAreaProperties();
        Scoreboard_TextAreaProperties();
        Player1NameTextArea_TextAreaProperties();
        Player2NameTextArea_TextAreaProperties();


        HighScoreButton_ButtonProperties();
        SetNameButton_ButtonProperties();



        HighScoreFrameProperties();
        HighScorePanelProperties();


        HistoryFrameProperties();
        HistoryPanelProperties();
        HistoryTextAreaProperties();

        HistoryNameSearchTextAreaProperies();
        HistoryNameSearchButtonProperties();
        HighScoreTextAreaProperties();

        GameHistoryFrameProperties();
        GameHistoryPanelProperties();
        GameHistoryTextAreaProperties();
        GameHistorySearchTextAreaProperies();
        GameHistorySearchButtonProperties();
        GameHistoryButton_ButtonProperties();



        MainFrame.setVisible(true);
    }




    public void MainFrameProperties(){
        MainFrame.setSize(new Dimension(1150,800));
        MainFrame.setResizable(false);
        MainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void MainPanelProperties(){
        MainPanel.setLayout(null);
        MainFrame.add(MainPanel);


    }


    public void WhichPlayersTurn_TextAreaProperties (){
        WhichPlayersTurn.setEditable(false);

        WhichPlayersTurn.setBounds(60,50, 100,30);
        MainPanel.add(WhichPlayersTurn);


    }

    public void Logg_TextAreaProperties () {

        LoggTextArea.setBounds(360,50, 340,1680);
        LoggTextArea.setLineWrap(true);
        LoggTextArea.setWrapStyleWord(true);
        LoggTextArea.setEditable(false);

        MainPanel.add(LoggTextArea);

        JScrollPane scrollPane = new JScrollPane(LoggTextArea);// scroll bar till text arean
        scrollPane.setBounds(360,50, 340,680);
        MainPanel.add(scrollPane);
    }

    public void Scoreboard_TextAreaProperties (){
        Player1LoadScoreBoard();
        Player2LoadScoreBoard();

        Player1ScoreboardTextArea.setEditable(false);
        Player2ScoreboardTextArea.setEditable(false);

        Player1ScoreboardTextArea.setBounds(70,300,250,300);
        Player2ScoreboardTextArea.setBounds(730,300,250,300);
        MainPanel.add(Player1ScoreboardTextArea);
        MainPanel.add(Player2ScoreboardTextArea);

    }  // laddar scoreboard för båda spelarna

    public void Player1NameTextArea_TextAreaProperties (){
        Player1NameTextArea.setText("Player 1");

        Player1NameTextArea.setBounds(400,10,110,20);
        MainPanel.add(Player1NameTextArea);

    }

    public void Player2NameTextArea_TextAreaProperties (){
        Player2NameTextArea.setPreferredSize(new Dimension(150,20));
        Player2NameTextArea.setText("Player 2");

        Player2NameTextArea.setBounds(530,10,110,20);

        MainPanel.add(Player2NameTextArea);

    }

    public void DiceResult_TextAreaProperities(){
        Dice.RollAllDice();
        RefreshDiceTextArea();

        DiceResult.setEditable(false);
        DiceResult.setBounds(70,100,200,100);
        MainPanel.add(DiceResult);
    }




    public void LoadCheckBoxes(){
        Dice1.setBounds(45,98,18,18);
        MainPanel.add(Dice1);
        Dice2.setBounds(45,115,18,18);
        MainPanel.add(Dice2);
        Dice3.setBounds(45,132,18,18);
        MainPanel.add(Dice3);
        Dice4.setBounds(45,148,18,18);
        MainPanel.add(Dice4);
        Dice5.setBounds(45,165,18,18);
        MainPanel.add(Dice5);

    }

    public void ResultsLeft_ComboboxProperties(){


        ResultsLeft.addItem("ones");
        ResultsLeft.addItem("twos");
        ResultsLeft.addItem("threes");
        ResultsLeft.addItem("fours");
        ResultsLeft.addItem("fives");
        ResultsLeft.addItem("sixes");
        ResultsLeft.addItem("Three Of A Kind");
        ResultsLeft.addItem("Four Of A Kind");
        ResultsLeft.addItem("Full House");
        ResultsLeft.addItem("Small Straight");
        ResultsLeft.addItem("Large Straight");
        ResultsLeft.addItem("Yahtzee");
        ResultsLeft.addItem("Chance");

        ResultsLeft.setBounds(160,250,110,20);
        MainPanel.add(ResultsLeft);
    }




    public void ReRollButton_ButtonProperties(){

        ReRollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


           if(Dice.GetAmountOfRerolls()!=0) {

               Dice.UseReroll();
               if(Dice1.isSelected()){Dice.RerollDiceOne(); System.out.println("rerolling Dice 1");}
               if(Dice2.isSelected()){Dice.RerollDiceTwo();System.out.println("rerolling Dice 2");}
               if(Dice3.isSelected()){Dice.RerollDiceThree();System.out.println("rerolling Dice 3");}
               if(Dice4.isSelected()){Dice.RerollDiceFour();System.out.println("rerolling Dice 4");}
               if(Dice5.isSelected()){Dice.RerollDiceFive();System.out.println("rerolling Dice 5");}
               RefreshDiceTextArea();
               ResetCheckboxes();

               System.out.println(ResultsLeft.getSelectedItem()+" "+ ResultsLeft.getSelectedIndex());

           }
            }
        });

        ReRollButton.setBounds(70,210,80,40);
        MainPanel.add(ReRollButton);
    }

    public void AddScoreButton_ButtonProperties(){



        AddScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Addscore knappen trycktes");
                Dice.SortDiceBySize();


                if(PlayerCurrentlyPlaying=="Player1"){
                switch (ResultsLeft.getSelectedIndex()) {
                    case 0: {

                        if(player1.UsedSlot(0)){ NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetOnes(Dice.GetValueOfAllDice()));

                        System.out.println("SetOnes kallades");

                        break;
                    }

                    case 1: {
                        if(player1.UsedSlot(1)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetTwos(Dice.GetValueOfAllDice()));
                        System.out.println("SetTwos kallades");
                        break;
                    }

                    case 2: {
                        if(player1.UsedSlot(2)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetThrees(Dice.GetValueOfAllDice()));
                        System.out.println("SetThrees kallades");
                        break;
                    }

                    case 3: {
                        if(player1.UsedSlot(3)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetFours(Dice.GetValueOfAllDice()));
                        System.out.println("SetFours kallades");
                        break;
                    }

                    case 4: {
                        if(player1.UsedSlot(4)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetFives(Dice.GetValueOfAllDice()));
                        System.out.println("SetFives kallades");
                        break;
                    }

                    case 5: {
                        if(player1.UsedSlot(5)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetSixes(Dice.GetValueOfAllDice()));
                        System.out.println("SetSixes kallades");
                        break;
                    }
                    ///////////////////////// middle of upper / lower ///////////////////////////////////////////
                    case 6: {
                        if(player1.UsedSlot(6)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetThreeOfAKind(Dice.GetValueOfAllDice()));
                        System.out.println("SetThreeOfAKind kallades");
                        break;
                    }
                    case 7: {
                        if(player1.UsedSlot(7)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetFourOfAKind(Dice.GetValueOfAllDice()));
                        System.out.println("SetFourOfAkind kallades");
                        break;
                    }

                    case 8: {
                        if(player1.UsedSlot(8)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetFullHouse(Dice.GetValueOfAllDice()));
                        System.out.println("SetFullHouse kallades");
                        break;
                    }

                    case 9: {
                        if(player1.UsedSlot(9)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetSmallStraight(Dice.GetValueOfAllDice()));
                        System.out.println("SetSmallStraight kallades");
                        break;
                    }

                    case 10: {
                        if(player1.UsedSlot(10)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetLargeStraight(Dice.GetValueOfAllDice()));
                        System.out.println("SetlargStraight kallades");
                        break;
                    }

                    case 11: {
                        if(player1.UsedSlot(11)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetYahtzee(Dice.GetValueOfAllDice()));
                        System.out.println("SetYahtzee kallades");
                        break;
                    }
                    case 12: {
                        if(player1.UsedSlot(12)){
                            NPlayersTurn=true;}
                        Logg.add("Turn "+Turn+" "+player1.SetChance(Dice.GetValueOfAllDice()));
                        System.out.println("SetChance kallades");
                        break;
                    }

                }
                    LoggTextArea.append("\n "+ Logg.get(Logg.size() - 1).toString().replace("[","").replace("]",""));
                if(NPlayersTurn){
                    Dice.ResetReroll();
                    Dice.RollAllDice();
                    RefreshDiceTextArea();
                    ResetCheckboxes();
                    Player1LoadScoreBoard();
                    PlayerCurrentlyPlaying = "Player2";
                    System.out.println("byter till player 2 ");
                    NPlayersTurn=false;


                }


                }
               else if(PlayerCurrentlyPlaying=="Player2"){
                    switch (ResultsLeft.getSelectedIndex()) {
                        case 0: {

                            if(player2.UsedSlot(0)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetOnes(Dice.GetValueOfAllDice()));
                            System.out.println("SetOnes kallades");
                            break;
                        }

                        case 1: {
                            if(player2.UsedSlot(1)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetTwos(Dice.GetValueOfAllDice()));
                            System.out.println("SetTwos kallades");
                            break;
                        }

                        case 2: {
                            if(player2.UsedSlot(2)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetThrees(Dice.GetValueOfAllDice()));
                            System.out.println("SetThrees kallades");
                            break;
                        }

                        case 3: {
                            if(player2.UsedSlot(3)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetFours(Dice.GetValueOfAllDice()));
                            System.out.println("SetFours kallades");
                            break;
                        }

                        case 4: {
                            if(player2.UsedSlot(4)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetFives(Dice.GetValueOfAllDice()));
                            System.out.println("SetFives kallades");
                            break;
                        }

                        case 5: {
                            if(player2.UsedSlot(5)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetSixes(Dice.GetValueOfAllDice()));
                            System.out.println("SetSixes kallades");
                            break;
                        }
                        ///////////////////////// middle of upper / lower ///////////////////////////////////////////
                        case 6: {
                            if(player2.UsedSlot(6)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetThreeOfAKind(Dice.GetValueOfAllDice()));
                            System.out.println("SetThreeOfAKind kallades");
                            break;
                        }
                        case 7: {
                            if(player2.UsedSlot(7)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetFourOfAKind(Dice.GetValueOfAllDice()));
                            System.out.println("SetFourOfAkind kallades");
                            break;
                        }

                        case 8: {
                            if(player2.UsedSlot(8)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetFullHouse(Dice.GetValueOfAllDice()));
                            System.out.println("SetFullHouse kallades");
                            break;
                        }

                        case 9: {
                            if(player2.UsedSlot(9)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetSmallStraight(Dice.GetValueOfAllDice()));
                            System.out.println("SetSmallStraight kallades");
                            break;
                        }

                        case 10: {
                            if(player2.UsedSlot(10)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetLargeStraight(Dice.GetValueOfAllDice()));
                            System.out.println("SetlargStraight kallades");
                            break;
                        }

                        case 11: {
                            if(player2.UsedSlot(11)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetYahtzee(Dice.GetValueOfAllDice()));
                            System.out.println("SetYahtzee kallades");
                            break;
                        }
                        case 12: {
                            if(player2.UsedSlot(12)){
                                NPlayersTurn=true;}
                            Logg.add("Turn "+Turn+" "+player2.SetChance(Dice.GetValueOfAllDice()));
                            System.out.println("SetChance kallades");
                            break;
                        }

                    }
                    LoggTextArea.append("\n "+ Logg.get(Logg.size() - 1).toString().replace("[","").replace("]",""));
                    if(NPlayersTurn) {
                        Dice.ResetReroll();
                        Dice.RollAllDice();
                        RefreshDiceTextArea();
                        ResetCheckboxes();
                        Player2LoadScoreBoard();
                        PlayerCurrentlyPlaying = "Player1";
                        System.out.println("byter till player 1");
                        LoggTextArea.append("\n");
                        Turn++;
                        NPlayersTurn=false;


                    }
                }





            if(Turn==14){LoggTextArea.append(" Game is Over \n Winner is ");
                Player1ScoreboardTextArea.append("\nEnd score "+player1.GetTotalScore());
                Player2ScoreboardTextArea.append("\nEnd score "+player2.GetTotalScore());
                AddScoreButton.setVisible(false);
                sql.InsertUserNames();
                sql.GetUserID();




            if(player1.GetTotalScore() > player2.GetTotalScore()){
                LoggTextArea.append(User1 + " with a score of " + player1.GetTotalScore());
                sql.InsertGameResult(User1,User2);
                sql.GetGameID();
                sql.InsertScore(player1.GetTotalScore(),player2.GetTotalScore());
                sql.InsertGameLogg(Logg);
            }
            if(player1.GetTotalScore() < player2.GetTotalScore()){
                LoggTextArea.append(User2 + " with a score of " + player2.GetTotalScore());
                sql.InsertGameResult(User2,User1);
                sql.GetGameID();
                sql.InsertScore(player1.GetTotalScore(),player2.GetTotalScore());
                sql.InsertGameLogg(Logg);
            }
            else if(player1.GetTotalScore() == player2.GetTotalScore()){LoggTextArea.append("no one :P");}
            }
            else{
            WhichPlayersTurn.setText(PlayerCurrentlyPlaying +" turn");}
            }
        });

        AddScoreButton.setBounds(160,210,110,40);
        MainPanel.add(AddScoreButton);
    }

    public void HighScoreButton_ButtonProperties(){

        HighScoreButton.setBounds(915,10,100,30);

        HighScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("opened HighscoreBoard ");
                RefreshHighScoreTextArea();
                HighScoreBoardFrame.setVisible(true);

            }
        });

        MainPanel.add(HighScoreButton);
    }

    public void HistoryButton_ButtonProperties(){

        HistoryButton.setBounds(800,10,110,30);

        HistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("opened HistoryBoard ");
                HistoryFrame.setVisible(true);

            }
        });

        MainPanel.add(HistoryButton);

    }

    public void GameHistoryButton_ButtonProperties(){

        GameHistoryButton.setBounds(1020,10,110,30);

        GameHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("opened HistoryGameBoard ");
               GameHistoryFrame.setVisible(true);

            }
        });

        MainPanel.add(GameHistoryButton);

    }

    public void SetNameButton_ButtonProperties(){
        SetNameButton.setBounds(700,10,95,30);

        SetNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if(!Player1NameTextArea.getText().equals("Player 1"))  User1=Player1NameTextArea.getText();
              if(!Player2NameTextArea.getText().equals("Player 2"))  User2=Player2NameTextArea.getText();

                Player1LoadScoreBoard();
                Player2LoadScoreBoard();
                sql.setUser1(User1);
                sql.setUser2(User2);


            }
        });

        MainPanel.add(SetNameButton);
    }




    public void Player1LoadScoreBoard(){
        Player1ScoreboardTextArea.setText("  Player1 = "+User1+"     \n");
        if(player1.GetScore(0)!=-1){Player1ScoreboardTextArea.append ("  ones        "+player1.GetScore(0)+"\n");}
        if(player1.GetScore(1)!=-1){Player1ScoreboardTextArea.append ("  twos        "+player1.GetScore(1)+"\n");}
        if(player1.GetScore(2)!=-1){Player1ScoreboardTextArea.append ("  threes      "+player1.GetScore(2)+"\n");}
        if(player1.GetScore(3)!=-1){Player1ScoreboardTextArea.append ("  fours       "+player1.GetScore(3)+"\n");}
        if(player1.GetScore(4)!=-1){Player1ScoreboardTextArea.append ("  fives      "+player1.GetScore(4)+" \n");}
        if(player1.GetScore(5)!=-1){Player1ScoreboardTextArea.append ("  sixes       "+player1.GetScore(5)+"\n");}

        if(player1.GetScore(6)!=-1){Player1ScoreboardTextArea.append ("  Three Of A Kind     "+player1.GetScore(6)+" \n");}
        if(player1.GetScore(7)!=-1){Player1ScoreboardTextArea.append ("  Four Of A Kind   "+player1.GetScore(7)+"\n");}
        if(player1.GetScore(8)!=-1){Player1ScoreboardTextArea.append ("  Full House          "+player1.GetScore(8)+" \n");}
        if(player1.GetScore(9)!=-1){Player1ScoreboardTextArea.append ("  Small Straight      "+player1.GetScore(9)+" \n");}
        if(player1.GetScore(10)!=-1){Player1ScoreboardTextArea.append ("  Large Straight  "+player1.GetScore(10)+"\n");}
        if(player1.GetScore(11)!=-1){Player1ScoreboardTextArea.append ("  Yahtzee            "+player1.GetScore(11)+"   \n");}
        if(player1.GetScore(12)!=-1){Player1ScoreboardTextArea.append ("  Chance              "+player1.GetScore(12)+"  \n");}







    }

    public void Player2LoadScoreBoard(){
        Player2ScoreboardTextArea.setText("  Player2 ="+User2+"                      \n");
        if(player2.GetScore(0)!=-1){Player2ScoreboardTextArea.append ("  ones        "+player2.GetScore(0)+"\n");}
        if(player2.GetScore(1)!=-1){Player2ScoreboardTextArea.append ("  twos        "+player2.GetScore(1)+"\n");}
        if(player2.GetScore(2)!=-1){Player2ScoreboardTextArea.append ("  threes      "+player2.GetScore(2)+"\n");}
        if(player2.GetScore(3)!=-1){Player2ScoreboardTextArea.append ("  fours       "+player2.GetScore(3)+"\n");}
        if(player2.GetScore(4)!=-1){Player2ScoreboardTextArea.append ("  fives      "+player2.GetScore(4)+" \n");}
        if(player2.GetScore(5)!=-1){Player2ScoreboardTextArea.append ("  sixes       "+player2.GetScore(5)+"\n");}

        if(player2.GetScore(6)!=-1){Player2ScoreboardTextArea.append ("  Three Of A Kind     "+player2.GetScore(6)+" \n");}
        if(player2.GetScore(7)!=-1){Player2ScoreboardTextArea.append ("  Four Of A Kind   "+player2.GetScore(7)+"\n");}
        if(player2.GetScore(8)!=-1){Player2ScoreboardTextArea.append ("  Full House          "+player2.GetScore(8)+" \n");}
        if(player2.GetScore(9)!=-1){Player2ScoreboardTextArea.append ("  Small Straight      "+player2.GetScore(9)+" \n");}
        if(player2.GetScore(10)!=-1){Player2ScoreboardTextArea.append ("  Large Straight  "+player2.GetScore(10)+"\n");}
        if(player2.GetScore(11)!=-1){Player2ScoreboardTextArea.append ("  Yahtzee            "+player2.GetScore(11)+"   \n");}
        if(player2.GetScore(12)!=-1){Player2ScoreboardTextArea.append ("  Chance              "+player2.GetScore(12)+"  \n");}







    }

    public void RefreshDiceTextArea(){

        DiceResult.setText("");
        DiceResult.setText(Dice.ReturnAllDice());

    }

    public void ResetCheckboxes(){
        Dice1.setSelected(false);
        Dice2.setSelected(false);
        Dice3.setSelected(false);
        Dice4.setSelected(false);
        Dice5.setSelected(false);

    }



    public void HighScoreFrameProperties(){
        HighScoreBoardFrame.setSize(new Dimension(400,650));
        HighScoreBoardFrame.setResizable(false);



    }

    public void HighScorePanelProperties(){
        HighScoreBoardFrame.add(HighScoreBoardPanel);


    }

    public void HighScoreTextAreaProperties(){

        HighScoreTextArea.setPreferredSize(new Dimension(250,600));
        HighScoreTextArea.setEditable(false);

        HighScoreBoardPanel.add(HighScoreTextArea);

    }

    public void RefreshHighScoreTextArea(){
        try {
            HighScoreTextArea.setText("HighScore \n \n ");
            scan =new Scanner(sql.GetTop30HighSCore_Sql().toString().replace(",","").replace("[","").replace("]","")).useDelimiter("@@");
            while (scan.hasNext()){
                HighScoreTextArea.append(scan.next()+"\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void HistoryFrameProperties(){
        HistoryFrame.setSize(new Dimension(700,800));
        HistoryFrame.setResizable(false);



    }

    public void HistoryPanelProperties(){
        HistoryPanel.setLayout(null);
        HistoryFrame.add(HistoryPanel);



    }

    public void HistoryTextAreaProperties(){
        HistoryTextArea.setBounds(70,50,550,600);
        HistoryPanel.add(HistoryTextArea);


    }

    public void HistoryNameSearchTextAreaProperies(){
        HistoryNameSearchTextArea.setBounds(70,10,130,30);
        HistoryPanel.add(HistoryNameSearchTextArea);

    }

    public void HistoryNameSearchButtonProperties(){
        HistorySearchNameButton.setBounds(220,10,95,30);
        HistorySearchNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RefreshHistoryTextArea();


            }
        });



        HistoryPanel.add(HistorySearchNameButton);

    }

    public void RefreshHistoryTextArea(){

        HistoryTextArea.setText(" ");
        try {

            scan =new Scanner(sql.GetUserHistory_Sql(HistoryNameSearchTextArea.getText()).toString().replace(",","").replace("[","").replace("]","")).useDelimiter("@@");
            while (scan.hasNext()){
                HistoryTextArea.append(scan.next()+"\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public void GameHistoryFrameProperties(){
        GameHistoryFrame.setSize(new Dimension(700,800));
        GameHistoryFrame.setResizable(false);



    }

    public void GameHistoryPanelProperties(){
        GameHistoryPanel.setLayout(null);
        GameHistoryFrame.add(GameHistoryPanel);



    } //

    public void GameHistoryTextAreaProperties(){
        GameHistoryTextArea.setBounds(70,50,550,600);
        GameHistoryPanel.add(GameHistoryTextArea);


    } //

    public void GameHistorySearchTextAreaProperies(){
        GameHistoryNameSearchTextArea.setBounds(70,10,130,30);
        GameHistoryPanel.add(GameHistoryNameSearchTextArea);

    }//

    public void GameHistorySearchButtonProperties(){
        GameHistorySearchNameButton.setBounds(220,10,95,30);
        GameHistorySearchNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameRefreshHistoryTextArea();


            }
        });



        GameHistoryPanel.add(GameHistorySearchNameButton);

    }

    public void GameRefreshHistoryTextArea(){
       // GameHistoryNameSearchTextArea.getText()
        int temp= Integer.parseInt(GameHistoryNameSearchTextArea.getText());


        GameHistoryTextArea.setText(" ");
        try {

            scan =new Scanner(sql.GetHistoryForGameX_Sql(temp).toString().replace(",","").replace("[","").replace("]","")).useDelimiter("@@");
            while (scan.hasNext()){
                GameHistoryTextArea.append(scan.next()+"\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by simon blank on 2017-01-27.
 */
public class sql_Connection {
    Connection GetConn;
    String User1="Player1" , User2="Player2";
    int User1ID, User2ID, GameID;




    public sql_Connection() {


        String database = "YatzePlayers";
        String databas2 = "AdventureWorks2012";
        String port ="1433";
        String user = "developer";   ////developer
        String password = "popi34";   ///popi34
        String jdbcURL ="jdbc:sqlserver://localhost:1433; databaseName="+database+";user="+user+";password="+password;



        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("step1 succesful");
            GetConn = DriverManager.getConnection(jdbcURL);
            CreateTablesIfTheyDontExist();
            System.out.println("connection succesful");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void CreateTablesIfTheyDontExist(){
        String PlayerTable=
                "if not exists (select * from sysobjects where name='Players' and xtype='U') create table Players ( ID int IDENTITY(1,1) not null PRIMARY KEY,Name varchar(100) not null)";

        String GameLoggTable=
                "if not exists (select * from sysobjects where name='GameLoggTabel' and xtype='U')\n" +
                        "    create table GameLoggTabel (\n" +
                        "        ID int IDENTITY(1,1) not null PRIMARY KEY" +
                        "         ,GameID int    "+
                        "        , Turn int" +
                        "        ,PlayerID int" +
                        "        ,Combination varchar(100)" +
                        "        ,Slott varchar(100)" +
                        "        ,Score int" +
                        "    )";


        String ScoreTable=
                "if not exists (select * from sysobjects where name='ScoreTable' and xtype='U')\n" +
                        "    create table ScoreTable (\n" +
                        "        ID int IDENTITY(1,1) not null PRIMARY KEY" +
                        "         ,PlayerID int    "+
                        "        ,Score int not null" +
                        "        ,GameId int not null" +
                        "    )";

        String WinLossTable=
                "if not exists (select * from sysobjects where name='WinLossTable' and xtype='U')\n" +
                        "    create table WinLossTable (\n" +
                        "        GameID int IDENTITY(1,1) not null PRIMARY KEY" +
                        "        ,Player1ID int " +
                        "        ,Player2ID int " +
                        "        ,Winner varchar(100)" +
                        "        ,Loser varchar(100)" +
                        "        ,Date DATETIME" +
                        "    )";

        try {
            Connection Con = GetConn;
            PreparedStatement create = Con.prepareStatement(PlayerTable);
            create.executeUpdate();
            create = Con.prepareStatement(ScoreTable);
            create.executeUpdate();
            create = Con.prepareStatement(WinLossTable);
            create.executeUpdate();
            create = Con.prepareStatement(GameLoggTable);
            create.executeUpdate();





        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e);
        }


    }


    public void InsertUserNames(){
        String PostUser1Command ="if not exists (SELECT * FROM dbo.Players WHERE Name='"+User1+"')INSERT INTO Players (Name) VALUES('"+User1+"')";
        String PostUser2Command ="if not exists (SELECT * FROM dbo.Players WHERE Name='"+User2+"')INSERT INTO Players (Name) VALUES('"+User2+"')";

        try {
            Connection Con = GetConn;
            PreparedStatement statement = Con.prepareStatement(PostUser2Command);
            statement.execute();
            statement = Con.prepareStatement(PostUser1Command);
            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public ArrayList<String> GetTop30HighSCore_Sql()throws Exception {
        String SelectTop30HighScoreCommand ="SELECT TOP 30 Name , Score  FROM dbo.ScoreTable JOIN dbo.Players ON ScoreTable.PlayerID=Players.ID ORDER BY Score DESC";
        try {
            Connection Con = GetConn;
            PreparedStatement statement = Con.prepareStatement(SelectTop30HighScoreCommand);

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<>();
            while (result.next()) {
                System.out.print(result.getString("Name"));
                System.out.print(" ");
                System.out.println(result.getString("Score"));

                array.add(result.getString("Name"));
                array.add(result.getString("Score"));
                array.add("@@");
            }


            return array;
        }catch (Exception e){System.out.println(e);}

        return null;
    }

    public ArrayList<String> GetUserHistory_Sql(String search)throws Exception {

        String SelectCommand = "SELECT ScoreTable.GameId,Winner,Loser,Score,Date FROM dbo.ScoreTable " +
                "JOIN WinLossTable ON ScoreTable.GameId =WinLossTable.GameID WHERE PlayerID="+GetIDForSearchedUser(search)+" ORDER  BY Gameid DESC";
        try {
            Connection Con = GetConn;
            PreparedStatement statement = Con.prepareStatement(SelectCommand);

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<>();
            while (result.next()) {
                System.out.print(result.getString("GameId"));
                System.out.print(" ");
                System.out.println(result.getString("Winner"));
                System.out.print(" ");
                System.out.println(result.getString("Loser"));
                System.out.print(" ");
                System.out.println(result.getString("Score"));

                array.add("GameID : ");
                array.add(result.getString("GameId"));
                array.add("Winner : ");
                array.add(result.getString("Winner"));
                array.add(" Loser : ");
                array.add(result.getString("Loser"));
                array.add(" Score : ");
                array.add(result.getString("Score"));
                array.add(" ");
                array.add(result.getString("Date"));
                array.add("@@");
            }


            return array;
        }catch (Exception e){System.out.println(e);}

        return null;
    }

    public ArrayList<String> GetHistoryForGameX_Sql(int search)throws Exception {

        String SelectCommand = "Select GameID,Turn,Name,Combination,Slott,Score FROM dbo.GameLoggTabel JOIN dbo.Players ON GameLoggTabel.PlayerID =Players.ID WHERE GameID="+search;

        try {
            Connection Con = GetConn;
            PreparedStatement statement = Con.prepareStatement(SelectCommand);

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<>();
            while (result.next()) {
                System.out.println(result.getString("GameId"));
                System.out.print(" ");
                System.out.println(result.getString("Turn"));
                System.out.print(" ");
                System.out.println(result.getString("Name"));
                System.out.print(" ");
                System.out.println(result.getString("Combination"));
                System.out.print(" ");
                System.out.println(result.getString("Slott"));
                System.out.print(" ");
                System.out.println(result.getString("Score"));

                array.add("GameID : ");
                array.add(result.getString("GameId"));
                array.add("Turn : ");
                array.add(result.getString("Turn"));
                array.add(" user : ");
                array.add(result.getString("Name"));
                array.add(" Combination : ");
                array.add(result.getString("Combination"));
                array.add(" Slott =");
                array.add(result.getString("Slott"));
                array.add(" Score = ");
                array.add(result.getString("Score"));
                array.add("@@");
            }


            return array;
        }catch (Exception e){System.out.println(e);}

        return null;
    }




    public void InsertScore(int ScoreForPlayer1,int ScoreForPlayer2){



        try {
            Connection Con = GetConn;



            String InsertScore1 = "INSERT INTO dbo.ScoreTable (PlayerID,Score,GameId) VALUES("+User1ID+","+ScoreForPlayer1+","+GameID+")";
            String InsertScore2 = "INSERT INTO dbo.ScoreTable (PlayerID,Score,GameId) VALUES("+User2ID+","+ScoreForPlayer2+","+GameID+")";

            PreparedStatement statement = Con.prepareStatement(InsertScore1);
            statement.execute();
            statement = Con.prepareStatement(InsertScore2);
            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void InsertGameResult(String Winner, String Loser){
        String InsertString2 ="INSERT INTO WinLossTable(Player1ID,Player2ID,Winner,Loser,Date)VALUES("+User1ID+","+User2ID+",'"+Winner+"','"+Loser+"')";
        String InsertString ="INSERT WinLossTable(Player1ID,Player2ID,Winner,Loser,Date) VALUES ("+User1ID+","+User2ID+",'"+Winner+"','"+Loser+"',CURRENT_TIMESTAMP)";


        try {
            Connection Con = GetConn;
            PreparedStatement statement = Con.prepareStatement(InsertString);
            statement.execute();

            System.out.println("inserting result " + InsertString);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void InsertGameLogg(ArrayList Logg){
        int x=0;

        String InserCommand="";

        System.out.println("you are in InsertGameLogg now");
       // String InserCommand=    "INSERT GameLoggTabel(GameID,Turn,PlayerID,Combination,Slott,Score) VALUES ("+GameID+",1,1,' 2 5 6 3 4','Small Straigh',30)";
        // Turn 1 Player 1 Scored 0 in ones With 4 4 4 4 4
        String search  = "This slot is alredy filled";

        System.out.println(Logg.toString());
        while(x<Logg.size()) {



            if ( Logg.get(x).toString().toLowerCase().indexOf(search.toLowerCase()) != -1 ) {
                Logg.remove(x);
                System.out.println("found the keyword Skipping Line");
                x--;
            }


            x++;
        }




      for(int i=0;i<Logg.size();i++) {
          if(Logg.get(i)==""){i++;}
          System.out.println(Logg.get(i));



          InserCommand = "INSERT GameLoggTabel(GameID,Turn,PlayerID,Combination,Slott,Score) VALUES (" +

                  GameID + "," +    /// game ID
                  Logg.get(i).toString().substring(5, Logg.toString().indexOf("Player")-1) + ","+ /// Turn
                  User2ID+",'"+  // userID
                  Logg.toString().substring(Logg.toString().lastIndexOf("With")+4)+"','" + // Dice combination
                  Logg.get(i).toString().substring(     Logg.get(i).toString().lastIndexOf("in")+2    ,       Logg.get(i).toString().indexOf("With")-1) + "',"+  // slott
                  Logg.get(i).toString().substring(Logg.get(i).toString().lastIndexOf("Scored")+7,Logg.get(i).toString().indexOf("in")-1)+")"; // score

          System.out.println(InserCommand);




          try {
              Connection Con = GetConn;
              PreparedStatement statement = Con.prepareStatement(InserCommand);
              statement.execute();

              System.out.println("inserting result " + InserCommand);


          } catch (SQLException e) {
              e.printStackTrace();
          }



      }
    }




    public int GetIDForSearchedUser(String search){
        String GetID= "SELECT ID FROM dbo.Players WHERE Name ='"+search+"'";
        int FoundUser=1;



        try {
            Connection Con = GetConn;
            PreparedStatement statement = Con.prepareStatement(GetID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                FoundUser = rs.getInt(1);
            }



            System.out.println("ID for "+search+" is "+ FoundUser);
            return FoundUser;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void GetUserID(){

        String GetIDForUser1 = "SELECT ID FROM dbo.Players WHERE Name ='"+User1+"'";
        String GetIDForUser2 = "SELECT ID FROM dbo.Players WHERE Name ='"+User2+"'";


        try {
        Connection Con = GetConn;
        PreparedStatement statement = Con.prepareStatement(GetIDForUser1);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            User1ID = rs.getInt(1);
        }

        statement = Con.prepareStatement(GetIDForUser2);
        rs = statement.executeQuery();
        if (rs.next()) {
            User2ID = rs.getInt(1);
        }


        System.out.println("ID for "+User1+" is "+ User1ID);
        System.out.println("ID for "+User2+" is "+ User2ID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void GetGameID(){

        String GetGameID = "SELECT GameID FROM dbo.WinLossTable ORDER BY GameID DESC ";



        try {
            Connection Con = GetConn;
            PreparedStatement statement = Con.prepareStatement(GetGameID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                GameID = rs.getInt(1);
            }
            System.out.println("ID for this game is "+ GameID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void setUser1(String user1) {
        User1 = user1;
    }

    public void setUser2(String user2) {
        User2 = user2;
    }

}

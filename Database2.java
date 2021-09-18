/* 
NJCLabs Internship
JDBC Connection steps:
    1.Use Driver
    2.Establish Connection
    3.Create Statement
    4.Execute Query
    5.Get result
*/

import java.sql.*;

class Database2
{
public static void main(String[] args) throws Exception
{
/***********************************************************************************
1.Connect to the SQLite database
2.Creating a new SQLite database
*************************************************************************************/

Class.forName("org.sqlite.JDBC");

//Establish Connection and create database if not exists.
Connection con=DriverManager.getConnection("jdbc:sqlite:C://sqlite//movies.db");

Statement stm=con.createStatement();//3.Creates a select statement.

/***********************************************************************************
3.Creating a new Table
*************************************************************************************/
stm.executeUpdate("""
    CREATE TABLE if not exists movies (
        Name          TEXT,
        Actor         TEXT,
        Actress       TEXT,
        Director      TEXT,
        YearofRelease INTEGER
    );
""");

/***********************************************************************************
4.Inserting data into Movies table 
*************************************************************************************/

stm.executeUpdate
("""
INSERT INTO movies (Name, Actor, Actress, Director, YearofRelease) VALUES ('KGF', 'Yash', 'Shrinidhi', 'Prashant', 2018);
INSERT INTO movies (Name, Actor, Actress, Director, YearofRelease) VALUES ('Trance', 'Fahad', 'Nazria', 'Antony', 2020);
INSERT INTO movies (Name, Actor, Actress, Director, YearofRelease) VALUES ('Maharshi', 'Mahesh Babu', 'Pooja', 'Vikram', 2019);
INSERT INTO movies (Name, Actor, Actress, Director, YearofRelease) VALUES ('Dangal', 'Amir Khan', 'Fatima', 'Nitesh', 2016);
INSERT INTO movies (Name, Actor, Actress, Director, YearofRelease) VALUES ('URI', 'Vicky', 'Yami', 'Abhinav', 2020);
INSERT INTO movies (Name, Actor, Actress, Director, YearofRelease) VALUES ('Googly', 'Yash', 'Kriti', 'Pavan', 2010);
""");

/***********************************************************************************
5.Querying data from Movies table 
 retrives whole table data
*************************************************************************************/

ResultSet rs=stm.executeQuery("select distinct * from movies");

int YOR;
String Actr;
String Actrs;
String Dir;
String Nam;
while(rs.next())//if there is next row available in resultset it will execute
{
Actr=rs.getString("Actor");
YOR=rs.getInt("YearofRelease");
Nam=rs.getString("Name");
Actrs=rs.getString("Actress");
Dir=rs.getString("Director");
System.out.println(Nam+" |"+Actr+" |"+Actrs+" |"+Dir+" |"+YOR);//queries all rows from the Movies table

}

System.out.println("-------------------------------------------");

/***********************************************************************************
6.Querying data from Movies table 
 retrives movie details of actor Yash.
*************************************************************************************/

 String sql = "SELECT Distinct * FROM movies" + " WHERE Actor='Yash'";//fetches movies by actor Yash.
         rs = stm.executeQuery(sql);

while(rs.next())
{
Actr=rs.getString("Actor");
YOR=rs.getInt("YearofRelease");
Nam=rs.getString("Name");
Actrs=rs.getString("Actress");
Dir=rs.getString("Director");
System.out.println(Nam+" |"+Actr+" |"+Actrs+" |"+Dir+" |"+YOR);//fetches all

}

}

}


/*
Some of the other queries:
String sql = "SELECT Distinct * FROM movies" + " WHERE Actor Like='%a%'; -->gives output of actors having 'a' in their name
String sql = "SELECT Distinct * FROM movies" + " WHERE Actor Like='%a%'; -->gives output of actors having 'a' in their name
System.out.println(Actr+" "+YOR); -->fetch only actor and year of release. 
System.out.println(Dir+" "+YOR);-->fetch only director and Year of Release. etc.
*/
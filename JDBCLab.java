import java.sql.*;
import java.util.Scanner;


public class JDBCLab {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-lab","root","root");
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * from student");

            while(resultSet.next()){
                System.out.print(resultSet.getInt("sid")+" ");
                System.out.print(resultSet.getString("name")+" ");
                System.out.print(resultSet.getString("dept")+" ");
                System.out.println();
            }
            System.out.println("--------------");
//            String sql="INSERT into student values(2,'rafsan','cse')";
//            statement.executeUpdate(sql);
//            resultSet= statement.executeQuery("SELECT * from student");
//
//            while(resultSet.next()){
//                System.out.print(resultSet.getInt("sid")+" ");
//                System.out.print(resultSet.getString("name")+" ");
//                System.out.print(resultSet.getString("dept")+" ");
//                System.out.println();
//            }
            PreparedStatement preparedStatement;
            for(int i=3;i<5;++i){
                System.out.println("Enter name");
                String name=sc.nextLine();
                System.out.println("enter dept");
                String dept=sc.nextLine();
                String s="INSERT into student values(?,?,?)";
                preparedStatement =connection.prepareStatement(s);
                preparedStatement.setInt(1,i);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,dept);
                preparedStatement.executeUpdate();

            }
            resultSet= statement.executeQuery("SELECT * from student");

            while(resultSet.next()){
                System.out.print(resultSet.getInt("sid")+" ");
                System.out.print(resultSet.getString("name")+" ");
                System.out.print(resultSet.getString("dept")+" ");
                System.out.println();
            }
            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

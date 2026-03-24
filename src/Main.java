import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="RIBERA";
        String password="ribera";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             Statement statement = conn.createStatement()){
            String sql="INSERT INTO empleado2 (id, nombre, salario) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1,10);
            preparedStatement.setString(2, "Riber");
            preparedStatement.setDouble(3, 3500.0);
            int filas = preparedStatement.executeUpdate();
            System.out.println("Filas insertadas: " + filas);
        }catch (SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }

    }
}
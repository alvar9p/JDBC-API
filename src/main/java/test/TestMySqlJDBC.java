package test;

import java.sql.*;

// Para probar que la conexión funciona y lista los datos
public class TestMySqlJDBC {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "sasa";

        try {
            // Puede ser necesario
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, username,password);
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("ID Persona:  = " + resultado.getInt(1) + " | ");
                System.out.print("Nombre: " + resultado.getString("nombre") + " | ");
                System.out.print("Apellido:" + resultado.getString("apellido") + " | ");
                System.out.print("E-mail: " + resultado.getString("email") + " | ");
                System.out.print("Teléfono: " + resultado.getInt("telefono") + " | ");
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}
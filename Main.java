import java.sql.*;

public class Main {

    public void main (String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/pruebadb";
        String usuario = "root";
        String password = "mysterygamer567";
        Connection conexion = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, password);

            st = conexion.createStatement();

            rs = st.executeQuery("SELECT * FROM alumnos");

            while (rs.next()) {
                // Uso de ResultSet
                System.out.println("Nombre: " + rs.getString("nombre"));

                // Uso opcional de ResultSetMetaData (como dice el final del PDF)
                ResultSetMetaData rsmt = rs.getMetaData();
                System.out.println("Tipo de columna: " + rsmt.getColumnTypeName(2));
            }
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        } finally {
            // Cerramos siempre en el bloque finally para asegurar que ocurra
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conexion != null) conexion.close();
        }
    }
}
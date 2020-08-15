package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDataBaseRPG {
        public static void main(String[] args) {

            createDataBase();
        }

        private static void createDataBase() {


            CreateJogadores();
            CreateCampanha();
            CreateMesa();

    }

        public static void CreateMesa(){
            String sql = "CREATE TABLE \"Mesas\" (\n" +
                    "\t\"codeMesa\"\tINTEGER NOT NULL,\n" +
                    "\t\"NomeMestre\"\tTEXT,\n" +
                    "\t\"EmailMestre\"\tTEXT,\n" +
                    "\t\"Data\"\tDATETIME,\n" +
                    "\t\"IdadeMin\"\tINTEGER,\n" +
                    "\t\"LimiteJogador\"\tINTEGER,\n" +
                    "\t\"codeCampanha\"\tINTEGER NOT NULL,\n" +
                    "\tPRIMARY KEY(\"codeMesa\")\n" +
                    "\tFOREIGN KEY (\"codeCampanha\")\n" +
                    "\tREFERENCES Campanhas (\"codeCampanha\") \n" +
                    "\tON DELETE SET NULL\n" +
                    ")";
            try (Connection conn = DriverManager.getConnection(("jdbc:sqlite:RpgDeMesaSistema.db"));
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void CreateCampanha(){
            String sql = "CREATE TABLE \"Campanhas\"(\n"+
                    "\t\"codeCampanha\"\tINTEGER NOT NULL,\n" +
                    "\t\"nomeCampanha\"\tTEXT,\n" +
                    "\t\"descricao\"\tTEXT,\n" +
                    "\t\"numDados\"\tINTEGER,\n" +
                    "\t\"TipoDados\"\tTEXT,\n" +
                    "\t\"TipoRpg\"\tTEXT,\n" +
                    "\t\"codeMesa\"\tINTEGER NOT NULL,\n"+
                    "\tFOREIGN KEY (\"codeMesa\")\n" +
                    "\tREFERENCES Mesas (\"codeMesa\") \n" +
                    "\tPRIMARY KEY(\"codeCampanha\")\n" +
                    ")";
            try (Connection conn = DriverManager.getConnection(("jdbc:sqlite:RpgDeMesaSistema.db"));
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void CreateJogadores(){
            String sql = "CREATE TABLE \"Jogadores\"(\n"+
                    "\t\"codeJogador\"\tINTEGER NOT NULL,\n" +
                    "\t\"NomeJogador\"\tTEXT,\n" +
                    "\t\"NomePersonagem\"\tTEXT,\n" +
                    "\t\"email\"\tTEXT,\n" +
                    "\t\"Idade\"\tINTEGER,\n" +
                    "\t\"codeMesa\"\tINTEGER NOT NULL,\n"+
                    "\tPRIMARY KEY(\"codeJogador\")\n" +
                    "\tFOREIGN KEY (\"codeMesa\")\n" +
                    "\tREFERENCES Mesas (\"codeMesa\") \n" +
                    "\tON DELETE SET NULL\n" +
                    ")";
            try (Connection conn = DriverManager.getConnection(("jdbc:sqlite:RpgDeMesaSistema.db"));
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void AddDadosDataBase(){




        }

    }



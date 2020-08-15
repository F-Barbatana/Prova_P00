package View;


        import Controller.ControllerListarJogares;
        import Model.Mesa;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.layout.Pane;
        import javafx.stage.Modality;
        import javafx.stage.Stage;

        import java.io.IOException;

public class ListarJogadoresView {

    public void MostrarListarJogadoresEEsperar(){
        MostrarListarJogadoresEEsperar(null);
    }

    public void MostrarListarJogadoresEEsperar(Mesa mesa){
        FXMLLoader loader =new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("./ListarJogadores.fxml").openStream());
            Scene scene = new Scene(graph, 575, 450);
            ControllerListarJogares controle = loader.getController();

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Tabela de Jogadores");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        }catch (IOException e){
            e.printStackTrace();
        }



    }

}
package View;

import Controller.ControllerExibirDadosMesa;
import Controller.ControllerListarJogares;
import Model.Mesa;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ExibriDadosMesaView {

    public void MostrarDadosEEsperar(){
        MostrarDadosEEsperar(null);
    }

    public void MostrarDadosEEsperar(Mesa Mesa){
        FXMLLoader loader =new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("./ExibriDadosMesa.fxml").openStream());
            Scene scene = new Scene(graph, 275, 175);
            ControllerExibirDadosMesa controle = loader.getController();

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Dados da mesa");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        }catch (IOException e){
            e.printStackTrace();
        }



    }

}

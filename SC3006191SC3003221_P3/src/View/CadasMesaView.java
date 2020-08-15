package View;

import Controller.ControllerCadasMesa;
import Model.Mesa;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CadasMesaView {

    public void MostrarCadsEesperar(){
        MostrarCadsEesperar(null);
    }

    public void MostrarCadsEesperar(Mesa mesa){
        FXMLLoader loader =new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("./CadasMesa.fxml").openStream());
            Scene scene = new Scene(graph, 275, 175);

            ControllerCadasMesa controle = loader.getController();
            if (mesa != null){
                controle.SetValor(mesa);
            }

            Stage stage = new Stage();
            stage.setScene(scene);
            if(mesa!=null){stage.setTitle("Editar Mesa");}else{stage.setTitle("Cadastrar Mesa");}
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}

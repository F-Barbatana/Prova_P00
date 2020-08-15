package View;


import Controller.ControllerCadsJogador;
import Model.Jogador;
import Model.Mesa;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CadasJogadorView {
    public void MostrarCadsJogadorEesperar(Mesa mesa){
        MostrarCadsJogadorEesperar(null, mesa);
    }

    public void MostrarCadsJogadorEesperar(Jogador jogador, Mesa mesa){
        FXMLLoader loader =new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("./CadasJogador.fxml").openStream());
            Scene scene = new Scene(graph, 275, 175);

            ControllerCadsJogador controle = loader.getController();
            if (jogador != null){
                controle.SetValor(jogador);
            }

            Stage stage = new Stage();
            stage.setScene(scene);
            if(jogador!=null){stage.setTitle("Editar Jogador");}else{stage.setTitle("Cadastrar Jogador");}
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}

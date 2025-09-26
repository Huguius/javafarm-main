package br.com.joaocarloslima;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

    private Fazenda fazenda = new Fazenda();
    private List<ImageView> imageTerrenos = new ArrayList<>();
    private int sleepTime = 3000;

    @FXML
    GridPane grid;
    @FXML
    ToggleButton botaoBatata;
    @FXML
    ToggleButton botaoCenoura;
    @FXML
    ToggleButton botaoMorango;
    @FXML
    ToggleButton botaoColher;
    @FXML
    ProgressBar ocupacaoDoCeleiro;
    @FXML
    CheckBox ckbAcelerar;

    public void atualizar() {
        botaoBatata.setText("Batata x " + fazenda.getCeleiro().getQtdeBatatas());
        botaoCenoura.setText("Cenoura x " + fazenda.getCeleiro().getQtdeCenouras());
        botaoMorango.setText("Morango x " + fazenda.getCeleiro().getQtdeMorangos());
        ocupacaoDoCeleiro.setProgress(fazenda.getCeleiro().getOcupacao());

        for (int i = 0; i < imageTerrenos.size(); i++) {
            int x = i / 13;
            int y = i % 13;
            Terreno terreno = fazenda.getTerreno(x, y);
            ImageView imageView = imageTerrenos.get(i);

            Planta planta = terreno.getPlanta();
            if (planta != null) {
                imageView.setImage(new Image(getClass().getResourceAsStream(planta.getImagem())));
            } else {
                imageView.setImage(null);
            }
        }
    }

    public void ciclo() {

        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 13; y++) {
                Terreno terreno = fazenda.getTerreno(x, y);

                Planta planta = terreno.getPlanta();
                if (planta != null) {
                    planta.crescer();
                }
            }
        }

        Platform.runLater(this::atualizar);
    }

    public void acelerar() {
        sleepTime = ckbAcelerar.isSelected() ? 1000 : 3000;
    }

    public void clockThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(sleepTime);
                    ciclo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        for (int i = 0; i < 13 * 13; i++) {
            ImageView imageView = new ImageView();
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            grid.add(imageView, i / 13, i % 13);
            imageTerrenos.add(imageView);
        }

        grid.setOnMouseClicked(e -> {
            int x = (int) (e.getX() / 50);
            int y = (int) (e.getY() / 50);

            try {
                if (botaoBatata.isSelected())
                    fazenda.plantarBatata(x, y);
                else if (botaoCenoura.isSelected())
                    fazenda.plantarCenoura(x, y);
                else if (botaoMorango.isSelected())
                    fazenda.plantarMorango(x, y);
                else if (botaoColher.isSelected())
                    fazenda.colher(x, y);

                atualizar();

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atenção");
                alert.setHeaderText(ex.getMessage());
                alert.show();
            }
        });

        atualizar();
        clockThread();
    }
}
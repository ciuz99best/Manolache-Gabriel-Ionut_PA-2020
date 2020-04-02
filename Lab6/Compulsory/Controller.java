package sample;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.util.Random;


public class Controller  {
    @FXML private Canvas canvas;
    @FXML
    private TextField textBox;
    private Integer size=70;
    private Stage stage;
    public void changeSize(ActionEvent actionEvent) {
        try {
            size=Integer.parseInt(textBox.getText());
            if(size<=0) {
                size = 50;
                textBox.setText("50");
            }
        } catch (NumberFormatException e) {
            size = 50;
            textBox.setText("50");
        }
    }
    public void setStage(Stage stage)
    {
        this.stage=stage;
    }
    public void drawCircle(MouseEvent mouseEvent) {
        GraphicsContext gc=canvas.getGraphicsContext2D();
        double x,y;
        x=mouseEvent.getX();
        y=mouseEvent.getY();
        Random rand = new Random();
        int r,g,b;
        r=rand.nextInt(256);
        g=rand.nextInt(256);
        b=rand.nextInt(256);
        gc.setLineWidth(1);
        gc.setStroke(Color.rgb(r,g,b));
        gc.setFill(Color.rgb(r,g,b));
        gc.strokeOval(x-size/2,y-size/2, size, size);
        gc.fillOval(x-size/2,y-size/2, size, size);
    }

    public void clearCanvas(ActionEvent actionEvent) {
        GraphicsContext gc=canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void saveCanvas(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        WritableImage image = canvas.snapshot(new SnapshotParameters(), null);
        File file = fileChooser.showSaveDialog(stage);
        try
        {
            if(file != null)
            {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            }
        } catch (IOException ex)
        {
            System.out.println(ex.toString());
        }
    }

    public void loadCanvas(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        GraphicsContext gc=canvas.getGraphicsContext2D();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);
        Image image1 = null;
        if(file != null)
        {
            image1 = new Image(file.toURI().toString());
        }
        if(image1!=null)
        gc.drawImage(image1,0,0,image1.getWidth(),image1.getHeight());
    }

    public void exitCanvas(ActionEvent actionEvent) {
        stage.close();
    }
}
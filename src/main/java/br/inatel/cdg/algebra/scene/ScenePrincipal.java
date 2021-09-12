package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.scene.Ponto;
import br.inatel.cdg.algebra.scene.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnTeste; //Button representa botoes
    private Label labelTeste1, labelP1X, labelP1Y, labelP2X, labelP2Y; //Label representam rótulos
    private TextField  textOut1, textOut2, textIn1, textIn2, textIn3, textIn4; //TextField Representam áreas de texto

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        labelTeste1 = new Label("Entre com as coordenadas dos pontos:");
        labelP1X = new Label("P1.x:");
        textIn1 = new TextField();
        labelP1Y = new Label("P1.y:");
        textIn2 = new TextField();
        labelP2X = new Label("P2.x:");
        textIn3 = new TextField();
        labelP2Y = new Label("P2.y:");
        textIn4 = new TextField();

        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontal1 = new HBox(labelP1X, textIn1);
        HBox grupoHorizontal2 = new HBox(labelP1Y, textIn2);
        HBox grupoHorizontal3 = new HBox(labelP2X, textIn3);
        HBox grupoHorizontal4 = new HBox(labelP2Y, textIn4);


        //Agora vamos criar a area que mostrará o que foi digitado
        textOut1 = new TextField();
        textOut1.setEditable(false);//vamos deixar false para apenas mostrar texto
        textOut1.setText("Coef Angular: ");
        textOut2 = new TextField();
        textOut2.setEditable(false);//vamos deixar false para apenas mostrar texto
        textOut2.setText("Coef Linear: ");

        //Criamos o botão
        btnTeste = new Button("Calcular");
        //Criamos a ação que o botão responderá as ser pressionado
        btnTeste.setOnAction(evento -> {
            Ponto p1 = new Ponto(Double.parseDouble(textIn1.getText()), Double.parseDouble(textIn2.getText()));
            Ponto p2 = new Ponto(Double.parseDouble(textIn3.getText()), Double.parseDouble(textIn4.getText()));
            Reta reta = new Reta(p1,p2);
            textOut1.setText(Double.toString(reta.coefAng()));
            textOut2.setText(Double.toString(reta.coefLinear()));
        });
        HBox botao = new HBox(btnTeste);
        HBox grupoHorizontal5 = new HBox(textOut1, textOut2);

        VBox layoutFinal = new VBox(grupoHorizontal1,grupoHorizontal2,grupoHorizontal3,grupoHorizontal4,botao,grupoHorizontal5);
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

}
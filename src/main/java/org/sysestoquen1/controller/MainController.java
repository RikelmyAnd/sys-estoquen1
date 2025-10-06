package org.sysestoquen1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.sysestoquen1.model.Produto;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private TableView<Produto> tableViewProdutos;
    @FXML
    private TableColumn<Produto, String> tableColumnNome;
    @FXML
    private TableColumn<Produto, Double>  tableColumnPreco;
    @FXML
    private TableColumn<Produto, Integer> tableColumnQuantidade;
    @FXML
    private Label labelValorTotal;

    public float calcularValorTotal(float preco, int quantidade) {
        return 0;

    }

    private List<Produto> listProdutos = new ArrayList<>();
    private ObservableList<Produto> observableProdutos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        tableColumnPreco.setCellValueFactory( new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory( new PropertyValueFactory<>("quantidade"));

        carregarProdutos();

    }

    public void carregarProdutos(){

        Produto produto1 = new Produto("Bola", 13.5, 45);
        Produto produto2 = new Produto("Calça Caqui", 109.48, 67);
        Produto produto3 = new Produto("Camisinha", 0, 200);

        listProdutos.add(produto1);
        listProdutos.add(produto2);
        listProdutos.add(produto3);

        observableProdutos = FXCollections.observableArrayList(listProdutos);

        tableViewProdutos.setItems(observableProdutos);
    }
}

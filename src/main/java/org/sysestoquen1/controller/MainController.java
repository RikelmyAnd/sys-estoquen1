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
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
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

    private List<Produto> listProdutos = new ArrayList<>();
    private ObservableList<Produto> observableProdutos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        tableColumnPreco.setCellValueFactory( new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory( new PropertyValueFactory<>("quantidade"));

        carregarProdutos();

        double valorTotal = calcularTotal();

        DecimalFormat df = new DecimalFormat();

        df.applyPattern("#0.00");
        labelValorTotal.setText("R$" + df.format(valorTotal));

    }

    public void carregarProdutos(){

        Produto produto1 = new Produto("Bola", 13.5, 45);
        Produto produto2 = new Produto("Calça Caqui", 109.48, 67);
        Produto produto3 = new Produto("Camisinha", 0, 3000);
        Produto produto4 = new Produto("Hipoglós", 75.99, 45);
        Produto produto5 = new Produto("Papel", 15.89, 70);
        Produto produto6 = new Produto("Vaselina", 7.5, 500);
        Produto produto7 = new Produto("Pepino", 22.5, 400);
        Produto produto8 = new Produto("Óleo de bebê", 40.5, 2000);

        listProdutos.add(produto1);
        listProdutos.add(produto2);
        listProdutos.add(produto3);
        listProdutos.add(produto4);
        listProdutos.add(produto5);
        listProdutos.add(produto6);
        listProdutos.add(produto7);
        listProdutos.add(produto8);

        observableProdutos = FXCollections.observableArrayList(listProdutos);

        tableViewProdutos.setItems(observableProdutos);


    }

    public double calcularTotal() {
        double valorTotal = 0;

        for (Produto produto : listProdutos) {
            valorTotal += produto.getPreco()*produto.getQuantidade();
        }
        return valorTotal;
    }
}

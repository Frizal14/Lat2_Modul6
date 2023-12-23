package com.example.laitihanm_2jfx;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

public class Main extends Application {

    private TableView table = new TableView();
    private ObservableList<Mahasiswa> data;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        stage.setTitle("Test TableView");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial", 30));

        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Nama");
        TableColumn nimCol = new TableColumn("NIM");
        TableColumn emailCol = new TableColumn("Email");

        table.getColumns().addAll(nameCol, nimCol, emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20, 10, 10, 10));
        vbox.getChildren().addAll(label, table);

        final TextField addName = new TextField();
        addName.setMaxWidth(nameCol.getPrefWidth());
        addName.setPromptText("Nama Mahasiswa");

        final TextField addNim = new TextField();
        addNim.setMaxWidth(nimCol.getPrefWidth());
        addNim.setPromptText("NIM");

        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        final Button addButton = new Button("Add");

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                data.add(new Mahasiswa(
                        addName.getText(),
                        addNim.getText(),
                        addEmail.getText()
                ));
                addName.clear();
                addNim.clear();
                addEmail.clear();
            }
        });

        final HBox hboxInput = new HBox();
        hboxInput.getChildren().addAll(addName, addNim, addEmail, addButton);
        hboxInput.setSpacing(10);

        vbox.getChildren().add(hboxInput);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

        data = FXCollections.observableArrayList(
                new Mahasiswa("Berryl", "202210370311122", "berrylkontol@gmail.com"),
                new Mahasiswa("Fazza", "202210370311120", "Fazzaasu@gmail.com")
        );

        nameCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("name")
        );

        nimCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("nim")
        );

        emailCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("email")
        );

        table.setItems(data);
    }

    public static class Mahasiswa {

        private final SimpleStringProperty name;
        private final SimpleStringProperty nim;
        private final SimpleStringProperty email;

        private Mahasiswa(String name, String nim, String email) {
            this.name = new SimpleStringProperty(name);
            this.nim = new SimpleStringProperty(nim);
            this.email = new SimpleStringProperty(email);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String fName) {
            name.set(fName);
        }

        public String getNim() {
            return nim.get();
        }

        public void setNim(String fName) {
            nim.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }
    }
}
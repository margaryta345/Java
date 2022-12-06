package com.example.studentgroupapp;

import com.example.studentgroupapp.model.Person;
import com.example.studentgroupapp.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class PersonOverviewController {
    @FXML
    private TableView<Person>personTable;
    @FXML
    private TableColumn<Person,String>firstNameColumn;
    @FXML
    private TableColumn<Person,String>lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label groupCodeLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label avrgGradeLabel;

    private Main mainApp;

    public PersonOverviewController(){
    }
    @FXML
    private void initialize(){
        firstNameColumn.setCellValueFactory(cellData ->cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData ->cellData.getValue().lastNameProperty());
        showPersonDetails(null);

        personTable.getSelectionModel().selectedIndexProperty().addListener((observable,oldValue, newValue)-> showPersonDetails(newValue));
    }
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(mainApp.getPersonData());
    }
    public void showPersonDetails(Person person){
        if(person !=null){
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            groupCodeLabel.setText(String.valueOf(person.getGroupCode()));
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            avrgGradeLabel.setText(String.valueOf(person.getAvrgGrafe()));
        }else{
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            groupCodeLabel.setText("");
            birthdayLabel.setText("");
            avrgGradeLabel.setText("");
        }
        }
    public void handleDeletePerson(){
        Alert alertConfirm = new Alert(Alert.AlertType.CONFIRMATION);
        alertConfirm.setTitle("Are you sure");
        alertConfirm.setContentText("Delete?");
        ButtonType yesButton = new ButtonType("yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("no", ButtonBar.ButtonData.NO);
        alertConfirm.getButtonTypes().setAll(yesButton, noButton);
        alertConfirm.showAndWait().ifPresent(type ->{
            if(type ==yesButton){
                int selectedIndex =personTable.getSelectionModel().getSelectedIndex();
                if(selectedIndex >=0){
                    personTable.getItems().remove(selectedIndex);
                }else{

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(mainApp.getPrimaryStage());
                    alert.setTitle("No Selection");
                    alert.setHeaderText("No person selected");
                    alert.setContentText("Please select a person in the table");
                    alert.showAndWait();

                }
            }
        });
    }
    private void handleNewPerson(){
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if(okClicked){
            mainApp.getPersonData().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson(){
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if(selectedPerson != null){
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if(okClicked){
                showPersonDetails(selectedPerson);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("no selection");
            alert.setHeaderText("No Person selected");
            alert.setContentText("Please select a person in the table");
            alert.showAndWait();
        }
    }


}

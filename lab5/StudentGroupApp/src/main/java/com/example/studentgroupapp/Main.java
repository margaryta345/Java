package com.example.studentgroupapp;

import com.example.studentgroupapp.model.Person;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    public Main(){
        personData.add(new Person("Петро","П'яточкин",128.5));
        personData.add(new Person("Іван","Зайців",189.92));
        personData.add(new Person("Катерина","Васильченко",100));
        personData.add(new Person("Ольга","Жук",199.41));
        personData.add(new Person("Людміла","Алексєєва",175.68));
        personData.add(new Person("Даніл","Кац",200));
        personData.add(new Person("Євген","Васнецов",123.2));
        personData.add(new Person("Дмитро","Жуликів",108.1));
        personData.add(new Person("Мрат","Алібов",182.5));
        personData.add(new Person("Martin","Mueller",168.65));
    }

    public ObservableList<Person> getPersonData(){
        return personData;
    }



    @Override
    public void start(Stage stage)throws IOException {
        this.primaryStage =stage;
        this.primaryStage.setTitle("StudentGroupApp");

        initRootLayout();
        ShowPersonOverview();

    }
    public void initRootLayout(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/example/studentgroupapp/view/RootLayout.fxml"));

        try{
            rootLayout =fxmlLoader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void ShowPersonOverview(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("/com/example/studentgroupapp/view/PersonOverview.fxml"));
        try{
            AnchorPane personOverview = fxmlLoader.load();
            rootLayout.setCenter(personOverview);
            PersonOverviewController controller = fxmlLoader.getController();
            controller.setMainApp(this);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public boolean showPersonEditDialog(Person person){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/com/example/studentgroupapp/view/PersonEditDialog.fxml"));
            AnchorPane page =loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene =new Scene(page);
            dialogStage.setScene(scene);
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
            dialogStage.showAndWait();
            return  controller.isOkClicked();
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}

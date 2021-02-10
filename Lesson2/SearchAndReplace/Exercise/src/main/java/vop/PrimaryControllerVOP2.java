package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.*;
import java.util.Scanner;

public class PrimaryControllerVOP2 {



    @FXML
    Button erstat, aaben, gemSom;
    @FXML
    TextField searchField, erstatField;
    @FXML
    TextArea textInput;

    @FXML
    public void erstatAlle() {
        String search = searchField.getText();
        String replace = erstatField.getText();
        String scanText = textInput.getText();
        Scanner inputStream = null;

        try{
            inputStream = new Scanner(scanText);
        }
        catch (Exception e){
            System.out.println("stupid");
            System.exit(0);
        }
        while (inputStream.hasNextLine()){
            inputStream.nextLine();
            textInput.setText(textInput.getText().replace(search, replace)+ "\n");
        }

    }

    @FXML
    public void open() {
        FileChooser choseFile = new FileChooser();
        File selectedFile = choseFile.showOpenDialog(null);

        //guard clause
        if (selectedFile == null){
            return;
        }

        Scanner inputStream = null;


        try {

            inputStream = new Scanner(selectedFile);
            //inputStream = new Scanner(new File("C:\\Users\\iceha\\OneDrive\\Skrivebord\\VOP\\exercises\\Lesson2\\SearchAndReplace\\Exercise\\src\\main\\resources\\vop\\HelloWorld.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("Error opening the file ");
            System.exit(0);
        }
        while (inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            //StringBuilder builder = new StringBuilder();
            //læser text fra fil i field
            //if(line.length() !=0 && !line.equals("")) builder.append(line);
            textInput.setText(textInput.getText() + line + "\n");
        }

        inputStream.close();
    }

    @FXML
    public void saveAs () {

        FileChooser choseFile = new FileChooser();
        File selectedFile = choseFile.showSaveDialog(null);
        if (selectedFile == null){
            return;
        }

        String text = textInput.getText();
        BufferedWriter output = null;
        try {
            File file = selectedFile;
            //File file = new File("C:\\Users\\iceha\\OneDrive\\Skrivebord\\VOP\\exercises\\Lesson2\\SearchAndReplace\\Exercise\\src\\main\\resources\\vop\\HelloMoon.txt");
            output = new BufferedWriter(new FileWriter(file, true));
            output.write(text);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}

package desktopcleaner;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// @author Ľudovít "Luigi" Kováč
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField prefixTextField;

    @FXML
    private Label label;

    @FXML
    private CheckBox chBoxPictures;

    @FXML
    private CheckBox chBoxVideos;

    @FXML
    private CheckBox chBoxDocuments;

    @FXML
    private CheckBox chBoxMusic;

    @FXML
    private CheckBox chBoxNotepad;

    @FXML
    private CheckBox chBoxCompressed;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        label.setText("");

        String prefix = prefixTextField.getText();

        if (prefix.endsWith("_")) {

        } else {

            prefix = prefix + "_";

        }
        try {

            if (chBoxDocuments.isSelected()) {

                new File(System.getProperty("user.home") + "/desktop/" + prefix + "Documents").mkdirs();
            }

            if (chBoxMusic.isSelected()) {

                new File(System.getProperty("user.home") + "/desktop/" + prefix + "Music").mkdirs();
            }

            if (chBoxPictures.isSelected()) {

                new File(System.getProperty("user.home") + "/desktop/" + prefix + "Pictures").mkdirs();

            }

            if (chBoxVideos.isSelected()) {

                new File(System.getProperty("user.home") + "/desktop/" + prefix + "Videos").mkdirs();

            }

            if (chBoxNotepad.isSelected()) {

                new File(System.getProperty("user.home") + "/desktop" + "/" + prefix + "Notepads").mkdirs();
            }

            if (chBoxCompressed.isSelected()) {

                new File(System.getProperty("user.home") + "/desktop/" + prefix + "Compressed").mkdirs();

            }
        } catch (Exception e) {
        }

        File[] files = new File(System.getProperty("user.home") + "/desktop").listFiles();

        for (File file : files) {
            try {
                if (chBoxDocuments.isSelected()) {

                    if (file.toString().endsWith(".pdf") || file.toString().endsWith(".doc") || file.toString().endsWith(".docx")
                            || file.toString().endsWith(".xls") || file.toString().endsWith(".xlsx") || file.toString().endsWith(".rtf")) {

                        Path fileMove = Paths.get(System.getProperty("user.home") + "/desktop/" + prefix + "Documents/" + file.getName());

                        Files.move(file.toPath(), fileMove, StandardCopyOption.REPLACE_EXISTING);

                    }

                }

                if (chBoxMusic.isSelected()) {

                    if (file.toString().endsWith(".mp3") || file.toString().endsWith(".wav") || file.toString().endsWith(".flac") || file.toString().endsWith(".wma")) {

                        Path fileMove = Paths.get(System.getProperty("user.home") + "/desktop/" + prefix + "Music/" + file.getName());

                        Files.move(file.toPath(), fileMove, StandardCopyOption.REPLACE_EXISTING);

                    }
                }

                if (chBoxPictures.isSelected()) {

                    if (file.toString().endsWith(".jpg") || file.toString().endsWith(".jpeg") || file.toString().endsWith(".gif")
                            || file.toString().endsWith(".bmp") || file.toString().endsWith(".png")) {

                        Path fileMove = Paths.get(System.getProperty("user.home") + "/desktop/" + prefix + "Pictures/" + file.getName());

                        Files.move(file.toPath(), fileMove, StandardCopyOption.REPLACE_EXISTING);

                    }
                }

                if (chBoxVideos.isSelected()) {
                    if (file.toString().endsWith(".mp4") || file.toString().endsWith(".avi") || file.toString().endsWith(".3gp") || file.toString().endsWith(".mpeg")
                            || file.toString().endsWith(".mpg")) {

                        Path fileMove = Paths.get(System.getProperty("user.home") + "/desktop/" + prefix + "Videos/" + file.getName());

                        Files.move(file.toPath(), fileMove, StandardCopyOption.REPLACE_EXISTING);

                    }
                }

                if (chBoxNotepad.isSelected()) {

                    if (file.toString().endsWith(".txt")) {

                        Path fileMove = Paths.get(System.getProperty("user.home") + "/desktop/" + prefix + "Notepads/" + file.getName());

                        Files.move(file.toPath(), fileMove, StandardCopyOption.REPLACE_EXISTING);

                    }
                }

                if (chBoxCompressed.isSelected()) {

                    if (file.toString().endsWith(".zip") || file.toString().endsWith(".cab") || file.toString().endsWith(".7z") || file.toString().endsWith(".ace")
                            || file.toString().endsWith(".alz") || file.toString().endsWith(".arj") || file.toString().endsWith(".bz2")
                            || file.toString().endsWith(".bzip2") || file.toString().endsWith(".gzip") || file.toString().endsWith(".rar")
                            || file.toString().endsWith(".tar") || file.toString().endsWith(".tar.gz") || file.toString().endsWith(".lzma")
                            || file.toString().endsWith(".lzip")) {

                        Path fileMove = Paths.get(System.getProperty("user.home") + "/desktop/" + prefix + "Compressed/" + file.getName());

                        Files.move(file.toPath(), fileMove, StandardCopyOption.REPLACE_EXISTING);

                    }
                }
            } catch (Exception e) {

            }
        }

        if (label.getText().equals("")) {
            label.setText("Done.");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

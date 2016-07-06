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
    private CheckBox usePrefix;

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
    private CheckBox chBoxCompressed;

    private String prefix;

    private void createFolder(String FolderType) {

        new File(System.getProperty("user.home") + "/desktop/" + prefix + FolderType).mkdirs();

    }

    private void moveToFolder(File file, String FolderType) throws IOException {

        Path fileMove = Paths.get(System.getProperty("user.home") + "/desktop/" + prefix + FolderType + "/" + file.getName());

        Files.move(file.toPath(), fileMove, StandardCopyOption.REPLACE_EXISTING);

    }

    @FXML
    private void usePrefixMethod(ActionEvent event) {

        if (usePrefix.isSelected()) {
            prefixTextField.setText("DC_");
            prefixTextField.setDisable(false);

        } else {
            prefixTextField.setText("");
            prefixTextField.setDisable(true);

        }

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        label.setText("");

        if (usePrefix.isSelected()) {

            prefix = prefixTextField.getText();

            if (prefix.endsWith("_")) {

            } else {

                prefix = prefix + "_";

            }

        } else {

            prefix = "";

        }

        try {

            if (chBoxDocuments.isSelected()) {

                createFolder("Documents");
            }

            if (chBoxMusic.isSelected()) {

                createFolder("Music");
            }

            if (chBoxPictures.isSelected()) {

                createFolder("Pictures");
            }

            if (chBoxVideos.isSelected()) {

                createFolder("Videos");
            }

            if (chBoxCompressed.isSelected()) {

                createFolder("Compressed");

            }

        } catch (Exception e) {

        }

        File[] Desktopfiles = new File(System.getProperty("user.home") + "/desktop").listFiles();

        for (File file : Desktopfiles) {

            try {

                if (chBoxDocuments.isSelected()) {

                    if (file.toString().endsWith(".pdf")
                            || file.toString().endsWith(".txt")
                            || file.toString().endsWith(".doc")
                            || file.toString().endsWith(".docx")
                            || file.toString().endsWith(".xls")
                            || file.toString().endsWith(".xlsx")
                            || file.toString().endsWith(".ppt")
                            || file.toString().endsWith(".pptx")
                            || file.toString().endsWith(".rtf")) {

                        moveToFolder(file, "Documents");

                    }

                }

                if (chBoxMusic.isSelected()) {

                    if (file.toString().endsWith(".mp3")
                            || file.toString().endsWith(".wav")
                            || file.toString().endsWith(".flac")
                            || file.toString().endsWith(".wma")) {

                        moveToFolder(file, "Music");

                    }
                }

                if (chBoxPictures.isSelected()) {

                    if (file.toString().endsWith(".jpg")
                            || file.toString().endsWith(".jpeg")
                            || file.toString().endsWith(".gif")
                            || file.toString().endsWith(".bmp")
                            || file.toString().endsWith(".png")) {

                        moveToFolder(file, "Pictures");

                    }

                }

                if (chBoxVideos.isSelected()) {
                    if (file.toString().endsWith(".mp4")
                            || file.toString().endsWith(".avi")
                            || file.toString().endsWith(".3gp")
                            || file.toString().endsWith(".mpeg")
                            || file.toString().endsWith(".mpg")
                            || file.toString().endsWith(".mkv")
                            || file.toString().endsWith(".m4v")
                            || file.toString().endsWith(".flv")
                            || file.toString().endsWith(".srt")) {

                        moveToFolder(file, "Videos");

                    }
                }

                if (chBoxCompressed.isSelected()) {

                    if (file.toString().endsWith(".zip")
                            || file.toString().endsWith(".rar")
                            || file.toString().endsWith(".7z")
                            || file.toString().endsWith(".cab")
                            || file.toString().endsWith(".ace")
                            || file.toString().endsWith(".alz")
                            || file.toString().endsWith(".arj")
                            || file.toString().endsWith(".bz2")
                            || file.toString().endsWith(".bzip2")
                            || file.toString().endsWith(".gzip")
                            || file.toString().endsWith(".tar")
                            || file.toString().endsWith(".tar.gz")
                            || file.toString().endsWith(".lzma")
                            || file.toString().endsWith(".lzip")) {

                        moveToFolder(file, "Compressed");

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

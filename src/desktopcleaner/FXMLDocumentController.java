package desktopcleaner;
// @author Ľudovít "Luigi" Kováč

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

    File[] Desktopfiles = new File(System.getProperty("user.home") + "/desktop").listFiles();

    String[] documentSuffixes = {".pdf", ".txt", ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".rtf"};
    String[] musicSuffixes = {".mp3", ".wav", ".flac", ".wma"};
    String[] pictureSuffixes = {".jpg", ".jpeg", ".gif", ".bmp", ".png"};
    String[] VideoSuffixes = {".mp4", ".avi", ".3gp", ".mpeg", ".mpg", ".mkv", ".m4v", ".flv", ".srt"};
    String[] CompressedSuffixes = {".zip", ".rar", ".7z", ".cab", ".ace", ".alz", ".arj", ".bz2", ".bzip2", ".gzip", ".tar", ".tar.gz", ".lzma", ".lzip"};

    private void createFolder(String FolderType) {

        new File(System.getProperty("user.home") + "/desktop/" + prefix + FolderType).mkdirs();

    }

    private void suffixCompare(File file, CheckBox checkBoxName, String[] fieldOfSuffixs, String typeOfFile) throws IOException {

        if (checkBoxName.isSelected()) {

            for (String string : fieldOfSuffixs) {

                if (file.toString().endsWith(string)) {

                    moveToFolder(file, typeOfFile);

                }

            }

        }

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
    private void handleButtonAction(ActionEvent event) throws IOException, InterruptedException {

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

        for (File file : Desktopfiles) {

            try {

                if (chBoxDocuments.isSelected()) {

                    suffixCompare(file, chBoxDocuments, documentSuffixes, "Documents");

                }

                if (chBoxMusic.isSelected()) {

                    suffixCompare(file, chBoxMusic, musicSuffixes, "Music");
                }

                if (chBoxPictures.isSelected()) {

                    suffixCompare(file, chBoxPictures, pictureSuffixes, "Pictures");

                }

                if (chBoxVideos.isSelected()) {

                    suffixCompare(file, chBoxVideos, VideoSuffixes, "Videos");

                }

                if (chBoxCompressed.isSelected()) {

                    suffixCompare(file, chBoxCompressed, CompressedSuffixes, "Compressed");
                }
            } catch (Exception e) {

            }
        }
        label.setText("Done.");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

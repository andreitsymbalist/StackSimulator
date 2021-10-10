package eu.grsu.stacksimulator.utils.filemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileManagerImpl implements FileManager {
    private final String dataBasePath;

    @Autowired
    public FileManagerImpl(@Value("${dataBasePath}") String dataBasePath) {
        this.dataBasePath = dataBasePath;
    }

    @Override
    public List<String> readLines() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(dataBasePath));
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        return lines;
    }
}

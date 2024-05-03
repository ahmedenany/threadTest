package performanceTest.file.imp;

import performanceTest.file.FileService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileServiceImpl implements FileService {
    @Override
    public void writeToTextFile(String basePath, String[] chunk) {
        for (String line : chunk) {
            if (line != null) {
                String fileName = basePath + line.split(",")[0] + ".txt";
                String content = line.split(",")[0]; // Assuming the content is the same as the file name

                File file = new File(fileName);

                try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                    fileOutputStream.write(content.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException("Error writing to file: " + fileName, e);
                }
            }
        }
    }

    @Override
    public void writeToTextFile(String basePath, String line) {

            if (line == null) {
                throw new IllegalArgumentException("Line cannot be null");
            }

            String fileName = basePath + line.split(",")[0] + ".txt";
            String content = line.split(",")[0]; // Assuming the content is the same as the file name

            File file = new File(fileName);

            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                fileOutputStream.write(content.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error writing to file: " + fileName, e);
            }
        }
    }


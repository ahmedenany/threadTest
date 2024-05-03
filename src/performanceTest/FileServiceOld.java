package performanceTest;

import performanceTest.file.FileService;
import performanceTest.file.imp.FileServiceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;

public class FileServiceOld {
    public static void main(String[] args) throws IOException {
        Files.createDirectories(Paths.get("c://files"));
        FileService fileService = new FileServiceImpl();
        long startTime = Instant.now().toEpochMilli();
        String csvFile = "src/performanceTest/resourses/customers-100000.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header if present
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                fileService.writeToTextFile("c://files/", line);
            }
            long endTime = Instant.now().toEpochMilli();
            System.out.println("Total time taken: " + (endTime - startTime) / 1000 + " seconds");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

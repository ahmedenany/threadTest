package performanceTest.file;

public interface FileService {
    void writeToTextFile(String basePath, String[] chunk);
    void writeToTextFile(String basePath, String line);
}

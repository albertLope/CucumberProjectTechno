package Utilities;



public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ReadProperties configFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance( ) {
        return fileReaderManager;
    }

    public ReadProperties getConfigReader() {
        return (configFileReader == null) ? new ReadProperties() : configFileReader;
    }
}

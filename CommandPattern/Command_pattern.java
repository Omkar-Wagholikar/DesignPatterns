// Command Interface
interface ICommand {
    void execute(String path);
}

// Receiver Interface
interface IFileSystem {
    void openFile(String path);
    void closeFile(String path);
}

// Receivers
class UnixFileSystem implements IFileSystem {
    
    @Override
    public void openFile(String path) {
        System.out.println("method 'openFile' on the UnixFileSystem, opening: " + path);
    }

    @Override
    public void closeFile(String path) {
        System.out.println("method 'closeFile' on the UnixFileSystem, closing: " + path);
    }
}
class WindowsFileSystem implements IFileSystem {
    
    @Override
    public void openFile(String path) {
        System.out.println("method 'openFile' on the WindowsFileSystem, opening: " + path);
    }
    
    @Override
    public void closeFile(String path) {
        System.out.println("method 'closeFile' on the WindowsFileSystem, closing: " + path);
    }
}

// Concrete Command Classes
class OpenFileCommand implements ICommand {
    private final IFileSystem fileSystem;

    public OpenFileCommand(IFileSystem fileSystem){
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String path) {
        fileSystem.openFile(path);
    }
}


class CloseFileCommand implements ICommand {
    private final IFileSystem fileSystem;

    public CloseFileCommand(IFileSystem fileSystem){
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String path) {
        fileSystem.closeFile(path);
    }
}

// Invoker class 
class FileOperationInvoker {
    private final ICommand command;
    private final String path;
    public FileOperationInvoker(String path, ICommand command) {
        this.command = command;
        this.path = path;
    }

    public void executeCommand() {
        command.execute(path);
    }
}

// Utility Class
class FileSystemUtil {
    public static IFileSystem getUnderlyingFileSystem() { 
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            System.out.println("Detected Windows OS. Using WindowsFileSystem.");
            return new WindowsFileSystem();
        } else if (osName.contains("linux") || osName.contains("unix")) {
            System.out.println("Detected Unix/Linux OS. Using UnixFileSystem.");
            return new UnixFileSystem();
        } else {
            System.out.println("Unknown OS detected: " + osName + ". Defaulting to UnixFileSystem.");
            return new UnixFileSystem(); // Default to Unix or throw an exception
        }
    }
}


public class Command {
    public static void main(String[] args) {
        IFileSystem fs = FileSystemUtil.getUnderlyingFileSystem();
        ICommand openConfig = new OpenFileCommand(fs);
        ICommand closeConfig = new CloseFileCommand(fs);
        
        String path = "/path/to/file";
        
        FileOperationInvoker fileOpen = new FileOperationInvoker(path, openConfig);
        FileOperationInvoker closeOpen = new FileOperationInvoker(path,closeConfig);

        fileOpen.executeCommand();
        closeOpen.executeCommand();
    }
}

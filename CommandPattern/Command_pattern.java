// Command Interface
interface ICommand {
    void execute();
}

// Receiver Interface
interface IFileSystem {
    void openFile();
    void closeFile();
}

// Receivers
class UnixFileSystem implements IFileSystem {
    
    @Override
    public void openFile() {
        System.out.println("method 'openFile' on the UnixFileSystem");
    }

    @Override
    public void closeFile() {
        System.out.println("method 'closeFile' on the UnixFileSystem");
    }
}
class WindowsFileSystem implements IFileSystem {
    
    @Override
    public void openFile() {
        System.out.println("method 'openFile' on the WindowsFileSystem");
    }
    
    @Override
    public void closeFile() {
        System.out.println("method 'closeFile' on the WindowsFileSystem");
    }
}

// Concrete Command Classes
class OpenFileCommand implements ICommand {
    private final IFileSystem fileSystem;

    public OpenFileCommand(IFileSystem fileSystem){
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        fileSystem.openFile();
    }
}


class CloseFileCommand implements ICommand {
    private final IFileSystem fileSystem;

    public CloseFileCommand(IFileSystem fileSystem){
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        fileSystem.closeFile();
    }
}

// Invoker class 
class MyFile {
    private final ICommand command;

    public MyFile(ICommand command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}

// Utility Class
class FileSystemUtil {
    public static IFileSystem getUnderlyingFileSystem(String sys) {
        // Just a simple toggle for demo purpose
        if(sys.equals("unix")) return new UnixFileSystem();  // or return new WindowsFileSystem();
        return new WindowsFileSystem();
    }
}


public class Command {
    public static void main(String[] args) {
        IFileSystem fs = FileSystemUtil.getUnderlyingFileSystem("unix");
        ICommand open = new OpenFileCommand(fs);
        ICommand close = new CloseFileCommand(fs);

        MyFile fileOpen = new MyFile(open);
        MyFile closeOpen = new MyFile(close);

        fileOpen.execute();
        closeOpen.execute();
    }
}

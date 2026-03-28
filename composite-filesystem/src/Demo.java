import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails(String indent);
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "- File: " + name);
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "+ Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails(indent + "  ");
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Directory root = new Directory("Project");
        Directory src = new Directory("src");
        Directory lib = new Directory("lib");

        File f1 = new File("Main.java");
        File f2 = new File("Utils.java");
        File f3 = new File("mysql-connector.jar");

        src.addComponent(f1);
        src.addComponent(f2);
        lib.addComponent(f3);

        root.addComponent(src);
        root.addComponent(lib);
        root.addComponent(new File("README.md"));

        System.out.println("File System Hierarchy:");
        root.showDetails("");
    }
}

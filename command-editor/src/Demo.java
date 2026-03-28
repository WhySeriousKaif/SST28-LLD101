import java.util.Stack;

interface Command {
    void execute();
    void undo();
}

class TextEditor {
    private String content = "";

    public void append(String text) {
        content += text;
    }

    public void removeLast(int length) {
        if (length <= content.length()) {
            content = content.substring(0, content.length() - length);
        }
    }

    public String getContent() {
        return content;
    }
}

class AppendCommand implements Command {
    private TextEditor editor;
    private String text;

    public AppendCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.append(text);
    }

    @Override
    public void undo() {
        editor.removeLast(text.length());
    }
}

class CommandManager {
    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CommandManager manager = new CommandManager();

        System.out.println("Step 1: Append 'Hello '");
        manager.executeCommand(new AppendCommand(editor, "Hello "));
        System.out.println("Content: [" + editor.getContent() + "]");

        System.out.println("\nStep 2: Append 'World!'");
        manager.executeCommand(new AppendCommand(editor, "World!"));
        System.out.println("Content: [" + editor.getContent() + "]");

        System.out.println("\nStep 3: Undo once");
        manager.undo();
        System.out.println("Content: [" + editor.getContent() + "]");

        System.out.println("\nStep 4: Undo again");
        manager.undo();
        System.out.println("Content: [" + editor.getContent() + "]");
    }
}

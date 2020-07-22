package counter;

import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    private List<Command> commandList = new ArrayList<>();
    private List<Command> undoList = new ArrayList<>();

    public void undo() {
        if (commandList.size() > 0) {
            Command command = (Command) commandList.get(commandList.size() - 1);
            commandList.remove(command);
            command.unExecute();
            undoList.add(command);
        }
    }

    public void redo() {
        if (undoList.size() > 0) {
            Command command = undoList.get(undoList.size() - 1);
            command.execute();
            undoList.remove(command);
            commandList.add(command);
        }
    }

    public void addCommand(Command command) {
        this.commandList.add(command);
    }
}

package invoker;

import structures.Command;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl {
    private List<Command> commandList = new ArrayList<>();
    public void executeCommand(Command command){
        commandList.add(command);
        command.execute();
    }
}

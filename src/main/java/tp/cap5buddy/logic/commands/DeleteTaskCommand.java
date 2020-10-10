package tp.cap5buddy.logic.commands;

import tp.cap5buddy.contacts.ContactList;
import tp.cap5buddy.modules.ModuleList;
import tp.cap5buddy.todolist.Task;
import tp.cap5buddy.todolist.TodoList;

public class DeleteTaskCommand extends Command {
    private final int indexToRemove;

    public DeleteTaskCommand(int index) {
        this.indexToRemove = index;
    }

    /**
     * Adds a task to the todolist.
     *
     * @param moduleList The related module list.
     * @param contactList The related contact list.
     * @param todoList The related todo list.
     * @return A CommandResult base on the command.
     */
    @Override
    public CommandResult execute(ModuleList moduleList, ContactList contactList, TodoList todoList) {
        Task toRemove = todoList.get(indexToRemove);
        todoList.remove(toRemove);
        String message = createSuccessMessage(indexToRemove);
        return new CommandResult(message, isExit());
    }

    /**
     * Creates success message after execution of command.
     *
     * @param index index of task to be removed.
     * @return A String representing the outcome of the execution.
     */
    public String createSuccessMessage(int index) {
        StringBuilder builder = new StringBuilder();
        builder.append("Task ")
                .append(index + 1)
                .append(" has been successfully removed")
                .append("\n");
        return builder.toString();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
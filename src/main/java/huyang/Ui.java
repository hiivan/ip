package huyang;

import java.util.ArrayList;

/**
 * Ui class responsible for handling user interaction and displaying messages.
 */
public class Ui {

    /**
     * Returns a greeting message.
     */
    public static String getGreetingMessage() {
        return "Hello! I'm Huyang\nWhat can I do for you?";
    }

    /**
     * Returns an error message.
     *
     * @param message The error message to be returned.
     */
    public String getErrorMessage(String message) {
        return "Error: " + message;
    }

    /**
     * Returns a message for an unknown command.
     */
    public String getUnknownCommandMessage() {
        return "I'm sorry, but I don't know what that means :-(";
    }

    /**
     * Returns a farewell message.
     */
    public static String getFarewellMessage() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Returns a message for an added task and the current task count.
     *
     * @param task The added task to be displayed.
     */
    public String getAddTaskMessage(Task task, int taskCount) {
        return "Got it. I've added this task:\n  " + task
                + "\nNow you have " + taskCount + " tasks in the list.";
    }

    /**
     * Returns a message for a marked task as done or not done yet.
     *
     * @param input The user input.
     * @param isMarked Whether the task is marked as done.
     */
    public String getMarkOrUnmarkMessage(Task task, boolean isMarked) {
        String status = isMarked ? "done" : "not done yet";
        return "Nice! I've marked this task as " + status + ":\n  " + task;
    }

    /**
     * Returns a message for a deleted task and the current task count.
     *
     * @param task The deleted task to be displayed.
     * @param taskCount The current task count to be displayed.
     */
    public String getDeleteTaskMessage(Task task, int taskCount) {
        return "Noted. I've removed this task:\n  " + task
                + "\nNow you have " + taskCount + " tasks in the list.";
    }

    /**
     * Returns the list of tasks.
     *
     * @param tasks An ArrayList of tasks to be displayed.
     */
    public String getTasksMessage(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            return "You have no tasks in your list.";
        }
        StringBuilder sb = new StringBuilder("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("\n" + (i + 1) + ". " + tasks.get(i));
        }
        return sb.toString();
    }

    /**
     * Returns a list of found tasks based on a keyword search.
     *
     * @param tasks An ArrayList of tasks containing the tasks found with the given keyword.
     */
    public String getFoundTasksMessage(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            return "No tasks found with the given keyword.";
        }
        StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + "." + tasks.get(i) + "\n");
        }
        return sb.toString();
    }

    /**
     * Print statement.
     *
     * @param s String to be printed.
     */
    public void print(String s) {
        System.out.println(s);
    }
}
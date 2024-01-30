package huyang;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    protected LocalDateTime start;
    protected LocalDateTime end;

    public Event(String taskName, LocalDateTime start, LocalDateTime end) {
        super(taskName);
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    private String getTypeIcon() {
        return "[E]";
    }

    @Override
    public String toFileFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return "E | " + (isDone ? "1" : "0") + " | " + taskName + " | " + start.format(formatter) + " to " + end.format(formatter);
    }

    public static Event fromFileFormat(String fileFormat) throws TaskException {
        try {
            String[] parts = fileFormat.split(" \\| ");
            String description = parts[2];
            String[] times = parts[3].split(" to "); // Split by " to "

            LocalDateTime start = LocalDateTime.parse(times[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            LocalDateTime end = LocalDateTime.parse(times[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            Event event = new Event(description, start, end);
            if (parts[1].equals("1")) {
                event.check();
            }
            return event;
        } catch (DateTimeParseException e) {
            throw new TaskException("Invalid date format.");
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return getTypeIcon() + super.getStatusIcon() + " " + taskName +
                " (from: " + start.format(formatter) + " to: " + end.format(formatter) + ")";
    }
}

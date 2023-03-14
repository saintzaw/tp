package seedu.duke;

public class DukeException extends Exception {
    public String description;

    /**
     * Creates an object of the class DukeException.
     * This has inputs, and it will be stored into the description.
     *
     * @param description This will contain the description of the error found in commandChecker.
     */
    public DukeException(String description) {
        this.description = description;
    }

    /**
     * Sets the description of the error to be stored in DukeException.
     *
     * @return description of the error stored in DukeException.
     */
    public String getDescription() {
        return this.description;
    }
}

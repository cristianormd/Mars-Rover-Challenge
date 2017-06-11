import java.text.ParseException;

/**
 * Represents a command in the context of the MarsRover project
 *
 * Created by crmdias on 10/06/2017.
 */
enum Command {
    Left('L'),Right('R'),Move('M');

    private final char c;

    Command(char c) {
        this.c = c;
    }

    /**
     * Parses the given string into a series of commands
     *
     * @param str the string with all commands in sequential order
     * @return An array with all commands in the same order
     * @throws ParseException if the string is not a valid command chain
     */
    static Command[] parseCommandSequence(String str) throws ParseException
    {
        Command[] commands = new Command[str.length()];

        for(int i=0; i < str.length(); i++)
        {
            commands[i] = Command.getEnum(str.charAt(i));
        }

        return commands;
    }

    public static Command getEnum(char value) {
        for(Command v : values())
            if(v.c == value) return v;
        throw new IllegalArgumentException();
    }
}

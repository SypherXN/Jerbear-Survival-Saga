package adventure.exception;

import adventure.command.Command;

public class CommandAliasUsedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public final String alias;
    public final Command command;
    
    public CommandAliasUsedException(String alias, Command command) {
        super(String.format("Command alias %s has been taken.", alias));
        this.alias = alias;
        this.command = command;
    }

}

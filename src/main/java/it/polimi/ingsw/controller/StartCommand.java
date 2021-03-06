package it.polimi.ingsw.controller;

import it.polimi.ingsw.game.Player;
import it.polimi.ingsw.network.server.Server;

import java.util.List;

/**
 * Command used to request/notify that a match started
 * (Server)
 * Inform players that the match where they are is starting and provide them information about their opponents
 * (Client)
 * Request to start the match before its full
 */
public class StartCommand extends BaseCommand {
    private int[] playersID;
    private String[] username;

    /**
     * (Server) Used to inform all the clients that the match they have joined
     * is started
     * @param sender sender id of who is issuing this command
     * @param target receiver of the command
     * @param connectedPlayers list of connected players (ids)
     */
    public StartCommand(int sender, int target, List<Player> connectedPlayers) {
        super(sender, target);
        this.playersID = idsToArray(connectedPlayers);
        this.username = usernameToArray(connectedPlayers);
    }

    /**
     * (Client) Used to request the server to start the game before the lobby is full
     * @param sender sender id of who is issuing this command
     * @param target receiver of the command
     */
    public StartCommand(int sender, int target) {
        super(sender, target);
        this.playersID = null;
    }

    /**
     * Return stored array of player ids
     * @return array of player ids
     */
    public int[] getPlayersID() {
        return playersID;
    }

    /**
     * Return stored array of players username
     * @return array of players username
     */
    public String[] getUsername() { return username; }

    /**
     * Convert a list of player ids into an array
     * @return array id of every player
     */
    private int[] idsToArray(List<Player> connectedPlayers){
        int[] ids = new int[connectedPlayers.size()];

        for(int i = 0; i < connectedPlayers.size(); i++ )
            ids[i] = connectedPlayers.get(i).getId();

        return ids;
    }

    /**
     * Convert a list of players username into an array
     * @return string array of every player's username
     */
    private String[] usernameToArray(List<Player> connectedPlayers) {
        String[] username = new String[connectedPlayers.size()];

        for(int i = 0; i<connectedPlayers.size(); i++)
            username[i] = connectedPlayers.get(i).getUsername();

        return username;
    }

    /**
     * (Server) Used to inform clients that the match they have joined is started
     * @param sender sender id
     * @param target receiver of the command
     * @param connectedPlayers list of connected players (ids)
     * @return wrapped command ready to be sent over the network
     */
    public static CommandWrapper makeReply(int sender, int target, List<Player> connectedPlayers)
    {
        return new CommandWrapper(CommandType.START, new StartCommand(sender, target, connectedPlayers));
    }

    /**
     * (Client) Create a command to request the match start to the server
     * @param sender sender id (current client id)
     * @param target target id
     * @return wrapped command ready to be sent over the network
     */
    public static CommandWrapper makeRequest(int sender, int target)
    {
        return new CommandWrapper(CommandType.START, new StartCommand(sender, target));
    }

}

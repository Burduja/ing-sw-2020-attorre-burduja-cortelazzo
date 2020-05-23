package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.CommandWrapper;

public interface INetworkForwarder
{
    /**
     * Send a packet to all clients, only command's target can handle the command
     * @param packet packet to send
     */
    void send(CommandWrapper packet);

    /**
     * Return default server ID
     * @return server ID
     */
    int getServerID();

    /**
     * Return default broadcast ID
     * @return broadcast ID
     */
    int getBroadCastID();

    /**
     * Return default server port
     * @return default server port
     */
    int getDefaultPort();
}
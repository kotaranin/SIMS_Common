/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Uros
 */
public class Receiver {

    private final ObjectInputStream in;

    public Receiver(Socket socket) throws IOException {
        this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public Object receive() throws ClassNotFoundException, IOException {
        return in.readObject();
    }
}

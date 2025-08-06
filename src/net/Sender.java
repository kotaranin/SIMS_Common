/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Uros
 */
public class Sender {

    private final ObjectOutputStream out;

    public Sender(Socket socket) throws IOException {
        this.out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        out.flush();
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void send(Object object) throws IOException {
        out.writeObject(object);
        out.flush();
    }
}

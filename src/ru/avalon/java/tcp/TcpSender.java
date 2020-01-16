package ru.avalon.java.tcp;

import java.net.*;
import java.io.*;

/**
 * Упражнение на выработку базовых умений использования
 * протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpSender {

    public static void main(String[] args) throws IOException {
        // 1. Подготавливааем сообщение
        final String message = prepareMessage();
        // 2. Подготавливаем адрес
        final SocketAddress address = prepareAddress();
        // 3. Устанавливаем соединение
        Socket socket = connect(address);
        // 4. Отправляем сообщение
        send(socket, message);
        final ServerSocket listener = new ServerSocket(18000);
        // 4.5 Получаем ответ
        String resmessage = receive(socket);
        System.out.print(resmessage);
        
         
        // 5. Закрываем соединеие
        socket.close();
        listener.close();
    }

    /**
     * Возвращает объект сообщения.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() {
        /*
         * TODO Реализовать метод prepareMessage класса TcpSender
         */
        return "my sended message";
    }

    /**
     * Возвращает адрес, на который будет выполнена отправка сообщения.
     *
     * @return экземпля типа {@link SocketAddress}
     */
    private static SocketAddress prepareAddress() {
        /*
         * TODO Реализовать метод prepareAddress класса TcpSender
         */
        
        try
        {
            return new InetSocketAddress(InetAddress.getLocalHost(), 18000);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * Устанавливает соединение на указанный адрес и возвращает сокет
     * описывающий соединение.
     *
     * @param address адрес, на который будет выполено соединение.
     *
     * @return сокет, описывающий открытое соединеие.
     *
     * @throws IOException
     */
    private static Socket connect(SocketAddress address) throws IOException,UnknownHostException {
        /*
         * TODO Реализовать метод connect класса TcpSender
         */
         Socket socket = new Socket();
         socket.connect(address);
         return socket;
    }

    /**
     * Выполняет отправку сообщения {@code message} на {@code socket}.
     *
     * @param socket соединение, через которое будет отправлено сообщение.
     * @param message сообщение
     *
     * @throws IOException
     */
    private static void send(Socket socket, String message) throws IOException {
        /*
         * TODO Реализовать метод send класса TcpSender
         */
        try {
            OutputStream stream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(stream);
            writer.write(message);
            
            writer.flush();
        }    
        catch (IOException e)
        {
            
        }
    }
    
    
    private static String receive(Socket socket) {
        /*
         * TODO Реализовать метод receive класса TcpReceiver
         */
        String message = null;
        try 
        {
                InputStream stream = socket.getInputStream();
                Reader reader = new InputStreamReader(stream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                message = bufferedReader.readLine();
        }
        catch (Exception e)
        {
            
        }
        return message;
    }

}

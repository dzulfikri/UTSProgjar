/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utsprogjar;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author M. H. F. Dzulfikri
 */
public class UTSProgjar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Socket socket = null;
        BufferedReader read = null;
        BufferedReader in = null;
        PrintWriter out = null;
        
        try {
            socket = new Socket ("10.151.34.155", 6666);

            read = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            
        } 
            catch (IOException ex) {
            Logger.getLogger(UTSProgjar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String textToServer;
            while((textToServer = read.readLine())!=null){
                out.print(textToServer + "\r\n" );
                out.flush();

                String messageFromServer;
                while(( messageFromServer = textToServer=in.readLine()) != null){
                    System.out.println(messageFromServer);
            }
        }
        
        Integer intToServer;
        while((intToServer = Integer.parseInt(read.readLine()))!=null){
            out.print(intToServer + "\r\n" );
            out.flush();

            String messageFromServer;
            while(( messageFromServer = textToServer=in.readLine()) != null){
                System.out.println(messageFromServer);
            }
        }
        
        out.close();
        in.close();
        read.close();
        socket.close();
    }
}
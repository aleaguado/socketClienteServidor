/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclienteservidor;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleaguado
 */
public class Servidor {
    private int porta;
    private List<PrintStream> clientes;
    
    
    public void rodar() {
        try {
                    
        this.clientes = new ArrayList<PrintStream>();
        
        ServerSocket servidor = new ServerSocket(porta);    
        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " +  cliente.getInetAddress().getHostAddress());

            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            TrataCliente tc = new TrataCliente(cliente.getInputStream(), this);
            new Thread(tc).start();
        } 
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
     }
    
    public void distribuiMensagem(String msg) {
     // envia msg para todo mundo
     for (PrintStream cliente : this.clientes) {
       cliente.println(msg);
     }
   }  
     
    public void setPorta(int portaP){
       porta =  portaP;
    }  
}

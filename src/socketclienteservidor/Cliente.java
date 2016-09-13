/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclienteservidor;

import java.io.*; 
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author aleaguado
 */
public class Cliente {
        private int porta;
        private String end;
        private String nome;
    
    public void rodar() {
      try {
            Scanner lerTeclado = new Scanner(System.in);
            Socket cliente = new Socket(end, porta);
            System.out.println("Conectado ao servidor!");
            
             // thread para receber mensagens do servidor ========
               receberMsg r = new receberMsg(cliente.getInputStream());
               new Thread(r).start();
            //=====================================================
  
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            while (lerTeclado.hasNextLine()) {
                saida.println(nome + ": " + lerTeclado.nextLine());
            }
            saida.close();
            lerTeclado.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println("Erro!");
        } 
     }
     public void setDados(int portaP, String ip, String n){
        porta =  portaP;
        end = ip;
        nome = n;
     }     
         
}

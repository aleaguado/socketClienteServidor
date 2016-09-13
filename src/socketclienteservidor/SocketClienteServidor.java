/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclienteservidor;

import java.util.Scanner;

/**
 *
 * @author aleaguado
 */
public class SocketClienteServidor {
    
     

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lerTeclado = new Scanner(System.in);
        Scanner lerTecladoInt = new Scanner(System.in);
        int op, portaS;
        String ip, nome;
        // TODO code application logic here
        System.out.println("Digite 1 para executar o servidor ou 2 para executar o cliente:");
        op = lerTecladoInt.nextInt();
        
        if(op == 1){
            Servidor sv = new Servidor(); // Instanciando a parte servidora
            System.out.println("Em qual porta o servidor devera ouvir?");
            sv.setPorta(lerTecladoInt.nextInt());
            sv.rodar();
        }else{
             Cliente sc = new Cliente(); // Instanciando a parte cliente
             System.out.println("Qual IP do Servidor?");
             ip = lerTeclado.next();
             System.out.println("Qual Porta do Servidor?");
             portaS = lerTecladoInt.nextInt();
             System.out.println("Qual seu nome?");
             nome = lerTeclado.next();
             sc.setDados(portaS, ip, nome);
             sc.rodar();
        }
    }
    
}

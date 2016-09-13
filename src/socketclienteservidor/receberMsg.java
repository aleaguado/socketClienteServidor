/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclienteservidor;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author aleaguado
 */
public class receberMsg implements Runnable{
    private InputStream servidor;
    public receberMsg(InputStream servidor) {
        this.servidor = servidor;
    }

    public void run() {

     // recebe msgs do servidor e imprime na tela
     Scanner s = new Scanner(this.servidor);
     while (s.hasNextLine()) {
        System.out.println(s.nextLine());
     }
   }
}

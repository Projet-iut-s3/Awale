


import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Plateau plateau1;
        Socket sclient  =new Socket("localhost",4999);
        Serveur sss=new Serveur();

        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez saisir le nom de J1");
        String nomj1=sc.nextLine();

        DataOutputStream out=new DataOutputStream(sclient.getOutputStream());
        out.writeUTF(nomj1);

        DataInputStream in = new DataInputStream((sclient.getInputStream()));
        String nomj2=in.readUTF();

        System.out.println( "nomj1="+nomj1+"\n nomj2="+nomj2);

        System.out.println(in.readUTF());
        System.out.println("Le joueur 1 joue");
        System.out.println(in.readUTF());




    }
}

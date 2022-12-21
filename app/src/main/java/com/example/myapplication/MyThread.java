    package com.example.myapplication;

    import java.io.BufferedReader;
    import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.io.PrintWriter;
    import java.net.Socket;


    public class MyThread implements Runnable{
        private String msg;


        Socket s;
        String msgrecu;
        @Override
        public void run() {
          /*  try {
                System.out.println(msg);

                Socket socket = new Socket("192.168.80.1", 1234);

                OutputStream os = socket.getOutputStream();

                PrintWriter pw = new PrintWriter(os, true);
                System.out.println("avant");

                pw.println(msg);
                System.out.println("apres");



                InputStream is = socket.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
               String a=br.readLine();
                System.out.println(" msg"+a);

            }
            catch(Exception ex) {
                System.out.println("err");
            }*/
            try {
                Socket socket = new Socket("192.168.1.9", 1234);
                System.out.println("je suis connecté");
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                System.out.println("msg de la socket"+msg);
                pw.println(msg);
                InputStream sr=socket.getInputStream();
                InputStreamReader r=new InputStreamReader(sr);
                BufferedReader br=new BufferedReader(r);
                String s=br.readLine();
                msgrecu = s.toString();

                System.out.println("la note des reponses deja choisi : "+s.toString());
                System.out.println("end");
                msgrecu = s.toString();

                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        public void sendMessage(String msg){
            System.out.println("msg recu"+ msg);
            this.msg = msg;
            run();
            this.msgrecu=msgrecu;

        }
        public String getmsg(){
            return msg;
        }
        public String getmsgrecu(){
            return msgrecu;
        }

    }
package com.example.myapplication;

import static com.example.myapplication.R.id.radio1;
import static com.example.myapplication.R.id.radio2;
import static com.example.myapplication.R.id.radio3;
import static com.example.myapplication.R.id.radio4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    static EditText e1, e2;
    private RadioGroup radioGroup;
    private RadioButton r1, r2, r3,r4;
    private TextView qt;


    Button b1;

    static String msg;

    static BufferedReader serverIn = null;
    static MyThread thread = new MyThread();
    private static String mr = thread.msgrecu;
    private static final String[] paths = {"en", "fr", "de", "tr", "it"};
    public static String question[] = {
            "JNDI est :",
            "Le protocole UDP est un protocole _____?",
            "La méthode rebind a le rôle de ______ ?",
            "La sérialisation est utilisée, notamment, pour _______ :",
            "L’API socket est :",
            "Quel protocole travaille-t-il en mode non-connecté?"
            ,"En CORBA, les modes d'invocation des méthodes sont __________ ?"
            ,"Dans l'architecture RMI, quelle couche intercepte les appels de la méthode effectués par le client et redirige ces appels vers un service RMI distant ?"
          ,"Lequels sont des composants CORBA qui font partie du serveur et non pas du client ?"
            ,"En CORBA, que représente la classe IBanqueRemotePOA ?",
            "Que permet de faire l'élément EditText ?",
            "pour démarrer une activité avec un Intent ,on utilise la méthode:",
            "En quoi l’architecture MVC est-elle intéressante ?",
            "Quelle est la méthode permettant d’intercepter le clic de l’utilisateur sur un bouton ?",
            "Application hybride est une application mobile",
            "Les Intens sont :",
"Comment pouvez-vous tester votre application sur plusieurs Devices Android?",
"Lequel des noyaux suivants est utilisé dans Android ?",
            "Que contient le fichier manifest.xml ?",
            "Quelle partie responsable de mémoriser les données émises par l'utilisateur?",

            "qt"

    };
    public static String choices[][] = {
            {"Java Naming Directory Interface.", "Javax Naming Directory Interface.", "Java Naming and Directory Interface.", "Java Network and Directory Information."},
            {"qui envoie des données sous forme de flux de paquets liés", "dont tous les paquets UDP sont traités indépendamment par la couche de transport", "dont les paquets sont reçus dans le même ordre que l’ordre envoyé", "Aucune de ces réponses n’est correcte."},
            {"Appeler une méthode d’un objet distant.", "Démarrer l'annuaire.", "Enregistrer la référence de l'objet distant dans l'annuaire.", "Récupérer le stub de l'objet enregistré dans l'annuaire."},
            {"faire la sauvegarde des objets sur disque ", "structurer les données de l'interface IDL qui définit les données échangées entre le client et le serveur",
                    "transporter les données entre un client et un serveur via le réseau.", "Aucune de ces réponses n’est vraie."},
            {"Un mécanisme de communication permettant d’utiliser l’interface de transport TCP-UDP.","est une machine de communication.","une réponse à un problème spécifique, fourniture de services à ses utilisateurs.","Aucune réponse n'est correcte."}
            ,{
                "TCP","UDP","ICMP","IGMP",},
            {"synchrone, asynchrone et semi-asynchrone.","synchrone, asynchrone et semi-asynchrone." +
                    "seulement semi-synchrone.","synchrone et asynchrone."}
            ,{"Couche Transport.","Couche Stub et Skeleton (Souche et Squelette)","Couche Application.","Couche de référencement distante"},
            {"POA","ORB","Skeleton","Stub"},
            {"Le POA.","L’interface de l’objet distant.","Le skeleton","Le servant."},
            {"permet à l'utilisateur de saisir des entrées et d'afficher une chaine","permet à l'utilisateur de saisir des entrées","permet à l'utilisateur d'afficher une chaine"},
            {"startActivity()","startIntent()","startActivity (Intent)"},
            {"Elle permet d’organiser son code plus proprement, afin qu’il soit plus maintenable et évolutif","Elle permet d’avoir une application plus rapide et plus jolie","Elle permet de rendre une application compatible sur la majorité des équipements du marché"},
            {"setOnClickListener()","addListener()","setListener()"},
            {"Accessible seulement sur les plateformes d'applications","Accessible à travers un navigateur internet","Accessible sur toutes les plateformes d'application"},
            {"Le framework de communication inter-applications","Les composants d'application visuels","Le framework de notifications aux utilisateurs"},
            {"En achetant chacun de ces devices","En utilisant Android Device Monitor","En utilisant Android Virtual Device et en configurant pour créer un Device Virtuel différent"},
            {"MacOS","Linux","Redhat","Windows"} ,
            {"La liste des chaînes de caractères utilisées dans l’application","Le code source","Le mot de passe et le login","Les permissions que l’application requiert"}  ,
            {"Contrôleur","Vue","Modèle","Aucune réponse n'est correcte."} ,
            {"a","b","c","d"}

    };
    private Spinner spinner1;
    private Spinner spinner2;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);

        qt = (TextView) findViewById(R.id.question);
        r1 = (RadioButton) findViewById(radio1);

        r2 = (RadioButton) findViewById(radio2);
        r3 = (RadioButton) findViewById(radio3);
        r4 = (RadioButton) findViewById(radio4);


        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


int a=i+1;

                System.out.println("question numero "+a);


                RadioGroup rg = (RadioGroup) findViewById(R.id.radio);
                final String value =
                        ((RadioButton) findViewById(rg.getCheckedRadioButtonId()))
                                .getText().toString();
                msg = value;
System.out.println("question "+question[i]);
                System.out.println("reponse choisi "+value);


                myTask mt = new myTask();
                ScheduledExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
                executorService1.schedule(() -> mt.execute(), 100, TimeUnit.MILLISECONDS);


                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.schedule(() -> qt.setText(question[i]), 100, TimeUnit.MILLISECONDS);
                executorService.schedule(() -> r1.setText(choices[i][0]), 120, TimeUnit.MILLISECONDS);
                executorService.schedule(() -> r2.setText(choices[i][1]), 120, TimeUnit.MILLISECONDS);
                executorService.schedule(() -> r3.setText(choices[i][2]), 120, TimeUnit.MILLISECONDS);

                executorService.schedule(() -> r4.setText(choices[i][3]), 120, TimeUnit.MILLISECONDS);

                i++;
                radioGroup.clearCheck();
                // new ServerThread().start();
                if(i>=20){

                    ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
                    executorService2.schedule(() ->{ System.out.println("test");
                        goscore();        }, 400, TimeUnit.MILLISECONDS);
                            }


                // Do something in response to button click

            }



        });

    }





   void  goscore() {
        Intent intent = new Intent(MainActivity.this, Score.class);
       intent.putExtra("score",mr);


        startActivity(intent);
    }

    public void send (View v){

    }
    static class myTask extends AsyncTask<Void, Void, Void> {
        @SuppressLint("SetTextI18n")
        @Override
protected Void doInBackground(Void...params){

            thread.sendMessage(msg);
            mr=thread.getmsgrecu();
            return null;
        }
    }
}
package com.domomtica.JarviseRemote;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.domotica.JarviseRemote.R;
 
public class Avanzate extends Fragment implements OnClickListener{
	private static String nameFile = "jarvise.txt";
	EditText host;
	EditText user;
	EditText pass;
	EditText def1;
	EditText def2;
	EditText def3;
	EditText def4;
	Button setgarageOn;
	Button setgarageOff;
	Button setAllarmeCasaOn;
	Button setAllarmeCasaOff;
	Button setAllarmeGarageOn;
	Button setAllarmeGarageOff;
	Button personalizzato8;
	Button personalizzato9;
	Button personalizzato10;
	Button save;
	Button shutdown;
	Button reboot;
	Configuration readFile;
	static Activity thisActivity = null;
	
    @SuppressWarnings("static-access")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Personalizzato", "Selezionato");
        this.thisActivity = this.getActivity();
    	this.readFile = new Configuration(nameFile);
    	
    	
    }
 
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
 
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.avanzate, container, false);
        TextView textView = (TextView) view.findViewById(R.id.infoAvanzate);
//        textView.setText("OPZIONI  AVANZATE");

        shutdown = (Button) view.findViewById(R.id.Spento);
        reboot = (Button) view.findViewById(R.id.Riavvia);
        save = (Button)	  view.findViewById(R.id.Salva);
        user = (EditText) view.findViewById(R.id.UserValore);
        host = (EditText) view.findViewById(R.id.hostValore);
        pass = (EditText) view.findViewById(R.id.passwordValore);
        def1 = (EditText) view.findViewById(R.id.default1Value);
        def2 = (EditText) view.findViewById(R.id.default2Value);
        def3 = (EditText) view.findViewById(R.id.default3Value);
        def4 = (EditText) view.findViewById(R.id.default4Value);
        setgarageOn = (Button)view.findViewById(R.id.SetGarageOn);
		setgarageOff = (Button)view.findViewById(R.id.SetGarageOff);
		setAllarmeCasaOn = (Button)view.findViewById(R.id.SetAllarmeCasaOn);
		setAllarmeCasaOff = (Button)view.findViewById(R.id.SetAllarmeCasaOff);
		setAllarmeGarageOn = (Button)view.findViewById(R.id.SetAllarmeGarageOn);
		setAllarmeGarageOff = (Button)view.findViewById(R.id.SetAllarmeGarageOff);
		personalizzato8 = (Button) view.findViewById(R.id.ControlloPerditaAcquarioButton);
		personalizzato9 = (Button) view.findViewById(R.id.ControlloPerditaCasaButton);
		personalizzato10 = (Button) view.findViewById(R.id.ControlloMovimentoCasaButton);
		reboot.setOnClickListener(this);
		setgarageOn.setOnClickListener(this);
		setgarageOff.setOnClickListener(this);
		setAllarmeCasaOn.setOnClickListener(this);
		setAllarmeCasaOff.setOnClickListener(this);
		setAllarmeGarageOn.setOnClickListener(this);
		setAllarmeGarageOff.setOnClickListener(this);
		personalizzato8.setOnClickListener(this);
		personalizzato9.setOnClickListener(this);
		personalizzato10.setOnClickListener(this);
        save.setOnClickListener(this);
        shutdown.setOnClickListener(this);
		personalizzato8.setText("Resetta");
		personalizzato9.setText("Resetta");
		personalizzato10.setText("Resetta");
        return view;
    }

    public static void log(String log){
		Toast.makeText(thisActivity, log, Toast.LENGTH_LONG).show();

	}
    
    public void checkButtonAlarm(Button personale, String log){
    	
    		personale.setBackgroundResource(R.layout.rosso);
    		personale.setText(log);
    	
    }
   
	@Override
	public void onClick(View button) {
		if(button == save){
			try {
				log("Modifiche Salvate");
				readFile.write2File(user.getText().toString(), pass.getText().toString(), host.getText().toString(), def1.getText().toString(), def2.getText().toString(), def3.getText().toString(), def4.getText().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.getText().clear();
			host.getText().clear();
			pass.getText().clear();
			def1.getText().clear();
			def2.getText().clear();
			def3.getText().clear();
			def4.getText().clear();
			
			getActivity().getActionBar().setSelectedNavigationItem(0);
		}
		
		if(button == setgarageOn){
			new ProgressMessageTask().execute("");
			new MultiThread("127.0.0.1", 9001,new PaccoGpio(4, 3));
		}
		if(button == setgarageOff){
			new ProgressMessageTask().execute("");
			new MultiThread("127.0.0.1", 9001,new PaccoGpio(5, 4));
		}
		if(button == setAllarmeCasaOn){
			new ProgressMessageTask().execute("");
			new MultiThread("127.0.0.1", 9001,new PaccoGpio(7, 3));
		}
		if(button == setAllarmeCasaOff){
			new ProgressMessageTask().execute("");
			new MultiThread("127.0.0.1", 9001,new PaccoGpio(7, 4));
		}
		if(button == setAllarmeGarageOff){
			new ProgressMessageTask().execute("");
			new MultiThread("127.0.0.1", 9001,new PaccoGpio(6, 4));
		}
		if(button == setAllarmeGarageOn){
			new ProgressMessageTask().execute("");
			new MultiThread("127.0.0.1", 9001,new PaccoGpio(6, 3));
		}
		if(button == personalizzato8){
			new ProgressMessageTask().execute("");
			checkButtonAlarm(personalizzato8,"Resettato");
			new MultiThread("127.0.0.1", 9001,new PaccoGpio(8, 2)); 
			
		}
		if(button == personalizzato9){
			new ProgressMessageTask().execute("");
				checkButtonAlarm(personalizzato9,"Resettato");
				new MultiThread("127.0.0.1", 9001,new PaccoGpio(9, 2)); 
			
		}
		if(button == personalizzato10){
			new ProgressMessageTask().execute("");
			 MultiThread p10 = new MultiThread("127.0.0.1", 9001,new PaccoGpio(10, 2)); 
		   		if(!p10.errore)checkButtonAlarm(personalizzato10,"Resettato");
			   
			
		}
		
		if(button == reboot){
			
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity()); 
			builder.setMessage("Sei sicuro di voler riavviare il Raspberry?").setCancelable(false); 
			builder.setPositiveButton("Si", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int id) {
					new ProgressMessageTask().execute("");
					new ToastMessageTask().execute("Provo a riavviare il Raspberry");
					new MultiThread("127.0.0.1", 9001,new PaccoGpio(0, 2));  
					
					 }});
			
			builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) { 
				dialog.cancel();      } 
			});
			AlertDialog alert = builder.create();  
			alert.show();
			 
			
		}
		
		if(button == shutdown){
			AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity()); 
			builder.setMessage("Sei sicuro di voler spegnere il Raspberry?").setCancelable(false); 
			builder.setPositiveButton("Si", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int id) {
					new ProgressMessageTask().execute("");
					new ToastMessageTask().execute("Provo a spegnere il Raspberry");
					new MultiThread("127.0.0.1", 9001,new PaccoGpio(0, 3));   }});
			builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) { 
				dialog.cancel();      } 
			});
			AlertDialog alert = builder.create();  
			alert.show();
			
		}
		
	}
}
package com.example.tablayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
 
public class Controllo extends Fragment  implements OnClickListener {
	Button garageOn;
	Button garageOff;
	Button AllarmeCasaOn;
	Button AllarmeCasaOff;
	Button AllarmeGarageOn;
	Button AllarmeGarageOff;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Personalizzato", "Selezionato");
    }
 
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
 
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.controllo, container, false);
        TextView textView = (TextView) view.findViewById(R.id.infoControlli);
        textView.setText("Controllo Remoto Rel�");
        garageOn = (Button)view.findViewById(R.id.ControlloGarageOn);
		garageOff = (Button)view.findViewById(R.id.ControlloGarageOff);
		AllarmeCasaOn = (Button)view.findViewById(R.id.ControlloAllarmeCasaOff);
		AllarmeCasaOff = (Button)view.findViewById(R.id.ControlloAllarmeCasaOn);
		AllarmeGarageOn = (Button)view.findViewById(R.id.ControlloAllarmeGarageOn);
		AllarmeGarageOff = (Button)view.findViewById(R.id.ControlloAllarmeGarageOff);
		garageOn.setOnClickListener(this);
		garageOff.setOnClickListener(this);
		AllarmeCasaOn.setOnClickListener(this);
		AllarmeCasaOff.setOnClickListener(this);
		AllarmeGarageOn.setOnClickListener(this);
		AllarmeGarageOff.setOnClickListener(this);
        return view;
    }

	@Override
	public void onClick(View button) {
		if(button == garageOn){
			
		}
		if(button == garageOff){
			
		}
		if(button == AllarmeCasaOn){
			
		}
		if(button == AllarmeCasaOff){
			
		}
		if(button == AllarmeGarageOff){
			
		}
		if(button == AllarmeGarageOn){
			
		}
		
	}
}
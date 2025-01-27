package com.domomtica.JarviseRemote;
import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.Toast;


public class ToastMessageTask extends AsyncTask<String, String, String> {
	    String toastMessage;

	    @Override
	    protected String doInBackground(String... params) {
	        toastMessage = params[0];
	        return toastMessage;
	    }

	    protected void OnProgressUpdate(String... values) { 
	        super.onProgressUpdate(values);
	    }
	   // This is executed in the context of the main GUI thread
	    protected void onPostExecute(String result){
	           Toast toast = Toast.makeText(AllControlli.thisActivity, result, Toast.LENGTH_SHORT);
	           toast.setGravity(Gravity.BOTTOM, 0, 0);
	           toast.show();
	    }}

package alvarado.wuil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.researchmobile.coretel.entity.RespuestaWS;
import com.researchmobile.coretel.entity.User;
import com.researchmobile.coretel.entity.Usuario;
import com.researchmobile.coretel.utility.Mensaje;
import com.researchmobile.coretel.ws.RequestWS;

public class Perfil extends Activity implements OnClickListener, OnKeyListener{
	
	private LinearLayout edicionLayout;
	private TextView nombreTextView;
	private TextView emailText;
	private EditText clavenuevaEditText;
	private EditText clavenueva1EditText;
	private EditText clavenueva2EditText;
	private Button cambiaButton;
	private Button guardarButton;
	private Usuario usuario;
	private User user;
	private Mensaje mensaje;
	private ProgressDialog pd = null;
	private RespuestaWS respuestaWS;
	private boolean cambioHecho;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil);
		
		Bundle bundle = (Bundle)getIntent().getExtras();
		setUsuario((Usuario)bundle.get("usuario"));
		setMensaje(new Mensaje());
		setNombreTextView((TextView)findViewById(R.id.perfil_nombre_textview));
		setEmailText((TextView)findViewById(R.id.perfil_email_textview));
		setClavenuevaEditText((EditText)findViewById(R.id.perfil_claveactual_edittext));
		setClavenueva1EditText((EditText)findViewById(R.id.perfil_clavenueva1_edittext));
		setClavenueva2EditText((EditText)findViewById(R.id.perfil_clavenueva2_edittext));
		setCambiaButton((Button)findViewById(R.id.perfil_cambiar_button));
		setGuardarButton((Button)findViewById(R.id.perfil_guardar_button));
		
		getNombreTextView().setText(getUsuario().getNombre());
		getEmailText().setText(getUsuario().getEmail());
		getCambiaButton().setOnClickListener(this);
		getGuardarButton().setOnClickListener(this);
		setEdicionLayout((LinearLayout)findViewById(R.id.perfil_layout_edit));
		getEdicionLayout().setVisibility(View.INVISIBLE);
	}
	
	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		 if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP)
         {
             if (v == getClavenuevaEditText()){
            	 getClavenueva1EditText().requestFocus();
             }else if (v == getClavenueva1EditText()){
            	 getClavenueva2EditText().requestFocus();
             }else if (v == getClavenueva2EditText()){
            	 ConfirmarCambio(Perfil.this);
             }
             return true;
         }
         if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)
         {
             //TODO: When the enter key is pressed
             return true;
         }
         return false;

	}

	private void ConfirmarCambio(Context ctx) {
		new AlertDialog.Builder(ctx)
        .setIcon(ctx.getResources().getDrawable(R.drawable.alert))
        .setTitle("CAMBIO DE CLAVE")
        .setMessage("�Esta de seguro de realizar el cambio?")
        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                	new GuardarAsync().execute("");
                     LimpiarCampos();
                }
        })
        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                	getMensaje().VerMensaje(Perfil.this, "Cambio Cancelado");
                }
        })
        .show();

		
	}

	protected void LimpiarCampos() {
		getClavenuevaEditText().setText("");
		getClavenueva1EditText().setText("");
		getClavenueva2EditText().setText("");
	}

	@Override
	public void onClick(View view) {
		if (view == getGuardarButton()){
			new GuardarAsync().execute("");
		}else if (view == getCambiaButton()){
			if(getEdicionLayout().getVisibility() == View.INVISIBLE){
				getEdicionLayout().setVisibility(View.VISIBLE);
				getCambiaButton().setText("Cancelar");
			}else{
				getEdicionLayout().setVisibility(View.INVISIBLE);
				getCambiaButton().setText("Cambiar Clave");
				getClavenuevaEditText().setText("");
				getClavenueva1EditText().setText("");
				getClavenueva2EditText().setText("");
			}
			
		}
		
	}
	
	// Clase para ejecutar en Background
	class GuardarAsync extends AsyncTask<String, Integer, Integer> {

		// Metodo que prepara lo que usara en background, Prepara el progress
		@Override
		protected void onPreExecute() {
			pd = ProgressDialog.show(Perfil.this, "ENVIANDO DATOS",
					"ESPERE UN MOMENTO");
			pd.setCancelable(false);
		}

		// Metodo con las instrucciones que se realizan en background
		@Override
		protected Integer doInBackground(String... urlString) {
			try {
				setCambioHecho(CambiarClave());

			} catch (Exception exception) {

			}
			return null;
		}

		// Metodo con las instrucciones al finalizar lo ejectuado en background
		protected void onPostExecute(Integer resultado) {
			pd.dismiss();
			getMensaje().VerMensaje(Perfil.this, getRespuestaWS().getMensaje());
		}
	}

	private boolean CambiarClave() {
		try{
			String clavereal = user.getPassword();
			String claveactual = getClavenuevaEditText().getText().toString();
			String clavenueva1 = getClavenueva1EditText().getText().toString();
			String clavenueva2 = getClavenueva2EditText().getText().toString();
			System.out.println("clavereal = " + clavereal + ". claveactual = " + claveactual + ". clavenueva1 = " + clavenueva1 + ". clavenueva2 = " + clavenueva2);
			if (CamposLlenos(claveactual, clavenueva1, clavenueva2)){
				if (clavereal.equalsIgnoreCase(claveactual)){
					if (clavenueva1.equalsIgnoreCase(clavenueva2)){
						RequestWS request = new RequestWS();
						setRespuestaWS(request.CambiarClave(claveactual, clavenueva1));
						getMensaje().VerMensaje(Perfil.this, getRespuestaWS().getMensaje());
						return true;
					}else{
						getMensaje().ClavesNuevasDiferente(this);
						return false;
					}
				}else{
					getMensaje().ClaveActualDiferente(this);
					return false;
				}
			}else{
				getMensaje().CamposVacios(this);
				return false;
			}
		}catch(Exception exception){
			return false;
		}
		
	}

	private boolean CamposLlenos(String claveactual, String clavenueva1, String clavenueva2) {
		if (!claveactual.equalsIgnoreCase("") && !clavenueva1.equalsIgnoreCase("") && !clavenueva2.equalsIgnoreCase("")){
			return true;
		}
		return false;
	}

	public LinearLayout getEdicionLayout() {
		return edicionLayout;
	}

	public void setEdicionLayout(LinearLayout edicionLayout) {
		this.edicionLayout = edicionLayout;
	}

	public TextView getNombreTextView() {
		return nombreTextView;
	}

	public void setNombreTextView(TextView nombreTextView) {
		this.nombreTextView = nombreTextView;
	}

	public TextView getEmailText() {
		return emailText;
	}

	public void setEmailText(TextView emailText) {
		this.emailText = emailText;
	}

	public EditText getClavenuevaEditText() {
		return clavenuevaEditText;
	}

	public void setClavenuevaEditText(EditText clavenuevaEditText) {
		this.clavenuevaEditText = clavenuevaEditText;
	}

	public EditText getClavenueva1EditText() {
		return clavenueva1EditText;
	}

	public void setClavenueva1EditText(EditText clavenueva1EditText) {
		this.clavenueva1EditText = clavenueva1EditText;
	}

	public EditText getClavenueva2EditText() {
		return clavenueva2EditText;
	}

	public void setClavenueva2EditText(EditText clavenueva2EditText) {
		this.clavenueva2EditText = clavenueva2EditText;
	}

	public Button getCambiaButton() {
		return cambiaButton;
	}

	public void setCambiaButton(Button cambiaButton) {
		this.cambiaButton = cambiaButton;
	}

	public Button getGuardarButton() {
		return guardarButton;
	}

	public void setGuardarButton(Button guardarButton) {
		this.guardarButton = guardarButton;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isCambioHecho() {
		return cambioHecho;
	}

	public void setCambioHecho(boolean cambioHecho) {
		this.cambioHecho = cambioHecho;
	}

	public RespuestaWS getRespuestaWS() {
		return respuestaWS;
	}

	public void setRespuestaWS(RespuestaWS respuestaWS) {
		this.respuestaWS = respuestaWS;
	}
}

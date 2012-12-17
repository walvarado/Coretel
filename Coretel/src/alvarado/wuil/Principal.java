package alvarado.wuil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Principal extends Activity implements OnClickListener{
	private Button loginButton;
	private Button registrarButton;

	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		setLoginButton((Button)findViewById(R.id.principal_login_button));
		setRegistrarButton((Button)findViewById(R.id.principal_registrar_button));
		getLoginButton().setOnClickListener(this);
		getRegistrarButton().setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		if (view == getLoginButton()){
			IniciaLogin();
		}else if(view == getRegistrarButton()){
			Registrar();
		}
		
	}

	private void Registrar() {
		Intent intent = new Intent(Principal.this, Registrar.class);
		startActivity(intent);
	}

	private void IniciaLogin() {
		Intent intent = new Intent(Principal.this, Login.class);
		startActivity(intent);
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
	}

	public Button getRegistrarButton() {
		return registrarButton;
	}

	public void setRegistrarButton(Button registrarButton) {
		this.registrarButton = registrarButton;
	}

}

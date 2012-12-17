package com.researchmobile.coretel.ws;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Environment;
import android.util.Log;

import com.researchmobile.coretel.entity.Anotacion;
import com.researchmobile.coretel.entity.CatalogoAnotacion;
import com.researchmobile.coretel.entity.CatalogoComunidad;
import com.researchmobile.coretel.entity.CatalogoMiembro;
import com.researchmobile.coretel.entity.CatalogoTipoAnotacion;
import com.researchmobile.coretel.entity.DetalleComunidad;
import com.researchmobile.coretel.entity.Miembro;
import com.researchmobile.coretel.entity.RespuestaWS;
import com.researchmobile.coretel.entity.TipoAnotacion;
import com.researchmobile.coretel.entity.User;
import com.researchmobile.coretel.entity.Usuario;

public class RequestWS {
	private static final String WS_LOGIN = "ws_login.php?usuario=";
	private static final String WS_COMUNIDADES = "ws_comunidad.php?id=";
	private static final String WS_ANOTACIONES = "ws_anotacion.php?comunidad=";
	private static final String WS_DATOSUSUARIO = "ws_usuario.php?id=";
	private static final String WS_CREAUSUARIO = "login.actions.php?client=1&a=add&email=";
	private static final String WS_MISCOMUNIDADES = "dashboard.comunidades.usuario.php?usuario=";
	private static final String WS_DETALLECOMUNIDAD = "ws_comunidad.php?id=";
	private static final String WS_CATALOGOMIEMBRO = "ws_miembro.php?comunidad=";
	private static final String WS_MANDAREVENTO = "dashboard.anotaciones.actions.php?idusuario=";
	private static final String WS_CREACOMUNIDAD = "ws_crear_comunidad.php?usuario=";
	private static final String WS_CAMBIARCLAVE = "ws_update_usuario.php?action=clave&id=2&clave=";
	private static final String WS_CHAT = "envio?usuario=Luis&mensaje=";
	private static final String WS_NUEVOTIPOANOTACION = "ws_crear_tipo_anotacion.php?comunidad=";
	private static final String WS_LISTATIPOANOTACION = "ws_tipo_anotacion.php?comunidad=";
	
	private ConnectWS connectWS = new ConnectWS();
	
	public boolean Login(User user){
		JSONObject jsonObject = null;
		String finalURL = WS_LOGIN + user.getUsername() + "&clave=" + user.getPassword();
		boolean respuesta = false;
		try {
			jsonObject = connectWS.Login(finalURL);
			if (jsonObject != null){
				User user_t = new User();
				respuesta = Boolean.parseBoolean(jsonObject.getString("resultado"));
				JSONArray datosUsuario = jsonObject.getJSONArray("usuario");
				JSONObject id = (JSONObject) datosUsuario.get(0);
				user_t.setUserId(id.getString("id"));
				System.out.println("resultado = " + respuesta);
				return respuesta;
			}else{
				return respuesta;
			}
		} catch (JSONException e) {
			return respuesta;
		}
	}
	
	public RespuestaWS EnviarMensajeChat(String miMensaje) {
		JSONObject jsonObject = null;


		String finalURL = WS_CHAT + miMensaje;
		String url = finalURL.replace(" ", "%20");
		RespuestaWS respuesta = new RespuestaWS();
		try{
			jsonObject = connectWS.Chat(url);
			if (jsonObject != null){
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				System.out.println(respuesta.getMensaje());
				return respuesta;
			}
		}catch(Exception exception){
			return null;
		}
		return null;
	}
	
	public RespuestaWS NuevoTipoEvento(String idComunidad, String nombre, String descripcion, String tipo) {
		JSONObject jsonObject = null;
		
		String finalURL = WS_NUEVOTIPOANOTACION + idComunidad + "&incidente=1" + "&administrador=" + tipo + "&nombre=" + nombre + "&descripcion=" + descripcion;
		String url = finalURL.replace(" ", "%20");
		RespuestaWS respuesta = new RespuestaWS();
		try{
			jsonObject = connectWS.NuevoTipoEvento(url);
			if (jsonObject != null){
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				return respuesta;
			}
		}catch(Exception exception){
			return respuesta;
		}
		return null;
	}
	
	public RespuestaWS CrearUsuario(String nombre, String usuario, String email, String telefono) {
		JSONObject jsonObject = null;

		String finalURL = WS_CREAUSUARIO + email + "&nombre=" + nombre + "&telefono=" + telefono + "&usuario=" + usuario;
		RespuestaWS respuesta = new RespuestaWS();
		try{
			jsonObject = connectWS.CreaUsuario(finalURL);
			if (jsonObject != null){
				respuesta.setResultado(jsonObject.getBoolean("respuesta"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				System.out.println(respuesta.getMensaje());
				return respuesta;
			}
		}catch (Exception exception){
			return respuesta;
		}
		return null;
	}
	
	public CatalogoComunidad CargarComunidades(String id) {
		JSONArray jsonArray = null;
		String finalURL = WS_MISCOMUNIDADES + id + "&activo=1";
		RespuestaWS respuesta = new RespuestaWS();
		CatalogoComunidad catalogo = new CatalogoComunidad();
		try{
			jsonArray = connectWS.MisComunidades(finalURL);
			if (jsonArray != null){
				int tamano = jsonArray.length();
				DetalleComunidad[] comunidad = new DetalleComunidad[tamano];
				for (int i = 0; i < tamano; i++){
					JSONObject json = jsonArray.getJSONObject(i);
					DetalleComunidad com = new DetalleComunidad();
					com.setId(json.getString("id"));
					com.setNombre(json.getString("nombre"));
					comunidad[i] = com;
				}
				catalogo.setComunidad(comunidad);
				return catalogo;
			}
		}catch (Exception exception){
			return catalogo;
		}
		return null;
	}
	
	public RespuestaWS CreaComunidad(String nombre, String descripcion, String tipo) {
		JSONObject jsonObject = null;
		String finalURL = WS_CREACOMUNIDAD + User.getUserId() + "&tipo_comunidad=" + tipo + "&publica=" + "1" +"&nombre=" + nombre + "&descripcion=" + descripcion;
		RespuestaWS respuesta = new RespuestaWS();
		try{
			jsonObject = connectWS.CrearComunidad(finalURL);
			if (jsonObject != null){
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				return respuesta;
			}else{
				return respuesta;
			}
		}catch(Exception exception){
			return null;
		}
	}
	
	public CatalogoTipoAnotacion BuscarTiposEventos(String id) {
		CatalogoTipoAnotacion catalogo = new CatalogoTipoAnotacion();
		JSONObject jsonObject = null;
		String finalURL = WS_LISTATIPOANOTACION + id + "&activo=1";
		RespuestaWS respuesta = new RespuestaWS();
		try{
			jsonObject = connectWS.ListaTipoEventos(finalURL);
			if (jsonObject != null){
				System.out.println("json != null");
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				catalogo.setRespuestaWS(respuesta);
				if(respuesta.isResultado()){
					System.out.println("respuesta verdadera");
					JSONArray jsonArray = jsonObject.getJSONArray("tipo_anotacion");
					int tamano = jsonArray.length();
					TipoAnotacion[] tipoAnotacion = new TipoAnotacion[tamano];
					for (int i = 0; i < tamano; i++){
						JSONObject jsonTemp = jsonArray.getJSONObject(i);
						TipoAnotacion tipoTemp = new TipoAnotacion();
						tipoTemp.setId(jsonTemp.getString("id"));
						tipoTemp.setActivo(jsonTemp.getString("activo"));
						tipoTemp.setNombre(jsonTemp.getString("nombre"));
						tipoTemp.setComunidad(jsonTemp.getString("comunidad"));
						tipoTemp.setIcono(jsonTemp.getString("icono"));
						tipoTemp.setAdministrador(jsonTemp.getString("es_del_administrador"));
						tipoTemp.setIncidente(jsonTemp.getString("es_incidente"));
						tipoTemp.setDescripcion(jsonTemp.getString("descripcion"));
						tipoTemp.setNombreComunidad(jsonTemp.getString("nombrecomunidad"));
						tipoAnotacion[i] = tipoTemp;
					}
					catalogo.setTipoAnotacion(tipoAnotacion);
					System.out.println("retorno catalogo tipos de anotacion");
					return catalogo;
				}
				return catalogo;
			}
		}catch(Exception exception){
			return null;
		}
		return null;
	}
	
	public CatalogoMiembro CatalogoMiembro(String id) {
		JSONObject jsonObject = null;
		String finalURL = WS_CATALOGOMIEMBRO + id;
		RespuestaWS respuesta = new RespuestaWS();
		CatalogoMiembro catalogo = new CatalogoMiembro();
		try{
			jsonObject = connectWS.CatalogoMiembro(finalURL);
			if (jsonObject != null){
				System.out.println("CatalogoMiembro - != null");
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				catalogo.setRespuestaWS(respuesta);
				if(respuesta.isResultado()){
					System.out.println("CatalogoMiembro - respuesta true");
					JSONArray jsonArray = jsonObject.getJSONArray("miembro");
					
					int tamano = jsonArray.length();
					Miembro[] miembro = new Miembro[tamano];
					for (int i = 0; i < tamano; i++){
						System.out.println("CatalogoMiembro - cargando miembro");
						JSONObject mJson = jsonArray.getJSONObject(i);
						Miembro miembroTemp = new Miembro();
						miembroTemp.setId(mJson.getString("id"));
						miembroTemp.setId_comunidad(mJson.getString("id_comunidad"));
						miembroTemp.setId_usuario(mJson.getString("id_usuario"));
						miembroTemp.setNombreUsuario(mJson.getString("nombreUsuario"));
						miembroTemp.setFecha_registro(mJson.getString("fecha_registro"));
						miembroTemp.setNombreComunidad(mJson.getString("nombreComunidad"));
						miembroTemp.setNombreUsuarioInvito(mJson.getString("nombreUsuarioInvito"));
						miembro[i] = miembroTemp;
						System.out.println("CatalogoMiembro - miembro cargado");
					}
					catalogo.setMiembro(miembro);
					return catalogo;
				}
			}
		}catch(Exception exception){
			
		}
		return null;
	}
	
	public DetalleComunidad DetalleComunidad(String idComunidad) {
		JSONObject jsonObject = null;
		String finalURL = WS_DETALLECOMUNIDAD + idComunidad;
		RespuestaWS respuesta = new RespuestaWS();
		DetalleComunidad detalleComunidad = new DetalleComunidad();
		try{
			jsonObject = connectWS.DetalleComunidad(finalURL);
			if (jsonObject != null){
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				detalleComunidad.setRespuestaWS(respuesta);
				if(respuesta.isResultado()){
					detalleComunidad.setId(jsonObject.getString("id"));
					detalleComunidad.setNombre(jsonObject.getString("nombre"));
					detalleComunidad.setDescripcion(jsonObject.getString("descripcion"));
					detalleComunidad.setActivo(jsonObject.getString("activo"));
					return detalleComunidad;
				}else{
					return detalleComunidad;
				}
			}else{
				return null;
			}
		}catch(Exception exception){
			
		}
		return null;
	}
	
	public RespuestaWS MandarEvento(String titulo, String latitud, String longitud, String idUsuario, String comunidad, String tipoAnotacion, String descripcion, String imagen) {
		RespuestaWS respuesta = new RespuestaWS();
		
		final List<NameValuePair> nombresArchivos = new ArrayList<NameValuePair>(2);
		nombresArchivos.add(new BasicNameValuePair("usuario", "2"));
		nombresArchivos.add(new BasicNameValuePair("comunidad", "1"));
		nombresArchivos.add(new BasicNameValuePair("tipo_anotacion", "2"));
		nombresArchivos.add(new BasicNameValuePair("descripcion", "asasas"));
		nombresArchivos.add(new BasicNameValuePair("lat", "14.23232323"));
		nombresArchivos.add(new BasicNameValuePair("lon", "-90.23231212"));
		nombresArchivos.add(new BasicNameValuePair("Filedata",Environment.getExternalStorageDirectory() + imagen) );
		System.out.println(imagen);
		String url = "http://190.149.200.202/WS/ws_crear_anotacion.php?";
		post(url, nombresArchivos);
		return null;
	}
		
	public void post(String url, List<NameValuePair> nameValuePairs) {
		
	    HttpClient httpClient = new DefaultHttpClient();
	    HttpContext localContext = new BasicHttpContext();
	    HttpPost httpPost = new HttpPost(url);

	    try {
	        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

	        for(int index=0; index < nameValuePairs.size(); index++) {
	            if(nameValuePairs.get(index).getName().equalsIgnoreCase("Filedata")) {
	                System.out.println("campo = "+ nameValuePairs.get(index).getValue());
	                entity.addPart(nameValuePairs.get(index).getName(), new FileBody(new File (nameValuePairs.get(index).getValue())));
	            } else {
	            	System.out.println("campo = "+ nameValuePairs.get(index).getValue());
	                // Normal string data
	                entity.addPart(nameValuePairs.get(index).getName(), new StringBody(nameValuePairs.get(index).getValue()));
	            }
	        }

	        httpPost.setEntity(entity);

	        HttpResponse response = httpClient.execute(httpPost, localContext);
	        System.out.println("del envieo = " + response);
	        System.out.println("del envieo = " + response.getEntity().getContent());
	        System.out.println("del envieo = " + response.getParams());
	        System.out.println("del envieo = " + response.getEntity().getContentLength());
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
		
		/*
		JSONObject jsonObject = null;
		String finalURL = WS_MANDAREVENTO + idUsuario
		+ "&a=add"
		+"&inputtitulo=" + titulo 
		+"&inputtipoevento=" + tipoAnotacion 
		+"&inputdescripcion=" + descripcion 
		+"&inputlon=" + longitud
		+"&inputlat=" + latitud
		+"&usuario_anoto=" + idUsuario
		+"&comunidad=" + comunidad;
		String url = finalURL.replace(" ", "%20");
		RespuestaWS respuesta = new RespuestaWS();
		try{
			jsonObject = connectWS.MandarEvento(url);
			if (jsonObject != null){
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				return respuesta;
			}else{
				return null;
			}
		}catch(Exception exception){
			return null;
		}
		*/
	
	
	public RespuestaWS CambiarClave(String claveactual, String clavenueva1) {
		JSONObject jsonObject = null;
		String finalURL = WS_CAMBIARCLAVE + claveactual + "&nclave=" + clavenueva1;
		String url = finalURL.replace(" ", "%20");
		RespuestaWS respuesta = new RespuestaWS();
		try{
			jsonObject = connectWS.CambiarClave(url);
			if (jsonObject != null){
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				return respuesta;
			}else{
				return null;
			}
		}catch(Exception exception){
			return null;
		}
	}
	
	
	
	public Usuario CargarPerfil(String userId) {
		System.out.println(userId);
		JSONObject jsonObject = null;
		String finalURL = WS_DATOSUSUARIO + userId;
		RespuestaWS respuesta = new RespuestaWS();
		Usuario usuario = new Usuario();
		try{
			jsonObject = connectWS.DatosUsuario(finalURL);
			if(jsonObject != null){
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				usuario.setRespuestaWS(respuesta);
				if (respuesta.isResultado()){
					System.out.println("CargarPerfil - correcto");
					usuario.setNombre(jsonObject.getString("nombre"));
					usuario.setEmail(jsonObject.getString("email"));
					usuario.setTelefono(jsonObject.getString("telefono"));
					usuario.setFechaRegistro(jsonObject.getString("fecha_registro"));
					
					
					return usuario;
				}else{
					return usuario;
				}
			}else{
				return null;
			}
		}catch (Exception exception){
			return null;
		}
	}

	public CatalogoComunidad CargarComunidad(String idUsuario) {
		CatalogoComunidad catalogo = new CatalogoComunidad();
		RespuestaWS respuesta = new RespuestaWS();
		JSONObject jsonObject = null;
		String finalURL = WS_COMUNIDADES + idUsuario;
		try{
			jsonObject = connectWS.CatalogoComunidad(finalURL);
			if (jsonObject != null){
				System.out.println("json != null");
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				Log.d("WA", "mensaje capturado");
				catalogo.setRespuestaWS((RespuestaWS)respuesta);
				Log.d("WA", "respuesta en catalogo");
				System.out.println("RequestWS" + catalogo.getRespuestaWS().getMensaje());
				JSONArray comunidades = jsonObject.getJSONArray("comunidades");
				DetalleComunidad[] comunidad = new DetalleComunidad[comunidades.length()]; 
				for (int i = 0; i < comunidades.length(); i++){
					JSONObject jsonTemp = comunidades.getJSONObject(i);
					DetalleComunidad com = new DetalleComunidad();
					com.setId(jsonTemp.getString("id"));
					com.setNombre(jsonTemp.getString("nombre"));
					comunidad[i] = com;
				}
				catalogo.setComunidad(comunidad);
				return catalogo;
			}else{
				respuesta.setResultado(false);
				respuesta.setMensaje("Error de conexi�n");
				catalogo.setRespuestaWS(respuesta);
				return catalogo;
			}
		}catch(Exception exception){
			respuesta.setResultado(false);
			respuesta.setMensaje("Error de conexi�n");
			catalogo.setRespuestaWS(respuesta);
			System.out.println(exception);
			return catalogo;
		}
	}

	public CatalogoAnotacion CargarAnotaciones() {
		CatalogoAnotacion catalogo = new CatalogoAnotacion();
		RespuestaWS respuesta = new RespuestaWS();
		JSONObject jsonObject = null;
		String finalURL = WS_ANOTACIONES + "1&tipo_anotacion=2";
		try{
			jsonObject = connectWS.CatalogoAnotacion(finalURL);
			if (jsonObject != null){
				System.out.println("json != null");
				respuesta.setResultado(jsonObject.getBoolean("resultado"));
				respuesta.setMensaje(jsonObject.getString("mensaje"));
				Log.d("WA-ANOTACION", "mensaje capturado");
				catalogo.setRespuesta((RespuestaWS)respuesta);
				Log.d("WA-ANOTACION", "respuesta en catalogo");
				System.out.println("RequestWS" + catalogo.getRespuesta().getMensaje());
				JSONArray anotaciones = jsonObject.getJSONArray("anotacion");
				Anotacion[] anotacion = new Anotacion[anotaciones.length()]; 
				for (int i = 0; i < anotaciones.length(); i++){
					JSONObject jsonTemp = anotaciones.getJSONObject(i);
					Anotacion anota = new Anotacion();
					anota.setIdAnotacion(jsonTemp.getString("id"));
					anota.setDescripcion(jsonTemp.getString("descripcion"));
					anota.setTipo_anotacion(jsonTemp.getString("tipo_anotacion"));
					anota.setLatitud(Float.parseFloat(jsonTemp.getString("latitud")));
					anota.setLongitud(Float.parseFloat(jsonTemp.getString("longitud")));
					anota.setNombreTipoAnotacion(jsonTemp.getString("nombreTipoAnotacion"));
					anota.setFecha_registro(jsonTemp.getString("fecha_registro"));
					anota.setActivo(Integer.parseInt(jsonTemp.getString("activo")));
					anota.setUsuario_anoto(jsonTemp.getString("usuario_anoto"));
					anota.setIdcomunidad(jsonTemp.getString("comunidad"));
					anota.setNombreUsuario(jsonTemp.getString("nombreUsuario"));
					anota.setNombreComunidad(jsonTemp.getString("nombreComunidad"));
					anota.setIcono(jsonTemp.getString("icono"));
					anotacion[i] = anota;
				}
				catalogo.setAnotacion(anotacion);
				return catalogo;
			}else{
				respuesta.setResultado(false);
				respuesta.setMensaje("Error de conexi�n");
				catalogo.setRespuesta(respuesta);
				return catalogo;
			}
		}catch(Exception exception){
			respuesta.setResultado(false);
			respuesta.setMensaje("Error de conexi�n");
			catalogo.setRespuesta(respuesta);
			System.out.println(exception);
			return catalogo;
		}
	}

	

	

	
}

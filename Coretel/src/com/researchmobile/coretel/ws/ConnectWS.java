package com.researchmobile.coretel.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConnectWS {
	//private static String IP_SERVER = "23.22.165.103";
	private static String IP_SERVER = "174.129.97.85";
	private static int PUERTO = 80;
	
	public static JSONObject Login(String url) {			
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("Login - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
		return jsonObject;
	}
	
	public JSONObject CrearComunidad(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("Login - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
		return jsonObject;
	}
	
	public JSONObject CatalogoComunidad(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("CatalogoComunidad - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println("CatalogoComunidad " + exception);
			return jsonObject;
		}
	}
	
	public JSONObject CatalogoAnotacion(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("CatalogoAnotaciones - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONObject DatosUsuario(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("DatosUsuario - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONObject DetalleComunidad(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("DetalleComunidad - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONObject CatalogoMiembro(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("DetalleComunidad - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONObject MandarEvento(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("MandarEvento - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONObject CambiarClave(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("CambiarClave - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONObject NuevoTipoEvento(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("CambiarClave - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONArray MisComunidades(String url) {
		JSONArray jsonArray = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("DatosUsuario - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonArray = new JSONArray(responseInputStream);
			return jsonArray;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonArray;
		}
	}
	
	public void CrearUsuarioChat(String usuario, String nombre, String regId) {
		try{
		String url = "crearUsuario?usuario=" + usuario + "&nombre=" + nombre + "&regId=" + regId;
		URL urlCon = new URL("http", "23.21.82.207", 9010, "/ServiciosUsuario/" + url);
		HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
		InputStream inputStream = urlConnection.getInputStream();
		String responseInputStream = convertStreamToString(inputStream);
		System.out.println(responseInputStream);
		} catch (Exception exception) {
		
		}
	}
	
	
	
	public JSONObject CreaUsuario(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("DatosUsuario - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONObject ListaTipoEventos(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", IP_SERVER, PUERTO, "/WS/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("DatosUsuario - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	public JSONObject Chat(String url) {
		JSONObject jsonObject = null;
		try {
			URL urlCon = new URL("http", "23.21.82.207", 9010, "/EnviaMensaje/" + url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlCon.openConnection();
			System.out.println("Chat - url = " + urlCon);
			InputStream inputStream = urlConnection.getInputStream();
			
			String responseInputStream = convertStreamToString(inputStream);
			System.out.println(responseInputStream);
			jsonObject = new JSONObject(responseInputStream);
			return jsonObject;
		} catch (Exception exception) {
			System.out.println(exception);
			return jsonObject;
		}
	}
	
	//Metodo que convierte el String de respuesta a JSON
	private static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	
	
}


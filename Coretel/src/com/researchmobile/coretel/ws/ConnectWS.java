package com.researchmobile.coretel.ws;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class ConnectWS {
	//private static String IP_SERVER = "23.22.165.103";
	//private static String IP_SERVER = "174.129.97.85";
	private static String IP_SERVER = "23.23.1.2";
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
	
	public static JSONObject enviarImagen(String titulo, String latitud, String longitud, String idUsuario, String comunidad, String tipoAnotacion, String descripcion, String imagen) {

		JSONObject jsonObject = null;
		String myJpgPath = "/mnt/sdcard" + imagen;
		System.out.println(myJpgPath);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		Bitmap bm = BitmapFactory.decodeFile(myJpgPath, options);

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.JPEG, 20, stream);
		byte[] byteArray = stream.toByteArray();

		try {
		//InputStream is = this.getAssets().open(myJpgPath);
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost("http://23.23.1.2/WS/ws_crear_anotacion.php?" );
		byte[] data = byteArray;
		InputStreamBody isb = new InputStreamBody(new ByteArrayInputStream(byteArray),"imagen");
		StringBody usuario = new StringBody(idUsuario);
		StringBody com = new StringBody(comunidad);
		StringBody anot = new StringBody(tipoAnotacion);
		StringBody desc = new StringBody(descripcion);
		StringBody lat = new StringBody(latitud);
		StringBody lon = new StringBody(longitud);
		//StringBody sb2 = new StringBody("someTextGoesHere too");
		MultipartEntity multipartContent = new MultipartEntity();
		multipartContent.addPart("usuario", usuario);
        multipartContent.addPart("comunidad", com);
        multipartContent.addPart("tipo_anotacion", anot);
        multipartContent.addPart("descripcion", desc);
        multipartContent.addPart("lat", lat);
        multipartContent.addPart("lon", lon);
        multipartContent.addPart("Filedata", isb);
		//multipartContent.addPart("two", sb2);
		postRequest.setEntity(multipartContent);
		HttpResponse res = httpClient.execute(postRequest);
		InputStream inputStream = res.getEntity().getContent(); //Obteniendo inputStream
		String responseInputStream = convertStreamToString(inputStream); //Convirtiendo el inputStream a String
		Log.e("TT", responseInputStream);
		jsonObject = new JSONObject(responseInputStream); //asignando el Objeto JSON a response
		res.getEntity().getContent().close();
		return jsonObject;
		} catch (Throwable e)
		{
		// handle exception here
		}
		return jsonObject;
		}



	public JSONObject EnviaImagen(String titulo, String latitud, String longitud, String idUsuario, String comunidad, String tipoAnotacion, String descripcion, String imagen) {
		JSONObject jsonObject = null;
		String myJpgPath = "/sdcard" + imagen;
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		System.out.println("Connect mandar " + myJpgPath);
		Bitmap bm = BitmapFactory.decodeFile(myJpgPath, options);
		ByteArrayOutputStream stream = new ByteArrayOutputStream(); 
        bm.compress(Bitmap.CompressFormat.JPEG, 20, stream); 
        byte[] byteArray = stream.toByteArray();
        
        try {
            //InputStream is = this.getAssets().open(myJpgPath);
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost("http://" + IP_SERVER + "/WS/ws_crear_anotacion.php?");
            InputStreamBody isb = new InputStreamBody(new ByteArrayInputStream(byteArray),"imagen");
            StringBody sbLatitud = new StringBody(latitud);
            StringBody sbLongitud = new StringBody(longitud);
            StringBody sbUsuairo = new StringBody(idUsuario);
            StringBody sbComunidad = new StringBody(comunidad);
            StringBody sbAnotacion = new StringBody(tipoAnotacion);
            StringBody sbDescripcion = new StringBody(descripcion);
            //StringBody sb2 = new StringBody("someTextGoesHere too");
            MultipartEntity multipartContent = new MultipartEntity();
            multipartContent.addPart("usuario", sbUsuairo);
            multipartContent.addPart("comunidad", sbComunidad);
            multipartContent.addPart("tipo_anotacion", sbAnotacion);
            multipartContent.addPart("descripcion", sbDescripcion);
            multipartContent.addPart("lat", sbLatitud);
            multipartContent.addPart("lon", sbLongitud);
            multipartContent.addPart("Filedata", isb);
            System.out.println("Connect mandar evento multipart = " + multipartContent.toString());
            //multipartContent.addPart("two", sb2);
            postRequest.setEntity(multipartContent);
            System.out.println("Connect mandar evento postRequest = " + postRequest.getURI());
            HttpResponse res = httpClient.execute(postRequest);
            System.out.println("Connect mandar evento res = " + res.toString());
            InputStream inputStream = res.getEntity().getContent();   //Obteniendo inputStream
            System.out.println("Connect mandar evento inputstream = " + inputStream);
			String responseInputStream = convertStreamToString(inputStream);    //Convirtiendo el inputStream a String
			System.out.println("Connect mandar evento responseIS = " + responseInputStream);
	        jsonObject = new JSONObject(responseInputStream);   //asignando el Objeto JSON a response
	        System.out.println("Connect mandar evento 5");
            res.getEntity().getContent().close();
            System.out.println("Connect mandar evento 6");
            return jsonObject;
        } catch (Throwable e)
        {
            System.out.println(e);
        }
        return jsonObject;
	}
}


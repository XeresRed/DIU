/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.google.api.client.googleapis.media.MediaHttpDownloader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.google.api.services.drive.model.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Camilo
 */
public class busqueda {
    // Pasos para conseguir los datos CLIENT_ID y REDIRECT_URI en
	// https://developers.google.com/drive/quickstart-java#step_1_enable_the_drive_api
	private static final String CLIENT_ID = "944498025690-m24f9b1c4n86irfkciar1c65b4d4ild3.apps.googleusercontent.com";
	private static final String CLIENT_SECRET = "JmReZeyB8azLmxHcUwfHRE3Z";
	private static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
	private static drive gd;
        
        public String urlPermiso(){
            String url = "";
            gd=new drive(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI);
            url = gd.getURL();
            return url;
        }
        
        public List<File> getNombreArc(String code) throws IOException{
            gd.setCode(code);
            List<File> result = gd.retrieveAllFiles();
            
            return result;
        }
        
        public String contenido(File file) throws IOException{
            String p = gd.downloadTextFile(file);
            return p;
        }
        
        public InputStream descargaEx(File file){
            
            try {
                InputStream arc = gd.downloadFileEx(file);
                return  arc;
            } catch (IOException ex) {
                Logger.getLogger(busqueda.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        
        public byte[] descargaNo(File fileID, String conversion){
            
            try {
                byte[] arc = gd.downloadFile(fileID, conversion);
                return  arc;
            } catch (IOException ex) {
                Logger.getLogger(busqueda.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
	
	public static void main(String[] args) throws IOException{
		// Para permitir a nuestra aplicacion conectarse con nuestro google drive
		// primero tenemos que autorizarla abriendo una url en el navegador, darle
		// a permitir y copiar y pegar el codigo de autorizacion en la aplicacion
                
                
		/*gd=new drive(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI);
		
		System.out.println("Abre la siguiente URL en tu navegador:");
		System.out.println(" " + gd.getURL());
		System.out.println("Escribe el codigo de autorizacion:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		gd.setCode(code);*/
		
		// Sube un fichero de texto a google drive
		// El archivo document.txt se encuentra en la misma carpeta del proyecto
		// En el primer argumento se pone la ruta al fichero, en la segunda el
		// nombre del fichero en google drive
		//String fileID=gd.uploadTextFile("document.txt","documento.txt");
		//System.out.println("Fichero subido. ID del fichero:"+fileID);
		
		// Descarga el contenido del fichero de texto anteriormente subido
		//String contenido=gd.downloadTextFile(fileID);
		//System.out.println("Contenido:"+contenido);
		
		/*System.out.println("Pulse intro para listar los archivos de Google Drive");
		new InputStreamReader(System.in);
		
		System.out.println("Realizando consulta...");
		// Consulta los ficheros que hay actualmente en nuestro google drive
		List<File> result = gd.retrieveAllFiles();
		Iterator<File> iter = result.iterator();
		while (iter.hasNext()){
			System.out.println(iter.next().getTitle());
		}
		System.out.println("Ficheros encontrados:"+result.size());*/
    }
}

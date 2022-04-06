package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class ViewVentana{
	
	
	public ViewVentana(){
		
	}
	
	public int leerDatoInt(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		int d = Integer.parseInt(aux);
		return d;
	}
	public String leerDato(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	
	public void mostrarInformacion(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}

	public long leerDatoLong(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		long d = Long.parseLong(aux);
		return d;
	}
}
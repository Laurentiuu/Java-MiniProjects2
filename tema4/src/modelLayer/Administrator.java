package modelLayer;

import java.util.ArrayList;

import buisnessLayer.MenuItem;

/**
 * Clasa pentru utilizator
 * @author laurg
 *
 */
public class Administrator {

	private MenuItem item;
	
	public Administrator() {
		
	}
	
	/**
	 * Aici se genereaza datele pentru comenzile noi introduse
	 * @param nr
	 * @param nume
	 * @param ingrediente
	 */
	public Administrator(String nr, String nume, String ingrediente) {
		
		ArrayList<String>ing=new ArrayList<String>();
		String aux = ingrediente;
		int i=0;
		while(i<aux.length()) {
			i++;
			if (aux.charAt(i) == ',') {
				ing.add(aux.substring(0, i));
				aux=aux.substring(i+2, aux.length());
				i=0;
			}
			else if(i==aux.length()-1) {
				ing.add(aux.substring(0, i+1));
				break;
			}
			
		}
		this.item=new MenuItem(nr, nume, ing);
		
	}

	public MenuItem getItem() {
		return item;
	}
	
	
	
}

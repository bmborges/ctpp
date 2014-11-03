/**
 * 
 */
package valueObjects;

import java.io.Serializable;

/**
 * @author bruno
 *
 */

public class ComboBoxVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1040183036961149517L;
	
	
	String data;
	String label;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}


}

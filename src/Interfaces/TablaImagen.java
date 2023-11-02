
package Interfaces;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
//import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


public class TablaImagen extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        //setHorizontalAlignment(SwingConstants.CENTER); Alinear horizontalmente registros de la tabla
        
        
        if(o instanceof JLabel ){
            
            JLabel lbl= (JLabel)o;
            return lbl;
        }
        
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); 
    }
    
    
    
    
    
}



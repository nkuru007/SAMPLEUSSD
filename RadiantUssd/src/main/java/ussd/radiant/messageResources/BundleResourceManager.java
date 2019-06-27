/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussd.radiant.messageResources;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.Stateless;

/**
 *
 * @author ismaelnzamutuma
 */
@Stateless
public class BundleResourceManager implements Serializable{
    
   
    //private static final Logger LOGGER = Logger.getLogger(Messages.class.getName());
    
    public String getMessage(String key,String lang)
    {
      String BUNDLE_NAME = "ussd.radiant.messageResources.UssdMessageBundle_"+lang; //$NON-NLS-1$
      ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
       return  resourceBundle.getString(key);
    }
    
}

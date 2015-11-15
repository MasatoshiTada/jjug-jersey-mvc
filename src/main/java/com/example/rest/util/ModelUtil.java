package com.example.rest.util;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.glassfish.jersey.server.validation.ValidationError;

/**
 *
 * @author tada
 */
@Named
@ApplicationScoped
public class ModelUtil {
    /**
     * 
     * @param obj
     * @return objがList＜ValidationError＞であればtrue、そうでなければfalse
     */
    public boolean isValidationError(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty()) {
                return false;
            } else {
                return list.get(0) instanceof ValidationError;
            }
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param obj
     * @return objがExceptionであればtrue、そうでなければfalse
     */
    public boolean isException(Object obj) {
        return obj instanceof Exception;
    }
    
    /**
     * 
     * @param obj
     * @return objが(List＜ValidationError＞またはException)でなければtrue
     */
    public boolean isNotError(Object obj) {
        return !(isValidationError(obj) || isException(obj));
    }
}

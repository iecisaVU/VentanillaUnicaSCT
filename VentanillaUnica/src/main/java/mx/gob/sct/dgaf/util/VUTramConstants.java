package mx.gob.sct.dgaf.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class VUTramConstants {

    public static final int ZERO = 0;
    public static final int ONE_PIECE = 1;
    
    public static boolean ACTIVO = Boolean.TRUE;
    public static boolean NO_ACTIVO = Boolean.FALSE;
    
    public static String OK = "OK";
    public static String ERROR = "ERROR";
    
    public static String LABE_PERSONA = "TPersona";
//    public static String RFC_TEMP = "QQQ801212456";
    
    public static Locale LOCAL_MX = new Locale("es", "MX");
    
    public static String KEY_COLORF = "KEY_COLORF";
    public static String KEY_COLORH = "KEY_COLORH";
    public static String KEY_COLORR = "KEY_COLORR";
    public static String KEY_COLORRF = "KEY_COLORRF";
    public static String KEY_PARG = "KEY_PARG";
    
    public static String FOR_TITULO = "TITULO";
    public static String FOR_TEXTO = "TEXTO";
    public static String FOR_NUMERO = "NUMERO";
    public static String FOR_CURRENCY = "CURRENCY";
    public static String FOR_FECHA = "FECHA";
    public static String FOR_DEF = "DEFAULT";
    
    //DESCARGA REP FINALIZADOS
    public static String COMILLAS = "\"";
    public static String REPF_PREN = "solicitudesFinalizadas_";
    public static String REPF_ATT = "attachment; filename=";
    public static String REPF_CONT = "Content-disposition";
    public static String EXT_XLSX = ".xlsx";
    public static String EXT_PDF = ".pdf";
    public static String APP_XLSX = "application/xlsx";
    public static String APP_PDF = "application/pdf";
    
    
    public static final List<String> listHeRep = 
    	    Collections.unmodifiableList(Arrays.asList(
    	    		"Folio", 
    	    		"Departamento", 
    	    		"Descripción", 
    	    		"Fecha", 
    	    		"Estatus"
    	    		));
    
}

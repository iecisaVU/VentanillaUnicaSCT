package mx.gob.sct.dgaf.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class VUFechasUtil {
	
	public static final String EMPTY = "";
	public static final SimpleDateFormat FMTDAT = new SimpleDateFormat("dd-MM-yyyy");
	public static final SimpleDateFormat FMTDATH = new SimpleDateFormat("dd-MM-yyyy HHmmss");
	public static final SimpleDateFormat FMTDATF = new SimpleDateFormat("yyMMddHHmmss");

    public static String convDateTxt(final Date fecha) {
    	if(null == fecha) {
    		return VUFechasUtil.EMPTY;
    	}
    	return VUFechasUtil.FMTDAT.format(fecha);
    }
    
    public static String convDateTxtH(final Date fecha) {
    	if(null == fecha) {
    		return VUFechasUtil.EMPTY;
    	}
    	return VUFechasUtil.FMTDATH.format(fecha);
    }
    
    public static String convDateTxtF(final Date fecha) {
    	if(null == fecha) {
    		return VUFechasUtil.EMPTY;
    	}
    	return VUFechasUtil.FMTDATF.format(fecha);
    }
   
}

package mx.gob.sct.dgaf.services.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.VUSolicitud;
import mx.gob.sct.dgaf.services.ITramXLSService;
import mx.gob.sct.dgaf.services.dao.ITramiteDao;
import mx.gob.sct.dgaf.util.FilesBean;
import mx.gob.sct.dgaf.util.VUTramConstants;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service("iTramXLSServ")
public class TramXLSServiceImpl implements ITramXLSService {
	
	private static final Logger LOGVU = LoggerFactory.getLogger(TramXLSServiceImpl.class);
	
	@Autowired
	private ITramiteDao iTramDao;
	
	@Autowired
	protected MessageSource messageSource;
	
	@Autowired
	private FilesBean filesBean;

	@Override
	public byte[] reportSolicFin(final String rfcUser) throws VUException {
		final ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		
		try {
			final Map<String, Short> mapCellStyle = new HashMap<String, Short>();
			
			final XSSFWorkbook report = new XSSFWorkbook();
			final XSSFSheet hoja = report.createSheet(this.messageSource.
					getMessage("sol.nav.lab.fin", null, VUTramConstants.LOCAL_MX));
			
			mapCellStyle.putAll(this.cloneEstilos(report));
			
			
	        
	        int indexrow = 0;
	        final Row headTab = hoja.createRow(indexrow++);
	        
	        int index = 0;
	        for(final String header: VUTramConstants.listHeRep) {
	        	final Cell celda = headTab.createCell(index++, HSSFCell.CELL_TYPE_STRING);
		        celda.setCellStyle(report.getCellStyleAt(mapCellStyle.get(VUTramConstants.FOR_TITULO)));
		        celda.setCellValue(header);
	        }
	        
	        final List<VUSolicitud> listSol = this.iTramDao.getSolFin(rfcUser);
	        for(final VUSolicitud solict:listSol ) {
	        	int indexCeld = 0;
	        	final Row rowSoli = hoja.createRow(indexrow++);
	        	//folio
	        	this.addCelda(solict.getFolio(), indexCeld++, rowSoli, 
	        			report.getCellStyleAt(mapCellStyle.get(VUTramConstants.FOR_TEXTO)));
	        	
	        	this.addCelda(solict.getTramite().getDescDeptoTram(), indexCeld++, rowSoli, 
	        			report.getCellStyleAt(mapCellStyle.get(VUTramConstants.FOR_TEXTO)));
	        	
	        	this.addCelda(solict.getTramite().getDescTram(), indexCeld++, rowSoli, 
	        			report.getCellStyleAt(mapCellStyle.get(VUTramConstants.FOR_TEXTO)));
	        	
	        	this.addCelda(solict.getFechaReg(), indexCeld++, rowSoli, 
	        			report.getCellStyleAt(mapCellStyle.get(VUTramConstants.FOR_FECHA)));
	        	
	        	this.addCelda(solict.getEstSol().getDescEst(), indexCeld++, rowSoli, 
	        			report.getCellStyleAt(mapCellStyle.get(VUTramConstants.FOR_TEXTO)));
	        	
	        }
			
	        report.write(bOutput);
	        
		} catch (Exception expo) {
			LOGVU.error("error integrationtest XLS");
			throw new VUException(expo);
		} finally {
			if(null != bOutput) { 
				try { 
					bOutput.close();
				} catch (Exception expo) {
					LOGVU.error("error integrationtest XLS");
					throw new VUException(expo);
				} 
			}
		}
		return bOutput.toByteArray();
	}
	
	private final Map<String, Short> cloneEstilos(final XSSFWorkbook report) throws IOException {
		final Map<String, Short> mapCellStyle = new HashMap<String, Short>();
		
		final XSSFCellStyle defaUlt = report.createCellStyle();
		defaUlt.getCoreXf().unsetBorderId();
		defaUlt.setWrapText(true);
        mapCellStyle.put(VUTramConstants.FOR_DEF, defaUlt.getIndex());
		
		final XSSFWorkbook plantilla = new XSSFWorkbook(this.filesBean.getPlantXLS().getInputStream());
		final XSSFSheet hojaPl = plantilla.getSheetAt(0);
		
		final Iterator<Row> rowIterator = hojaPl.rowIterator();
        while (rowIterator.hasNext()) {
        	final Row renglon = rowIterator.next();
        	final Cell celda = renglon.getCell(0);
        	final XSSFCellStyle newStyle = report.createCellStyle();
        	newStyle.cloneStyleFrom(celda.getCellStyle());
        	newStyle.getCoreXf().unsetBorderId();
        	newStyle.setWrapText(true);
        	mapCellStyle.put(celda.getStringCellValue().toUpperCase(), newStyle.getIndex());
        }
        
        return mapCellStyle;
	}
	
	private void addCeldaBlank(int indexCeld, final Row rowSoli, final XSSFCellStyle estilo) {
		final Cell celda = rowSoli.createCell(indexCeld++, HSSFCell.CELL_TYPE_BLANK);
		celda.setCellStyle(estilo);
	}
	
	private void addCelda(final String valor, int indexCeld, final Row rowSoli, final XSSFCellStyle estilo) {
		if(null == valor) {
			this.addCeldaBlank(indexCeld, rowSoli, estilo);
		} else {
			final Cell celda = rowSoli.createCell(indexCeld++, HSSFCell.CELL_TYPE_STRING);
			celda.setCellStyle(estilo);
			celda.setCellValue(valor);
		}
	}
	
//	private void addCelda(final Double valor, int indexCeld, final Row rowSoli, final XSSFCellStyle estilo) {
//		if(null == valor) {
//			this.addCeldaBlank(indexCeld, rowSoli, estilo);
//		} else {
//			final Cell celda = rowSoli.createCell(indexCeld++, HSSFCell.CELL_TYPE_NUMERIC);
//			celda.setCellStyle(estilo);
//			celda.setCellValue(valor.doubleValue());
//		}
//	}
	
	private void addCelda(final Date valor, int indexCeld, final Row rowSoli, final XSSFCellStyle estilo) {
		if(null == valor) {
			this.addCeldaBlank(indexCeld, rowSoli, estilo);
		} else { 
			final Cell celda = rowSoli.createCell(indexCeld++, HSSFCell.CELL_TYPE_NUMERIC);
			celda.setCellStyle(estilo);
			celda.setCellValue(valor);
		}
	}
	
	
}

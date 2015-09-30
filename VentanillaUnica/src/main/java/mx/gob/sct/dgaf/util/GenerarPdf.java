package mx.gob.sct.dgaf.util;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import mx.gob.sct.dgaf.documentos.DigitalizarDocumento;
import mx.gob.sct.dgaf.documentos.DigitalizarDocumentoServiceLocator;
import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.VUSolicitud;
import mx.gob.sct.dgaf.services.ICatalogoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerarPdf {
	private static final Logger LOGVU = LoggerFactory
			.getLogger(GenerarPdf.class);

	@Autowired
	protected MessageSource messageSource;
	@Autowired
	private FilesBean filesBean;
	
	//@Autowired
	//ContentManagerDocument contentManager;
	@Autowired
	ICatalogoService catalogoService;

	public GenerarPdf() {

	}

	public  byte[] pdf(List<String> listaHeaderTablePdf,Map<String, String> mapaPdf, String firmaDigital)
			throws DocumentException, IOException {
		
		String rutaPdf = null;
		PdfWriter writer = null;
		HeaderFooter event = null;
		String titulo=null;
		final Document document = new Document(PageSize.A4, 10, 10, 10, 70);
		final ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		try {
			rutaPdf =messageSource.getMessage("generaPdf.pdf.rutaPdf", null,
					 Locale.getDefault());
			titulo =messageSource.getMessage("generaPdf.pdf.DGAF", null,
					 Locale.getDefault()); 
			writer  = PdfWriter.getInstance(document, bOutput);
			event = new HeaderFooter(
	        		filesBean.getFileSctImg().getURL().getPath(),
	        		filesBean.getFileImgSello().getURL().getPath()
	        		, footer(),titulo);
			writer.setPageEvent(event);
			
		    document.open();
		    LOGVU.info("Inicia Generacion de PDF");    
		    document.add(new Paragraph(" "));
//		    cuerpo(listaHeaderTablePdf, mapaPdf);
		    document.add(this.cuerpo(listaHeaderTablePdf, mapaPdf));
		    final PdfPTable tablaPDF = getTablaPDF(firmaDigital);
			
			document.add(tablaPDF);		        
		    //document.close();			
			LOGVU.info("PDF GENERADO CORRECTAMENTE");
		} catch (Exception expo) {
			LOGVU.error("error al generar PDF", expo);
		}finally {
			if(null != document) {
				document.close();
			}
			
		}
		return bOutput.toByteArray();
		
		
	}

	private PdfPTable getTablaPDF(String firmaDigital) {
		
		final PdfPTable tabPDF = new PdfPTable(4);
		final PdfPCell cellPDF = new PdfPCell(
				new Paragraph(messageSource.getMessage("generaPdf.pdf.firmaDigital", null, VUTramConstants.LOCAL_MX)));
		cellPDF.setBorder(Rectangle.NO_BORDER);
		cellPDF.setColspan(4);
		
		final PdfPCell cellFirm = new PdfPCell(new Paragraph(firmaDigital));
		cellFirm.setBorder(Rectangle.NO_BORDER);
		cellFirm.setColspan(4);
		
		tabPDF.addCell(cellPDF);
		tabPDF.addCell(cellFirm);
		return tabPDF;
	}
	
	
	private PdfPTable footer(){
		
        PdfPTable footer = new PdfPTable(1);
        footer.setTotalWidth(523);
        Font colorLetra= new Font();
        colorLetra.setColor(new BaseColor(Color.white));
        colorLetra.setSize(8);
        
        PdfPCell cell = new PdfPCell(new Paragraph(
        		messageSource.getMessage("generaPdf.pdf.DireccionPart1", null,
   					 Locale.getDefault()),colorLetra));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(new BaseColor(0,0,0));		
        footer.addCell(cell);        
        cell = new PdfPCell( new Paragraph(
        		messageSource.getMessage("generaPdf.pdf.DireccionPart2", null,
   					 Locale.getDefault())
   					,colorLetra));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(new BaseColor(0,0,0));		
        footer.addCell(cell);
        cell = new PdfPCell(new Paragraph(
        		messageSource.getMessage("generaPdf.pdf.DireccionPart3", null,
   					 Locale.getDefault())
   					,colorLetra));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(new BaseColor(0,0,0));		
        footer.addCell(cell);
        return footer;
    }
	
	private PdfPTable cuerpo(final List<String> listaHeaderTable, final Map<String, String> mapa) throws DocumentException{
        
		PdfPTable body = new PdfPTable(12);
        body.setWidthPercentage(100);
        Font colorLetra= null;
		Paragraph aliniarTexto = null;
		PdfPCell cellCuerpoHeader=null; 
        
		//pinta los header de la tabla 
		for (String valorCelda : listaHeaderTable) {
			aliniarTexto = new Paragraph();
			aliniarTexto.setAlignment(Element.ALIGN_CENTER);
			colorLetra= new Font();
			colorLetra.setColor(new BaseColor(Color.white));
				
			cellCuerpoHeader = new PdfPCell(new Phrase(valorCelda, colorLetra));
			cellCuerpoHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellCuerpoHeader.setBackgroundColor(new BaseColor(0,0,0));
			cellCuerpoHeader.setBorder(Rectangle.NO_BORDER);
			cellCuerpoHeader.setColspan(12);
			body.addCell(cellCuerpoHeader);
		}
		
		
		PdfPCell cellSaltoDeLinea=new PdfPCell();
		cellSaltoDeLinea = new PdfPCell(new Phrase(" "));
		cellSaltoDeLinea.setBorder(Rectangle.NO_BORDER);
		cellSaltoDeLinea.setColspan(12);
		body.addCell(cellSaltoDeLinea);

		for (Map.Entry<String,String> entry : mapa.entrySet()) {
			
		    String key = entry.getKey();
		    String value = entry.getValue();
		    
		    PdfPCell celdaEnBlanco = new PdfPCell(new Phrase(""));
	        celdaEnBlanco.setColspan(2);
	        celdaEnBlanco.setBorder(0);
		    
			aliniarTexto = new Paragraph();
			aliniarTexto.setAlignment(Element.ALIGN_CENTER);
			colorLetra= new Font();
			colorLetra.setColor(new BaseColor(Color.BLACK));
			
			PdfPCell celdaKey = new PdfPCell(new Phrase(key,colorLetra));
	        celdaKey.setColspan(3);
	        celdaKey.setBorder(0);
	        
	        PdfPCell celdaValor = new PdfPCell(new Phrase(value,colorLetra));
	        celdaValor.setColspan(5);
	        celdaValor.setBorder(0);
			
	        body.addCell(celdaEnBlanco);
	        body.addCell(celdaKey);
	        body.addCell(celdaValor);
	        body.addCell(celdaEnBlanco);

		}
		
		return body;
	}
	
	public byte[] generaArcSol(final List<VUSolicitud> listSolic, final String titulo, final String firmaDigital) throws VUException {
		
		final Document document = new Document(PageSize.A4, 10, 10, 10, 70);
		final ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		try {
			final PdfWriter writer  = PdfWriter.getInstance(document, bOutput);
			
			final HeaderFooter event = new HeaderFooter(this.footer(), 
					filesBean.getFileSctImg().getURL().getPath(), titulo);
			writer.setPageEvent(event);
			
		    document.open();
		    document.add(new Paragraph(" "));
		    document.add(this.cuerpoSol(listSolic));
		    
		    final PdfPTable tabPDF = getTablaPDF(firmaDigital);
			document.add(tabPDF);
		} catch(Exception expo) {
			LOGVU.error("ERRROR al generar PDF", expo);
		} finally {
			if(null != document) {
				document.close();
			}
		}
		return bOutput.toByteArray();
	}
	
	private PdfPCell constCelda(final String valorCelda, final Map<String, Object> mapCarac) {
		final PdfPCell cellCuerpoHeader = new PdfPCell(new Paragraph(valorCelda, (Font) mapCarac.get(VUTramConstants.KEY_COLORF)));
		cellCuerpoHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellCuerpoHeader.setBackgroundColor((BaseColor) mapCarac.get(VUTramConstants.KEY_COLORH));
		cellCuerpoHeader.setBorder(Rectangle.NO_BORDER);
		return cellCuerpoHeader;
	}
	
	private PdfPCell constCeldaR(final String valorCelda, final Map<String, Object> mapCarac) {
		final PdfPCell cellRow = new PdfPCell(new Paragraph(valorCelda, (Font) mapCarac.get(VUTramConstants.KEY_COLORRF)));
		cellRow.setPaddingLeft(3f);
		cellRow.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellRow.setBackgroundColor((BaseColor) mapCarac.get(VUTramConstants.KEY_COLORR));
		cellRow.setBorderWidth(1f);
		cellRow.setBorderColor(new BaseColor(Color.white));
		return cellRow;
	}
	
	private PdfPTable cuerpoSol(final List<VUSolicitud> listSol) throws DocumentException{
        
		final PdfPTable body = new PdfPTable(5);
        body.setWidthPercentage(95);
        
        final Map<String, Object> mapConfig = this.getMapSol();
        
		//pinta los header de la tabla 
        for(final String header: VUTramConstants.listHeRep) {
        	body.addCell(this.constCelda(header, mapConfig));
        }
		
        for(final VUSolicitud solicitud: listSol) {
        	body.addCell(this.constCeldaR(solicitud.getFolio(), mapConfig));
        	body.addCell(this.constCeldaR(solicitud.getTramite().getDescDeptoTram(), mapConfig));
        	body.addCell(this.constCeldaR(solicitud.getTramite().getDescTram(), mapConfig));
        	body.addCell(this.constCeldaR(solicitud.getFecView(), mapConfig));
        	body.addCell(this.constCeldaR(solicitud.getEstSol().getDescEst(), mapConfig));
        	
        	body.completeRow();
        }
        
        PdfPCell celdaValor = new PdfPCell(new Phrase(""));
        celdaValor.setColspan(50);
        celdaValor.setBorder(0);
        body.addCell(celdaValor);
        
        
        return body;
	}
	
	private Map<String, Object> getMapSol() {
		
		final HashMap<String,Object> mapCarac = new HashMap<String, Object>();
		
		final Paragraph paraText = new Paragraph();
		paraText.setAlignment(Element.ALIGN_CENTER);
		
		final Font colorLetra= new Font();
		colorLetra.setColor(new BaseColor(Color.white));
		
		final Font colorRow = new Font();
		colorRow.setColor(new BaseColor(39,40,41));
		
		mapCarac.put(VUTramConstants.KEY_COLORF, colorLetra);
		mapCarac.put(VUTramConstants.KEY_PARG, paraText);
		mapCarac.put(VUTramConstants.KEY_COLORH, new BaseColor(57, 60, 62));
		mapCarac.put(VUTramConstants.KEY_COLORR, new BaseColor(84, 84, 84));
		mapCarac.put(VUTramConstants.KEY_COLORRF, colorRow);
		
		
		return mapCarac;
	}
	
	
	public File procesaDocumento(byte[] documento){
		
		String CVE=null;
		File file =null;
		for(int i=0; i<10;i++){
			catalogoService.getActSecuenciaInodocto();			
		}
		CVE = catalogoService.getSecuenciaInodocto()+"";
		
        //String CVE = "6122";
		String[] DOWMLOAD_KEYS=    
			{ 
				messageSource.getMessage("DOWMLOAD_KEYS.userid", null,Locale.getDefault()), //"userid", 
				messageSource.getMessage("DOWMLOAD_KEYS.password", null,Locale.getDefault()), //"password", 
				messageSource.getMessage("DOWMLOAD_KEYS.entity", null,Locale.getDefault()), //"entity", 
				messageSource.getMessage("DOWMLOAD_KEYS.maxResults", null,Locale.getDefault()), //"maxResults", 
				messageSource.getMessage("DOWMLOAD_KEYS.queryOP", null,Locale.getDefault()), //"queryOP", 
				messageSource.getMessage("DOWMLOAD_KEYS.lintiCveDocumen", null,Locale.getDefault()) //"lintiCveDocumen" 
			};
		String[] DOWMLOAD_VALUES= 
			{ 
				messageSource.getMessage("DOWMLOAD_VALUES.userid", null,Locale.getDefault()), //"icmadmin",
				messageSource.getMessage("DOWMLOAD_VALUES.password", null,Locale.getDefault()), //"lscmv82",
				messageSource.getMessage("DOWMLOAD_VALUES.entity", null,Locale.getDefault()), //"DGAFDocDesa",
				messageSource.getMessage("DOWMLOAD_VALUES.maxResults", null,Locale.getDefault()), //"1", 
				messageSource.getMessage("DOWMLOAD_VALUES.queryOP", null,Locale.getDefault()), //"true", 
				CVE
			};
		
		String[] UPLOAD_KEYS=
			{ 
				messageSource.getMessage("UPLOAD_KEYS.userid", null,Locale.getDefault()), //"userid",
				messageSource.getMessage("UPLOAD_KEYS.password", null,Locale.getDefault()), //"password", 
				messageSource.getMessage("UPLOAD_KEYS.entity", null,Locale.getDefault()), //"entity", 
				messageSource.getMessage("UPLOAD_KEYS.mimeType", null,Locale.getDefault()), //"mimeType", 
				messageSource.getMessage("UPLOAD_KEYS.lintiCveDocumen", null,Locale.getDefault()) //"lintiCveDocumen" 
			};
		String[] UPLOAD_VALUES=
			{ 
				messageSource.getMessage("UPLOAD_VALUES.userid", null,Locale.getDefault()), //"icmadmin", 
				messageSource.getMessage("UPLOAD_VALUES.password", null,Locale.getDefault()), //"lscmv82", 
				messageSource.getMessage("UPLOAD_VALUES.entity", null,Locale.getDefault()), //"DGAFDocDesa",
				messageSource.getMessage("UPLOAD_VALUES.mimeType", null,Locale.getDefault()), //"application/octet-stream", 
				CVE
			};
		
		String[] DOWMLOAD_OPERATORS   = { "","","","","",messageSource.getMessage("DOWMLOAD_OPERATORS.equal", null,Locale.getDefault()) };
		
	    DigitalizarDocumentoServiceLocator wsSerConSL = new DigitalizarDocumentoServiceLocator();

		String idDoc = "";
		try {		
			
			DigitalizarDocumento wsSerCon = wsSerConSL.getDigitalizarDocumentoSoapPort(new URL("http://aplicaciones7.sct.gob.mx/Documentos/DigitalizarDocumento"));
			LOGVU.info("asigna documento al contenedor");   
			idDoc= wsSerCon.asignar(
					messageSource.getMessage("UPLOAD_VALUES.userid", null,Locale.getDefault()),
					messageSource.getMessage("UPLOAD_VALUES.password", null,Locale.getDefault()),
					messageSource.getMessage("UPLOAD_VALUES.entity", null,Locale.getDefault()),
					UPLOAD_KEYS, 
					UPLOAD_VALUES, 
					documento);
			LOGVU.info("idDoc: "+idDoc);  
			documento = wsSerCon.obtener(
					messageSource.getMessage("DOWMLOAD_VALUES.userid", null,Locale.getDefault()), 
					messageSource.getMessage("DOWMLOAD_VALUES.password", null,Locale.getDefault()), 
					messageSource.getMessage("DOWMLOAD_VALUES.entity", null,Locale.getDefault()), 
					DOWMLOAD_KEYS, 
					DOWMLOAD_VALUES, 
					DOWMLOAD_OPERATORS);
			LOGVU.info("obtine archivo del contenedor: "+ documento);
			
			file = new File(CVE+".pdf");
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(documento);
			
			fos.close();
			LOGVU.info("Longitud: "+file);  
			
			
		}catch(Exception e){
			e.printStackTrace();
			}
		return file;
	}
		
}
package mx.gob.sct.dgaf.util;



import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class HeaderFooter extends PdfPageEventHelper {

	protected PdfPTable footer;
	protected String logoSct;
	protected String selloDigital;	
	protected String titulo;

	
	public HeaderFooter(String logoSct, String selloDigital,PdfPTable footer, String titulo) {
		this.logoSct = logoSct;
		this.selloDigital = selloDigital;
		this.footer = footer;
		this.titulo = titulo;
	}
	
	public HeaderFooter(PdfPTable footer, String logoSct, String titulo) {
		super();
		this.footer = footer;
		this.logoSct = logoSct;
		this.titulo = titulo;
	}

	@Override
	public void onStartPage(PdfWriter writer, Document document) {		
		
		Image imageHeader = null;
		PdfPCell cellImg= null;
		PdfPCell cellText= null;
		PdfPCell cellSepador= null;
		Phrase phrase= null;
		LineSeparator ls=null;
		PdfPTable header = new PdfPTable(3);
        header.setWidthPercentage(100);

		try {
			cellImg=new PdfPCell();			
			imageHeader = Image.getInstance(logoSct);
			imageHeader.scaleAbsolute(200, 70);
			cellImg.setImage(imageHeader);
			cellImg.setBorder(Rectangle.NO_BORDER);
			header.addCell(cellImg);
			
			phrase=new Phrase();
			phrase.add(titulo);
					
			cellText = new PdfPCell(phrase);			
			cellText.setBorder(Rectangle.NO_BORDER);
			cellText.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellText.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cellText.setColspan(2);
			header.addCell(cellText);
			
			cellSepador=new PdfPCell();
			cellSepador.setBorder(Rectangle.NO_BORDER);
			cellSepador.setColspan(3);
			ls= new LineSeparator();
			cellSepador.addElement(new Chunk(ls));
			header.addCell(cellSepador);
			
			
			document.add(header);
			//document.add(new Paragraph(" "));
			//document.add(cellSepador);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {

		try {
	    	footer.writeSelectedRows(0, -1, 36, 50, writer.getDirectContent());
	    	} catch(Exception e){
	         e.printStackTrace();
	     }		
	}


	public String getLogoSct() {
		return logoSct;
	}

	public void setLogoSct(String logoSct) {
		this.logoSct = logoSct;
	}

	public String getSelloDigital() {
		return selloDigital;
	}

	public void setSelloDigital(String selloDigital) {
		this.selloDigital = selloDigital;
	}

	public PdfPTable getFooter() {
		return footer;
	}

	public void setFooter(PdfPTable footer) {
		this.footer = footer;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}

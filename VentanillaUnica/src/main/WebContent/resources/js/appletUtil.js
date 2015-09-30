/* 
 *
 *applet util 
 *
 */

var cOutputPath = "";
var cNombre = "";
var cCURP = "";
var cRFC = "";
var cCadFirmada = "";
var cCertNum = "";
var cFirmNum = "";
var cLocSerialNumber = "";
var cLocIssuerDN = "";
var cLocSubjectDN = "";

function funcionNameSuccess(outputPaths) {
}

function funcionNameCancel() {
	 window.location.href = contextvu +'/login.sct?rfc=MARO830417374&curp=MARO830417HDFRSS03&nombre=nombre1234&confirm='+isConfirm+'&rfcConfirm='+rfcConfirm;                                       
}

function funcionGetContibuyente(nombre, curp, rfc) {
    alert(cNombre);
    cNombre = nombre;
    cCURP = curp;
    cRFC = rfc;
    
}
function firmaCadenaFuntion(firma) {
    cCadFirmada = '';//firma;
}
function getDataCert(cSerialNumber, cIssuerDN, SubjectDN, cCertOut, cCertificado, cFirmaNumber) {
    cCertNum = cCertificado;
    cFirmNum = cFirmaNumber;
    cLocSerialNumber = cSerialNumber;
    cLocIssuerDN = cIssuerDN;
    cLocSubjectDN = SubjectDN;
}

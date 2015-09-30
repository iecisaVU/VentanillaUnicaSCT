package mx.gob.sct.dgaf.services;

import mx.gob.sct.dgaf.exception.VUException;

public interface ITramXLSService {
	byte[] reportSolicFin(final String rfcUser) throws VUException;
}

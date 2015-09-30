package mx.gob.sct.dgaf.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@MappedJdbcTypes(JdbcType.CHAR)
@MappedTypes(Boolean.class)
public class BooleanTypeHandler  extends BaseTypeHandler<Object> {
	
	private static final Logger LOGVU = LoggerFactory.getLogger(BooleanTypeHandler.class);

	private static final String YES = "Y";
	private static final String NO = "N";

	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return transformtoBoolean(rs.getString(columnName));
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return transformtoBoolean(rs.getString(columnIndex));
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return transformtoBoolean(cs.getString(columnIndex));
	}

	private Boolean transformtoBoolean(final String strValue) throws SQLException {
		if (YES.equalsIgnoreCase(strValue)) {
			return Boolean.TRUE;
		} else if (NO.equalsIgnoreCase(strValue)) {
			return Boolean.FALSE;
		} else {
			LOGVU.error("por omision se regresa false");
			return Boolean.FALSE;
		}
	}
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			Object parameter, JdbcType jdbcType) throws SQLException {
	}

}
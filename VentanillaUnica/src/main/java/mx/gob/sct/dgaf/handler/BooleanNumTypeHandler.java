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


@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(Boolean.class)
public class BooleanNumTypeHandler  extends BaseTypeHandler<Object> {
	
	private static final Logger LOGVU = LoggerFactory.getLogger(BooleanNumTypeHandler.class);

	private static final int ZERO = 0;
	private static final int ONEPIECE = 1;

	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return transformtoBoolean(rs.getInt(columnName));
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return transformtoBoolean(rs.getInt(columnIndex));
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return transformtoBoolean(cs.getInt(columnIndex));
	}

	private Boolean transformtoBoolean(final int intValue) throws SQLException {
		if (ONEPIECE == intValue) {
			return Boolean.TRUE;
		} else if (ZERO == intValue) {
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
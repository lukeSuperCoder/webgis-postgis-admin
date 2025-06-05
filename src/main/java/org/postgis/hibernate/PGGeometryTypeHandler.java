package org.postgis.hibernate;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.postgis.PGgeometry;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PostGIS几何类型处理器
 */
public class PGGeometryTypeHandler extends BaseTypeHandler<Object> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter);
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object obj = rs.getObject(columnName);
        return obj;
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Object obj = rs.getObject(columnIndex);
        return obj;
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object obj = cs.getObject(columnIndex);
        return obj;
    }
} 
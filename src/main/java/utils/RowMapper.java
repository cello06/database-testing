package utils;

import org.apache.poi.ss.formula.functions.T;

import java.sql.ResultSet;

public interface RowMapper<T> {

	T mapRow(ResultSet rs) throws Exception;

}

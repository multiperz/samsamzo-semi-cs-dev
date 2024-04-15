package hong.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hong.cs.dto.CSDTO;
import hong.cs.service.CSService;

public class CSDAO implements CSService {
	private static Log log = LogFactory.getLog(CSDAO.class);

	@Override
	public ArrayList<CSDTO> csSelect() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<CSDTO> arrayList = new ArrayList<CSDTO>();

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select cs_number, cs_title, cs_date from ci";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CSDTO csDTO = new CSDTO();
				csDTO.setCs_number(resultSet.getInt("cs_number"));
				csDTO.setCs_title(resultSet.getString("cs_title"));
				csDTO.setCs_date(resultSet.getString("cs_date"));
				arrayList.add(csDTO);
			}
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 문의가 없습니다. 문의를 등록해 주세요.");
			}
		} catch (Exception e) {
			log.info("전체 문의 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public CSDTO csSelectDetail(int cs_number) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CSDTO csDTO = new CSDTO();

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select cs_number, cs_title, cs_date from ci";
			sql += " where cs_number=?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cs_number);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				csDTO.setCs_number(resultSet.getInt("cs_number"));
				csDTO.setCs_title(resultSet.getString("cs_title"));
				csDTO.setCs_date(resultSet.getString("cs_date"));
			}
		} catch (Exception e) {
			log.info("특정 부서 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return csDTO;
	}

	@Override
	public CSDTO csInsert(CSDTO csDTO) {
		return null;
	}

	@Override
	public CSDTO csUpdate(CSDTO csDTO) {
		return null;
	}

	@Override
	public CSDTO csDelete(int cs_number) {
		return null;
	}
}
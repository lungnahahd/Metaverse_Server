package com.Lungnaha.MetaverseServer.Repository;

import com.Lungnaha.MetaverseServer.Domain.DataForm;
import com.Lungnaha.MetaverseServer.Interface.DBInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// DB 저장을 위해서  JDBC 템플릿을 활용
// DB 저장소를 구현하기 위해서 인터페이스를 활용\

public class TemplateJDBC implements DBInterface {
    private final JdbcTemplate jdbcTemplate;
    
    public TemplateJDBC(DataSource dataSource) {
        // jdbc 템플릿 생성자 처리 -> DataSource를 통해서 DB 연결
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 데이터를 저장하는 부분
    @Override
    public DataForm Save(DataForm dataForm) {
        jdbcTemplate.update("INSERT INTO `springprac`.`server` (`id`, `password`) VALUES (?,?)",dataForm.getId(),dataForm.getPassword());
        return null;
    }

    // 데이터를 이름으로 찾는 부분
    @Override
    public Optional<DataForm> FindByName(String id) {
        List<DataForm> result = jdbcTemplate.query("SELECT * FROM server where id = ?", new DataRowMapper(), id );
        return result.stream().findAny(); // 반환이 Optional이므로 이를 처리하기 위해서 이렇게 구현
    }

    // 데이터 전체를 받아 오는 부분
    @Override
    public List<DataForm> FindAll() {
        return jdbcTemplate.query("SELECT * FROM server", new DataRowMapper());
    }

    // Query문의 결과를 객체로 변환해서 받을 수 있도록 구현해주는 함수
    public class DataRowMapper implements RowMapper<DataForm>{

        @Override
        public DataForm mapRow(ResultSet rs, int rowNum) throws SQLException {
            DataForm dataForm = new DataForm();
            dataForm.setNum(rs.getInt("num"));
            dataForm.setId(rs.getString("id"));
            dataForm.setPassword(rs.getString("password"));
            return dataForm;
        }
    }


}

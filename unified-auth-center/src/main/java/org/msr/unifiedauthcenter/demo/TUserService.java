package org.msr.unifiedauthcenter.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-06-15 21:57
 **/
@Service
public class TUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RowMapper<TUser> rowMapper() {
        return (resultSet, row) -> {
            TUser tUser = new TUser();
            tUser.setId(resultSet.getLong("id"));
            tUser.setUsername(resultSet.getString("username"));
            return tUser;
        };
    }

    public List<TUser> getUsers() {
        String sql = "SELECT id, username FROM t_user";
        return jdbcTemplate.query(sql, rowMapper());
    }
}

package org.jesus.spring.filemaker;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.*;

@Slf4j
//@SpringBootTest
@ActiveProfiles("local")
public class FMJdbcTest {

    @Test
    public void test(){
        log.debug("connection test start...");
        // register the JDBC client driver
        try {
            Driver d = (Driver)Class.forName("com.filemaker.jdbc.Driver").newInstance();
        } catch(Exception e) {
            log.error("driver error: ", e);
        }
// establish a connection to FileMaker
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:filemaker://localhost/Tasks","jin", "1234");
        } catch(Exception e) {
            log.error("connection error: ", e);
        }
// get connection warnings
        SQLWarning warning = null;
        try {
            warning = con.getWarnings();
            if (warning == null) {
                //System.out.println("No warnings");
                log.info("no error: ");
            }
            while (warning != null) {
                //System.out.println("Warning: "+warning);
                log.warn("Warning: {}", warning);
                warning = warning.getNextWarning();
            }
        } catch (Exception e) {
            log.error("exception: ", e);
        }

        log.debug("connection: {}", con);
        if(con != null) {
            log.info("connection success");

            try {
                DatabaseMetaData databaseMetaData = con.getMetaData();
                try(ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"})) {
                    while (resultSet.next()) {
                        String tableName = resultSet.getString("TABLE_NAME");
                        String remarks = resultSet.getString("REMARKS");
                        log.debug("tableName={}, remarks={}", tableName, remarks);
                    }
                }
            } catch (SQLException e) {
                log.error("metadata error: {}", e);
            }
        }


    }
}

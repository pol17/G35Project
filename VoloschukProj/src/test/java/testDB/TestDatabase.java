package testDB;

import libs.Database;
import libs.UtilsForDB;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDatabase {
    static Database dbMySql;
    static Logger logger = Logger.getLogger(TestDatabase.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySQL db connected");

    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();

    }

    @Test
    public void testDataBase() throws SQLException, IOException, ClassNotFoundException {
        List<ArrayList> dataFromSeleniumTable =
                dbMySql.selectTable("select * from seleniumTable where login='test'");
        logger.info("Result = " + dataFromSeleniumTable);
        logger.info("3 line = " + dataFromSeleniumTable.get(2));
        logger.info("login 3 line = " + dataFromSeleniumTable.get(2).get(2));
        UtilsForDB utilsForDB = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("ovol"));
//        int effectedRows = dbMySql.changeTable("insert into seleniumTable VALUES (125, 'ovol', 'ovol223344')");
//        dataFromSeleniumTable =
//                dbMySql.selectTable("select * from seleniumTable where login='ovol'");
//        logger.info("Result = " + dataFromSeleniumTable);

    }
}

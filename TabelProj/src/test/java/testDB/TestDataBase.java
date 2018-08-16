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


public class TestDataBase {
    static Database dbMySql;
    static Logger logger = Logger.getLogger(TestDataBase.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySql DB connected");
    }

    @After
    public void rearDown() throws SQLException{
    dbMySql.quit();
    }

    @Test
    public void testDataBase() throws SQLException, IOException, ClassNotFoundException {
        List<ArrayList> dataFromSeleniumTable =
                dbMySql.selectTable("select * from seleniumTable where login = 'test'"); //любой запрос
        logger.info("Result = " + dataFromSeleniumTable);
        logger.info(" 3 line = " +  dataFromSeleniumTable.get(2));
        logger.info(" 3 line 3 element = " +  dataFromSeleniumTable.get(2).get(2));
       // int effectedRows = dbMySql.changeTable("INSERT INTO seleniumTable VALUES (87, 'iu15372','15372')");
      dataFromSeleniumTable =
                dbMySql.selectTable("select * from seleniumTable where login = 'iu15372'"); //любой запрос
        logger.info("Result = " + dataFromSeleniumTable);
        UtilsForDB utilsForDB = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("iu15372"));




    }
}

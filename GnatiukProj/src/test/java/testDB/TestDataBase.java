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

    @Test
    public void testDataBase() throws SQLException, IOException, ClassNotFoundException {
        List<ArrayList> dataFromSeleniumTable =
                dbMySql.selectTable("select * from seleniumTable where login = 'test'");
        logger.info(" Result = " + dataFromSeleniumTable); //получаем всю базу
        logger.info(" 3 line = " + dataFromSeleniumTable.get(2)); //получаем 3ю строку
        logger.info(" 3 line = " + dataFromSeleniumTable.get(2).get(2)); //получаем логин из 3й строки
        //for Update, Insert and Delete
//        int effectedRows = dbMySql.changeTable
//                ("INSERT INTO seleniumTable VALUES (17, 'hnatiuk', 'vasilePass')");
        dataFromSeleniumTable =
                dbMySql.selectTable("select * from seleniumTable where login = 'hnatiuk'");
        logger.info(" Result = " + dataFromSeleniumTable);
        UtilsForDB utilsForDB = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("hnatiuk"));
    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }
}

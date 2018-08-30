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

    static Database dbMySQL;
    static Logger logger = Logger.getLogger(TestDataBase.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL"); /*установили коннекшн*/

    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();

    }

    @Test
    public void testDataBase() throws SQLException, IOException, ClassNotFoundException {
        List<ArrayList> dataFromSeleniumTable = dbMySQL.selectTable("select * from seleniumTable where login = 'test'");
        logger.info("Result = " + dataFromSeleniumTable);
        logger.info(" 3 line = " + dataFromSeleniumTable.get(2)); /*получить данные из третьей строки */
        logger.info(" 3 line = " + dataFromSeleniumTable.get(2).get(2)); /*получить второй элемент из третьей строки */
//        int affectedRows = dbMySQL.changeTable("INSERT INTO seleniumTable VALUES (7, 'kotok', 'myownPass')");
//        dataFromSeleniumTable = dbMySQL.selectTable("select * from seleniumTable where login = 'kotok'");
//        logger.info("Result = " + dataFromSeleniumTable);
        UtilsForDB utilsForDB = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("kotok"));


    }


}

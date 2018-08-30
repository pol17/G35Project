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

public class testDataBase {
    static Database dbMySql;
    static Logger logger= Logger.getLogger(testDataBase.class);
    @Before
    public void SetUp () throws SQLException, IOException, ClassNotFoundException {
        dbMySql=new Database("MySQL_PADB_DB", "MySQL");
        logger.info("My SQl connected");

    }
    @Test
    public void testDataBase () throws SQLException, IOException, ClassNotFoundException {
        List<ArrayList> dataFromSileniumTable = dbMySql.selectTable("Select * from seleniumTable");
    logger.info("Result = " + dataFromSileniumTable);
    logger.info("Line 3 = " + dataFromSileniumTable.get(2).get(2));
//    int effectedRows=dbMySql.changeTable("INSERT into seleniumTable values (9,'Petrovskaya','elvina')");
//        dataFromSileniumTable = dbMySql.selectTable("Select * from seleniumTable where passWord='elvina'");
//        logger.info("Result2 = " + dataFromSileniumTable);
        UtilsForDB utilsForDB=new UtilsForDB();
       logger.info(utilsForDB.getPassForLogin("Petrovskaya"));

    }
    @After
    public void tearDown () throws SQLException {
        dbMySql.quit();
    }

}

package siuts;

import loginTests.LoginTest;
import loginTests.LoginTestWithExcel;
import loginTests.LoginTestWithOutPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTest.class,
                LoginTestWithExcel.class,
                LoginTestWithOutPageObject.class
        }
)

public class LoginSuite {
}

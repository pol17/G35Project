package suits;

import loginTests.LoginTest;
import loginTests.LoginTestWithExcel;
import loginTests.UnValidLoginWithParamsWithExcel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTest.class,
                LoginTestWithExcel.class,
                UnValidLoginWithParamsWithExcel.class
        }
)
public class LoginSuite {

}

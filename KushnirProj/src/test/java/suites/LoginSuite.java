package suites;

import loginTests.LoginTest;
import loginTests.LoginTestWithExcel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTest.class,
                LoginTestWithExcel.class
        }
)

public class LoginSuite {




}

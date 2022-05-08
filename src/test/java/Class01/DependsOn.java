package Class01;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void login(){
       /* System.out.println(10/0);//will give this error Default Suite
       // Total tests run: 2, Passes: 0, Failures: 1, Skips: 1*/
        System.out.println("This is a login test");
    }

    @Test(dependsOnMethods = "login")
    public void verificationOfDashboard() {
        System.out.println("This is dashboard");
    }
}

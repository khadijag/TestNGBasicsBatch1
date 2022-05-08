package Class01;

import org.testng.annotations.Test;

public class EnableAndDisable {
    //by default enable is ture always
    @Test(enabled = false)
    public void FirstTest(){
        System.out.println("1st");
    }
    @Test
    public void SecondTest(){
        System.out.println("2nd");
    }
    @Test
    public void ThirdTest(){
        System.out.println("3rd");
    }
}

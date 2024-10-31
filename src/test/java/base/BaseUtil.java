package base;

public class BaseUtil {

    private static String userFullName;


    public static String getUserFullName() {
        return userFullName;
    }

    public static void setUserFullName(String userFullName) {
        BaseUtil.userFullName = userFullName;
    }
}

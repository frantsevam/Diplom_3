package api.constants;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiAndUrl {
    public static final String USER_REGISTER = "api/auth/register";
    public static final String USER = "api/auth/user";
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String RECOVER_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";

    public static RequestSpecification spec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(MAIN_URL)
                .log()
                .all();

    }
}


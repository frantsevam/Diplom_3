package api.user;

import api.constants.ApiAndUrl;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UserRequests extends ApiAndUrl {
    @Step("Создание пользователя")
    public static Response createUser(api.user.UserRegistration userRegistration) {
        return spec()
                .body(userRegistration)
                .when()
                .post(USER_REGISTER);

    }

    @Step("Удаление пользователя")
    public static void deleteUser(String accessToken) {
        spec()
                .header("Authorization",accessToken)
                .when()
                .delete(USER);
    }
}

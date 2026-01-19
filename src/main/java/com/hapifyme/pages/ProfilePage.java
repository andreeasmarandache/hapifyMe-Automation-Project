package com.hapifyme.pages;

import org.openqa.selenium.By;
import java.util.List;
import java.util.Map;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    private By firstNameInput = By.name("first_name");
    private By lastNameInput = By.name("last_name");
    private By updateDetailsButton = By.name("update_details");

    public void updateFirstName(String firstName) { $(firstNameInput).setValue(firstName); }
    public void updateLastName(String lastName) { $(lastNameInput).setValue(lastName); }

    public void updateProfileDetails(List<Map<String, String>> rows) {
        for (Map<String, String> row : rows) {
            String field = row.get("field");
            String value = row.get("value");

            if ("FirstName".equals(field)) updateFirstName(value);
            else if ("LastName".equals(field)) updateLastName(value);
        }
    }

    public void clickUpdateDetailsButton() { $(updateDetailsButton).click(); }
}


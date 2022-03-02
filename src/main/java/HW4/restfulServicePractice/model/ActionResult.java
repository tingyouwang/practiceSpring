package HW4.restfulServicePractice.model;

import org.springframework.stereotype.Component;

@Component
public class ActionResult {

    Boolean isVerifySuccess;
    Integer id;
    String name;
    String message;

    public Boolean getVerifySuccess() {
        return isVerifySuccess;
    }

    public void setVerifySuccess(Boolean verifySuccess) {
        isVerifySuccess = verifySuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

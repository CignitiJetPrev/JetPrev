package com.web.automation.slack;

/**
 * @author Pankaj Kumar (HOOQ Team)
 */
public enum SlackActionType {
    BUTTON("button"),
    SELECT("select");

    private String code;

    SlackActionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}

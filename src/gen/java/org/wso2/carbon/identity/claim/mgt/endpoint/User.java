package org.wso2.carbon.identity.claim.mgt.endpoint;

/**
 * Sample user bean to check the servlet bridge works.
 */
public class User {

    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

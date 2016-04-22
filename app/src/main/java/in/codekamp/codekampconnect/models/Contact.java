package in.codekamp.codekampconnect.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("facebook_id")
    @Expose
    private String facebookId;
    @SerializedName("linkedin_id")
    @Expose
    private String linkedinId;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday The birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return The facebookId
     */
    public String getFacebookId() {
        return facebookId;
    }

    /**
     * @param facebookId The facebook_id
     */
    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    /**
     * @return The linkedinId
     */
    public String getLinkedinId() {
        return linkedinId;
    }

    /**
     * @param linkedinId The linkedin_id
     */
    public void setLinkedinId(String linkedinId) {
        this.linkedinId = linkedinId;
    }

}
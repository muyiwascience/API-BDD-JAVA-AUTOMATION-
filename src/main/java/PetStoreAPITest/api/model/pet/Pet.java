
package PetStoreAPITest.api.model.pet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Pet implements Serializable
{

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photoUrls")
    @Expose
    private List<String> photoUrls = new ArrayList<String>();
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("status")
    @Expose
    private String status;
    private final static long serialVersionUID = -2815578918704039654L;


    public Pet() {
    }


    public Pet(Long id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
        super();
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("category", category).append("name", name).append("photoUrls", photoUrls).append("tags", tags).append("status", status).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tags).append(id).append(category).append(status).append(name).append(photoUrls).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pet) == false) {
            return false;
        }
        Pet rhs = ((Pet) other);
        return new EqualsBuilder().append(tags, rhs.tags).append(id, rhs.id).append(category, rhs.category).append(status, rhs.status).append(name, rhs.name).append(photoUrls, rhs.photoUrls).isEquals();
    }

}

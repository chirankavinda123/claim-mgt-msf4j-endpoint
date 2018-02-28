package org.wso2.carbon.identity.claim.mgt.endpoint.dto;


import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * AttributeMappingDTO
 */
public class AttributeMappingDTO   {
  @SerializedName("attributeName")
  private String attributeName = null;

  @SerializedName("userStoreDomain")
  private String userStoreDomain = null;

  public AttributeMappingDTO attributeName(String attributeName) {
    this.attributeName = attributeName;
    return this;
  }

   /**
   * Get attributeName
   * @return attributeName
  **/
  @ApiModelProperty(value = "")
  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public AttributeMappingDTO userStoreDomain(String userStoreDomain) {
    this.userStoreDomain = userStoreDomain;
    return this;
  }

   /**
   * Get userStoreDomain
   * @return userStoreDomain
  **/
  @ApiModelProperty(value = "")
  public String getUserStoreDomain() {
    return userStoreDomain;
  }

  public void setUserStoreDomain(String userStoreDomain) {
    this.userStoreDomain = userStoreDomain;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttributeMappingDTO attributeMapping = (AttributeMappingDTO) o;
    return Objects.equals(this.attributeName, attributeMapping.attributeName) &&
        Objects.equals(this.userStoreDomain, attributeMapping.userStoreDomain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeName, userStoreDomain);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeMappingDTO {\n");
    
    sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
    sb.append("    userStoreDomain: ").append(toIndentedString(userStoreDomain)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


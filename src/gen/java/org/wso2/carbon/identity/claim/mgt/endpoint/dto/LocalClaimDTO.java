package org.wso2.carbon.identity.claim.mgt.endpoint.dto;


import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.AttributeMappingDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.ClaimPropertyDTO;
import java.util.Objects;

/**
 * LocalClaimDTO
 */
public class LocalClaimDTO   {
  @SerializedName("attributeMappings")
  private List<AttributeMappingDTO> attributeMappings = new ArrayList<AttributeMappingDTO>();

  @SerializedName("claimProperties")
  private List<ClaimPropertyDTO> claimProperties = new ArrayList<ClaimPropertyDTO>();

  @SerializedName("localClaimURI")
  private String localClaimURI = null;

  public LocalClaimDTO attributeMappings(List<AttributeMappingDTO> attributeMappings) {
    this.attributeMappings = attributeMappings;
    return this;
  }

  public LocalClaimDTO addAttributeMappingsItem(AttributeMappingDTO attributeMappingsItem) {
    this.attributeMappings.add(attributeMappingsItem);
    return this;
  }

   /**
   * Get attributeMappings
   * @return attributeMappings
  **/
  @ApiModelProperty(value = "")
  public List<AttributeMappingDTO> getAttributeMappings() {
    return attributeMappings;
  }

  public void setAttributeMappings(List<AttributeMappingDTO> attributeMappings) {
    this.attributeMappings = attributeMappings;
  }

  public LocalClaimDTO claimProperties(List<ClaimPropertyDTO> claimProperties) {
    this.claimProperties = claimProperties;
    return this;
  }

  public LocalClaimDTO addClaimPropertiesItem(ClaimPropertyDTO claimPropertiesItem) {
    this.claimProperties.add(claimPropertiesItem);
    return this;
  }

   /**
   * Get claimProperties
   * @return claimProperties
  **/
  @ApiModelProperty(value = "")
  public List<ClaimPropertyDTO> getClaimProperties() {
    return claimProperties;
  }

  public void setClaimProperties(List<ClaimPropertyDTO> claimProperties) {
    this.claimProperties = claimProperties;
  }

  public LocalClaimDTO localClaimURI(String localClaimURI) {
    this.localClaimURI = localClaimURI;
    return this;
  }

   /**
   * Get localClaimURI
   * @return localClaimURI
  **/
  @ApiModelProperty(value = "")
  public String getLocalClaimURI() {
    return localClaimURI;
  }

  public void setLocalClaimURI(String localClaimURI) {
    this.localClaimURI = localClaimURI;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalClaimDTO localClaim = (LocalClaimDTO) o;
    return Objects.equals(this.attributeMappings, localClaim.attributeMappings) &&
        Objects.equals(this.claimProperties, localClaim.claimProperties) &&
        Objects.equals(this.localClaimURI, localClaim.localClaimURI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeMappings, claimProperties, localClaimURI);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalClaimDTO {\n");
    
    sb.append("    attributeMappings: ").append(toIndentedString(attributeMappings)).append("\n");
    sb.append("    claimProperties: ").append(toIndentedString(claimProperties)).append("\n");
    sb.append("    localClaimURI: ").append(toIndentedString(localClaimURI)).append("\n");
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


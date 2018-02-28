package org.wso2.carbon.identity.claim.mgt.endpoint.dto;


import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * ExternalClaimDTO
 */
public class ExternalClaimDTO   {
  @SerializedName("externalClaim")
  private String externalClaim = null;

  @SerializedName("mappedLocalClaim")
  private String mappedLocalClaim = null;

  public ExternalClaimDTO externalClaim(String externalClaim) {
    this.externalClaim = externalClaim;
    return this;
  }

   /**
   * Get externalClaim
   * @return externalClaim
  **/
  @ApiModelProperty(value = "")
  public String getExternalClaim() {
    return externalClaim;
  }

  public void setExternalClaim(String externalClaim) {
    this.externalClaim = externalClaim;
  }

  public ExternalClaimDTO mappedLocalClaim(String mappedLocalClaim) {
    this.mappedLocalClaim = mappedLocalClaim;
    return this;
  }

   /**
   * Get mappedLocalClaim
   * @return mappedLocalClaim
  **/
  @ApiModelProperty(value = "")
  public String getMappedLocalClaim() {
    return mappedLocalClaim;
  }

  public void setMappedLocalClaim(String mappedLocalClaim) {
    this.mappedLocalClaim = mappedLocalClaim;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExternalClaimDTO externalClaim = (ExternalClaimDTO) o;
    return Objects.equals(this.externalClaim, externalClaim.externalClaim) &&
        Objects.equals(this.mappedLocalClaim, externalClaim.mappedLocalClaim);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalClaim, mappedLocalClaim);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalClaimDTO {\n");
    
    sb.append("    externalClaim: ").append(toIndentedString(externalClaim)).append("\n");
    sb.append("    mappedLocalClaim: ").append(toIndentedString(mappedLocalClaim)).append("\n");
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


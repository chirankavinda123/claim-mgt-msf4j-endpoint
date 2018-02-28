package org.wso2.carbon.identity.claim.mgt.endpoint.dto;


import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.ExternalClaimDTO;
import java.util.Objects;

/**
 * ClaimDialectDTO
 */
public class ClaimDialectDTO   {
  @SerializedName("id")
  private String id = null;

  @SerializedName("externalClaims")
  private List<ExternalClaimDTO> externalClaims = new ArrayList<ExternalClaimDTO>();

  public ClaimDialectDTO id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The URI of the Claim Dialect.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The URI of the Claim Dialect.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ClaimDialectDTO externalClaims(List<ExternalClaimDTO> externalClaims) {
    this.externalClaims = externalClaims;
    return this;
  }

  public ClaimDialectDTO addExternalClaimsItem(ExternalClaimDTO externalClaimsItem) {
    this.externalClaims.add(externalClaimsItem);
    return this;
  }

   /**
   * Array of external claims
   * @return externalClaims
  **/
  @ApiModelProperty(value = "Array of external claims")
  public List<ExternalClaimDTO> getExternalClaims() {
    return externalClaims;
  }

  public void setExternalClaims(List<ExternalClaimDTO> externalClaims) {
    this.externalClaims = externalClaims;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClaimDialectDTO claimDialect = (ClaimDialectDTO) o;
    return Objects.equals(this.id, claimDialect.id) &&
        Objects.equals(this.externalClaims, claimDialect.externalClaims);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, externalClaims);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClaimDialectDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    externalClaims: ").append(toIndentedString(externalClaims)).append("\n");
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


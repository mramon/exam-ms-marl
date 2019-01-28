package com.gft.exam.ms.marl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CustomerDetail
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-21T18:18:25.922-06:00")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class CustomerDetail   {
	
  @JsonProperty("customerId")
  @ApiModelProperty(example = "00021244", value = "")
  @Id
  @GeneratedValue
  private String customerId;

  @JsonProperty("originChannel")
  @ApiModelProperty(example = "BANCA SERFIN", value = "")
  private String originChannel;

  @JsonProperty("fullName")
  @ApiModelProperty(example = "ACEVES GONZALEZ ADOLFO", value = "")
  private String fullName;

  @JsonProperty("condition")
  @ApiModelProperty(example = "CLIENTE", value = "")
  private String condition;

  @JsonProperty("segment")
  @ApiModelProperty(example = "PREMIER", value = "")
  private String segment;

  @JsonProperty("address")
  @ApiModelProperty(example = "LOMA BONITA 1839", value = "")
  private String address;

  @JsonProperty("customerCategory")
  @ApiModelProperty(example = "FISICA", value = "")
  private String customerCategory;

}


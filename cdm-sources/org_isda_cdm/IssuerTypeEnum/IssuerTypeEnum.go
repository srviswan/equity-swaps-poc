/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package IssuerTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents an enumeration list to identify the type of entity issuing the asset.
   */
  
  const (
  /**
   * Specifies debt issued Securities by corporate bodies including Banks.
   */
  CORPORATE IssuerTypeEnum = iota + 1
  /**
   * Specifies a vehicle (with or without separate legal personality) designed for the purposes of collective investment towards a defined investment goal.
   */
  FUND IssuerTypeEnum = iota + 1
  /**
   * Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
   */
  QUASI_GOVERNMENT IssuerTypeEnum = iota + 1
  /**
   * Specifies Regional Government Issued Debt including states within countries, local authorities and municipalities.
   */
  REGIONAL_GOVERNMENT IssuerTypeEnum = iota + 1
  /**
   * Specifies Sovereign, Government Debt Securities including Central Banks.
   */
  SOVEREIGN_CENTRAL_BANK IssuerTypeEnum = iota + 1
  /**
   * Specifies a vehicle setup for the purpose of acquisition and financing of specific assets on a limited recourse basis. E.g. asset backed securities, including securitisations.
   */
  SPECIAL_PURPOSE_VEHICLE IssuerTypeEnum = iota + 1
  /**
   * Specifies debt issued by international organisations and multilateral banks, entities constituted by treaties or with multiple sovereign members includes Multilateral development Banks.
   */
  SUPRA_NATIONAL IssuerTypeEnum = iota + 1
  )    

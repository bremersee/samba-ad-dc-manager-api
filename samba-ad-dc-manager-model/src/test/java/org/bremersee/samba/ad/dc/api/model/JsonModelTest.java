/*
 * Copyright 2026 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bremersee.samba.ad.dc.api.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

/**
 * The json model test.
 *
 * @author Christian Bremer
 */
class JsonModelTest {

  private static final String DISCRIMINATOR = "jsonType";

  private static final String DN = "CN=test,DC=example,DC=com";

  private static final String NAME = "A Name";

  private final JsonMapper mapper = JsonMapper.builder().build();

  /**
   * Dns entry.
   */
  @Test
  void dnsEntry() {
    AdEntry source = DnsEntry.builder()
        .distinguishedName(DN)
        .type(DnsEntryType.A)
        .name(NAME)
        .value("foobar")
        .build();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);
    AdEntry actual = mapper.readValue(json, AdEntry.class);
    assertThat(actual).isExactlyInstanceOf(DnsEntry.class);
    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFields(DISCRIMINATOR)
        .isEqualTo(source);
  }

  /**
   * Dns zone.
   */
  @Test
  void dnsZone() {
    AdEntry source = DnsZone.builder()
        .distinguishedName(DN)
        .name(NAME)
        .build();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);
    AdEntry actual = mapper.readValue(json, AdEntry.class);
    assertThat(actual).isExactlyInstanceOf(DnsZone.class);
    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFields(DISCRIMINATOR)
        .isEqualTo(source);
  }

  /**
   * Organizational unit.
   */
  @Test
  void organizationalUnit() {
    AdEntry source = OrganizationalUnit.builder()
        .distinguishedName(DN)
        .name(NAME)
        .build();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);
    AdEntry actual = mapper.readValue(json, AdEntry.class);
    assertThat(actual).isExactlyInstanceOf(OrganizationalUnit.class);
    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFields(DISCRIMINATOR)
        .isEqualTo(source);
  }

  /**
   * Sam account.
   */
  @Test
  void samAccount() {
    AdEntry source = SamAccount.builder()
        .distinguishedName(DN)
        .samAccountName(NAME)
        .build();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);
    AdEntry actual = mapper.readValue(json, AdEntry.class);
    assertThat(actual).isExactlyInstanceOf(SamAccount.class);
    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFields(DISCRIMINATOR)
        .isEqualTo(source);
  }

  /**
   * Domain computer.
   */
  @Test
  void domainComputer() {
    SamAccount source = DomainComputer.builder()
        .distinguishedName(DN)
        .samAccountName(NAME)
        .build();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);
    SamAccount actual = mapper.readValue(json, SamAccount.class);
    assertThat(actual).isExactlyInstanceOf(DomainComputer.class);
    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFields(DISCRIMINATOR)
        .isEqualTo(source);
  }

  /**
   * Domain group.
   */
  @Test
  void domainGroup() {
    SamAccount source = DomainGroup.builder()
        .distinguishedName(DN)
        .samAccountName(NAME)
        .build();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);
    SamAccount actual = mapper.readValue(json, SamAccount.class);
    assertThat(actual).isExactlyInstanceOf(DomainGroup.class);
    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFields(DISCRIMINATOR)
        .isEqualTo(source);
  }

  /**
   * Domain group member.
   */
  @Test
  void domainGroupMember() {
    SamAccount source = DomainGroupMember.builder()
        .distinguishedName(DN)
        .samAccountName(NAME)
        .memberType(DomainGroupMemberType.USER)
        .build();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);
    SamAccount actual = mapper.readValue(json, SamAccount.class);
    assertThat(actual).isExactlyInstanceOf(DomainGroupMember.class);
    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFields(DISCRIMINATOR)
        .isEqualTo(source);
  }

  /**
   * Domain user.
   */
  @Test
  void domainUser() {
    SamAccount source = DomainUser.builder()
        .distinguishedName(DN)
        .samAccountName(NAME)
        .build();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);
    SamAccount actual = mapper.readValue(json, SamAccount.class);
    assertThat(actual).isExactlyInstanceOf(DomainUser.class);
    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFields(DISCRIMINATOR)
        .isEqualTo(source);
  }

}
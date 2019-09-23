/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2019 the original author or authors.
 */
package org.assertj.core.error;

import static java.lang.String.format;

import java.io.File;

/**
 * Creates an error message indicating that an assertion that verifies that a value have certain size failed.
 * 
 * @author Alex Ruiz
 */
public class ShouldHaveSize extends BasicErrorMessageFactory {

  private static final String SHOULD_HAVE_FILE_SIZE = "%nExpecting file%n  <%s>%nto have size:%n  <%s>%nbut had:%n  <%s>";

  /**
   * Creates a new <code>{@link ShouldHaveSize}</code>.
   * @param actual the actual value in the failed assertion.
   * @param actualSize the size of {@code actual}.
   * @param expectedSize the expected size.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldHaveSize(Object actual, int actualSize, int expectedSize) {
    return new ShouldHaveSize(actual, actualSize, expectedSize);
  }

  private ShouldHaveSize(Object actual, int actualSize, int expectedSize) {
    // format the sizes in a standard way, otherwise if we use (for ex) an Hexadecimal representation
    // it will format sizes in hexadecimal while we only want actual to be formatted in hexadecimal
    super(format("%nExpected size:<%s> but was:<%s> in:%n<%s>", expectedSize, actualSize, "%s"), actual);
  }

  /**
   * Creates a new <code>{@link ShouldHaveSize}</code>.
   * @param actual the actual value in the failed assertion.
   * @param expectedSize the expected size.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldHaveSize(File actual, long expectedSize) {
    return new ShouldHaveSize(actual, expectedSize);
  }

  private ShouldHaveSize(File actual, long expectedSize) {
    super(SHOULD_HAVE_FILE_SIZE, actual, expectedSize, actual.length());
  }

}

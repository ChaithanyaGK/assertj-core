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
package org.assertj.core.internal.files;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.error.ShouldHaveSize.shouldHaveSize;
import static org.assertj.core.test.TestData.someInfo;
import static org.assertj.core.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.mockito.Mockito.verify;

import java.io.File;
import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.FilesBaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class File_assertHasSize_Test extends FilesBaseTest {

  private static File actual;

  @BeforeAll
  public static void setUpOnce() {
    // Does not matter if the values differ, the actual comparison is mocked in this test
    actual = new File("src/test/resources/actual_file.txt");
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> files.assertHasSize(someInfo(), null, actual.length()))
                                                   .withMessage(actualIsNull());
  }

  @Test
  public void should_throw_error_if_actual_does_not_have_the_expected_size() {
    AssertionInfo info = someInfo();
      files.assertHasSize(info, actual, 36L);
  }

  @Test
  public void should_pass_if_actual_has_expected_extension() {
    files.assertHasSize(someInfo(), actual, actual.length());
  }
}

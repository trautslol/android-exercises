package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

/**
 * Created by Stuart on 14/12/2016.
 */

@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTestLeRetourDuJedi {

    LoginActivity activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_set_logged_state() throws Exception {
        // Given
        // When
        activity.logged();
        // Then
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void shouldnt_set_logged_state() throws Exception {
        // Given
        // When
        activity.notLogged();
        // Then
        Assertions.assertThat(activity.loginLayout).isVisible();
        Assertions.assertThat(activity.loggedText).isGone();
    }
}


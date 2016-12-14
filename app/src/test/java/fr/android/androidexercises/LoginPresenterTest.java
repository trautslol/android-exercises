package fr.android.androidexercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Stuart on 14/12/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    LoginActivity activity;
    @InjectMocks
    LoginPresenter loginPresenter;
    @Test
    public void password_should_be_valid() throws Exception {
        // Given
        // When
        loginPresenter.checkCredentials("password");
        // Then
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }
    @Test
    public void password_shouldnt_be_valid_inf3() throws Exception {
        // Given
        // When
        loginPresenter.checkCredentials("pa");
        // Then
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }
    @Test
    public void password_should_be_valid_eq3() throws Exception {
        // Given
        // When
        loginPresenter.checkCredentials("pas");
        // Then
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }
    @Test
    public void password_shouldnt_be_valid_null() throws Exception {
        // Given
        // When
        loginPresenter.checkCredentials("");
        // Then
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }
}
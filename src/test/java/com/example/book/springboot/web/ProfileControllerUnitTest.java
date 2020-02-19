package com.example.book.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

public class ProfileControllerUnitTest {
    @Test
    public void real_profile_조회(){
        //given
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();
        //then
        Assertions.assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void real_profile없을시_첫번째_조회(){
        //given
        String expectedProfile= "oauth";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();
        //then
        Assertions.assertThat(profile).isEqualTo(expectedProfile);

    }

    @Test
    public void actvie_profile이없을시_default(){
        //given
        String expectedProfile= "default";
        MockEnvironment env = new MockEnvironment();

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();
        //then
        Assertions.assertThat(profile).isEqualTo(expectedProfile);

    }
}

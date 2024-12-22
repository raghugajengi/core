package com.springboot.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoreApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/RestApi/getData";
    }

    @Test
    public void testGetUserData_Success() {
        // Given
        UserData expectedData = new UserData();
        expectedData.setId("1");
        expectedData.setUserName("raghu");
        expectedData.setData("Data send by Rest-API");

        // When
        ResponseEntity<UserData> response = testRestTemplate.getForEntity(
            baseUrl, UserData.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        
        UserData actualData = response.getBody();
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getUserName(), actualData.getUserName());
        assertEquals(expectedData.getData(), actualData.getData());
    }

    @Test
    public void testGetUserData_NotFound() {
        // When
        ResponseEntity<UserData> response = testRestTemplate.getForEntity(
            baseUrl + "/999", UserData.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetUserData_BadRequest() {
        // When
        ResponseEntity<UserData> response = testRestTemplate.getForEntity(
            baseUrl + "?invalid=true", UserData.class);

        // Then
        //assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}

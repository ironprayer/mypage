package com.example.test2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class TestDTO {
    private String email;
    private String user;
    private String createdAt;
    private String password;

    private String passwor1;

    private TestDTOBuilder(String email1){
        this.email = email1;
    }


    public static TestDTOBuilder builder() {
        return new TestDTOBuilder();
    }

    TestDTOBuilder.email().user().

    public static class TestDTOBuilder{
        private String email;
        private String user;
        private String createdAt;
        private String password;

        private String passwor1;
        public TestDTOBuilder() {}

        public TestDTOBuilder email(String email){
            this.email = email;
            return this;
        }

        public TestDTOBuilder user(String email){
            this.email = email;
            return this;
        }

        public TestDTOBuilder createdAt(String email){
            this.email = email;
            return this;
        }

        public TestDTOBuilder email(String email){
            this.email = email;
            return this;
        }

        public TestDTO build(){
            return new TestDTO(email, user, );
        }
    }

}
